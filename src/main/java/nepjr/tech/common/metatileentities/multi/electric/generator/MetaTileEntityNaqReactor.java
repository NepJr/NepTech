package nepjr.tech.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.NTUniqueCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MetaTileEntityNaqReactor extends FuelMultiblockController
{

    public MetaTileEntityNaqReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, NTRecipeMaps.NAQ_FUELS, GTValues.MAX);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCCCC", "RCCCCCCCR", "R       R", "R       R", "R       R", "R       R", "R       R", "R       R", "R       R", "RCCCCCCCR", "CCCCCCCCC")
                .aisle("CCHHHHHCC", "CCHHHHHCC", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "CCHHHHHCC", "CCHHHHHCC")
                .aisle("CHCCCCCHC", "CHCCCCCHC", "  CCCCC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CCCCC  ", "CHCCCCCHC", "CHCCCCCHC")
                .aisle("CHCCCCCHC", "CHCCCCCHC", "  CFFFC  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  CFFFC  ", "CHCCCCCHC", "CHCCCCCHC")
                .aisle("CHCCCCCHC", "CHCCCCCHC", "  CFNFC  ", "  GFNFG  ", "  GFNFG  ", "  GFNFG  ", "  GFNFG  ", "  GFNFG  ", "  CFNFC  ", "CHCCCCCHC", "CHCCCCCHC")
                .aisle("CHCCCCCHC", "CHCCCCCHC", "  CFFFC  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  GFFFG  ", "  CFFFC  ", "CHCCCCCHC", "CHCCCCCHC")
                .aisle("CHCCCCCHC", "CHCCCCCHC", "  CCCCC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CCCCC  ", "CHCCCCCHC", "CHCCCCCHC")
                .aisle("CCHHHHHCC", "CCHHHHHCC", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "CCHHHHHCC", "CCHHHHHCC")
                .aisle("CCCCCCCCC", "RCCCSCCCR", "R       R", "R       R", "R       R", "R       R", "R       R", "R       R", "R       R", "RCCCCCCCR", "CCCCCCCCC")
                .where('C', states(getCasingState())
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setExactLimit(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setExactLimit(1)))
                .where('H', states(getHeatVent()))
                .where('R', frames(NTMaterials.Trinaquadalloy))
                .where('G', states(getGlassState()))
                .where('F', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_COIL)))
                .where('N', states(getStabilizer()))
                .where(' ', any())
                .where('S', selfPredicate())
                .build();
    }

    public IBlockState getCasingState()
    {
        return NTMetaBlocks.NT_CASINGS.getState(BlockNTCasings.NTCasingType.ATOMIC_CASING);
    }

    public IBlockState getGlassState()
    {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    public IBlockState getHeatVent()
    {
        return NTMetaBlocks.UNIQUE_CASINGS.getState(NTUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    public IBlockState getStabilizer()
    {
        return NTMetaBlocks.NT_CASINGS.getState(BlockNTCasings.NTCasingType.NAQFUEL_STABILIZER);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return NTTextures.ATOMIC_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return Textures.AUTOCLAVE_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityNaqReactor(metaTileEntityId);
    }
}
