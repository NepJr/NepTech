package nepjr.tech.common.blocks;

import org.jetbrains.annotations.NotNull;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import nepjr.tech.api.block.IMixingModuleStats;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockMixingModules extends VariantActiveBlock<BlockMixingModules.ModuleTier>
{
	public BlockMixingModules() 
	{
		super(Material.IRON);
        setTranslationKey("mixing_module");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(ModuleTier.ULV));
	}
	
	@Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

	public enum ModuleTier implements IStringSerializable, IMixingModuleStats
	{
		ULV(GTValues.ULV, 0.0f),
		LV(GTValues.LV, 2.2f),
		MV(GTValues.MV, 3.4f),
		HV(GTValues.HV, 4.6f),
		EV(GTValues.EV, 5.8f),
		IV(GTValues.IV, 7.0f),
		LuV(GTValues.LuV, 8.2f),
		ZPM(GTValues.ZPM, 9.4f);
		
		private final int tier;
		private final float processingSpeed;
		
		ModuleTier(int tier, float processingSpeed)
		{
			this.tier = tier;
			this.processingSpeed = processingSpeed;
		}

		@Override
		public String getName() {
			return GTValues.VN[tier].toLowerCase();
		}
		
		@Override
		public float getProcessingSpeed()
		{
			return processingSpeed;
		}

		@Override
		public int getTier() 
		{
			return tier;
		}
	}
}
