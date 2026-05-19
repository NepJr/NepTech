package nepjr.tech.api.unification.material;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;

public class GTMaterialModifications 
{
	public static void init()
	{
		Materials.Topaz.addFlags(MaterialFlags.GENERATE_LENS); // Topaz Lens for orange lens
		Materials.BlueTopaz.addFlags(MaterialFlags.GENERATE_LENS); // Blue Topaz Lens for Light Blue
		Materials.GarnetYellow.addFlags(MaterialFlags.GENERATE_LENS); // Yellow Garnet Lens for Yellow (shocker!)
	}
}
