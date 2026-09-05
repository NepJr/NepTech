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
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModels()
	{
		registerItemModel(NT_CASINGS);
		
		FERTILIZED_DIRT.onModelRegister();
		GENERIC_BLOCKS.onModelRegister();		
		MIXING_MODULES.onModelRegister();
		MIXING_MODULES2.onModelRegister();
		UNIQUE_CASINGS.onModelRegister();
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
