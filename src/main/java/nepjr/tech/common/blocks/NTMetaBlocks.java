package nepjr.tech.common.blocks;

import org.jetbrains.annotations.NotNull;

import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NTMetaBlocks 
{
	private NTMetaBlocks() {}
	
	public static BlockFertilizedDirt FERTILIZED_DIRT;
	public static BlockGeneric GENERIC_BLOCKS;
	public static BlockNTCasings NT_CASINGS;
	public static NTUniqueCasing UNIQUE_CASINGS;
	public static BlockMixingModules MIXING_MODULES;
	public static BlockMixingModules2 MIXING_MODULES2;
	public static BlockLaserFoci LASER_FOCI;
	public static BlockBeamSplitter BEAM_SPLITTER;
	public static BlockCrushingWheels CRUSHING_WHEELS;
	
	public static void init()
	{
		FERTILIZED_DIRT = new BlockFertilizedDirt();
		FERTILIZED_DIRT.setRegistryName("fertilized_dirt");
		
		GENERIC_BLOCKS = new BlockGeneric();
		GENERIC_BLOCKS.setRegistryName("generic_blocks");
		
		NT_CASINGS = new BlockNTCasings();
		NT_CASINGS.setRegistryName("nt_casing_blocks");
		
		UNIQUE_CASINGS = new NTUniqueCasing();
		UNIQUE_CASINGS.setRegistryName("unique_casing");
		
		MIXING_MODULES = new BlockMixingModules();
		MIXING_MODULES.setRegistryName("mixing_modules");
		
		// With VariantActiveBlock, you can't have more than 8 subblocks, otherwise the game fucking crashes.
		// so we make a 2nd class
		MIXING_MODULES2 = new BlockMixingModules2();
		MIXING_MODULES2.setRegistryName("mixing_modules2");

		LASER_FOCI = new BlockLaserFoci();
		LASER_FOCI.setRegistryName("laser_foci");
		
		BEAM_SPLITTER = new BlockBeamSplitter();
		BEAM_SPLITTER.setRegistryName("beam_splitter");
		
		CRUSHING_WHEELS = new BlockCrushingWheels();
		CRUSHING_WHEELS.setRegistryName("crushing_wheels");
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModels()
	{
		registerItemModel(NT_CASINGS);
		registerItemModel(GENERIC_BLOCKS);
		registerItemModel(LASER_FOCI);
		registerItemModel(BEAM_SPLITTER);
		
		FERTILIZED_DIRT.onModelRegister();	
		MIXING_MODULES.onModelRegister();
		MIXING_MODULES2.onModelRegister();
		UNIQUE_CASINGS.onModelRegister();
		CRUSHING_WHEELS.onModelRegister();
	}
	
	// Taken from GYCM
    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@NotNull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

    @SuppressWarnings({ "unchecked", "unused" })
    private static <T extends Comparable<T>> @NotNull String getPropertyName(@NotNull IProperty<T> property,
                                                                             Comparable<?> value) {
        return property.getName((T) value);
    }
}
