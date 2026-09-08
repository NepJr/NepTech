package nepjr.tech.common.blocks;

import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import nepjr.tech.api.block.ILaserFociStats;
import nepjr.tech.common.blocks.BlockLaserFoci.FociTier;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockLaserFoci extends VariantBlock<FociTier>
{
	public BlockLaserFoci() 
	{
		super(Material.IRON);
		setTranslationKey("laser_foci");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(FociTier.IV));
	}

	public enum FociTier implements IStringSerializable, ILaserFociStats
	{
		IV(GTValues.IV, 1.5f),
		LuV(GTValues.LuV, 2.0f),
		ZPM(GTValues.ZPM, 2.5f),
		UV(GTValues.UV, 3.0f),
		UHV(GTValues.UHV, 3.5f),
		UEV(GTValues.UEV, 4.0f),
		UIV(GTValues.UIV, 4.5f),
		UXV(GTValues.UXV, 5.0f),
		OpV(GTValues.OpV, 5.5f),
		MAX(GTValues.MAX, 6.0f);
		
		private int tier;
		private float speed;
		
		FociTier(int tier, float speed)
		{
			this.tier = tier;
			this.speed = speed;
		}
		
		@Override
		public float getProcessingSpeed() 
		{
			return speed;
		}

		@Override
		public int getTier() 
		{
			return tier;
		}

		@Override
		public String getName() 
		{
			return GTValues.VN[tier].toLowerCase();
		}
	}
}
