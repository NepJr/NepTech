package nepjr.tech.common.blocks;

import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.util.TextComponentUtil;
import nepjr.tech.api.NepTechAPI;
import nepjr.tech.api.block.IMetalworkingModuleStats;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockMetalworkingModule extends VariantBlock<BlockMetalworkingModule.ModuleTier>
{
    public BlockMetalworkingModule()
    {
        super(Material.IRON);
        setTranslationKey("metalworking_module");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setCreativeTab(NepTechAPI.TAB_NEPTECH);
        setDefaultState(getState(BlockMetalworkingModule.ModuleTier.LV));
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
        VariantItemBlock itemBlock = (VariantItemBlock<BlockMetalworkingModule.ModuleTier, BlockMetalworkingModule>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        BlockMetalworkingModule.ModuleTier moduleTier = getState(stackState);

        ITextComponent processingSpeed = TextComponentUtil.stringWithColor(TextFormatting.YELLOW, String.valueOf((int) Math.round(100 * moduleTier.getProcessingSpeed())));
        lines.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "neptech.processing_speed_bonus", processingSpeed).getFormattedText());
    }

    public enum ModuleTier implements IStringSerializable, IMetalworkingModuleStats
    {
        LV(GTValues.LV, 0.5f),
        MV(GTValues.MV, 1.0f),
        HV(GTValues.HV, 2.5f),
        EV(GTValues.EV, 3.0f),
        IV(GTValues.IV, 3.5f),
        LuV(GTValues.LuV, 4.0f),
        ZPM(GTValues.ZPM, 4.5f),
        UV(GTValues.UV, 5.0f),
        UHV(GTValues.UHV, 5.5f);
        // Don't feel like doing texture work for these right now lol
        //UEV(GTValues.UEV, 6.0f),
        //UIV(GTValues.UIV, 6.5f),
        //UXV(GTValues.UXV, 7.0f),
        //OpV(GTValues.OpV, 7.5f),
        //MAX(GTValues.MAX, 8.0f);

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