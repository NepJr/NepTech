package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.BlockMixingModules.ModuleTier;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
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
		
		// Mixing Modules
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.ULV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Iron, 4)
			.input(OrePrefix.stickLong, Materials.Iron, 8)
			.input("craftingPiston", 2)
			.input(OrePrefix.circuit, Tier.ULV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.ULV))
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Steel, 4)
			.input(OrePrefix.stickLong, Materials.Steel, 8)
			.input(MetaItems.ELECTRIC_PISTON_LV, 2)
			.input(OrePrefix.circuit, Tier.LV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.LV))
			.EUt(GTValues.VA[GTValues.LV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.MV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Aluminium, 4)
			.input(OrePrefix.stickLong, Materials.Aluminium, 8)
			.input(MetaItems.ELECTRIC_PISTON_MV, 2)
			.input(OrePrefix.circuit, Tier.MV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.MV))
			.EUt(GTValues.VA[GTValues.MV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.HV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.StainlessSteel, 4)
			.input(OrePrefix.stickLong, Materials.StainlessSteel, 8)
			.input(MetaItems.ELECTRIC_PISTON_HV, 2)
			.input(OrePrefix.circuit, Tier.HV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.HV))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.EV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Titanium, 4)
			.input(OrePrefix.stickLong, Materials.Titanium, 8)
			.input(MetaItems.ELECTRIC_PISTON_EV, 2)
			.input(OrePrefix.circuit, Tier.EV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.EV))
			.EUt(GTValues.VA[GTValues.EV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.IV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.TungstenSteel, 4)
			.input(OrePrefix.stickLong, Materials.TungstenSteel, 8)
			.input(MetaItems.ELECTRIC_PISTON_IV, 2)
			.input(OrePrefix.circuit, Tier.IV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.IV))
			.EUt(GTValues.VA[GTValues.IV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LuV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.HSSS, 4)
			.input(OrePrefix.stickLong, Materials.HSSS, 8)
			.input(MetaItems.ELECTRIC_PISTON_LUV, 2)
			.input(OrePrefix.circuit, Tier.LuV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.LuV))
			.EUt(GTValues.VA[GTValues.LuV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.ZPM])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Osmiridium, 4)
			.input(OrePrefix.stickLong, Materials.Osmiridium, 8)
			.input(MetaItems.ELECTRIC_PISTON_ZPM, 2)
			.input(OrePrefix.circuit, Tier.ZPM)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.ZPM))
			.EUt(GTValues.VA[GTValues.ZPM])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Tritanium, 4)
			.input(OrePrefix.stickLong, Materials.Tritanium, 8)
			.input(MetaItems.ELECTRIC_PISTON_UV, 2)
			.input(OrePrefix.circuit, Tier.UV)
			.outputs(NTMetaBlocks.MIXING_MODULES2.getItemVariant(nepjr.tech.common.blocks.BlockMixingModules2.ModuleTier.UV))
			.EUt(GTValues.VA[GTValues.UV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UHV])
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.MIXER_CASING))
			.input(OrePrefix.rotor, Materials.Neutronium, 4)
			.input(OrePrefix.stickLong, Materials.Neutronium, 8)
			.input(MetaItems.ELECTRIC_PISTON_UHV, 2)
			.input(OrePrefix.circuit, Tier.UHV)
			.outputs(NTMetaBlocks.MIXING_MODULES2.getItemVariant(nepjr.tech.common.blocks.BlockMixingModules2.ModuleTier.UHV))
			.EUt(GTValues.VA[GTValues.UHV])
			.duration(100)
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
