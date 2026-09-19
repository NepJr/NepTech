package nepjr.tech.common.blocks;

import org.jetbrains.annotations.NotNull;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNTFusionCasings extends VariantActiveBlock<BlockNTFusionCasings.NTFusionCasingType>
{
	public BlockNTFusionCasings()
	{
		super(Material.IRON);
		setTranslationKey("nt_fusion_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(NTFusionCasingType.MK4));
	}
	
	@Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityLiving.SpawnPlacementType type) 
	{
        return false;
    }
	
	public enum NTFusionCasingType implements IStringSerializable
	{
		MK4("mk4"),
		MK5("mk5"),
		MK6("mk6");
		
		private final String name;
		
		NTFusionCasingType(String name)
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
