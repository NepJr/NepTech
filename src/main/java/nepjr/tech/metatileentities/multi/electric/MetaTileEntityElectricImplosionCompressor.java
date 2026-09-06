package nepjr.tech.metatileentities.multi.electric;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityElectricImplosionCompressor extends RecipeMapMultiblockController
{

	public MetaTileEntityElectricImplosionCompressor(ResourceLocation metaTileEntityId)
	{
		super(metaTileEntityId, NTRecipeMaps.ELECTRIC_IMPLOSION_RECIPES);
		this.recipeMapWorkable = new EICRecipeLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() {
		return FactoryBlockPattern.start()
				.aisle(" CCCCC ", "       ", "       ", "       ", "       ", "       ", " CCCCC ")
				.aisle("CCCCCCC", " F   F ", " F   F ", " F   F ", " F   F ", " F   F ", "CCCCCCC")
				.aisle("CCCCCCC", "  WWW  ", "  WWW  ", "  WWW  ", "  WWW  ", "  WWW  ", "CCCCCCC")
				.aisle("CCCCCCC", "  WAW  ", "  WAW  ", "  WAW  ", "  WAW  ", "  WAW  ", "CCCMCCC")
				.aisle("CCCCCCC", "  WWW  ", "  WWW  ", "  WSW  ", "  WWW  ", "  WWW  ", "CCCCCCC")
				.aisle("CCCCCCC", " F   F ", " F   F ", " F   F ", " F   F ", " F   F ", "CCCCCCC")
				.aisle(" CCCCC ", "       ", "       ", "       ", "       ", "       ", " CCCCC ")
				.where(' ', any())
				.where('A', air())
				.where('W', states(getCasingState()).setMinGlobalLimited(32)
						.or(abilities(MultiblockAbility.IMPORT_ITEMS).setPreviewCount(1))
						.or(abilities(MultiblockAbility.EXPORT_ITEMS).setPreviewCount(1))
						.or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setPreviewCount(1))
						.or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.INPUT_ENERGY).stream()
								.filter(mte -> (mte instanceof ITieredMetaTileEntity) &&
		                                (((ITieredMetaTileEntity) mte).getTier() >= GTValues.ZPM))
		                        .toArray(MetaTileEntity[]::new))
		                                .addTooltip("gregtech.multiblock.pattern.error.limited.1", GTValues.VN[GTValues.ZPM])
		                                .setMaxGlobalLimited(2, 1)))
				.where('M', metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.MUFFLER_HATCH).stream()
                        .filter(mte -> (mte instanceof ITieredMetaTileEntity) &&
                                (((ITieredMetaTileEntity) mte).getTier() >= GTValues.ZPM))
                        .toArray(MetaTileEntity[]::new))
                                .addTooltip("gregtech.multiblock.pattern.error.limited.1", GTValues.VN[GTValues.ZPM])
                                .setExactLimit(1))
				.where('C', states(getCasingState()))
				.where('F', getFrameboxState())
				.where('S', selfPredicate())
				.build();
	}
	
	@Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addParallelsLine(recipeMapWorkable.getParallelLimit())
                .addWorkingStatusLine()
                .addProgressLine(recipeMapWorkable.getProgressPercent());
    }
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(TextFormatting.LIGHT_PURPLE + I18n.format("neptech.electric_implosion_compressor.parallels"));
    }

	@Override
	public boolean hasMufflerMechanics() 
	{
		return true;
	}
	
	protected IBlockState getCasingState() 
	{
        return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NAQUADAH_ALLOY);
    }
	
	protected TraceabilityPredicate getFrameboxState()
	{
		return frames(Materials.NaquadahAlloy);
	}
	
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		// TODO Auto-generated method stub
		return NTTextures.NAQUADAH_ALLOY_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
		// TODO Auto-generated method stub
		return new MetaTileEntityElectricImplosionCompressor(metaTileEntityId);
	}
	
	private class EICRecipeLogic extends MultiblockRecipeLogic
	{
		private MetaTileEntityElectricImplosionCompressor tileEntity;
		public EICRecipeLogic(MetaTileEntityElectricImplosionCompressor tileEntity) 
		{
			super(tileEntity, true);
			this.tileEntity = tileEntity;
		}
		
		@Override
		public int getParallelLimit()
		{
			return (int) Math.pow(8, GTUtility.getTierByVoltage(((MetaTileEntityElectricImplosionCompressor) tileEntity).getEnergyContainer().getInputVoltage()) - GTValues.LuV);
		}
		
	}

}
