package nepjr.tech.metatileentities.multi.electric.generator;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import gregtech.common.blocks.BlockTurbineCasing.TurbineCasingType;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeCombustionEngine;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaTileEntityOverkillCombustionEngine extends MetaTileEntityLargeCombustionEngine
{

	public MetaTileEntityOverkillCombustionEngine(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, GTValues.LuV);
		this.recipeMapWorkable = new OverkillCombustionEngineWorkableHandler(this);
		this.recipeMapWorkable.setMaximumOverclockVoltage(GTValues.V[GTValues.LuV]);
	}
	

	@Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
        return new MetaTileEntityOverkillCombustionEngine(metaTileEntityId);
    }
	
	@Override
	public IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.HSSE_STURDY);
    }
	
	@Override
	public IBlockState getGearboxState() {
        return MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.TUNGSTENSTEEL_GEARBOX);
    }

	@Override
    public IBlockState getIntakeState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING);
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.ROBUST_TUNGSTENSTEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.EXTREME_COMBUSTION_ENGINE_OVERLAY;
    }
    
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
    	OverkillCombustionEngineWorkableHandler recipeLogic = ((OverkillCombustionEngineWorkableHandler) recipeMapWorkable);

        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive());

        
        builder.addEnergyProductionLine(GTValues.V[GTValues.ZPM], recipeLogic.getRecipeEUt());

        builder.addFuelNeededLine(recipeLogic.getRecipeFluidInputInfo(), recipeLogic.getPreviousRecipeDuration())
                .addCustom(tl -> {
                    if (isStructureFormed() && recipeLogic.isCryotheumBoosted) {
                        String key = "neptech.multiblock.large_combustion_engine.cryotheum_boosted";
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.AQUA, key));
                    }
                })
                .addWorkingStatusLine();
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.universal.tooltip.base_production_eut", GTValues.V[GTValues.LuV]));
        tooltip.add(I18n.format("gregtech.universal.tooltip.uses_per_hour_lubricant", 1000));
        tooltip.add(I18n.format("neptech.machine.overkill_combustion_engine.tooltip.boost_regular",
                GTValues.V[GTValues.LuV] * 6));
    }
    
    @Override
    public double getFillPercentage(int index) {
        if (index == 0) {
            int[] fuelAmount = new int[2];
            if (getInputFluidInventory() != null) {
                MultiblockFuelRecipeLogic recipeLogic = (MultiblockFuelRecipeLogic) recipeMapWorkable;
                if (recipeLogic.getInputFluidStack() != null) {
                    FluidStack testStack = recipeLogic.getInputFluidStack().copy();
                    testStack.amount = Integer.MAX_VALUE;
                    fuelAmount = getTotalFluidAmount(testStack, getInputFluidInventory());
                }
            }
            return fuelAmount[1] != 0 ? 1.0 * fuelAmount[0] / fuelAmount[1] : 0;
        } else if (index == 1) {
            int[] lubricantAmount = new int[2];
            if (getInputFluidInventory() != null) {
                lubricantAmount = getTotalFluidAmount(Materials.Lubricant.getFluid(Integer.MAX_VALUE),
                        getInputFluidInventory());
            }
            return lubricantAmount[1] != 0 ? 1.0 * lubricantAmount[0] / lubricantAmount[1] : 0;
        } else {
            int[] cryotheumAmount = new int[2];
            if (getInputFluidInventory() != null) {
                if (isBoostAllowed()) {
                    FluidStack cryotheumStack = NTMaterials.Cryotheum.getFluid(Integer.MAX_VALUE);
                    cryotheumAmount = getTotalFluidAmount(cryotheumStack, getInputFluidInventory());
                }
            }
            return cryotheumAmount[1] != 0 ? 1.0 * cryotheumAmount[0] / cryotheumAmount[1] : 0;
        }
    }
    
    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        if (index == 0) {
            addFuelText(hoverList);
        } else if (index == 1) {
            // Lubricant
            int lubricantStored = 0;
            int lubricantCapacity = 0;
            if (isStructureFormed() && getInputFluidInventory() != null) {
                // Hunt for tanks with lubricant in them
                int[] lubricantAmount = getTotalFluidAmount(Materials.Lubricant.getFluid(Integer.MAX_VALUE),
                        getInputFluidInventory());
                lubricantStored = lubricantAmount[0];
                lubricantCapacity = lubricantAmount[1];
            }

            ITextComponent lubricantInfo = TextComponentUtil.stringWithColor(
                    TextFormatting.GOLD,
                    TextFormattingUtil.formatNumbers(lubricantStored) + " / " +
                            TextFormattingUtil.formatNumbers(lubricantCapacity) + " L");
            hoverList.add(TextComponentUtil.translationWithColor(
                    TextFormatting.GRAY,
                    "gregtech.multiblock.large_combustion_engine.lubricant_amount",
                    lubricantInfo));
        } else {
            // Cryotheum
            if (isBoostAllowed()) {
                int cryotheumStored = 0;
                int cryotheumCapacity = 0;
                if (isStructureFormed() && getInputFluidInventory() != null) {
                    // Hunt for tanks with Oxygen or LOX (depending on tier) in them
                    FluidStack cryotheumStack = NTMaterials.Cryotheum.getFluid(Integer.MAX_VALUE);
                    int[] cryotheumAmount = getTotalFluidAmount(cryotheumStack, getInputFluidInventory());
                    cryotheumStored = cryotheumAmount[0];
                    cryotheumCapacity = cryotheumAmount[1];
                }

                ITextComponent oxygenInfo = TextComponentUtil.stringWithColor(
                        TextFormatting.AQUA,
                        TextFormattingUtil.formatNumbers(cryotheumStored) + " / " +
                                TextFormattingUtil.formatNumbers(cryotheumCapacity) + " L");
                String key = "neptech.multiblock.large_combustion_engine.cryotheum_amount";
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, key, oxygenInfo));
            } else {
                String key = "neptech.multiblock.large_combustion_engine.cryotheum_boost_disallowed";
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, key));
            }
        }
    }
    
    private static class OverkillCombustionEngineWorkableHandler extends MultiblockFuelRecipeLogic {

        private boolean isCryotheumBoosted = false;

        private final MetaTileEntityOverkillCombustionEngine combustionEngine;
        private final int tier;

        private static final FluidStack CRYOTHEUM_STACK = NTMaterials.Cryotheum.getFluid(1);
        private static final FluidStack LUBRICANT_STACK = Materials.Lubricant.getFluid(1);

        public OverkillCombustionEngineWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.combustionEngine = (MetaTileEntityOverkillCombustionEngine) tileEntity;
            this.tier = GTValues.LuV;
        }

        @Override
        protected void updateRecipeProgress() {
            if (canRecipeProgress && drawEnergy(recipeEUt, true)) {
                drainLubricant();
                drainOxygen();
                drawEnergy(recipeEUt, false);

                // as recipe starts with progress on 1 this has to be > only not => to compensate for it
                if (++progressTime > maxProgressTime) {
                    completeRecipe();
                }
            }
        }

        protected void checkOxygen() {
            // check oxygen if present to boost production, and if the dynamo hatch supports it
            if (combustionEngine.isBoostAllowed()) {
                IMultipleTankHandler inputTank = combustionEngine.getInputFluidInventory();
                FluidStack boosterStack = CRYOTHEUM_STACK;
                isCryotheumBoosted = boosterStack.isFluidStackIdentical(inputTank.drain(boosterStack, false));
            }
        }

        protected void drainOxygen() {
            if (isCryotheumBoosted && totalContinuousRunningTime % 20 == 0) {
                FluidStack boosterStack = CRYOTHEUM_STACK;
                combustionEngine.getInputFluidInventory().drain(boosterStack, true);
            }
        }

        protected boolean checkLubricant() {
            // check lubricant and invalidate if it fails
            IMultipleTankHandler inputTank = combustionEngine.getInputFluidInventory();
            if (LUBRICANT_STACK.isFluidStackIdentical(inputTank.drain(LUBRICANT_STACK, false))) {
                return true;
            } else {
                invalidate();
                return false;
            }
        }

        protected void drainLubricant() {
            if (totalContinuousRunningTime == 1 || totalContinuousRunningTime % 72 == 0) {
                IMultipleTankHandler inputTank = combustionEngine.getInputFluidInventory();
                inputTank.drain(LUBRICANT_STACK, true);
            }
        }

        @Override
        protected boolean shouldSearchForRecipes() {
            checkOxygen();
            return super.shouldSearchForRecipes() && checkLubricant();
        }

        @Override
        protected boolean canProgressRecipe() {
            return super.canProgressRecipe() && checkLubricant();
        }

        @Override
        public long getMaxVoltage() {
            // this multiplies consumption through parallel
            if (isCryotheumBoosted)
                return GTValues.V[tier] * 2;
            else
                return GTValues.V[tier];
        }

        @Override
        protected long boostProduction(long production) {
            // this multiplies production without increasing consumption
            if (isCryotheumBoosted)
                return production * 3;
            return production;
        }

        @Override
        public void invalidate() {
        	isCryotheumBoosted = false;
            super.invalidate();
        }
    }
}
