package xyz.nepjr.tech.common.blocks;

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
	
	public static void init()
	{
		FERTILIZED_DIRT = new BlockFertilizedDirt();
		FERTILIZED_DIRT.setRegistryName("fertilized_dirt");
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModels()
	{
		FERTILIZED_DIRT.onModelRegister();
		registerItemModel(FERTILIZED_DIRT);
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
