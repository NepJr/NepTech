package nepjr.tech.metatileentities.multi.multiblockpart;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityNTEnergyHatch extends MetaTileEntityEnergyHatch
{

	public MetaTileEntityNTEnergyHatch(ResourceLocation metaTileEntityId, int tier, int amperage, boolean isExportHatch) 
	{
		super(metaTileEntityId, tier, amperage, isExportHatch);
	}
	
	@Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityNTEnergyHatch(metaTileEntityId, getTier(), amperage, isExportHatch);
    }
	
	@Override
	public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems)
	{
        subItems.add(getStackForm());
    }
}
