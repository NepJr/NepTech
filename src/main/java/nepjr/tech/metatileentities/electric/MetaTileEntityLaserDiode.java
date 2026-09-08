package nepjr.tech.metatileentities.electric;

import static gregtech.api.capability.GregtechDataCodes.AMP_INDEX;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.ILaserContainer;
import gregtech.api.capability.impl.LaserContainerHandler;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.IPassthroughHatch;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleOrientedCubeRenderer;
import gregtech.client.renderer.texture.custom.FireboxActiveRenderer;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class MetaTileEntityLaserDiode extends MetaTileEntityMultiblockPart
implements IPassthroughHatch, IMultiblockAbilityPart<IPassthroughHatch>
{
	protected ILaserContainer buffer;
	private int amps;
	private static final String AMP_NBT_KEY = "laser_amp_mode";
	
	public MetaTileEntityLaserDiode(ResourceLocation metaTileEntityId, int tier) 
	{
		super(metaTileEntityId, tier);
		this.amps = 256;
		reinitializeEnergyContainer();
	}
	
	protected void reinitializeEnergyContainer() 
	{
        long tierVoltage = GTValues.V[getTier()];
        this.buffer = new LaserContainerHandler(this, tierVoltage * 65536, tierVoltage, amps, tierVoltage, amps);
		((LaserContainerHandler) this.buffer).setSideOutputCondition(s -> s == getFrontFacing());
		((LaserContainerHandler) this.buffer).setSideInputCondition(s -> s == getFrontFacing().getOpposite());
    }
	
	@Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
        return new MetaTileEntityLaserDiode(metaTileEntityId, getTier());
    }
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger(AMP_NBT_KEY, amps);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.amps = data.getInteger(AMP_NBT_KEY);
        reinitializeEnergyContainer();
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(amps);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.amps = buf.readInt();
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == AMP_INDEX) {
            this.amps = buf.readInt();
        }
    }

	@Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) 
	{
		ICubeRenderer baseTexture = getBaseTexture();
        pipeline = ArrayUtils.add(pipeline,
                new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        if (baseTexture instanceof FireboxActiveRenderer || baseTexture instanceof SimpleOrientedCubeRenderer) 
        {
            baseTexture.renderOriented(renderState, translation, pipeline, getFrontFacing());
        } else 
        {
            baseTexture.render(renderState, translation, pipeline);
        }
        
        if (shouldRenderOverlay()) 
        {
        	Textures.LASER_SOURCE.renderSided(getFrontFacing(), renderState, translation, pipeline);
        	Textures.LASER_TARGET.renderSided(getFrontFacing().getOpposite(), renderState, translation, pipeline);
        }
    }
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, @NotNull List<String> tooltip,
                               boolean advanced) {
        tooltip.add(I18n.format("gregtech.machine.diode.tooltip_general"));
        tooltip.add(I18n.format("neptech.machine.laser_diode.tooltip_starts_at"));
        tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in_out", buffer.getInputVoltage(),
                GTValues.VNF[getTier()]));
        tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_in_out_till", getMaxAmperage()));
    }
	
	@Override
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.access_covers"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        tooltip.add(I18n.format("gregtech.tool_action.soft_mallet.toggle_mode"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }
	
	private void setAmpMode() 
	{
		amps = amps == getMaxAmperage() ? 256 : amps << 2;
        if (!getWorld().isRemote) {
            reinitializeEnergyContainer();
            writeCustomData(AMP_INDEX, b -> b.writeInt(amps));
            notifyBlockUpdate();
            markDirty();
        }
    }
	
	@Override
    public MultiblockAbility<IPassthroughHatch> getAbility() {
        return MultiblockAbility.PASSTHROUGH_HATCH;
    }

    @Override
    public void registerAbilities(@NotNull List<IPassthroughHatch> abilityList) {
        abilityList.add(this);
    }
	
	@Override
    protected boolean openGUIOnRightClick() {
        return false;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
	
	@Override
    public boolean onSoftMalletClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
                                     CuboidRayTraceResult hitResult) {
        if (getWorld().isRemote) {
            scheduleRenderUpdate();
            return true;
        }
        setAmpMode();
        playerIn.sendStatusMessage(new TextComponentTranslation("gregtech.machine.diode.message", amps), true);
        return true;
    }
	
    protected int getMaxAmperage()
	{
        return 65536;
    }
	
	@NotNull
    @Override
    public Class<?> getPassthroughType() 
	{
        return ILaserContainer.class;
    }
}
