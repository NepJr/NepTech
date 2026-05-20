package nepjr.tech.metatileentities.multi.electric;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.GasCollectorDimensionProperty;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import it.unimi.dsi.fastutil.ints.IntLists;
import nepjr.tech.api.metatileentity.NTMetaTileEntity;
import nepjr.tech.api.recipes.NTRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityDroneLauncher extends NTMetaTileEntity
{

	public MetaTileEntityDroneLauncher(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, NTRecipeMaps.ASTEROID_MINING);
		this.recipeMapWorkable = new DroneLauncherRecipeLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() 
	{
		return FactoryBlockPattern.start()
				.aisle("ABBBA", "AGGGA", "ACCCA", "AGGGA", "ACCCA", "AGGGA", "ACCCA")
				.aisle("BBBBB", "GFIFG", "CFIFC", "GFIFG", "CFIFC", "GFIFG", "CCCCC")
				.aisle("BBBBB", "GIIIG", "CIIIC", "GIIIG", "CIIIC", "GIIIG", "CCMCC")
				.aisle("BBBBB", "GFIFG", "CFIFC", "GFIFG", "CFIFC", "GFIFG", "CCCCC")
				.aisle("ABSBA", "AGGGA", "ACCCA", "AGGGA", "ACCCA", "AGGGA", "ACCCA")
				.where('S', selfPredicate())
				.where('B', states(getCasingState()).or(autoAbilities(true, true, true, true, true, true, false)))
				.where('F', frames(Materials.StainlessSteel))
				.where('I', air())
				.where('A', any())
				.where('G', states(getGratingState()))
				.where('C', states(getCasingState()))
				.where('M', autoAbilities(false, false, false, false, false, false, true))
				.build();
	}
	
	@Override
	public boolean hasMufflerMechanics() 
	{
		return true;
	}
	
	protected IBlockState getCasingState() 
	{
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID);
    }
	
	protected IBlockState getGratingState() 
	{
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasingType.GRATE_CASING);
    }
	
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) 
	{
		return Textures.SOLID_STEEL_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
		return new MetaTileEntityDroneLauncher(metaTileEntityId);
	}
	
	protected boolean checkRecipe(@NotNull Recipe recipe) {
        for (int dimension : recipe.getProperty(GasCollectorDimensionProperty.getInstance(), IntLists.EMPTY_LIST)) {
            if (dimension == this.getWorld().provider.getDimension()) {
                return true;
            }
        }
        return false;
    }

    private static class DroneLauncherRecipeLogic extends MultiblockRecipeLogic {

        public DroneLauncherRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
            super(metaTileEntity);
        }

        @Override
        public boolean checkRecipe(@NotNull Recipe recipe) {
            return ((MetaTileEntityDroneLauncher) metaTileEntity).checkRecipe(recipe) && super.checkRecipe(recipe);
        }
    }

}
