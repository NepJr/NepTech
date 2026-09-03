package nepjr.tech.client;

import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import nepjr.tech.NTTags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = NTTags.MODID, value = Side.CLIENT)
public final class NTTextures 
{
	public static SimpleOverlayRenderer NETHERITE_CASING;
	public NTTextures() {}
	
	public static void preInit()
	{
		NETHERITE_CASING = new SimpleOverlayRenderer("casings/neptech/netherite");
	}
}
