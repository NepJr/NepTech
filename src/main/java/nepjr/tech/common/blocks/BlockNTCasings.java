package nepjr.tech.common.blocks;

import org.jetbrains.annotations.NotNull;

import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNTCasings extends VariantBlock<BlockNTCasings.NTCasingType>
{
	public BlockNTCasings()
	{
		super(Material.IRON);
		setTranslationKey("nt_casing_blocks");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.PICKAXE, 2);
        setDefaultState(getState(NTCasingType.NETHERITE));
	}
	
	@Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityLiving.SpawnPlacementType type) 
	{
        return false;
    }
	
	public enum NTCasingType implements IStringSerializable
	{
		NETHERITE("netherite"),
		NAQUADAH_ALLOY("naquadah_alloy");
		
		private final String name;
		
		NTCasingType(String name)
		{
			this.name = name;
		}
		
		@Override
		public String getName() 
		{
			return name;
		}
	}
}
