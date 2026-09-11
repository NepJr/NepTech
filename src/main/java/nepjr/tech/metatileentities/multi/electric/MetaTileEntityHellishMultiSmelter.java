package nepjr.tech.metatileentities.multi.electric;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.RecipeMapFurnace;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.core.sound.GTSoundEvents;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaTileEntityHellishMultiSmelter extends MultiMapMultiblockController
{
	protected int heatingCoilLevel;
    protected int heatingCoilDiscount;
    
	public MetaTileEntityHellishMultiSmelter(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, new RecipeMap[]{RecipeMaps.FURNACE_RECIPES, RecipeMaps.ALLOY_SMELTER_RECIPES});
		this.recipeMapWorkable = new MultiSmelterWorkable(this);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
	{
		// TODO Auto-generated method stub
		return NTTextures.NETHERITE_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
	{
		// TODO Auto-generated method stub
		return new MetaTileEntityHellishMultiSmelter(metaTileEntityId);
	}

	@Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addCustom(tl -> {
                    if (isStructureFormed()) {
                        // Heating coil discount
                        if (heatingCoilDiscount > 1) {
                            ITextComponent coilDiscount = TextComponentUtil.stringWithColor(
                                    TextFormatting.AQUA,
                                    TextFormattingUtil.formatNumbers(100.0 / heatingCoilDiscount) + "%");

                            ITextComponent base = TextComponentUtil.translationWithColor(
                                    TextFormatting.GRAY,
                                    "gregtech.multiblock.multi_furnace.heating_coil_discount",
                                    coilDiscount);

                            ITextComponent hoverText = TextComponentUtil.translationWithColor(
                                    TextFormatting.GRAY,
                                    "gregtech.multiblock.multi_furnace.heating_coil_discount_hover");

                            TextComponentUtil.setHover(base, hoverText);
                            tl.add(base);
                        }

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
    protected void formStructure(PatternMatchContext context)
    {
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        if (coilType instanceof IHeatingCoilBlockStats)
        {
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
            this.heatingCoilDiscount = ((IHeatingCoilBlockStats) coilType).getEnergyDiscount();
        } else
        {
            this.heatingCoilLevel = CoilType.CUPRONICKEL.getLevel();
            this.heatingCoilDiscount = CoilType.CUPRONICKEL.getEnergyDiscount();
        }
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced)
	{
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.parallels.multi_smelter"));
    }

    @Override
    public void invalidateStructure()
    {
        super.invalidateStructure();
        this.heatingCoilLevel = 0;
        this.heatingCoilDiscount = 0;
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern()
    {
        return FactoryBlockPattern.start()
                .aisle("XXX", "CCC", "XXX")
                .aisle("XXX", "C#C", "XMX")
                .aisle("XSX", "CCC", "XXX")
                .where('S', selfPredicate())
                .where('X',
                        states(getCasingState()).setMinGlobalLimited(9)
                                .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('C', heatingCoils())
                .where('#', air())
                .build();
    }

    public IBlockState getCasingState()
    {
        return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.NETHERITE);
    }

    @Override
    public SoundEvent getBreakdownSound()
    {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay()
    {
        return Textures.MULTI_FURNACE_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics()
    {
        return true;
    }

    /**
     * @param parallel the amount of parallel recipes
     * @param discount the energy discount
     * @return the un-overclocked EUt for an amount of parallel recipes
     */
    public static int getEUtForParallel(int parallel, int discount)
    {
        return RecipeMapFurnace.RECIPE_EUT * Math.max(1, (parallel / 8) / discount);
    }

    /**
     * @param heatingCoilLevel the level to get the parallel for
     * @return the max parallel for the heating coil level
     */
    public static int getMaxParallel(int heatingCoilLevel)
    {
        return 64 * heatingCoilLevel;
    }

    /**
     * @param parallel      the amount of parallel recipes
     * @param parallelLimit the maximum limit on parallel recipes
     * @return the un-overclocked duration for an amount of parallel recipes
     */
    public static int getDurationForParallel(int parallel, int parallelLimit)
    {
        return (int) Math.max(1.0, RecipeMapFurnace.RECIPE_DURATION * 2 * parallel / Math.max(1, parallelLimit * 1.0));
    }

    protected class MultiSmelterWorkable extends MultiblockRecipeLogic 
    {
    	private MetaTileEntityHellishMultiSmelter mte;
        public MultiSmelterWorkable(MetaTileEntityHellishMultiSmelter tileEntity)
        {
            super(tileEntity, true);
            this.mte = tileEntity;
        }
        
        @NotNull
        @Override
        public ParallelLogicType getParallelLogicType() 
        {
            return mte.getRecipeMap() == RecipeMaps.FURNACE_RECIPES ? ParallelLogicType.APPEND_ITEMS:
            														  ParallelLogicType.MULTIPLY;
        }

        @Override
        public void applyParallelBonus(@NotNull RecipeBuilder<?> builder)
        {
            if(mte.getRecipeMap() == RecipeMaps.FURNACE_RECIPES)
            {
            	builder.EUt(getEUtForParallel(builder.getParallel(), heatingCoilDiscount))
                .duration(getDurationForParallel(builder.getParallel(), getParallelLimit()));
            }
        }

        @Override
        public int getParallelLimit()
        {
            return getMaxParallel(heatingCoilLevel);
        }
    }
}
