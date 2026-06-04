package nepjr.tech.metatileentities.steam;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.particle.VanillaParticleEffects;
import gregtech.client.renderer.texture.Textures;
import nepjr.tech.api.recipes.NTRecipeMaps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

public class SteamAutoSifter extends SteamMetaTileEntity {

    public SteamAutoSifter(ResourceLocation metaTileEntityId, boolean isHighPressure) {
        super(metaTileEntityId, NTRecipeMaps.AUTO_SIFTER, Textures.SIFTER_OVERLAY, isHighPressure);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new SteamAutoSifter(metaTileEntityId, isHighPressure);
    }

    @Override
    protected boolean isBrickedCasing() {
        return false;
    }

    @Override
    protected IItemHandlerModifiable createImportItemHandler() {
        return new NotifiableItemStackHandler(this, 1, this, false);
    }

    @Override
    protected IItemHandlerModifiable createExportItemHandler() {
        return new NotifiableItemStackHandler(this, 9, this, true);
    }

    @Override
    public ModularUI createUI(EntityPlayer player) {
        return createUITemplate(player)
                .slot(this.importItems, 0, 53, 25, GuiTextures.SLOT_STEAM.get(isHighPressure),
                        GuiTextures.FURNACE_OVERLAY_STEAM.get(isHighPressure))
                .progressBar(workableHandler::getProgressPercent, 79, 26, 20, 16,
                        GuiTextures.PROGRESS_BAR_ARROW_STEAM.get(isHighPressure), MoveType.HORIZONTAL,
                        workableHandler.getRecipeMap())
                .slot(this.exportItems, 0, 114, 7, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 1, 132, 7, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 2, 150, 7, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 3, 114, 25, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 4, 132, 25, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 5, 150, 25, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 6, 114, 43, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 7, 132, 43, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .slot(this.exportItems, 8, 150, 43, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .build(getHolder(), player);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick() {
        super.randomDisplayTick();
        if (isActive() && GTValues.RNG.nextBoolean()) {
            VanillaParticleEffects.defaultFrontEffect(this, 0.5F, EnumParticleTypes.SMOKE_NORMAL);
        }
    }
}
