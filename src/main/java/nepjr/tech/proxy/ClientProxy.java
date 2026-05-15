package nepjr.tech.proxy;

import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

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
