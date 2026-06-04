package nepjr.tech.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static nepjr.tech.NepTech.nepId;

public class NTMaterials 
{
	public static Material VoidGas;
	public static Material Cryotheum;
	public static Material Pyrotheum;
	
	// Holmium related stuff
	public static Material ImpureHolmiumSolution;
	public static Material EnrichedHolmiumSolution;
	public static Material HolmiumChloride;
	public static Material Holminide;
	
	public static void init()
	{
		VoidGas = new Material.Builder(8000, nepId("void_gas"))
				.gas()
				.color(0x440044)
				.build();
		
		Holminide = new Material.Builder(8002, nepId("holminide"))
				.ore()
				.iconSet(DULL)
				.color(0x661166)
				.build();
		
		Cryotheum = new Material.Builder(8003, nepId("cryotheum"))
				.liquid(new FluidBuilder()
                        .temperature(1))
				.iconSet(DULL)
				.color(0x89CFEF)
				.build();
	}
}
