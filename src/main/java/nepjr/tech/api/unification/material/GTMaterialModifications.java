package nepjr.tech.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;

public class GTMaterialModifications 
{
	public static void init()
	{
		Materials.Topaz.addFlags(MaterialFlags.GENERATE_LENS); // Topaz Lens for orange lens
		Materials.BlueTopaz.addFlags(MaterialFlags.GENERATE_LENS); // Blue Topaz Lens for Light Blue
		Materials.GarnetYellow.addFlags(MaterialFlags.GENERATE_LENS); // Yellow Garnet Lens for Yellow (shocker!)
		
		Materials.Glowstone.getProperties().ensureSet(PropertyKey.ORE);
		OrePrefix.ore.removeIgnored(Materials.Glowstone);
		OrePrefix.oreNetherrack.removeIgnored(Materials.Glowstone);
		OrePrefix.oreEndstone.removeIgnored(Materials.Glowstone);
		
		Materials.Zinc.getProperties().ensureSet(PropertyKey.ORE);
		Materials.Zinc.getProperty(PropertyKey.ORE).setOreByProducts(Materials.Gallium);
		
		Materials.Holmium.setMaterialRGB(0x882288);
		Materials.Holmium.getProperties().ensureSet(PropertyKey.WIRE);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setVoltage((int) GTValues.V[GTValues.UEV]);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setLossPerBlock(0);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setAmperage(8);
		Materials.Holmium.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
		
		Materials.Gallium.getProperties().ensureSet(PropertyKey.ORE);
		
		Materials.NetherStar.getProperties().ensureSet(PropertyKey.ORE);
		OrePrefix.gemChipped.removeIgnored(Materials.NetherStar);
		OrePrefix.gemExquisite.removeIgnored(Materials.NetherStar);
		OrePrefix.gemFlawed.removeIgnored(Materials.NetherStar);
		OrePrefix.gemFlawless.removeIgnored(Materials.NetherStar);
		Materials.NetherStar.addFlags(MaterialFlags.HIGH_SIFTER_OUTPUT);
	}
}
