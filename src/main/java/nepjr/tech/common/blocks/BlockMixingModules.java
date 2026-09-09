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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag)
	{
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<ModuleTier, BlockMixingModules>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        ModuleTier moduleTier = getState(stackState);
        
        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * moduleTier.getProcessingSpeed())));
        
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed_bonus", processingSpeed).getFormattedText());
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
