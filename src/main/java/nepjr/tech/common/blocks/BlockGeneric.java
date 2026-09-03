package nepjr.tech.common.blocks;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockGeneric extends VariantActiveBlock<BlockGeneric.GenericType>
{
	public BlockGeneric()
	{
		super(Material.ROCK);
		setTranslationKey("generic_blocks");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.STONE);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(GenericType.SLAG));
	}
	
	public enum GenericType implements IStringSerializable
	{
		SLAG("slag");
		
		private final String name;
		
		GenericType(String name)
		{
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}
}
