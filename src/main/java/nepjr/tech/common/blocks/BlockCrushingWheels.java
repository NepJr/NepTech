package nepjr.tech.common.blocks;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.block.ICrushingWheelStats;
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

public class BlockCrushingWheels extends VariantActiveBlock<BlockCrushingWheels.CrushingWheels>
{
	public BlockCrushingWheels() 
	{
		super(Material.IRON);
        setTranslationKey("crushing_wheels");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(CrushingWheels.COBALT_BRASS));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag)
	{
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<CrushingWheels, BlockCrushingWheels>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        CrushingWheels crushingWheels = getState(stackState);
        
        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * crushingWheels.getProcessingSpeed())));
        ITextComponent parallel = TextComponentUtil.stringWithColor(TextFormatting.DARK_PURPLE, String.valueOf((int) Math.pow(8, crushingWheels.getTier())));
        
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.parallel", parallel).getFormattedText());
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed", processingSpeed).getFormattedText());
    }


	public enum CrushingWheels implements IStringSerializable, ICrushingWheelStats
	{
		COBALT_BRASS("cobalt_brass", 2.0f, GTValues.LV),
		VANADIUMSTEEL("vanadiumsteel", 4.0f, GTValues.MV),
		BLUESTEEL("bluesteel", 6.0f, GTValues.HV),
		ULTIMET("ultimet", 8.0f, GTValues.EV),
		TUNGSTEN_CARBIDE("tungsten_carbide", 10.0f, GTValues.IV),
		HSSE("hsse", 12.0f, GTValues.LuV),
		NAQUADAH_ALLOY("naquadah_alloy", 14.0f, GTValues.ZPM),
		DURANIUM("duranium", 16.0f, GTValues.UV);
		
		private float processingSpeed;
		private int tier;
		private String name;
		
		CrushingWheels(String name, float processingSpeed, int tier)
		{
			this.processingSpeed = processingSpeed;
			this.tier = tier;
			this.name = name;
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

		@Override
		public String getName()
		{
			return name;
		}
	}
}
