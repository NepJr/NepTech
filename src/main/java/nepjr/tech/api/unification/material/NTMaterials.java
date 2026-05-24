package nepjr.tech.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static nepjr.tech.NepTech.nepId;

public class NTMaterials 
{
	public static Material VoidGas;
	
	// Holmium related stuff
	public static Material Holmium;
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
		
		Holmium = new Material.Builder(8001, nepId("holmium"))
				.ingot()
				.iconSet(SHINY)
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0x882288)
				.cableProperties(GTValues.V[UEV], 8, 0, false)
				.build();
		
		Holminide = new Material.Builder(8002, nepId("holminide"))
				.ore()
				.iconSet(DULL)
				.color(0x661166)
				.build();
	}
}
