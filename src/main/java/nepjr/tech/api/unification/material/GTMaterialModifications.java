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
		Materials.Holmium.getProperties().ensureSet(PropertyKey.INGOT);
		Materials.Holmium.getProperties().ensureSet(PropertyKey.DUST, true);
		Materials.Holmium.getProperties().ensureSet(PropertyKey.FLUID);
		Materials.Holmium.getProperties().ensureSet(PropertyKey.WIRE);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setVoltage((int) GTValues.V[GTValues.UEV]);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setLossPerBlock(0);
		Materials.Holmium.getProperty(PropertyKey.WIRE).setAmperage(16);
		Materials.Holmium.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
		
		Materials.Polybenzimidazole.addFlags(MaterialFlags.GENERATE_ROD);
		Materials.Polybenzimidazole.addFlags(MaterialFlags.GENERATE_FRAME);
		
		Materials.Gallium.getProperties().ensureSet(PropertyKey.ORE);
		
		Materials.NetherStar.getProperties().ensureSet(PropertyKey.ORE);
		OrePrefix.gemChipped.removeIgnored(Materials.NetherStar);
		OrePrefix.gemExquisite.removeIgnored(Materials.NetherStar);
		OrePrefix.gemFlawed.removeIgnored(Materials.NetherStar);
		OrePrefix.gemFlawless.removeIgnored(Materials.NetherStar);
		Materials.NetherStar.addFlags(MaterialFlags.HIGH_SIFTER_OUTPUT);
		
		// Frames
        Materials.TungstenCarbide.addFlags(MaterialFlags.GENERATE_FRAME);
        Materials.Tungsten.addFlags(MaterialFlags.GENERATE_FRAME);
        Materials.Brass.addFlags(MaterialFlags.GENERATE_FRAME);

        // Small Gears
        Materials.TungstenCarbide.addFlags(MaterialFlags.GENERATE_SMALL_GEAR);

        // Long Rods
        Materials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD);

        // Rotors
        Materials.Iridium.addFlags(MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROTOR);
        Materials.Neutronium.addFlags(MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROTOR);
        Materials.Aluminium.addFlags(MaterialFlags.GENERATE_ROTOR);
        Materials.Tritanium.addFlags(MaterialFlags.GENERATE_ROTOR);

        // Springs
        Materials.Neutronium.addFlags(MaterialFlags.GENERATE_SPRING);

        // Dense Plates
        Materials.Neutronium.addFlags(MaterialFlags.GENERATE_DENSE);

        // Foils
        Materials.Graphene.addFlags(MaterialFlags.GENERATE_FOIL);
	}
}
