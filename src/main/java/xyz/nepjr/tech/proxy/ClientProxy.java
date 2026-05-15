package xyz.nepjr.tech.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import xyz.nepjr.tech.common.blocks.NTMetaBlocks;

@EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public boolean isServerSide()
	{
		return false;
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		NTMetaBlocks.registerItemModels();
	}
}
