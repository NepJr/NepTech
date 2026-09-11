package nepjr.tech.metatileentities.multi.electric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.Widget;
import gregtech.api.gui.Widget.ClickData;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockGlassCasing.CasingType;
import gregtech.common.blocks.MetaBlocks;
import nepjr.tech.api.NepTechAPI;
import nepjr.tech.api.block.IBeamSplitterStats;
import nepjr.tech.api.block.ILaserFociStats;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityLargeLaserEngraver extends RecipeMapMultiblockController
{
	private int maxParallels;
	private int configuredParallels = 1;
	private float processingSpeed;
	private int fociTier;
	
	public MetaTileEntityLargeLaserEngraver(ResourceLocation metaTileEntityId) 
	{
		super(metaTileEntityId, RecipeMaps.LASER_ENGRAVER_RECIPES);
		this.recipeMapWorkable = new LaserEngraverRecipeLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() 
	{
		return FactoryBlockPattern.start()
				.aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
				.aisle("CCCCC", "CAAAC", "CAAAC", "CAAAC", "CCCCC")
				.aisle("CCCCC", "CAAAC", "CABAC", "CALAC", "CCCCC")
				.aisle("CCCCC", "CAAAC", "CAAAC", "CAAAC", "CCCCC")
				.aisle("CCSCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
				.where('C', states(getCasingState()).setMinGlobalLimited(60)
						.or(abilities(MultiblockAbility.INPUT_LASER).setExactLimit(1))
						.or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
						.or(abilities(MultiblockAbility.IMPORT_ITEMS).setPreviewCount(1))
						.or(abilities(MultiblockAbility.EXPORT_ITEMS).setPreviewCount(1)))
				.where('G', states(getGlassState()))
				.where('L', laserFoci())
				.where('B', beamSplitter())
				.where('A', air())
				.where('S', selfPredicate())
				.build();
	}
	
	private IBlockState getCasingState()
	{
		return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.ENGRAVER_CASING);
	}
	
	private IBlockState getGlassState()
	{
		return MetaBlocks.TRANSPARENT_CASING.getState(CasingType.LAMINATED_GLASS);
	}
	
	public static TraceabilityPredicate laserFoci()
	{
		return LASER_FOCI.get();
	}
	
	public static TraceabilityPredicate beamSplitter()
	{
		return BEAM_SPLITTER.get();
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced)
	{
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("neptech.laser_needed"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.recipes.large_laser_engraver"));
        tooltip.add(TextFormatting.YELLOW + I18n.format("neptech.warning.large_laser_engraver"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.processing_speed.large_laser_engraver"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.parallels.large_laser_engraver"));
    }
	
	public static Supplier<TraceabilityPredicate> LASER_FOCI = () -> new TraceabilityPredicate(blockWorldState ->
	{
        IBlockState blockState = blockWorldState.getBlockState();
        if (NepTechAPI.LASER_FOCI.containsKey(blockState))
        {
        	ILaserFociStats stats = NepTechAPI.LASER_FOCI.get(blockState);
            Object currentCoil = blockWorldState.getMatchContext().getOrPut("LaserFoci", stats);
            if (!currentCoil.equals(stats))
            {
                blockWorldState.setError(new PatternStringError("neptech.multiblock.pattern.error.laser_foci"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock1", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> NepTechAPI.LASER_FOCI.entrySet().stream()
            // sort to make autogenerated jei previews not pick random coils each game load
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(entry -> new BlockInfo(entry.getKey(), null))
            .toArray(BlockInfo[]::new))
                    .addTooltips("neptech.multiblock.pattern.error.laser_foci");
	
	public static Supplier<TraceabilityPredicate> BEAM_SPLITTER = () -> new TraceabilityPredicate(blockWorldState -> 
	{
        IBlockState blockState = blockWorldState.getBlockState();
        if (NepTechAPI.BEAM_SPLITTER.containsKey(blockState))
        {
        	IBeamSplitterStats stats = NepTechAPI.BEAM_SPLITTER.get(blockState);
            Object currentCoil = blockWorldState.getMatchContext().getOrPut("BeamSplitter", stats);
            if (!currentCoil.equals(stats))
            {
                blockWorldState.setError(new PatternStringError("neptech.multiblock.pattern.error.beam_splitter"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock2", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> NepTechAPI.BEAM_SPLITTER.entrySet().stream()
            // sort to make autogenerated jei previews not pick random coils each game load
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getParallels()))
            .map(entry -> new BlockInfo(entry.getKey(), null))
            .toArray(BlockInfo[]::new))
                    .addTooltips("neptech.multiblock.pattern.error.beam_splitter");
	
	@Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        
        Object laserFoci = context.get("LaserFoci");
        Object beamSplitter = context.get("BeamSplitter");
        if (laserFoci instanceof ILaserFociStats)
        {
            this.processingSpeed = ((ILaserFociStats) laserFoci).getProcessingSpeed();
            this.fociTier = ((ILaserFociStats) laserFoci).getTier();
        }
        if(beamSplitter instanceof IBeamSplitterStats)
        {
        	this.maxParallels = ((IBeamSplitterStats) beamSplitter).getParallels();
        	if(configuredParallels > maxParallels)
        	{
        		configuredParallels = maxParallels;
        	}
        }
        else
        {
        	this.fociTier = 0;
            this.processingSpeed = 0;
            this.maxParallels = 0;
        }
        
        List<IEnergyContainer> powerInput = new ArrayList<>(getAbilities(MultiblockAbility.INPUT_ENERGY));
        powerInput.addAll(getAbilities(MultiblockAbility.INPUT_LASER));

        this.energyContainer = new EnergyContainerList(powerInput);
	}
	
	@Override
    public void checkStructurePattern()
	{
		super.checkStructurePattern();
		IEnergyContainer energyContainer = getEnergyContainer();
		if (energyContainer instanceof EnergyContainerList energyList) {
			long highestVoltage = energyList.getHighestInputVoltage();
			if(GTUtility.getTierByVoltage(highestVoltage) > fociTier)
			{
				invalidateStructure();
			}
		}
	}
	
	@Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeMapWorkable.isWorkingEnabled(), recipeMapWorkable.isActive())
                .addEnergyUsageLine(recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(recipeMapWorkable.getMaxVoltage()))
                .addParallelsLine(maxParallels)
                .addCustom(tl -> {
                    // Coil heat capacity line
                    if (isStructureFormed()) {
                        ITextComponent cfgParallelsStr = TextComponentUtil.stringWithColor(
                                TextFormatting.DARK_PURPLE,
                                TextFormattingUtil.formatNumbers(recipeMapWorkable.getParallelLimit()));
                        
                        ITextComponent speedStr = TextComponentUtil.stringWithColor(
                                TextFormatting.YELLOW,
                                TextFormattingUtil.formatNumbers((int) 100 * processingSpeed));

                        tl.add(TextComponentUtil.translationWithColor(
                                TextFormatting.GRAY,
                                "neptech.multiblock.conf_parallels",
                                cfgParallelsStr));
                        
                        tl.add(TextComponentUtil.translationWithColor(
                                TextFormatting.GRAY,
                                "neptech.processing_speed",
                                speedStr));
                    }
                })
                .addWorkingStatusLine()
                .addProgressLine(recipeMapWorkable.getProgressPercent());
    }
	
	@Override
    protected @NotNull Widget getFlexButton(int x, int y, int width, int height)
	{
        WidgetGroup group = new WidgetGroup(x, y, width, height);
        group.addWidget(new ClickButtonWidget(0, 0, 9, 18, "", this::decrementParallels)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_MINUS)
                .setTooltipText("neptech.multiblock.laser_engraver.parallel_decrement"));
        group.addWidget(new ClickButtonWidget(9, 0, 9, 18, "", this::incrementParallels)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_PLUS)
                .setTooltipText("neptech.multiblock.laser_engraver.parallel_increment"));
        return group;
    }
	
	private void incrementParallels(ClickData clickData) 
	{
        if(!clickData.isShiftClick && !clickData.isCtrlClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels + 1, 1, maxParallels);
        }
        if(!clickData.isCtrlClick && clickData.isShiftClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels + 64, 1, maxParallels);
        }
        if(clickData.isCtrlClick && !clickData.isShiftClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels + 256, 1, maxParallels);
        }
        if(clickData.isShiftClick && clickData.isCtrlClick)
        {
        	this.configuredParallels = maxParallels;
        }
    }

    private void decrementParallels(ClickData clickData) 
    {
    	if(!clickData.isShiftClick && !clickData.isCtrlClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels - 1, 1, maxParallels);
        }
        if(!clickData.isCtrlClick && clickData.isShiftClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels - 64, 1, maxParallels);
        }
        if(clickData.isCtrlClick && !clickData.isShiftClick)
        {
        	this.configuredParallels = MathHelper.clamp(configuredParallels - 256, 1, maxParallels);
        }
        if(clickData.isShiftClick && clickData.isCtrlClick)
        {
        	this.configuredParallels = 1;
        }
    }

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) 
	{
		return NTTextures.ENGRAVER_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
		// TODO Auto-generated method stub
		return new MetaTileEntityLargeLaserEngraver(metaTileEntityId);
	}
	
	@Override
    public boolean canBeDistinct() 
	{
        return true;
    }
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound data)
	{
        data.setInteger("ParallelsCfg", configuredParallels);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data)
    {
    	configuredParallels = data.getInteger("ParallelsCfg");
        super.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf)
    {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(configuredParallels);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf)
    {
        super.receiveInitialSyncData(buf);
        configuredParallels = buf.readVarInt();
    }
	
	private float getProcessingSpeed()
	{
		return processingSpeed;
	}
	
	private int getConfiguredParallels()
	{
		return configuredParallels;
	}
	
	private int getFociTier()
	{
		return fociTier;
	}
	
	private class LaserEngraverRecipeLogic extends MultiblockRecipeLogic
	{
		private MetaTileEntityLargeLaserEngraver mte;
		public LaserEngraverRecipeLogic(MetaTileEntityLargeLaserEngraver tileEntity) 
		{
			super(tileEntity);
			this.mte = tileEntity;
		}
		
		@Override
		public int getParallelLimit()
		{
			return mte.getConfiguredParallels();
		}
		
		@Override
	    public long getMaxVoltage() {
	        return GTValues.V[mte.getFociTier()];
	    }
		
		@Override
	    public long getMaximumOverclockVoltage() 
		{
			IEnergyContainer energyContainer = getEnergyContainer();
			if (energyContainer instanceof EnergyContainerList energyList)
			{
				return energyList.getHighestInputVoltage();
			}
			else
			{
				return 0L;
			}
		}
		
		@Override
	    protected long getMaxParallelVoltage() {
	        return super.getMaximumOverclockVoltage();
	    }
		
		@Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage)
		{
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[1] /= mte.getProcessingSpeed(); 
            resultOverclock[1] = Math.max(1, resultOverclock[1]);
        }			
	}
}
