package nepjr.tech.common.blocks;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.block.ILaserFociStats;
import nepjr.tech.common.blocks.BlockLaserFoci.FociTier;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag)
	{
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<FociTier, BlockLaserFoci>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        FociTier fociTier = getState(stackState);
        
        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * fociTier.getProcessingSpeed())));

        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.max_recipe_tier", GTValues.VNF[fociTier.getTier()]).getFormattedText());
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed", processingSpeed).getFormattedText());
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
