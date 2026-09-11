package nepjr.tech.metatileentities.multi.electric;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import nepjr.tech.api.metatileentity.NTMetaTileEntity;
import nepjr.tech.client.NTTextures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntitySuperPacker extends NTMetaTileEntity
{
	public MetaTileEntitySuperPacker(ResourceLocation metaTileEntityId)
	{
		super(metaTileEntityId, RecipeMaps.PACKER_RECIPES, true, 0.01f, 90.01f);
		setParallels(1000000000);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() {
		// TODO Auto-generated method stub
		return FactoryBlockPattern.start()
				.aisle("CCC", "CCC", "CCC")
				.aisle("CCC", "CAC", "CCC")
				.aisle("CCC", "CSC", "CCC")
				.where('C', states(MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID)).or(autoAbilities()))
				.where('A', air())
				.where('S', selfPredicate())
				.build();
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
	{
		// TODO Auto-generated method stub
		return Textures.SOLID_STEEL_CASING;
	}
	
	@Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return Textures.PACKER_OVERLAY;
    }

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
		// TODO Auto-generated method stub
		return new MetaTileEntitySuperPacker(metaTileEntityId);
	}

}
