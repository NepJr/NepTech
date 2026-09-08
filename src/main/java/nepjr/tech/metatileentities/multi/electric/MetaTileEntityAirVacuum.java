package nepjr.tech.metatileentities.multi.electric;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityAirVacuum extends RecipeMapMultiblockController
{
	protected int tier;
	public MetaTileEntityAirVacuum(ResourceLocation metaTileEntityId, int tier)
	{
		super(metaTileEntityId, RecipeMaps.GAS_COLLECTOR_RECIPES);
		this.tier = tier;
		this.recipeMapWorkable = new AirVacuumLogic(this);
	}
	@Override
	protected @NotNull BlockPattern createStructurePattern()
	{
		// TODO Auto-generated method stub
		return FactoryBlockPattern.start()
				.aisle("CCCCC", "CIIIC", "CCCCC", "CIIIC", "CCCCC", "CIIIC", "CCCCC")
				.aisle("CCCCC", "IAPAI", "CAAAC", "IAPAI", "CAAAC", "IAPAI", "CCCCC")
				.aisle("CCCCC", "IPPPI", "CAPAC", "IPPPI", "CAPAC", "IPPPI", "CCCCC")
				.aisle("CCCCC", "IAPAI", "CAAAC", "IAPAI", "CAAAC", "IAPAI", "CCCCC")
				.aisle("CCSCC", "CIIIC", "CCCCC", "CIIIC", "CCCCC", "CIIIC", "CCCCC")
				.where('C', states(getCasingState()).or(autoAbilities()))
				.where('I', states(getIntakeState()))
				.where('P', states(getPipeState()))
				.where('A', air())
				.where('S', selfPredicate())
				.build();
	}
	
	private IBlockState getIntakeState()
	{
		return tier == 1 ? MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING) :
						   MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasingType.ENGINE_INTAKE_CASING);
	}
	
	private IBlockState getPipeState()
	{
		return tier == 1 ? MetaBlocks.BOILER_CASING.getState(BoilerCasingType.TUNGSTENSTEEL_PIPE) :
						   MetaBlocks.BOILER_CASING.getState(BoilerCasingType.TITANIUM_PIPE);
	}
	
	private IBlockState getCasingState()
	{
		return tier == 1 ? MetaBlocks.METAL_CASING.getState(MetalCasingType.TUNGSTENSTEEL_ROBUST) :
						   MetaBlocks.METAL_CASING.getState(MetalCasingType.TITANIUM_STABLE);
	}
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
	{
		// TODO Auto-generated method stub
		return tier == 1 ? Textures.ROBUST_TUNGSTENSTEEL_CASING : 
						   Textures.STABLE_TITANIUM_CASING;
	}
	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
	{
		// TODO Auto-generated method stub
		return new MetaTileEntityAirVacuum(metaTileEntityId, tier);
	}
	
	private int getTier()
	{
		return tier;
	}

	protected class AirVacuumLogic extends MultiblockRecipeLogic
	{
		private MetaTileEntityAirVacuum mte;
		public AirVacuumLogic(MetaTileEntityAirVacuum tileEntity) 
		{
			super(tileEntity, true);
			this.mte = tileEntity;
		}
		
		@Override
		public int getParallelLimit()
		{
			return tier == 1 ? 4096 :
							   1024;
		}
	}
}
