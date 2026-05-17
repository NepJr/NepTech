package nepjr.tech.api.unification.material;

import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static nepjr.tech.NepTech.nepId;

public class NTMaterials 
{
	public static Material VoidGas;
	
	public static void init()
	{
		VoidGas = new Material.Builder(8000, nepId("void_gas"))
				.gas()
				.color(0x440044)
				.build();
	}
}
