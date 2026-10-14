package nepjr.tech.common.blocks;

import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import nepjr.tech.api.NepTechAPI;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockSpaceRocks extends VariantBlock<BlockSpaceRocks.SpaceRockType>
{
	public BlockSpaceRocks()
	{
		super(Material.ROCK);
		setTranslationKey("space_rocks");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.STONE);
        setHarvestLevel(ToolClasses.PICKAXE, 2);
		setCreativeTab(NepTechAPI.TAB_NEPTECH);
        setDefaultState(getState(SpaceRockType.MOON));
	}
	
	public enum SpaceRockType implements IStringSerializable
	{
		MOON("moon");
		
		private final String name;
		
		SpaceRockType(String name)
		{
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}
}
