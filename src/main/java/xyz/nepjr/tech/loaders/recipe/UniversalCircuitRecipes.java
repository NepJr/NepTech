package xyz.nepjr.tech.loaders.recipe;

import gregtech.common.items.MetaItems;
import xyz.nepjr.tech.common.items.NTMetaItems;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.FORMING_PRESS_RECIPES;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_CREDIT;

public class UniversalCircuitRecipes 
{
	public static void init()
	{
		// ULV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.NAND_CHIP_ULV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_ULV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// LV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.ELECTRONIC_CIRCUIT_LV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.INTEGRATED_CIRCUIT_LV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.MICROPROCESSOR_LV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// MV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.ELECTRONIC_CIRCUIT_MV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_MV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.INTEGRATED_CIRCUIT_MV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_MV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.PROCESSOR_MV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_MV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// HV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.PROCESSOR_ASSEMBLY_HV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_HV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.NANO_PROCESSOR_HV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_HV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.PROCESSOR_ASSEMBLY_HV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_HV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// EV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.WORKSTATION_EV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_EV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.NANO_PROCESSOR_ASSEMBLY_EV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_EV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.QUANTUM_PROCESSOR_EV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_EV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// IV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.MAINFRAME_IV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_IV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.NANO_COMPUTER_IV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_IV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.QUANTUM_ASSEMBLY_IV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_IV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.CRYSTAL_PROCESSOR_IV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_IV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// LuV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.NANO_MAINFRAME_LUV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LuV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.QUANTUM_COMPUTER_LUV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LuV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.CRYSTAL_ASSEMBLY_LUV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LuV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.WETWARE_PROCESSOR_LUV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_LuV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// ZPM
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.QUANTUM_MAINFRAME_ZPM)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_ZPM)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.CRYSTAL_COMPUTER_ZPM)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_ZPM)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.WETWARE_PROCESSOR_ASSEMBLY_ZPM)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_ZPM)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.BIOWARE_PROCESSOR_ZPM)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_ZPM)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// UV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.CRYSTAL_MAINFRAME_UV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.WETWARE_SUPER_COMPUTER_UV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.BIOWARE_PROCESSOR_ASSEMBLY_UV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.OPTICAL_PROCESSOR_UV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// UHV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(MetaItems.WETWARE_MAINFRAME_UHV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UHV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.BIOWARE_SUPER_COMPUTER_UHV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UHV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.OPTICAL_PROCESSOR_ASSEMBLY_UHV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UHV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.EXOTIC_PROCESSOR_UHV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UHV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// UEV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.BIOWARE_MAINFRAME_UEV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UEV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.OPTICAL_SUPER_COMPUTER_UEV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UEV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.EXOTIC_PROCESSOR_ASSEMBLY_UEV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UEV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.COSMIC_PROCESSOR_UEV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UEV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// UIV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.OPTICAL_MAINFRAME_UIV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UIV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.EXOTIC_SUPER_COMPUTER_UIV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UIV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
			
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.COSMIC_PROCESSOR_ASSEMBLY_UIV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UIV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.SUPRACAUSAL_PROCESSOR_UIV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UIV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// UXV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.EXOTIC_MAINFRAME_UXV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UXV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();

		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.COSMIC_SUPER_COMPUTER_UXV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UXV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.SUPRACAUSAL_PROCESSOR_ASSEMBLY_UXV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_UXV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		// OpV
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.COSMIC_MAINFRAME_OpV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_OpV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
		
		FORMING_PRESS_RECIPES.recipeBuilder()
			.input(NTMetaItems.SUPRACAUSAL_SUPER_COMPUTER_OpV)
			.notConsumable(SHAPE_MOLD_CREDIT)
			.output(NTMetaItems.UNIVERSAL_CIRCUIT_OpV)
			.EUt(1)
			.duration(1)
			.buildAndRegister();
	}
}
