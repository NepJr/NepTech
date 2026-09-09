package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.metatileentities.NTMetaTileEntities;

public class LaserHatchRecipes 
{
	public static void init()
	{
		ivRecipes();
		luvRecipes();
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
}
