package nepjr.tech.common.metatileentities.multi.electric;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.*;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.GTUtility;
import gregtech.api.util.RelativeDirection;
import gregtech.api.util.TextComponentUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import nepjr.tech.api.NepTechAPI;
import nepjr.tech.api.block.IMetalworkingModuleStats;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static gregtech.api.util.RelativeDirection.*;

public class MetaTileEntityIndustrialMetalworkingUnit extends MultiMapMultiblockController
{
    protected float processingSpeed;
    protected int moduleTier;
    public MetaTileEntityIndustrialMetalworkingUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.BENDER_RECIPES,
                RecipeMaps.EXTRUDER_RECIPES,
                RecipeMaps.FORMING_PRESS_RECIPES
        });
        this.recipeMapWorkable = new MetalworkingRecipeLogic(this);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);

        Object metalworkingModule = context.get("MetalworkingModule");
        if (metalworkingModule instanceof IMetalworkingModuleStats)
        {
            this.processingSpeed = ((IMetalworkingModuleStats) metalworkingModule).getProcessingSpeed();
            this.moduleTier = ((IMetalworkingModuleStats) metalworkingModule).getTier();
        }
        else
        {
            this.processingSpeed = 0;
            this.moduleTier = GTValues.LV;
        }
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern()
    {
        return FactoryBlockPattern.start(FRONT, UP, RIGHT)
                .aisle(" CCC ", "CCCCC", "CCCCC", "CCCCC", " CCC ")
                .aisle("     ", " CCC ", " CCC ", " CCC ", "     ")
                .aisle("     ", " CCC ", " CMI ", " CCC ", "     ").setRepeatable(0, 15)
                .aisle("     ", " CCO ", " SMI ", " CCO ", "     ")
                .aisle("     ", " CCC ", " CMI ", " CCC ", "     ").setRepeatable(0, 15)
                .aisle("     ", " CCC ", " CCC ", " CCC ", "     ")
                .aisle(" CCC ", "CCCCC", "CCCCC", "CCCCC", " CCC ")
                .where('C', states(getCasingState())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1, 1).setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1)))
                .where('M', metalworkingModules())
                .where('I', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1, 1)
                        .or(states(getCasingState())))
                .where(' ', any())
                .where('S', selfPredicate())
                .build();
    }

    private IBlockState getCasingState()
    {
        return NTMetaBlocks.NT_CASINGS.getState(BlockNTCasings.NTCasingType.STRESS_PROOF_CASING);
    }

    public static Supplier<TraceabilityPredicate> METALWORKING_MODULES = () -> new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (NepTechAPI.METALWORKING_MODULES.containsKey(blockState)) {
            IMetalworkingModuleStats stats = NepTechAPI.METALWORKING_MODULES.get(blockState);
            Object currentCoil = blockWorldState.getMatchContext().getOrPut("MetalworkingModule", stats);
            if (!currentCoil.equals(stats)) {
                blockWorldState.setError(new PatternStringError("neptech.multiblock.pattern.error.metalworking_module"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> NepTechAPI.METALWORKING_MODULES.entrySet().stream()
            // sort to make autogenerated jei previews not pick random coils each game load
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(entry -> new BlockInfo(entry.getKey(), null))
            .toArray(BlockInfo[]::new))
            .addTooltips("neptech.multiblock.pattern.error.metalworking_module");

    public static TraceabilityPredicate metalworkingModules() {
        return METALWORKING_MODULES.get();
    }

    @Override
    public boolean canBeDistinct()
    {
        return true;
    }

    @Override
    protected Function<BlockPos, Integer> multiblockPartSorter()
    {
        // player's right when looking at the controller, but the controller's left
        return RelativeDirection.LEFT.getSorter(getFrontFacing(), getUpwardsFacing(), isFlipped());
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
    {
        return NTTextures.STRESS_PROOF_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return Textures.BENDER_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addParallelsLine(recipeMapWorkable.getParallelLimit())
                .addCustom(tl ->
                {
                    ITextComponent psTxt;
                    if(getProcessingSpeed() > 0)
                    {
                        psTxt = TextComponentUtil.stringWithColor(TextFormatting.GREEN, "%+" + String.valueOf((int) Math.round(100 * getProcessingSpeed())));
                    }
                    else if (getProcessingSpeed() == 0)
                    {
                        psTxt = TextComponentUtil.stringWithColor(TextFormatting.GRAY, String.valueOf(0));
                    }
                    else
                    {
                        psTxt = TextComponentUtil.stringWithColor(TextFormatting.RED, String.valueOf((int) Math.round(100 * getProcessingSpeed())));
                    }
                    tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed_mixer", psTxt));
                })
                .addWorkingStatusLine()
                .addProgressLine(recipeMapWorkable.getProgressPercent());
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
    {
        return new MetaTileEntityIndustrialMetalworkingUnit(metaTileEntityId);
    }

    public float getProcessingSpeed()
    {
        int i = -1 * getMbSize() - 1;
        i /= 10; // every time the Mb gets wider or taller, it makes it 10% slower
        return i + processingSpeed;
    }

    public int getMbSize()
    {
        return getAbilities(MultiblockAbility.IMPORT_ITEMS).size();
    }

    public int getModuleTier()
    {
        return moduleTier;
    }

    private class MetalworkingRecipeLogic extends MultiblockRecipeLogic
    {
        private MetaTileEntityIndustrialMetalworkingUnit mte;
        public MetalworkingRecipeLogic(MetaTileEntityIndustrialMetalworkingUnit tileEntity)
        {
            super(tileEntity);
            mte = tileEntity;
        }

        @Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage)
        {
            super.modifyOverclockPost(resultOverclock, storage);

            if(mte.getProcessingSpeed() > 0.0f)
            {
                resultOverclock[1] /= (int) mte.getProcessingSpeed();
                resultOverclock[1] = Math.max(1, resultOverclock[1]);
            }
            if(mte.getProcessingSpeed() < 0.0f)
            {
                float f = Math.abs(mte.getProcessingSpeed()); // Convert back into positive value
                f += 1.0f; // Add one
                resultOverclock[1] *= (int) f;
            }
        }

        @Override
        public int getParallelLimit()
        {
            return 128 * (mte.getMbSize() + 1);
        }
    }
}
