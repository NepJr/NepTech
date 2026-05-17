package nepjr.tech.common.blocks;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import nepjr.tech.api.block.IFertilizedDirtBlockStats;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockFertilizedDirt extends VariantActiveBlock<BlockFertilizedDirt.FertilizerType>
{
	public BlockFertilizedDirt()
	{
		super(Material.GROUND);
        setTranslationKey("fertilized_dirt");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.GROUND);
        setHarvestLevel(ToolClasses.SHOVEL, 2);
        setDefaultState(getState(FertilizerType.BASIC));
	}
	
	public enum FertilizerType implements IStringSerializable, IFertilizedDirtBlockStats 
	{
		BASIC("basic", 1, 0.1F),
		ADVANCED("advanced", 2, 0.2F),
		LIVING("living", 4, 0.4F),
		EXTRATERRESTRIAL("extraterrestrial", 8, 0.5F),
		ABSURD("absurd", 16, 0.99F);
		
		private final String name;
		private final int fertilizerTier;
		private final float growthDiscount;
		
		FertilizerType(String name, int fertilizerTier, float growthDiscount)
		{
			this.name = name;
			this.fertilizerTier = fertilizerTier;
			this.growthDiscount = 1.0F - growthDiscount;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getTier() {
			return this.fertilizerTier;
		}

		@Override
		public float getDiscount() {
			return this.growthDiscount;
		}
	}
}
