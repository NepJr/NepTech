package nepjr.tech.common.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NTItemRingOfFlight extends Item implements IBauble
{
	public NTItemRingOfFlight()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack arg0)
	{
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase entity) 
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			player.capabilities.allowFlying = true;
		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase entity) 
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			player.capabilities.isFlying = false;
			player.capabilities.allowFlying = false;
		}
	}
}
