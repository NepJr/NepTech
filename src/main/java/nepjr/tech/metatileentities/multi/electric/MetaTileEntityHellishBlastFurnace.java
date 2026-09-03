package nepjr.tech.metatileentities.multi.electric;

import static gregtech.api.recipes.logic.OverclockingLogic.heatingCoilOverclockingLogic;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import nepjr.tech.api.metatileentity.NTMetaTileEntity;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityHellishBlastFurnace extends NTMetaTileEntity implements IHeatingCoil
{
	private int blastFurnaceTemperature;
	public MetaTileEntityHellishBlastFurnace(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, RecipeMaps.BLAST_RECIPES, false, 0.8F, 0.9F);
		this.recipeMapWorkable = new HellishBlastFurnaceLogic(this);
		this.setParallels(8);
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TextFormatting.AQUA + I18n.format("neptech.hellish_ebf.oc.tip"));
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
            this.blastFurnaceTemperature = CoilType.CUPRONICKEL.getCoilTemperature();
        }
        // the subtracted tier gives the starting level (exclusive) of the +100K heat bonus
        this.blastFurnaceTemperature += 100 *
                Math.max(0, GTUtility.getFloorTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
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
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "CCC", "CCC", "XXX")
                .aisle("XXX", "C#C", "C#C", "XMX")
                .aisle("XSX", "CCC", "CCC", "XXX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(9)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('C', heatingCoils())
                .where('#', air())
                .build();
    }

    protected IBlockState getCasingState() {
        return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NETHERITE);
    }

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		// TODO Auto-generated method stub
		return NTTextures.NETHERITE_CASING;
	}
	

	@Override
	public int getCurrentTemperature() 
	{
		return blastFurnaceTemperature;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
		// TODO Auto-generated method stub
		return new MetaTileEntityHellishBlastFurnace(metaTileEntityId);
	}
	
	protected class HellishBlastFurnaceLogic extends HeatingCoilRecipeLogic
	{
		protected MetaTileEntityHellishBlastFurnace mte;
		public HellishBlastFurnaceLogic(RecipeMapMultiblockController metaTileEntity) 
		{
			super(metaTileEntity);
			mte = (MetaTileEntityHellishBlastFurnace) this.getMetaTileEntity();
		}
		
		@Override
		public int getParallelLimit()
		{
			return mte.getParallels();
		}
	}
}
