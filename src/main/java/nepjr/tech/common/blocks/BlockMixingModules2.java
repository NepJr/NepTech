package nepjr.tech.common.blocks;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.block.IMixingModuleStats;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
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

public class BlockMixingModules2 extends VariantActiveBlock<BlockMixingModules2.ModuleTier>
{
	public BlockMixingModules2() 
	{
		super(Material.IRON);
        setTranslationKey("mixing_module2");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(ModuleTier.UV));
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
        VariantItemBlock itemBlock = (VariantItemBlock<ModuleTier, BlockMixingModules2>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        ModuleTier moduleTier = getState(stackState);

        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * moduleTier.getProcessingSpeed())));
        
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed_bonus", processingSpeed).getFormattedText());
    }

	public enum ModuleTier implements IStringSerializable, IMixingModuleStats
	{
		UV(GTValues.UV, 5.0f),
		UHV(GTValues.UHV, 5.5f),
		UEV(GTValues.UEV, 6.0f),
		UIV(GTValues.UIV, 6.5f),
		UXV(GTValues.UXV, 7.0f),
		OpV(GTValues.OpV, 7.5f),
		MAX(GTValues.MAX, 8.0f);
		
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
