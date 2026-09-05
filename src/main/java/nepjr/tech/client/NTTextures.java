package nepjr.tech.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import nepjr.tech.NTTags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = NTTags.MODID, value = Side.CLIENT)
public final class NTTextures 
{
	// Controllers
	public static OrientedOverlayRenderer ALLOY_BLAST_SMELTER_OVERLAY;
	
	// Casings
	public static SimpleOverlayRenderer NETHERITE_CASING;
	public static SimpleOverlayRenderer NAQUADAH_ALLOY_CASING;
	public static SimpleOverlayRenderer MACERATOR_CASING;
    public static SimpleOverlayRenderer BLAST_CASING;
    public static SimpleOverlayRenderer ASSEMBLING_CASING;
    public static SimpleOverlayRenderer STRESS_PROOF_CASING;
    public static SimpleOverlayRenderer CORROSION_PROOF_CASING;
    public static SimpleOverlayRenderer VIBRATION_SAFE_CASING;
    public static SimpleOverlayRenderer WATERTIGHT_CASING;
    public static SimpleOverlayRenderer CUTTER_CASING;
    public static SimpleOverlayRenderer NONCONDUCTING_CASING;
    public static SimpleOverlayRenderer MIXER_CASING;
    public static SimpleOverlayRenderer ENGRAVER_CASING;
    public static SimpleOverlayRenderer ATOMIC_CASING;
    public static SimpleOverlayRenderer STEAM_CASING;
	
	public NTTextures() {}
	
	public static void preInit()
	{
		ALLOY_BLAST_SMELTER_OVERLAY = new OrientedOverlayRenderer("multiblock/neptech/alloy_blast_smelter");
		
		NETHERITE_CASING = new SimpleOverlayRenderer("casings/neptech/netherite");
		NAQUADAH_ALLOY_CASING = new SimpleOverlayRenderer("casings/neptech/naquadah_alloy");
		MACERATOR_CASING = new SimpleOverlayRenderer("casings/neptech/macerator_casing");
        BLAST_CASING = new SimpleOverlayRenderer("casings/neptech/blast_casing");
        ASSEMBLING_CASING = new SimpleOverlayRenderer("casings/neptech/assembler_casing");
        STRESS_PROOF_CASING = new SimpleOverlayRenderer("casings/neptech/stress_proof_casing");
        CORROSION_PROOF_CASING = new SimpleOverlayRenderer("casings/neptech/corrosion_proof_casing");
        VIBRATION_SAFE_CASING = new SimpleOverlayRenderer("casings/neptech/vibration_safe_casing");
        WATERTIGHT_CASING = new SimpleOverlayRenderer("casings/neptech/watertight_casing");
        CUTTER_CASING = new SimpleOverlayRenderer("casings/neptech/cutter_casing");
        NONCONDUCTING_CASING = new SimpleOverlayRenderer("casings/neptech/nonconducting_casing");
        MIXER_CASING = new SimpleOverlayRenderer("casings/neptech/mixer_casing");
        ENGRAVER_CASING = new SimpleOverlayRenderer("casings/neptech/engraver_casing");
        ATOMIC_CASING = new SimpleOverlayRenderer("casings/neptech/atomic_casing");
        STEAM_CASING = new SimpleOverlayRenderer("casings/neptech/steam_casing");
	}
}
