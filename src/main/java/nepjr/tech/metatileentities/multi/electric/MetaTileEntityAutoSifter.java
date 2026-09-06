package nepjr.tech.metatileentities.multi.electric;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockCleanroomCasing.CasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import nepjr.tech.api.recipes.NTRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaTileEntityAutoSifter extends RecipeMapMultiblockController
{
	public MetaTileEntityAutoSifter(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, NTRecipeMaps.AUTO_SIFTER);
		this.recipeMapWorkable = new AutoSifterLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() 
	{
		return FactoryBlockPattern.start()
				.aisle("CCCCC", "CCCCC", "CCCCC")
				.aisle("CCCCC", "CFFFC", "CFFFC")
				.aisle("CCCCC", "CFFFC", "CFFFC")
				.aisle("CCCCC", "CCSCC", "CCCCC")
				.where('F', states(getFilterState()))
				.where('C', states(getCasingState()).or(autoAbilities(true, true, true, true, false, false, false)))
				.where('S', selfPredicate())
				.build();
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
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

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.SIFTER_OVERLAY;
    }
    
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) 
	{
		return Textures.SOLID_STEEL_CASING;
	}
	
	protected IBlockState getCasingState() 
	{
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID);
    }
	
	protected IBlockState getFilterState() 
	{
        return MetaBlocks.CLEANROOM_CASING.getState(CasingType.FILTER_CASING);
    }

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
		return new MetaTileEntityAutoSifter(metaTileEntityId);
	}
	
	protected class AutoSifterLogic extends MultiblockRecipeLogic
	{

		public AutoSifterLogic(RecipeMapMultiblockController tileEntity) 
		{
			super(tileEntity, true);
		}
	}

}
