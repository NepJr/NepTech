package nepjr.tech.metatileentities.multi.electric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.metatileentity.NTMetaTileEntity;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTUniqueCasing.UniqueCasingType;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityHellishABS extends NTMetaTileEntity implements IHeatingCoil
{
	private int blastFurnaceTemperature;

    public MetaTileEntityHellishABS(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, NTRecipeMaps.ALLOY_BLAST_RECIPES, false, 0.8F, 1.5F);
        this.recipeMapWorkable = new HellishABSLogic(this);
        this.setParallels(8);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityHellishABS(metaTileEntityId);
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
        if (type instanceof IHeatingCoilBlockStats) {
            this.blastFurnaceTemperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
        } else {
            this.blastFurnaceTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
        }

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
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#XXX#", "#CCC#", "#GGG#", "#CCC#", "#XXX#")
                .aisle("XXXXX", "CAAAC", "GAAAG", "CAAAC", "XXXXX")
                .aisle("XXXXX", "CAAAC", "GAAAG", "CAAAC", "XXMXX")
                .aisle("XXXXX", "CAAAC", "GAAAG", "CAAAC", "XXXXX")
                .aisle("#XSX#", "#CCC#", "#GGG#", "#CCC#", "#XXX#")
                .where('S', selfPredicate())
                .where('X',
                        states(getCasingState()).setMinGlobalLimited(30)
                                .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('C', heatingCoils())
                .where('G', states(getCasingState2()))
                .where('M', metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.MUFFLER_HATCH).stream()
                        .filter(mte -> (mte instanceof ITieredMetaTileEntity) &&
                                (((ITieredMetaTileEntity) mte).getTier() >= GTValues.LuV))
                        .toArray(MetaTileEntity[]::new))
                                .addTooltip("gregtech.multiblock.pattern.error.limited.1", GTValues.VN[GTValues.LuV])
                                .setExactLimit(1))
                .where('A', air())
                .where('#', any())
                .build();
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("#XEX#", "#CCC#", "#GGG#", "#CCC#", "#XXX#")
                .aisle("XXXXX", "C###C", "G###G", "C###C", "XXXXX")
                .aisle("XXXXX", "C###C", "G###G", "C###C", "XXMXX")
                .aisle("FXXXH", "C###C", "G###G", "C###C", "XXXXX")
                .aisle("#ISO#", "#CCC#", "#GGG#", "#CCC#", "#XXX#")
                .where('S', NTMetaTileEntities.ALLOY_BLAST_SMELTER, EnumFacing.SOUTH)
                .where('X', getCasingState())
                .where('G', getCasingState2())
                .where('M', MetaTileEntities.MUFFLER_HATCH[GTValues.LuV], EnumFacing.UP)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.HV], EnumFacing.SOUTH)
                .where('O', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.HV], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.EV], EnumFacing.NORTH)
                .where('H',
                        () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH :
                                getCasingState(),
                        EnumFacing.SOUTH)
                .where('#', Blocks.AIR.getDefaultState());

        GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> shapeInfo.add(builder.where('C', entry.getKey()).build()));
        return shapeInfo;
    }

    protected IBlockState getCasingState() {
        return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NETHERITE);
    }

    private static IBlockState getCasingState2() {
        return NTMetaBlocks.UNIQUE_CASINGS.getState(UniqueCasingType.HEAT_VENT);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TextFormatting.AQUA + I18n.format("neptech.hellish_ebf.oc.tip"));
    }

    @Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		// TODO Auto-generated method stub
		return NTTextures.NETHERITE_CASING;
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
    
    protected class HellishABSLogic extends HeatingCoilRecipeLogic
	{
		protected MetaTileEntityHellishABS mte;
		public HellishABSLogic(RecipeMapMultiblockController metaTileEntity) 
		{
			super(metaTileEntity);
			mte = (MetaTileEntityHellishABS) this.getMetaTileEntity();
		}
		
		@Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[0] *= mte.getEnergyDiscount(); 
            resultOverclock[0] = Math.max(1, resultOverclock[0]);
            
            resultOverclock[1] /= mte.getProcessingSpeed(); 
            resultOverclock[1] = Math.max(1, resultOverclock[1]);
        }
		
		@Override
		public int getParallelLimit()
		{
			if(mte.getParallels() <= Integer.MAX_VALUE)
			{
				return (int) mte.getParallels();
			}
			if(mte.getParallels() > Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}
			else
			{
				return 1;
			}
		}
	}
}
