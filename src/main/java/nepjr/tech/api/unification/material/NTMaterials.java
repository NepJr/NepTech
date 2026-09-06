package nepjr.tech.api.unification.material;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.GTValues.*;
import static nepjr.tech.NepTech.nepId;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

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
	
	// GCYM Materials
	public static Material Stellite100;
    public static Material WatertightSteel;
    public static Material MaragingSteel300;
    public static Material HastelloyC276;
    public static Material HastelloyX;
    public static Material Trinaquadalloy;
    public static Material Zeron100;
    public static Material TitaniumCarbide;
    public static Material TantalumCarbide;
    public static Material MolybdenumDisilicide;
    public static Material HSLASteel;
    public static Material TitaniumTungstenCarbide;
    public static Material IncoloyMA956;
	
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
				.flags(MaterialFlags.GENERATE_FRAME)
				.cableProperties(V[LuV], 16, 5)
				.blast(builder -> builder
						.temp(4500, GasTier.HIGH)
						.blastStats(VA[IV], 400))
				.addOreByproducts(Materials.Naquadah)
				.color(0x4b4042)
				.build();
		
		// EnderIO alloys
		// Colors borrowed from Nomi Labs / Nomifactory CEu
		
		EnergeticAlloy = new Material.Builder(8100, nepId("energetic_alloy"))
				.ingot(2).fluid()
				.iconSet(SHINY)
				.flags(EXT2_METAL)
				.cableProperties(V[MV], 16, 1)
				.blast(builder -> builder
						.temp(1500, GasTier.LOW)
						.blastStats(VA[LV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xffb545)
				.components(Materials.Gold, 1, Materials.Redstone, 1, Materials.Glowstone, 1)
				.build();
		
		VibrantAlloy = new Material.Builder(8101, nepId("vibrant_alloy"))
				.ingot(3).fluid()
				.iconSet(SHINY)
				.flags(EXT2_METAL)
				.cableProperties(V[HV], 16, 2)
				.blast(builder -> builder
						.temp(2000, GasTier.LOW)
						.blastStats(VA[MV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xa4ff70)
				.components(NTMaterials.EnergeticAlloy, 1, Materials.EnderPearl, 1)
				.build();
		
		RedstoneAlloy = new Material.Builder(8102, nepId("redstone_alloy"))
				.ingot(1).fluid()
				.iconSet(DULL)
				.flags(EXT2_METAL)
				.color(0xC80000)
				.components(Materials.Redstone, 1, Materials.Silicon, 1)
				.build();
		
		ElectricalSteel = new Material.Builder(8103, nepId("electrical_steel"))
				.ingot(2).fluid()
				.iconSet(METALLIC)
				.flags(EXT2_METAL)
				.color(0xb2c0c1)
				.components(Materials.Steel, 1, Materials.Silicon, 1)
				.build();
		
		ConductiveIron = new Material.Builder(8104, nepId("conductive_iron"))
				.ingot(2).fluid()
				.iconSet(DULL)
				.flags(EXT2_METAL)
				.cableProperties(V[LV], 16, 0)
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.components(Materials.Iron, 1, Materials.Redstone, 1)
				.color(0xf7b29b)
				.build();
		
		PulsatingIron = new Material.Builder(8105, nepId("pulsating_iron"))
				.ingot(2).fluid()
				.iconSet(DULL)
				.flags(EXT2_METAL)
				.cableProperties(V[ULV], 16, 0)
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0x6ae26e)
				.components(Materials.Iron, 1, Materials.EnderPearl, 1)
				.build();
		
		DarkSteel = new Material.Builder(8106, nepId("dark_steel"))
				.ingot(4).fluid()
				.iconSet(METALLIC)
				.flags(EXT2_METAL)
				.cableProperties(V[EV], 16, 3)
				.blast(builder -> builder
						.temp(3000, GasTier.LOW)
						.blastStats(VA[EV], 400))
				.color(0x414751)
				.components(Materials.Steel, 1, Materials.Obsidian, 1)
				.build();
		
		Soularium = new Material.Builder(8107, nepId("soularium"))
				.ingot(2).fluid()
				.iconSet(METALLIC)
				.flags(EXT2_METAL)
				.color(0x7c674d)
				.build();
		
		EndSteel = new Material.Builder(8108, nepId("end_steel"))
				.ingot(3).fluid()
				.iconSet(METALLIC)
				.flags(EXT2_METAL)
				.cableProperties(V[IV], 16, 4)
				.blast(builder -> builder
						.temp(4000, GasTier.MID)
						.blastStats(VA[IV], 400))
				.flags(MaterialFlags.GENERATE_FINE_WIRE)
				.color(0xd6d980)
				.components(NTMaterials.DarkSteel, 1, Materials.Endstone, 1, Materials.Obsidian, 1, Materials.TungstenSteel, 1)
				.build();
		
		Stellite100 = new Material.Builder(8109, nepId("stellite_100"))
                .ingot().fluid()
                .color(0xDEDEFF).iconSet(BRIGHT)
                .flags(GENERATE_PLATE)
                .components(Iron, 4, Chrome, 3, Tungsten, 2, Molybdenum, 1)
                .blast(builder -> builder
                		.temp(3790, GasTier.HIGH)
                		.blastStats(VA[EV], 1000))
                .build();

        WatertightSteel = new Material.Builder(8110, nepId("watertight_steel"))
                .ingot().fluid()
                .color(0x355D6A).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Iron, 7, Aluminium, 4, Nickel, 2, Chrome, 1, Sulfur, 1)
                .blast(builder -> builder
                		.temp(3850, GasTier.MID)
                		.blastStats(VA[EV], 800))
                .build();

        MaragingSteel300 = new Material.Builder(8111, nepId("maraging_steel_300"))
                .ingot().fluid()
                .color(0x637087).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Iron, 16, Titanium, 1, Aluminium, 1, Nickel, 4, Cobalt, 2)
                .blast(builder -> builder
                		.temp(4000, GasTier.HIGH)
                		.blastStats(VA[EV], 1000))
                .build();

        HastelloyC276 = new Material.Builder(8112, nepId("hastelloy_c_276"))
                .ingot().fluid()
                .color(0xCF3939).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Nickel, 12, Molybdenum, 8, Chrome, 7, Tungsten, 1, Cobalt, 1, Copper, 1)
                .blast(builder -> builder
                		.temp(4625, GasTier.MID))
                .build();

        HastelloyX = new Material.Builder(8113, nepId("hastelloy_x"))
                .ingot().fluid()
                .color(0x6BA3E3).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Nickel, 8, Iron, 3, Tungsten, 4, Molybdenum, 2, Chrome, 1, Niobium, 1)
                .blast(builder -> builder
                		.temp(4200, GasTier.HIGH)
                		.blastStats(VA[EV], 900))
                .build();

        Trinaquadalloy = new Material.Builder(8114, nepId("trinaquadalloy"))
                .ingot().fluid()
                .color(0x281832).iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .components(Trinium, 6, Naquadah, 2, Carbon, 1)
                .blast(builder -> builder
                		.temp(8747, GasTier.HIGHER)
                		.blastStats(VA[ZPM], 1200))
                .build();

        Zeron100 = new Material.Builder(8115, nepId("zeron_100"))
                .ingot().fluid()
                .color(0x325A8C).iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(Iron, 10, Nickel, 2, Tungsten, 2, Niobium, 1, Cobalt, 1)
                .blast(builder -> builder
                		.temp(3693, GasTier.MID)
                		.blastStats(VA[EV], 1000))
                .build();

        TitaniumCarbide = new Material.Builder(8116, nepId("titanium_carbide"))
                .ingot().fluid()
                .color(0xB20B3A).iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(Titanium, 1, Carbon, 1)
                .blast(builder -> builder
                		.temp(3430, GasTier.MID)
                		.blastStats(VA[EV], 1000))
                .build();

        TantalumCarbide = new Material.Builder(8117, nepId("tantalum_carbide"))
                .ingot().fluid()
                .color(0x56566A).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DENSE)
                .components(Tantalum, 1, Carbon, 1)
                .blast(builder -> builder
                		.temp(4120, GasTier.MID)
                		.blastStats(VA[EV], 1200))
                .build();

        MolybdenumDisilicide = new Material.Builder(8118, nepId("molybdenum_disilicide"))
                .ingot().fluid()
                .color(0x6A5BA3).iconSet(METALLIC)
                .flags(EXT_METAL, GENERATE_DOUBLE_PLATE, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_RING)
                .components(Molybdenum, 1, Silicon, 2)
                .blast(builder -> builder
                		.temp(2300, GasTier.MID)
                		.blastStats(VA[EV], 800))
                .build();
        
        HSLASteel = new Material.Builder(8119, nepId("hsla_steel"))
                .ingot().fluid()
                .color(0x808080).iconSet(METALLIC)
                .flags(EXT_METAL, GENERATE_DOUBLE_PLATE, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_FRAME)
                .components(Invar, 2, Vanadium, 1, Titanium, 1, Molybdenum, 1)
                .blast(builder -> builder
                		.temp(1711, GasTier.LOW)
                		.blastStats(VA[HV], 1000))
                .build();

        TitaniumTungstenCarbide = new Material.Builder(8120, nepId("titanium_tungsten_carbide"))
                .ingot().fluid()
                .color(0x800D0D).iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(TungstenCarbide, 1, TitaniumCarbide, 2)
                .blast(builder -> builder
                		.temp(3800, GasTier.HIGH)
                		.blastStats(VA[EV], 1000))
                .build();

        IncoloyMA956 = new Material.Builder(8121, nepId("incoloy_ma_956"))
                .ingot().fluid()
                .color(0x37BF7E).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(VanadiumSteel, 4, Manganese, 2, Aluminium, 5, Yttrium, 2)
                .blast(builder -> builder
                		.temp(3625, GasTier.MID)
                		.blastStats(VA[EV], 800))
                .build();
	}
}
