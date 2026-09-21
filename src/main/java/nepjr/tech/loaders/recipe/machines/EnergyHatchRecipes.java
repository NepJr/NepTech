package nepjr.tech.loaders.recipe.machines;

import static gregtech.api.GTValues.*;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.pipelike.optical.OpticalPipeType;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.common.metatileentities.NTMetaTileEntities;

public class EnergyHatchRecipes 
{
	public static void init()
	{
		laserDiodes();
		laserHatches();
		uhvRecipes();
	}

	private static void laserDiodes()
	{
		for(int i = 0; i < 10; i++)
		{
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.input(MetaTileEntities.HULL[IV + i])
					.input(OrePrefix.gemFlawless, Materials.NetherStar, 2)
					.input(MetaBlocks.LASER_PIPES[0])
					.output(NTMetaTileEntities.LASER_DIODE[i])
					.EUt(VA[IV + i])
					.duration(200)
					.buildAndRegister();
		}
	}

	private static void laserHatches()
	{
		for(int i = 0; i < 10; i++)
		{
			int tier = IV + i;
			MetaItem<?>.MetaValueItem emitter = MetaItems.EMITTER_LV;
			MetaItem<?>.MetaValueItem sensor = MetaItems.SENSOR_LV;
			MetaItem<?>.MetaValueItem pump = MetaItems.ELECTRIC_PUMP_LV;
			Material cableMaterial = Materials.Tin;

			if(tier == IV)
			{
				emitter = MetaItems.EMITTER_IV;
				sensor = MetaItems.SENSOR_IV;
				pump = MetaItems.ELECTRIC_PUMP_IV;
				cableMaterial = Materials.Platinum;
			}

			if(tier == LuV)
			{
				emitter = MetaItems.EMITTER_LuV;
				sensor = MetaItems.SENSOR_LuV;
				pump = MetaItems.ELECTRIC_PUMP_LuV;
				cableMaterial = Materials.NiobiumTitanium;
			}

			if(tier == ZPM)
			{
				emitter = MetaItems.EMITTER_ZPM;
				sensor = MetaItems.SENSOR_ZPM;
				pump = MetaItems.ELECTRIC_PISTON_ZPM;
				cableMaterial = Materials.VanadiumGallium;
			}

			if(tier == UV)
			{
				emitter = MetaItems.EMITTER_UV;
				sensor = MetaItems.SENSOR_UV;
				pump = MetaItems.ELECTRIC_PISTON_UV;
				cableMaterial = Materials.YttriumBariumCuprate;
			}

			if(tier == UHV)
			{
				emitter = MetaItems.EMITTER_UHV;
				sensor = MetaItems.SENSOR_UHV;
				pump = MetaItems.ELECTRIC_PISTON_UHV;
				cableMaterial = Materials.RutheniumTriniumAmericiumNeutronate;
			}

			if(tier == UEV)
			{
				emitter = MetaItems.EMITTER_UEV;
				sensor = MetaItems.SENSOR_UEV;
				pump = MetaItems.ELECTRIC_PISTON_UEV;
				cableMaterial = Materials.Holmium;
			}

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.input(MetaTileEntities.HULL[tier])
					.input(OrePrefix.lens, Materials.Diamond, 8)
					.input(emitter, 8)
					.input(pump, 8)
					.input(OrePrefix.cableGtOctal, cableMaterial, 4)
					.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_16384[i].getStackForm())
					.circuitMeta(4)
					.EUt(VA[IV])
					.duration(120*20)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.input(MetaTileEntities.HULL[tier])
					.input(OrePrefix.lens, Materials.Diamond, 8)
					.input(sensor, 8)
					.input(pump, 8)
					.input(OrePrefix.cableGtOctal, cableMaterial, 4)
					.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_16384[i].getStackForm())
					.circuitMeta(4)
					.EUt(VA[tier])
					.duration(120*20)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.input(MetaTileEntities.HULL[IV])
					.input(OrePrefix.lens, Materials.Diamond, 16)
					.input(emitter, 16)
					.input(pump, 16)
					.input(OrePrefix.cableGtHex, cableMaterial, 4)
					.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_65536[i].getStackForm())
					.circuitMeta(5)
					.EUt(VA[tier])
					.duration(240*20)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.input(MetaTileEntities.HULL[tier])
					.input(OrePrefix.lens, Materials.Diamond, 16)
					.input(sensor, 16)
					.input(pump, 16)
					.input(OrePrefix.cableGtHex, cableMaterial, 4)
					.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_65536[i].getStackForm())
					.circuitMeta(5)
					.EUt(VA[tier])
					.duration(240*20)
					.buildAndRegister();

		}
	}
	
	private static void uhvRecipes()
	{
		RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UHV])
			.input(OrePrefix.cableGtSingle, Materials.Europium, 4)
			.input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
			.input(OrePrefix.circuit, Tier.UHV)
			.input(NTMetaItems.VOLTAGE_COIL_UHV)
			.fluidInputs(Materials.SodiumPotassium.getFluid(12000), Materials.SolderingAlloy.getFluid(5760))
			.stationResearch(b -> b
					.researchStack(MetaTileEntities.ENERGY_INPUT_HATCH[UV].getStackForm())
					.EUt(VA[UV])
					.CWUt(128))
			.output(MetaTileEntities.ENERGY_INPUT_HATCH[UHV])
			.EUt(VA[UHV])
			.duration(50*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UHV])
			.input(OrePrefix.spring, Materials.Europium, 4)
			.input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
			.input(OrePrefix.circuit, Tier.UHV)
			.input(NTMetaItems.VOLTAGE_COIL_UHV)
			.fluidInputs(Materials.SodiumPotassium.getFluid(12000), Materials.SolderingAlloy.getFluid(5760))
			.stationResearch(b -> b
					.researchStack(MetaTileEntities.ENERGY_OUTPUT_HATCH[UV].getStackForm())
					.EUt(VA[UV])
					.CWUt(128))
			.output(MetaTileEntities.ENERGY_OUTPUT_HATCH[UHV])
			.EUt(VA[UHV])
			.duration(50*20)
			.buildAndRegister();
	}
}
