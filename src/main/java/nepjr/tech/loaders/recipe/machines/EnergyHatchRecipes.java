package nepjr.tech.loaders.recipe.machines;

import static gregtech.api.GTValues.*;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.metatileentities.NTMetaTileEntities;

public class EnergyHatchRecipes 
{
	public static void init()
	{
		ivRecipes();
		luvRecipes();
		zpmRecipes();
		uvRecipes();
		uhvRecipes();
	}
	
	private static void ivRecipes()
	{
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[IV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.EMITTER_IV, 8)
			.input(MetaItems.ELECTRIC_PUMP_IV, 8)
			.input(OrePrefix.cableGtOctal, Materials.Platinum, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_16384[0].getStackForm())
			.circuitMeta(4)
			.EUt(VA[IV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[IV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.SENSOR_IV, 8)
			.input(MetaItems.ELECTRIC_PUMP_IV, 8)
			.input(OrePrefix.cableGtOctal, Materials.Platinum, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_16384[0].getStackForm())
			.circuitMeta(4)
			.EUt(VA[IV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[IV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.EMITTER_IV, 16)
			.input(MetaItems.ELECTRIC_PUMP_IV, 16)
			.input(OrePrefix.cableGtHex, Materials.Platinum, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_65536[0].getStackForm())
			.circuitMeta(5)
			.EUt(VA[IV])
			.duration(240*20)
			.buildAndRegister();
	
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[IV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.SENSOR_IV, 16)
			.input(MetaItems.ELECTRIC_PUMP_IV, 16)
			.input(OrePrefix.cableGtHex, Materials.Platinum, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_65536[0].getStackForm())
			.circuitMeta(5)
			.EUt(VA[IV])
			.duration(240*20)
			.buildAndRegister();
	}
	
	private static void luvRecipes()
	{
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[LuV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.EMITTER_LuV, 8)
			.input(MetaItems.ELECTRIC_PUMP_LuV, 8)
			.input(OrePrefix.cableGtOctal, Materials.NiobiumTitanium, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_16384[1].getStackForm())
			.circuitMeta(4)
			.EUt(VA[LuV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[LuV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.SENSOR_LuV, 8)
			.input(MetaItems.ELECTRIC_PUMP_LuV, 8)
			.input(OrePrefix.cableGtOctal, Materials.NiobiumTitanium, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_16384[1].getStackForm())
			.circuitMeta(4)
			.EUt(VA[LuV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[LuV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.EMITTER_LuV, 16)
			.input(MetaItems.ELECTRIC_PUMP_LuV, 16)
			.input(OrePrefix.cableGtHex, Materials.NiobiumTitanium, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_65536[1].getStackForm())
			.circuitMeta(5)
			.EUt(VA[LuV])
			.duration(240*20)
			.buildAndRegister();
	
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[LuV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.SENSOR_LuV, 16)
			.input(MetaItems.ELECTRIC_PUMP_LuV, 16)
			.input(OrePrefix.cableGtHex, Materials.NiobiumTitanium, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_65536[1].getStackForm())
			.circuitMeta(5)
			.EUt(VA[LuV])
			.duration(240*20)
			.buildAndRegister();
	}
	
	private static void zpmRecipes()
	{
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[ZPM])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.EMITTER_ZPM, 8)
			.input(MetaItems.ELECTRIC_PUMP_ZPM, 8)
			.input(OrePrefix.cableGtOctal, Materials.VanadiumGallium, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_16384[2].getStackForm())
			.circuitMeta(4)
			.EUt(VA[ZPM])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[ZPM])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.SENSOR_ZPM, 8)
			.input(MetaItems.ELECTRIC_PUMP_ZPM, 8)
			.input(OrePrefix.cableGtOctal, Materials.VanadiumGallium, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_16384[2].getStackForm())
			.circuitMeta(4)
			.EUt(VA[ZPM])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[ZPM])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.EMITTER_ZPM, 16)
			.input(MetaItems.ELECTRIC_PUMP_ZPM, 16)
			.input(OrePrefix.cableGtHex, Materials.VanadiumGallium, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_65536[2].getStackForm())
			.circuitMeta(5)
			.EUt(VA[ZPM])
			.duration(240*20)
			.buildAndRegister();
	
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[ZPM])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.SENSOR_ZPM, 16)
			.input(MetaItems.ELECTRIC_PUMP_ZPM, 16)
			.input(OrePrefix.cableGtHex, Materials.VanadiumGallium, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_65536[2].getStackForm())
			.circuitMeta(5)
			.EUt(VA[ZPM])
			.duration(240*20)
			.buildAndRegister();
	}
	
	private static void uvRecipes()
	{
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.EMITTER_UV, 8)
			.input(MetaItems.ELECTRIC_PUMP_UV, 8)
			.input(OrePrefix.cableGtOctal, Materials.YttriumBariumCuprate, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_16384[3].getStackForm())
			.circuitMeta(4)
			.EUt(VA[UV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UV])
			.input(OrePrefix.lens, Materials.Diamond, 8)
			.input(MetaItems.SENSOR_UV, 8)
			.input(MetaItems.ELECTRIC_PUMP_UV, 8)
			.input(OrePrefix.cableGtOctal, Materials.YttriumBariumCuprate, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_16384[3].getStackForm())
			.circuitMeta(4)
			.EUt(VA[UV])
			.duration(120*20)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.EMITTER_UV, 16)
			.input(MetaItems.ELECTRIC_PUMP_UV, 16)
			.input(OrePrefix.cableGtHex, Materials.YttriumBariumCuprate, 4)
			.outputs(NTMetaTileEntities.LASER_INPUT_HATCH_65536[3].getStackForm())
			.circuitMeta(5)
			.EUt(VA[UV])
			.duration(240*20)
			.buildAndRegister();
	
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[UV])
			.input(OrePrefix.lens, Materials.Diamond, 16)
			.input(MetaItems.SENSOR_UV, 16)
			.input(MetaItems.ELECTRIC_PUMP_UV, 16)
			.input(OrePrefix.cableGtHex, Materials.YttriumBariumCuprate, 4)
			.outputs(NTMetaTileEntities.LASER_OUTPUT_HATCH_65536[3].getStackForm())
			.circuitMeta(5)
			.EUt(VA[UV])
			.duration(240*20)
			.buildAndRegister();
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
