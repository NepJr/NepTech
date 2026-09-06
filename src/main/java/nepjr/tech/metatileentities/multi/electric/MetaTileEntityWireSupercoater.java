package nepjr.tech.metatileentities.multi.electric;

import org.jetbrains.annotations.NotNull;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolymerProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolymerTypeProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolyphenyleneSulfideProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolyvinylChlorideProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityWireSupercoater extends RecipeMapMultiblockController
{
	protected int parallels;
	protected float processingSpeed;
	protected float fluidDiscount;
	
	public MetaTileEntityWireSupercoater(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, NTRecipeMaps.WIRE_SUPERCOATER);
		this.recipeMapWorkable = new WireSupercoaterLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() 
	{
		// TODO Auto-generated method stub
		return FactoryBlockPattern.start()
					.aisle("CCCCCCCCC", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "  CCCCC  ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "  CCCCC  ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "  CCCCC  ", "   CCC   ", "   WWW   ", "   WWW   ", "   WWW   ", "   CCC   ", "   CCC   ", "   CCC   ", "   WWW   ", "   WWW   ", "   WWW   ", "   CCC   ", "  CCCCC  ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCPCCC ", "  CCPCC  ", "   CPC   ", "   WPW   ", "   WPW   ", "   WPW   ", "   CPC   ", "   CPC   ", "   CPC   ", "   WPW   ", "   WPW   ", "   WPW   ", "   CPC   ", "  CCPCC  ", " CCCPCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "  CCCCC  ", "   CCC   ", "   WWW   ", "   WWW   ", "   WWW   ", "   CCC   ", "   CSC   ", "   CCC   ", "   WWW   ", "   WWW   ", "   WWW   ", "   CCC   ", "  CCCCC  ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "  CCCCC  ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "  CCCCC  ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", " CCCCCCC ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", " CCCCCCC ", "CCCCCCCCC")
					.aisle("CCCCCCCCC", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "F       F", "CCCCCCCCC")
					.where('W', heatingCoils())
					.where('C', states(getCasingState())
							.or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1, 1))
							.or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1, 1))
							.or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1, 1))
							.or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
							.or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1, 1).setMaxGlobalLimited(3)))
					.where('P', states(getPipeState()))
					.where('F', frames(Materials.Polytetrafluoroethylene))
					.where(' ', any())
					.where('S', selfPredicate())
					.build();
	}
	
	@Override
    protected void formStructure(PatternMatchContext context)
	{
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        if (coilType instanceof IHeatingCoilBlockStats) 
        {
        	int tier = ((IHeatingCoilBlockStats) coilType).getTier();
            this.parallels = ((IHeatingCoilBlockStats) coilType).getLevel() * 32;
            this.fluidDiscount = (float) (100 - 10 * tier) / 100;
            if(tier > 0)
            {
            	this.processingSpeed = (float) (((50 * (tier + 1)) + (25 * (tier + 1)))) / 100;
            }
            else
            {
            	this.processingSpeed = 1;
            }
        } 
        else 
        {
            this.parallels = CoilType.CUPRONICKEL.getLevel() * 32;
            this.processingSpeed = 1;
            this.fluidDiscount = 1;
        }
    }
	
	@Override
    public void invalidateStructure() 
	{
        super.invalidateStructure();
        this.parallels = 0;
        this.processingSpeed = 0;
        this.fluidDiscount = 0;
    }
	
	protected IBlockState getCasingState() 
	{
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.PTFE_INERT_CASING);
    }
	
	protected IBlockState getPipeState()
	{
		return MetaBlocks.BOILER_CASING.getState(BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) 
	{
		return Textures.INERT_PTFE_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
		return new MetaTileEntityWireSupercoater(metaTileEntityId);
	}
	
	public int getParallels()
	{
		return parallels * 8;
	}
	
	public float getProcessingSpeed()
	{
		return processingSpeed;
	}
	
	public float getFluidDiscount()
	{
		return fluidDiscount;
	}
	
	private class WireSupercoaterLogic extends MultiblockRecipeLogic
	{
		private MetaTileEntityWireSupercoater mte;
		private int parallels;
		public WireSupercoaterLogic(MetaTileEntityWireSupercoater tileEntity) 
		{
			super(tileEntity, true);
			this.mte = tileEntity;
		}
		
		@Override
        public boolean checkRecipe(@NotNull Recipe recipe) 
		{
			Material polymer = recipe.getProperty(SupercoaterPolymerTypeProperty.getInstance(), null);
			int polymerAmount = recipe.getProperty(SupercoaterPolymerProperty.getInstance(), 0);
			int pvcAmount = recipe.getProperty(SupercoaterPolyvinylChlorideProperty.getInstance(), 0);
			int ppsAmount = recipe.getProperty(SupercoaterPolyphenyleneSulfideProperty.getInstance(), 0);
			
			if (getParallelLimit() > 1 && getRecipeMap() != null) {
	            RecipeBuilder<?> parallelBuilder = switch (getParallelLogicType()) {
	                case MULTIPLY -> findMultipliedParallelRecipe(getRecipeMap(), recipe, mte.getInputInventory(), mte.getInputFluidInventory(),
	                        mte.getOutputInventory(), mte.getOutputFluidInventory(), getParallelLimit(), getMaxVoltage(), getMetaTileEntity());
	                case APPEND_ITEMS -> findAppendedParallelItemRecipe(getRecipeMap(), mte.getInputInventory(), mte.getOutputInventory(), getParallelLimit(),
	                		getMaxVoltage(), getMetaTileEntity());
	            };

	            // if the builder returned is null, no recipe was found.
	            if (parallelBuilder == null) {
	                invalidateInputs();
	                return false;
	            } else {
	                // if the builder returned does not parallel, its outputs are full
	                if (parallelBuilder.getParallel() == 0) {
	                    invalidateOutputs();
	                    return false;
	                } else {
	                    parallels = parallelBuilder.getParallel();
	                }
	            }
	        }
			
			polymerAmount = (int) Math.max(1, Math.floor(mte.getFluidDiscount() * polymerAmount * parallels));
			pvcAmount = (int) Math.max(1, Math.floor(mte.getFluidDiscount() * pvcAmount * parallels));
			ppsAmount = (int) Math.max(1, Math.floor(mte.getFluidDiscount() * ppsAmount * parallels));
			
            if (!super.checkRecipe(recipe))
                return false;
            
            if(mte.getInputFluidInventory().drain(polymer.getFluid(polymerAmount), false) == null)
            {
            	return false;
            }
            
            if(mte.getInputFluidInventory().drain(Materials.PolyvinylChloride.getFluid(pvcAmount), false) == null)
            {
            	return false;
            }
            
            if(mte.getInputFluidInventory().drain(Materials.PolyphenyleneSulfide.getFluid(ppsAmount), false) == null)
            {
            	return false;
            }
            
            mte.getInputFluidInventory().drain(polymer.getFluid(polymerAmount), true);
            mte.getInputFluidInventory().drain(Materials.PolyvinylChloride.getFluid(pvcAmount), true);
            mte.getInputFluidInventory().drain(Materials.PolyphenyleneSulfide.getFluid(ppsAmount), true);
            
            return true;
		}
		
		@Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[1] /= mte.getProcessingSpeed(); 
            resultOverclock[1] = Math.max(1, resultOverclock[1]);
        }
		
		@Override
		public int getParallelLimit()
		{
			return mte.getParallels();
		}
	}

}
