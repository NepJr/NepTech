package nepjr.tech.metatileentities.multi.electric;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Material;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityVoidOreMiner extends RecipeMapMultiblockController
{
	private Material frameBox;
	private int tier;
	
	public MetaTileEntityVoidOreMiner(ResourceLocation metaTileEntityId, int tier, Material frameBox)
	{
		super(metaTileEntityId, NTRecipeMaps.VOID_ORE_MINER);
		this.recipeMapWorkable = new VoidOreMinerRecipeLogic(this);
		this.frameBox = frameBox;
		this.tier = tier;
	}
	@Override
	protected @NotNull BlockPattern createStructurePattern()
	{
		return FactoryBlockPattern.start()
				.aisle("CCC", " F ", " F ", " F ", "   ", "   ", "   ")
				.aisle("CCC", "FCF", "FCF", "FCF", " F ", " F ", " F ")
				.aisle("CSC", " F ", " F ", " F ", "   ", "   ", "   ")
				.where('F', frames(frameBox))
				.where('C', states(getCasingState())
						.or(metaTileEntities(MetaTileEntities.ENERGY_INPUT_HATCH[tier]).setMaxGlobalLimited(2, 1)
						.or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
						.or(abilities(MultiblockAbility.IMPORT_FLUIDS).setExactLimit(1))
						.or(abilities(MultiblockAbility.IMPORT_ITEMS).setExactLimit(1))
						.or(metaTileEntities(MetaTileEntities.ITEM_EXPORT_BUS_ME).setExactLimit(1))))
				.where('S', selfPredicate())
				.build();
	}
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
	{
		// TODO Auto-generated method stub
		return NTTextures.NAQUADAH_ALLOY_CASING;
	}
	
	private IBlockState getCasingState()
	{
		return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NAQUADAH_ALLOY);
	}
	
	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
	{
		return new MetaTileEntityVoidOreMiner(metaTileEntityId, tier, frameBox);
	}
	
	private class VoidOreMinerRecipeLogic extends MultiblockRecipeLogic
	{

		public VoidOreMinerRecipeLogic(MetaTileEntityVoidOreMiner tileEntity)
		{
			super(tileEntity, true);
		}
		
	}
   
}
