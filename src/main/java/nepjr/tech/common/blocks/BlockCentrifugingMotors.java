package nepjr.tech.common.blocks;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.block.ICentrifugingMotorStats;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCentrifugingMotors extends VariantBlock<BlockCentrifugingMotors.MotorTier>
{
	public BlockCentrifugingMotors() 
	{
		super(Material.IRON);
        setTranslationKey("centrifuging_motor");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(MotorTier.LV));
	}
	
	@Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag)
	{
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<MotorTier, BlockCentrifugingMotors>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        MotorTier moduleTier = getState(stackState);
        
        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * moduleTier.getProcessingSpeed())));
        ITextComponent energyDiscount = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 - (5 * moduleTier.getTier()))));
        
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed_bonus", processingSpeed).getFormattedText());
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.energy_discount", energyDiscount).getFormattedText());
    }

	public enum MotorTier implements IStringSerializable, ICentrifugingMotorStats
	{
		LV(GTValues.LV, 1.5f),
		MV(GTValues.MV, 2.0f),
		HV(GTValues.HV, 2.5f),
		EV(GTValues.EV, 3.0f),
		IV(GTValues.IV, 3.5f),
		LuV(GTValues.LuV, 4.0f),
		ZPM(GTValues.ZPM, 4.5f),
		UV(GTValues.UV, 5.0f),
		UHV(GTValues.UHV, 5.5f);
		
		private final int tier;
		private final float processingSpeed;
		
		MotorTier(int tier, float processingSpeed)
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
