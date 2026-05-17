package nepjr.tech.metatileentities.multi.electric;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockGlassCasing.CasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import nepjr.tech.api.block.IFertilizedDirtBlockStats;
import nepjr.tech.api.metatileentity.NTMetaTileEntity;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.common.blocks.BlockFertilizedDirt.FertilizerType;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityGreenhouse extends NTMetaTileEntity
{
	protected int fertilizerTier;
	protected float durationDiscount;
	
	public MetaTileEntityGreenhouse(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId, NTRecipeMaps.GREENHOUSE_RECIPES);
		this.recipeMapWorkable = new GreenhouseLogic(this, true);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() {
		return FactoryBlockPattern.start()
			.aisle("OCCCCCO", "OGGCGGO", "OOGCGOO", "OOOCOOO", "OOOOOOO", "OOOOOOO")
			.aisle("CDDDDDC", "GAAAAAG", "AGAAAGO", "OOGAGOO", "OOOCOOO", "OOOOOOO")
			.aisle("CDDDDDC", "GAAAAAG", "GAAAAAG", "OGAAAGO", "OOGCGOO", "OOOOOOO")
			.aisle("CDDDDDC", "CAAAAAC", "CAAAAAC", "CAAAAAC", "OCCACCO", "OOOCOOO")
			.aisle("CDDDDDC", "GAAAAAG", "GAAAAAG", "OGAAAGA", "OOGCGOO", "OOOOOOO")
			.aisle("CDDDDDC", "GAAAAAG", "OGAAAGO", "OOGAGAA", "OOOCOOO", "OOOOOOO")
			.aisle("OCCSCCO", "OGGCGGO", "OOGCGOO", "OOOCOOO", "OOOOOOO", "OOOOOOO")
			.where('S', selfPredicate())
			.where('C', states(getCasingState())
					.or(autoAbilities(true, true, true, true, true, false, false)))
			.where('D', fertilizedDirt())
			.where('O', any())
			.where('G', states(getGlassState()))
			.where('A', air())
			.build();
	}
	
	protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID);
    }
	
	protected IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(CasingType.TEMPERED_GLASS);
    }
	
	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		return Textures.SOLID_STEEL_CASING;
	}
	
	@Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object fertilizerType = context.get("FertilizerType");
        if (fertilizerType instanceof IFertilizedDirtBlockStats) {
            this.fertilizerTier = ((IFertilizedDirtBlockStats) fertilizerType).getTier();
            this.durationDiscount = ((IFertilizedDirtBlockStats) fertilizerType).getDiscount();
        } else {
            this.fertilizerTier = FertilizerType.BASIC.getTier();
            this.durationDiscount = FertilizerType.BASIC.getDiscount();
        }
    }
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }
	
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addCustom(tl -> {
                    if (isStructureFormed()) {
                        // Custom parallels line so we can have a hover text
                        if (recipeMapWorkable.getParallelLimit() > 1) {
                            ITextComponent parallels = TextComponentUtil.stringWithColor(
                                    TextFormatting.DARK_PURPLE,
                                    TextFormattingUtil.formatNumbers(recipeMapWorkable.getParallelLimit()));
                            ITextComponent bodyText = TextComponentUtil.translationWithColor(
                                    TextFormatting.GRAY,
                                    "gregtech.multiblock.parallel",
                                    parallels);
                            ITextComponent hoverText = TextComponentUtil.translationWithColor(
                                    TextFormatting.GRAY,
                                    "gregtech.multiblock.multi_furnace.parallel_hover");
                            tl.add(TextComponentUtil.setHover(bodyText, hoverText));
                        }
                    }
                })
                .addWorkingStatusLine()
                .addProgressLine(recipeMapWorkable.getProgressPercent());
    }

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
		return new MetaTileEntityGreenhouse(metaTileEntityId);
	}
	
	protected class GreenhouseLogic extends MultiblockRecipeLogic
	{
		protected final MetaTileEntity mte;
		public GreenhouseLogic(RecipeMapMultiblockController tileEntity, boolean hasPerfectOC) 
		{
			super(tileEntity, hasPerfectOC);
			this.mte = this.getMetaTileEntity();
		}
		
		@Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[0] *= 1.0f * durationDiscount; 
            resultOverclock[0] = Math.max(1, resultOverclock[0]);
        }
		
		@Override
		public int getParallelLimit()
		{
			return (int) Math.max(Math.pow(2, fertilizerTier), 1);
		}
	}
	
}
