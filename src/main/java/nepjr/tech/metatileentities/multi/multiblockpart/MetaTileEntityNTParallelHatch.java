package nepjr.tech.metatileentities.multi.multiblockpart;

import org.jetbrains.annotations.NotNull;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityParallelHatch;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.IncrementButtonWidget;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.ServerWidgetGroup;
import gregtech.api.gui.widgets.TextFieldWidget2;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityNTParallelHatch extends MetaTileEntityParallelHatch
{
	private final int maxParallel;
	public MetaTileEntityNTParallelHatch(ResourceLocation metaTileEntityId, int tier) 
	{
		super(metaTileEntityId, tier);
		this.maxParallel = (int) Math.pow(4, tier - GTValues.EV);
	}
	
	@Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) 
	{
        return new MetaTileEntityNTParallelHatch(this.metaTileEntityId, this.getTier());
    }

	@Override
    protected ModularUI createUI(@NotNull EntityPlayer entityPlayer) {
        ServerWidgetGroup parallelAmountGroup = new ServerWidgetGroup(() -> true);
        parallelAmountGroup.addWidget(new ImageWidget(62, 36, 53, 20, GuiTextures.DISPLAY)
                .setTooltip("gcym.machine.parallel_hatch.display"));

        parallelAmountGroup.addWidget(new IncrementButtonWidget(118, 36, 30, 20, 1, 4, 16, 64, this::setCurrentParallel)
                .setDefaultTooltip()
                .setShouldClientCallback(false));
        parallelAmountGroup
                .addWidget(new IncrementButtonWidget(29, 36, 30, 20, -1, -4, -16, -64, this::setCurrentParallel)
                        .setDefaultTooltip()
                        .setShouldClientCallback(false));

        parallelAmountGroup.addWidget(new TextFieldWidget2(63, 42, 51, 20, this::getParallelAmountToString, val -> {
            if (val != null && !val.isEmpty()) {
                setCurrentParallel(Integer.parseInt(val));
            }
        })
                .setCentered(true)
                .setNumbersOnly(1, this.maxParallel)
                .setMaxLength(6)
                .setValidator(getTextFieldValidator(() -> this.maxParallel)));

        return ModularUI.defaultBuilder()
                .widget(new LabelWidget(5, 5, getMetaFullName()))
                .widget(parallelAmountGroup)
                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT, 0)
                .build(getHolder(), entityPlayer);
    }
	
}
