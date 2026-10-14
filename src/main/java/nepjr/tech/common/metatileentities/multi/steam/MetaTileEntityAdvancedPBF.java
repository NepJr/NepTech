package nepjr.tech.common.metatileentities.multi.steam;

import org.jetbrains.annotations.NotNull;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.SteamMultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaTileEntityAdvancedPBF extends RecipeMapSteamMultiblockController
{
	private static final TraceabilityPredicate SNOW_PREDICATE = new TraceabilityPredicate(
            bws -> GTUtility.isBlockSnow(bws.getBlockState()));
	
	public MetaTileEntityAdvancedPBF(ResourceLocation metaTileEntityId)
	{
		super(metaTileEntityId, RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES, CONVERSION_RATE);
		this.recipeMapWorkable = new AdvancedPBFWorkable(this, CONVERSION_RATE);
		this.recipeMapWorkable.setParallelLimit(8);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() {
		// TODO Auto-generated method stub
		return FactoryBlockPattern.start()
				.aisle("CCC", "CCC", "CCC", "CCC")
				.aisle("CCC", "CXC", "C C", "C C")
				.aisle("CCC", "CSC", "CCC", "CCC")
				.where('C', states(getCasingState())
						.or(abilities(MultiblockAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
						.or(abilities(MultiblockAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
						.or(abilities(MultiblockAbility.STEAM).setExactLimit(1)))
				.where(' ', air())
				.where('X', air().or(SNOW_PREDICATE))
				.where('S', selfPredicate())
				.build();
	}
	
	private IBlockState getCasingState()
	{
		return MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		// TODO Auto-generated method stub
		return Textures.SOLID_STEEL_CASING;
	}
	
	@SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.PRIMITIVE_BLAST_FURNACE_OVERLAY;
    }
    
    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }


	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
	{
		// TODO Auto-generated method stub
		return new MetaTileEntityAdvancedPBF(metaTileEntityId);
	}

	public class AdvancedPBFWorkable extends SteamMultiblockRecipeLogic {
		
		protected final double conversionRate;
		protected final RecipeMapSteamMultiblockController mte;

	    public AdvancedPBFWorkable(RecipeMapSteamMultiblockController tileEntity, double conversionRate) {
	        super(tileEntity, tileEntity.recipeMap, tileEntity.getSteamFluidTank(), conversionRate);
	        this.mte = tileEntity;
	        if (conversionRate == 0) // In the event for some reason it's zero
	        	this.conversionRate = 1;
	        else
	        	this.conversionRate = 1 / conversionRate;
	    }

	    @Override
	    public long getMaxVoltage()
	    {
	        return GTValues.V[GTValues.HV];
	    }
	    
	    @Override
	    public boolean checkRecipe(@NotNull Recipe recipe)
	    {
	    	return recipe.getEUt() <= 32;
	    }
	    
	    @NotNull
	    @Override
	    public ParallelLogicType getParallelLogicType()
	    {
	    	return ParallelLogicType.MULTIPLY;
	    }

	    @Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[0] = (int) (32 * conversionRate);
            
            resultOverclock[1] *= 0.8;
        }
	}
	
}
