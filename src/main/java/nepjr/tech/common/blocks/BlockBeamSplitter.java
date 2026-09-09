package nepjr.tech.common.blocks;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.block.IBeamSplitterStats;
import nepjr.tech.common.blocks.BlockBeamSplitter.BeamSplitter;
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

public class BlockBeamSplitter extends VariantBlock<BeamSplitter>
{
	public BlockBeamSplitter() 
	{
		super(Material.IRON);
		setTranslationKey("beam_splitter");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(BeamSplitter.BASIC));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag)
	{
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<BeamSplitter, BlockBeamSplitter>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        BeamSplitter beamSplitter = getState(stackState);

        ITextComponent parallels = TextComponentUtil.stringWithColor(TextFormatting.DARK_PURPLE, String.valueOf(beamSplitter.getParallels()));
        
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.parallel", parallels).getFormattedText());
    }

	public enum BeamSplitter implements IStringSerializable, IBeamSplitterStats
	{
		BASIC(256),
		ADVANCED(1024),
		EXTREME(4096),
		INSANE(16384),
		LUDICROUS(65536);

		private int parallels;
		BeamSplitter(int parallels)
		{
			this.parallels = parallels;
		}
		
		@Override
		public int getParallels()
		{
			return parallels;
		}

		@Override
		public String getName()
		{
			return parallels + "a";
		}
		
	}
}
