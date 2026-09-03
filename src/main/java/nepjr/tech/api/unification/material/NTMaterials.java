package nepjr.tech.api.unification.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.GTValues.*;
import static nepjr.tech.NepTech.nepId;

public class NTMaterials 
{
	public static Material VoidGas;
	public static Material Cryotheum;
	public static Material Pyrotheum;
	public static Material Netherite;
	
	// EnderIO Alloys
	public static Material EnergeticAlloy;
	public static Material VibrantAlloy;
	public static Material ElectricalSteel;
	public static Material DarkSteel;
	public static Material EndSteel;
	public static Material RedstoneAlloy;
	public static Material ConductiveIron;
	public static Material PulsatingIron;
	public static Material Soularium;
	
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
		
		Netherite = new Material.Builder(8004, nepId("netherite"))
				.ingot().ore()
				.iconSet(METALLIC)
				.cableProperties(V[LuV], 16, 5)
				.blast(builder -> builder
						.temp(5000, GasTier.HIGH)
						.blastStats(VA[IV], 400))
				.addOreByproducts(Materials.Naquadah)
				.color(0x4b4042)
				.build();
		
		// EnderIO alloys
		// Colors borrowed from Nomi Labs / Nomifactory CEu
		
		EnergeticAlloy = new Material.Builder(8100, nepId("energetic_alloy"))
				.ingot().dust()
				.iconSet(SHINY)
				.cableProperties(V[MV], 16, 1)
				.blast(builder -> builder
						.temp(1500, GasTier.LOW)
						.blastStats(VA[LV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xffb545)
				.components(Materials.Gold, 1, Materials.Redstone, 1, Materials.Glowstone, 1)
				.build();
		
		VibrantAlloy = new Material.Builder(8101, nepId("vibrant_alloy"))
				.ingot().dust()
				.iconSet(SHINY)
				.cableProperties(V[HV], 16, 2)
				.blast(builder -> builder
						.temp(2000, GasTier.LOW)
						.blastStats(VA[MV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xa4ff70)
				.components(NTMaterials.EnergeticAlloy, 1, Materials.EnderPearl, 1)
				.build();
		
		RedstoneAlloy = new Material.Builder(8102, nepId("redstone_alloy"))
				.ingot().dust()
				.iconSet(DULL)
				.color(0xC80000)
				.components(Materials.Redstone, 1, Materials.Silicon, 1)
				.build();
		
		ElectricalSteel = new Material.Builder(8103, nepId("electrical_steel"))
				.ingot().dust()
				.iconSet(METALLIC)
				.color(0xb2c0c1)
				.components(Materials.Steel, 1, Materials.Silicon, 1)
				.build();
		
		ConductiveIron = new Material.Builder(8104, nepId("conductive_iron"))
				.ingot().dust()
				.iconSet(DULL)
				.cableProperties(V[LV], 16, 0)
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.components(Materials.Iron, 1, Materials.Redstone, 1)
				.color(0xf7b29b)
				.build();
		
		PulsatingIron = new Material.Builder(8105, nepId("pulsating_iron"))
				.ingot().dust()
				.iconSet(DULL)
				.cableProperties(V[ULV], 16, 0)
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0x6ae26e)
				.components(Materials.Iron, 1, Materials.EnderPearl, 1)
				.build();
		
		DarkSteel = new Material.Builder(8106, nepId("dark_steel"))
				.ingot().dust()
				.iconSet(METALLIC)
				.cableProperties(V[EV], 16, 3)
				.blast(builder -> builder
						.temp(3000, GasTier.LOW)
						.blastStats(VA[EV], 400))
				.color(0x414751)
				.components(Materials.Steel, 1, Materials.Obsidian, 1)
				.build();
		
		Soularium = new Material.Builder(8107, nepId("soularium"))
				.ingot().dust()
				.iconSet(METALLIC)
				.color(0x7c674d)
				.build();
		
		EndSteel = new Material.Builder(8108, nepId("end_steel"))
				.ingot().dust()
				.iconSet(METALLIC)
				.cableProperties(V[IV], 16, 4)
				.blast(builder -> builder
						.temp(4000, GasTier.MID)
						.blastStats(VA[IV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xd6d980)
				.components(NTMaterials.DarkSteel, 1, Materials.Endstone, 1, Materials.Obsidian, 1, Materials.Tungsten, 1)
				.build();
	}
}
