package nepjr.tech.metatileentities.multi.electric;

import static gregtech.api.recipes.logic.OverclockingLogic.heatingCoilOverclockingLogic;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.IMufflerHatch;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.logic.OverclockingLogic;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.NTUniqueCasing.UniqueCasingType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityUniversalSmelter extends MultiMapMultiblockController implements IHeatingCoil {

    private int blastFurnaceTemperature;
    private float processingSpeed;
    private int parallels;

    public MetaTileEntityUniversalSmelter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[] { 
        			RecipeMaps.BLAST_RECIPES,
        			NTRecipeMaps.ALLOY_BLAST_RECIPES,
        			RecipeMaps.ALLOY_SMELTER_RECIPES, 
        			RecipeMaps.ARC_FURNACE_RECIPES, 
        			RecipeMaps.FLUID_HEATER_RECIPES, 
        			RecipeMaps.FURNACE_RECIPES
        });
        this.recipeMapWorkable = new MegaBlastFurnaceRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityUniversalSmelter(this.metaTileEntityId);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addCustom(tl -> {
                    // Coil heat capacity line
                    if (isStructureFormed()) {
                        ITextComponent heatString = TextComponentUtil.stringWithColor(
                                TextFormatting.RED,
                                TextFormattingUtil.formatNumbers(blastFurnaceTemperature) + "K");

                        tl.add(TextComponentUtil.translationWithColor(
                                TextFormatting.GRAY,
                                "gregtech.multiblock.blast_furnace.max_temperature",
                                heatString));
                    }
                })
                .addParallelsLine(recipeMapWorkable.getParallelLimit())
                .addWorkingStatusLine()
                .addProgressLine(recipeMapWorkable.getProgressPercent());
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats stats) {
            this.blastFurnaceTemperature = stats.getCoilTemperature();
            int tier = ((IHeatingCoilBlockStats) stats).getTier();
            this.parallels = ((IHeatingCoilBlockStats) stats).getLevel() * 32;
            if(tier > 0)
            {
            	this.processingSpeed = (float) (((50 * (tier + 1)) + (25 * (tier + 1)))) / 100;
            }
            else
            {
            	this.processingSpeed = 1;
            }
        } else {
            this.blastFurnaceTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
            this.parallels = CoilType.CUPRONICKEL.getLevel() * 32;
            this.processingSpeed = 1;
        }
        
        List<IEnergyContainer> powerInput = new ArrayList<>(getAbilities(MultiblockAbility.INPUT_ENERGY));
        powerInput.addAll(getAbilities(MultiblockAbility.INPUT_LASER));

        this.energyContainer = new EnergyContainerList(powerInput);

        this.blastFurnaceTemperature += 200 *
                Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.blastFurnaceTemperature = 0;
    }

    @Override
    public boolean checkRecipe(@NotNull Recipe recipe, boolean consumeIfSuccess) {
        return this.blastFurnaceTemperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }
    
    @Override
    public void checkStructurePattern() {
        super.checkStructurePattern();
        
        // If we have both Lasers and an Energy Hatch, invalidate the structure
        if(!getAbilities(MultiblockAbility.INPUT_ENERGY).isEmpty() && !getAbilities(MultiblockAbility.INPUT_LASER).isEmpty())
        {
        	invalidateStructure();
        }
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        TraceabilityPredicate casing = states(getCasingState()).setMinGlobalLimited(360);
        return FactoryBlockPattern.start()
                .aisle("##XXXXXXXXX##", "##XXXXXXXXX##", "#############", "#############", "#############",
                        "#############", "#############", "#############", "#############", "#############",
                        "#############", "#############", "#############", "#############", "#############",
                        "#############", "#############")
                .aisle("#XXXXXXXXXXX#", "#XXXXXXXXXXX#", "###F#####F###", "###F#####F###", "###FFFFFFF###",
                        "#############", "#############", "#############", "#############", "#############",
                        "####FFFFF####", "#############", "#############", "#############", "#############",
                        "#############", "#############")
                .aisle("XXXXXXXXXXXXX", "XXXXVVVVVXXXX", "##F#######F##", "##F#######F##", "##FFFHHHFFF##",
                        "##F#######F##", "##F#######F##", "##F#######F##", "##F#######F##", "##F#######F##",
                        "##FFFHHHFFF##", "#############", "#############", "#############", "#############",
                        "#############", "###TTTTTTT###")
                .aisle("XXXXXXXXXXXXX", "XXXXXXXXXXXXX", "#F####P####F#", "#F####P####F#", "#FFHHHPHHHFF#",
                        "######P######", "######P######", "######P######", "######P######", "######P######",
                        "##FHHHPHHHF##", "######P######", "######P######", "######P######", "######P######",
                        "######P######", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXVXXXXXXXVXX", "####BBPBB####", "####TITIT####", "#FFHHHHHHHFF#",
                        "####BITIB####", "####CCCCC####", "####CCCCC####", "####CCCCC####", "####BITIB####",
                        "#FFHHHHHHHFF#", "####BITIB####", "####CCCCC####", "####CCCCC####", "####CCCCC####",
                        "####BITIB####", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXVXXXXXXXVXX", "####BAAAB####", "####IAAAI####", "#FHHHAAAHHHF#",
                        "####IAAAI####", "####CAAAC####", "####CAAAC####", "####CAAAC####", "####IAAAI####",
                        "#FHHHAAAHHHF#", "####IAAAI####", "####CAAAC####", "####CAAAC####", "####CAAAC####",
                        "####IAAAI####", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXVXXXXXXXVXX", "###PPAAAPP###", "###PTAAATP###", "#FHPHAAAHPHF#",
                        "###PTAAATP###", "###PCAAACP###", "###PCAAACP###", "###PCAAACP###", "###PTAAATP###",
                        "#FHPHAAAHPHF#", "###PTAAATP###", "###PCAAACP###", "###PCAAACP###", "###PCAAACP###",
                        "###PTAAATP###", "##TPPPMPPPT##")
                .aisle("XXXXXXXXXXXXX", "XXVXXXXXXXVXX", "####BAAAB####", "####IAAAI####", "#FHHHAAAHHHF#",
                        "####IAAAI####", "####CAAAC####", "####CAAAC####", "####CAAAC####", "####IAAAI####",
                        "#FHHHAAAHHHF#", "####IAAAI####", "####CAAAC####", "####CAAAC####", "####CAAAC####",
                        "####IAAAI####", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXVXXXXXXXVXX", "####BBPBB####", "####TITIT####", "#FFHHHHHHHFF#",
                        "####BITIB####", "####CCCCC####", "####CCCCC####", "####CCCCC####", "####BITIB####",
                        "#FFHHHHHHHFF#", "####BITIB####", "####CCCCC####", "####CCCCC####", "####CCCCC####",
                        "####BITIB####", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXXXXXXXXXXXX", "#F####P####F#", "#F####P####F#", "#FFHHHPHHHFF#",
                        "######P######", "######P######", "######P######", "######P######", "######P######",
                        "##FHHHPHHHF##", "######P######", "######P######", "######P######", "######P######",
                        "######P######", "##TTTTPTTTT##")
                .aisle("XXXXXXXXXXXXX", "XXXXVVVVVXXXX", "##F#######F##", "##F#######F##", "##FFFHHHFFF##",
                        "##F#######F##", "##F#######F##", "##F#######F##", "##F#######F##", "##F#######F##",
                        "##FFFHHHFFF##", "#############", "#############", "#############", "#############",
                        "#############", "###TTTTTTT###")
                .aisle("#XXXXXXXXXXX#", "#XXXXXXXXXXX#", "###F#####F###", "###F#####F###", "###FFFFFFF###",
                        "#############", "#############", "#############", "#############", "#############",
                        "####FFFFF####", "#############", "#############", "#############", "#############",
                        "#############", "#############")
                .aisle("##XXXXXXXXX##", "##XXXXSXXXX##", "#############", "#############", "#############",
                        "#############", "#############", "#############", "#############", "#############",
                        "#############", "#############", "#############", "#############", "#############",
                        "#############", "#############")
                .where('S', selfPredicate())
                .where('X', casing.setMinGlobalLimited(350).or(autoAbilities(false, true, true, true, true, true, false))
                		.or(abilities(MultiblockAbility.INPUT_LASER).setMaxGlobalLimited(1, 0))
                		.or(abilities(MultiblockAbility.INPUT_ENERGY).setMaxGlobalLimited(3, 1)))
                .where('F', frames(Materials.NaquadahAlloy))
                .where('H', casing)
                .where('P', states(getPipeState()))
                .where('B', states(getFireboxState()))
                .where('I', states(getIntakeState()))
                .where('T', states(getCasingState2()))
                .where('V', states(getVentState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('C', heatingCoils())
                .where('A', air())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NETHERITE);
    }

    private static IBlockState getCasingState2() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST);
    }

    private static IBlockState getFireboxState() {
        return MetaBlocks.BOILER_FIREBOX_CASING.getState(BlockFireboxCasing.FireboxCasingType.TUNGSTENSTEEL_FIREBOX);
    }

    private static IBlockState getIntakeState() {
        return MetaBlocks.MULTIBLOCK_CASING
                .getState(BlockMultiblockCasing.MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING);
    }

    private static IBlockState getPipeState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getVentState() {
        return NTMetaBlocks.UNIQUE_CASINGS.getState(UniqueCasingType.HEAT_VENT);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(TooltipHelper.RAINBOW_SLOW +I18n.format("neptech.machine.can_accept_single_laser"));
        tooltip.add(TextFormatting.YELLOW + I18n.format("neptech.universal_smelter.oc.tip"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.processing_speed.supercoater"));
        tooltip.add(TextFormatting.RED + I18n.format("neptech.fluid_heater.universal_smelter"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.parallels.universal_smelter"));
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return iMultiblockPart instanceof IMufflerHatch ? Textures.ROBUST_TUNGSTENSTEEL_CASING :
                NTTextures.NETHERITE_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return NTTextures.ALLOY_BLAST_SMELTER_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public int getCurrentTemperature() {
        return this.blastFurnaceTemperature;
    }
    
    public float getProcessingSpeed()
    {
    	return processingSpeed;
    }
    
    public int getParallels()
    {
    	return parallels * 16;
    }

    private class MegaBlastFurnaceRecipeLogic extends MultiblockRecipeLogic
    {
    	private MetaTileEntityUniversalSmelter mte;
    	
        public MegaBlastFurnaceRecipeLogic(MetaTileEntityUniversalSmelter metaTileEntity)
        {
            super(metaTileEntity, true);
            this.mte = metaTileEntity;
        }
        
        @Override
        protected void modifyOverclockPre(@NotNull int[] values, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPre(values, storage);
            // coil EU/t discount
            if(mte.getRecipeMap() == RecipeMaps.BLAST_RECIPES || mte.getRecipeMap() == NTRecipeMaps.ALLOY_BLAST_RECIPES)
        	{
	            values[0] = OverclockingLogic.applyCoilEUtDiscount(values[0],
	                    ((IHeatingCoil) metaTileEntity).getCurrentTemperature(),
	                    storage.getRecipePropertyValue(TemperatureProperty.getInstance(), 0));
        	}
        }

        @NotNull
        @Override
        protected int[] runOverclockingLogic(@NotNull IRecipePropertyStorage propertyStorage, int recipeEUt,
                                             long maxVoltage, int duration, int amountOC) {
        	
        	if(mte.getRecipeMap() == RecipeMaps.BLAST_RECIPES || mte.getRecipeMap() == NTRecipeMaps.ALLOY_BLAST_RECIPES)
        	{
        		return heatingCoilOverclockingLogic(
                        Math.abs(recipeEUt),
                        maxVoltage,
                        duration,
                        amountOC,
                        ((IHeatingCoil) metaTileEntity).getCurrentTemperature(),
                        propertyStorage.getRecipePropertyValue(TemperatureProperty.getInstance(), 0));
        	}
        	else
        	{
        		return super.runOverclockingLogic(propertyStorage, recipeEUt, maxVoltage, duration, amountOC);
        	}
        }
        
        @Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage)
		{
            if(mte.getRecipeMap() != RecipeMaps.FLUID_HEATER_RECIPES)
            {
            	super.modifyOverclockPost(resultOverclock, storage);
                resultOverclock[1] /= mte.getProcessingSpeed(); 
                resultOverclock[1] = Math.max(1, resultOverclock[1]);
            }
        }
        
        @NotNull
        @Override
        public ParallelLogicType getParallelLogicType() 
        {
            return mte.getRecipeMap() == RecipeMaps.FURNACE_RECIPES ? ParallelLogicType.APPEND_ITEMS:
            														  ParallelLogicType.MULTIPLY;
        }
        
        @Override
		public int getParallelLimit()
		{
			return mte.getParallels();
		}
    }
}

