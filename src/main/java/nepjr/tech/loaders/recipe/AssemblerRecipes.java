package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;

public class AssemblerRecipes 
{
	public static void init()
	{
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.PRIMITIVE_WATER_PUMP)
			.inputs(MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.PUMP_DECK, 10))
			.input(OrePrefix.frameGt, Materials.TreatedWood, 10)
			.input(MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV])
			.input(MetaItems.ELECTRIC_PUMP_LV)
			.output(MetaTileEntities.RESERVOIR_HATCH)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(300)
			.buildAndRegister();
		
		// Energy Hatch Bullshit
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.LV])
			.input(OrePrefix.wireGtQuadruple, Materials.Tin, 2)
			.input(OrePrefix.plate, Materials.Steel, 2)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_LV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV])
			.input(OrePrefix.wireGtQuadruple, Materials.Cupronickel, 2)
			.input(OrePrefix.plate, Materials.Aluminium, 2)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_MV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV])
			.input(OrePrefix.wireGtQuadruple, Materials.Electrum, 2)
			.input(OrePrefix.plate, Materials.StainlessSteel, 2)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_HV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.MV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.LV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_LV)
			.input(OrePrefix.wireGtOctal, Materials.Tin, 4)
			.input(OrePrefix.plate, Materials.Steel, 4)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_LV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.MV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_MV)
			.input(OrePrefix.wireGtOctal, Materials.Cupronickel, 4)
			.input(OrePrefix.plate, Materials.Aluminium, 4)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_MV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.HV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_4A_HV)
			.input(OrePrefix.wireGtOctal, Materials.Electrum, 4)
			.input(OrePrefix.plate, Materials.StainlessSteel, 4)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_HV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.MV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.EV])
			.input(MetaTileEntities.ENERGY_INPUT_HATCH_4A[0])
			.input(OrePrefix.wireGtOctal, Materials.Aluminium, 4)
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.output(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_EV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.HV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.LV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_LV)
			.input(OrePrefix.wireGtHex, Materials.Tin, 2)
			.input(OrePrefix.plate, Materials.Steel, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_INPUT_LV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.MV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_MV)
			.input(OrePrefix.wireGtHex, Materials.Cupronickel, 2)
			.input(OrePrefix.plate, Materials.Aluminium, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_INPUT_MV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.HV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_HV)
			.input(OrePrefix.wireGtHex, Materials.Electrum, 2)
			.input(OrePrefix.plate, Materials.StainlessSteel, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_INPUT_HV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.HV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.EV])
			.input(NTMetaTileEntities.ENERGY_INPUT_HATCH_16A_EV)
			.input(OrePrefix.wireGtHex, Materials.Aluminium, 2)
			.input(OrePrefix.plate, Materials.Titanium, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_INPUT_EV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		// Dynamo Hatch Bullshit
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.LV])
			.input(OrePrefix.wireGtQuadruple, Materials.Tin, 2)
			.input(OrePrefix.plate, Materials.Steel, 2)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_LV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.MV])
			.input(OrePrefix.wireGtQuadruple, Materials.Cupronickel, 2)
			.input(OrePrefix.plate, Materials.Aluminium, 2)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_MV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.HV])
			.input(OrePrefix.wireGtQuadruple, Materials.Electrum, 2)
			.input(OrePrefix.plate, Materials.StainlessSteel, 2)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_HV)
			.duration(100)
			.EUt(GTValues.VA[GTValues.MV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.LV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_LV)
			.input(OrePrefix.wireGtOctal, Materials.Tin, 4)
			.input(OrePrefix.plate, Materials.Steel, 4)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_LV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.MV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_MV)
			.input(OrePrefix.wireGtOctal, Materials.Cupronickel, 4)
			.input(OrePrefix.plate, Materials.Aluminium, 4)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_MV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.HV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_4A_HV)
			.input(OrePrefix.wireGtOctal, Materials.Electrum, 4)
			.input(OrePrefix.plate, Materials.StainlessSteel, 4)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_HV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.MV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.TRANSFORMER[GTValues.EV])
			.input(MetaTileEntities.ENERGY_OUTPUT_HATCH_4A[0])
			.input(OrePrefix.wireGtOctal, Materials.Aluminium, 4)
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.output(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_EV)
			.duration(200)
			.EUt(GTValues.VA[GTValues.HV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.LV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_LV)
			.input(OrePrefix.wireGtHex, Materials.Tin, 2)
			.input(OrePrefix.plate, Materials.Steel, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_LV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.MV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_MV)
			.input(OrePrefix.wireGtHex, Materials.Cupronickel, 2)
			.input(OrePrefix.plate, Materials.Aluminium, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_MV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.LV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.HV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_HV)
			.input(OrePrefix.wireGtHex, Materials.Electrum, 2)
			.input(OrePrefix.plate, Materials.StainlessSteel, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_HV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.HV])
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.POWER_TRANSFORMER[GTValues.EV])
			.input(NTMetaTileEntities.ENERGY_OUTPUT_HATCH_16A_EV)
			.input(OrePrefix.wireGtHex, Materials.Aluminium, 2)
			.input(OrePrefix.plate, Materials.Titanium, 6)
			.output(NTMetaTileEntities.SUBSTATION_ENERGY_OUTPUT_EV)
			.duration(400)
			.EUt(GTValues.VA[GTValues.ULV])
			.buildAndRegister();
		
		// Infinite spray can time!'
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(Items.NETHER_STAR, 64)
			.inputs(MetaItems.SPRAY_SOLVENT.getStackForm())
			.output(NTMetaItems.INFINITE_SPRAY_SOLVENT)
			.EUt(GTValues.VA[GTValues.EV])
			.duration(200)
			.buildAndRegister();
		
		for (int i = 0; i < EnumDyeColor.values().length; i++) {
			ASSEMBLER_RECIPES.recipeBuilder()
				.input(Items.NETHER_STAR, 64)
				.inputs(MetaItems.SPRAY_CAN_DYES[i].getStackForm())
				.output(NTMetaItems.INFINITE_SPRAY_CAN_DYES[i])
				.EUt(GTValues.VA[GTValues.EV])
				.duration(200)
				.buildAndRegister();
		}
	}
}
