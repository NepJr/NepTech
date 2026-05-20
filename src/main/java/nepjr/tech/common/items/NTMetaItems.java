package nepjr.tech.common.items;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import nepjr.tech.common.items.behaviors.ColorSprayInfiniteBehaviour;

import static gregtech.api.GTValues.M;

import gregtech.api.GregTechAPI;

public class NTMetaItems 
{
	private static StandardMetaItem nepItems;
	
	// Voltage Coils
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_MAX;
	
	// Bioware Circuits
	public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_ZPM;
	public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_ASSEMBLY_UV;
	public static MetaItem<?>.MetaValueItem BIOWARE_SUPER_COMPUTER_UHV;
	public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME_UEV;
	
	// Optical Circuits
	public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_UV;
	public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_ASSEMBLY_UHV;
	public static MetaItem<?>.MetaValueItem OPTICAL_SUPER_COMPUTER_UEV;
	public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME_UIV;
	
	// Exotic Circuits
	public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_UHV;
	public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_ASSEMBLY_UEV;
	public static MetaItem<?>.MetaValueItem EXOTIC_SUPER_COMPUTER_UIV;
	public static MetaItem<?>.MetaValueItem EXOTIC_MAINFRAME_UXV;
	
	// Cosmic Circuits
	public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_UEV;
	public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_ASSEMBLY_UIV;
	public static MetaItem<?>.MetaValueItem COSMIC_SUPER_COMPUTER_UXV;
	public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME_OpV;
	
	// Supra-Causal Circuits
	public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR_UIV;
	public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR_ASSEMBLY_UXV;
	public static MetaItem<?>.MetaValueItem SUPRACAUSAL_SUPER_COMPUTER_OpV;
	public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME_MAX;
	
	// Universal Circuits
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_LV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_MV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_HV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_EV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_IV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_LuV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_ZPM;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_UV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_UHV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_UEV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_UIV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_UXV;
	public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_OpV;
	//public static MetaItem<?>.MetaValueItem UNIVERSAL_CIRCUIT_MAX;
	
	public static MetaItem<?>.MetaValueItem INFINITE_SPRAY_CAN;
	
	// Mining Drones
	public static MetaItem<?>.MetaValueItem BASIC_MINING_DRONE;
	public static MetaItem<?>.MetaValueItem ADVANCED_MINING_DRONE;
	public static MetaItem<?>.MetaValueItem LEGENDARY_MINING_DRONE;
	
	public static void init()
	{
		nepItems = new StandardMetaItem();
		nepItems.setRegistryName("neptech_meta_item");
	}
	
	public static void initSub()
	{
		initItems();
	}
	
	private static void initItems()
	{
		// Voltage Coils: ID 0 - 5
        VOLTAGE_COIL_UHV = nepItems.addItem(0, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UEV = nepItems.addItem(1, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UIV = nepItems.addItem(2, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UXV = nepItems.addItem(3, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_OpV = nepItems.addItem(4, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_MAX = nepItems.addItem(5, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        
        // Bioware Circuits
        BIOWARE_PROCESSOR_ZPM = nepItems.addItem(6, "circuit.bioware_processor").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        BIOWARE_PROCESSOR_ASSEMBLY_UV = nepItems.addItem(7, "circuit.bioware_assembly").setUnificationData(OrePrefix.circuit, Tier.UV);
        BIOWARE_SUPER_COMPUTER_UHV = nepItems.addItem(8, "circuit.bioware_computer").setUnificationData(OrePrefix.circuit, Tier.UHV);
        BIOWARE_MAINFRAME_UEV = nepItems.addItem(9, "circuit.bioware_mainframe").setUnificationData(OrePrefix.circuit, Tier.UEV);
        
        // Optical Circuits
        OPTICAL_PROCESSOR_UV = nepItems.addItem(10, "circuit.optical_processor").setUnificationData(OrePrefix.circuit, Tier.UV);
        OPTICAL_PROCESSOR_ASSEMBLY_UHV = nepItems.addItem(11, "circuit.optical_assembly").setUnificationData(OrePrefix.circuit, Tier.UHV);
        OPTICAL_SUPER_COMPUTER_UEV = nepItems.addItem(12, "circuit.optical_computer").setUnificationData(OrePrefix.circuit, Tier.UEV);
        OPTICAL_MAINFRAME_UIV = nepItems.addItem(13, "circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, Tier.UIV);
        
        // Exotic Circuits
        EXOTIC_PROCESSOR_UHV = nepItems.addItem(14, "circuit.exotic_processor").setUnificationData(OrePrefix.circuit, Tier.UHV);
        EXOTIC_PROCESSOR_ASSEMBLY_UEV = nepItems.addItem(15, "circuit.exotic_assembly").setUnificationData(OrePrefix.circuit, Tier.UEV);
        EXOTIC_SUPER_COMPUTER_UIV = nepItems.addItem(16, "circuit.exotic_computer").setUnificationData(OrePrefix.circuit, Tier.UIV);
        EXOTIC_MAINFRAME_UXV = nepItems.addItem(17, "circuit.exotic_mainframe").setUnificationData(OrePrefix.circuit, Tier.UXV);
        
        // Cosmic Circuits
        COSMIC_PROCESSOR_UEV = nepItems.addItem(18, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, Tier.UEV);
        COSMIC_PROCESSOR_ASSEMBLY_UIV = nepItems.addItem(19, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, Tier.UIV);
        COSMIC_SUPER_COMPUTER_UXV = nepItems.addItem(20, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, Tier.UXV);
        COSMIC_MAINFRAME_OpV = nepItems.addItem(21, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, Tier.OpV);
        
        // Supra-Causal Circuits
        SUPRACAUSAL_PROCESSOR_UIV = nepItems.addItem(22, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, Tier.UIV);
        SUPRACAUSAL_PROCESSOR_ASSEMBLY_UXV = nepItems.addItem(23, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, Tier.UXV);
        SUPRACAUSAL_SUPER_COMPUTER_OpV = nepItems.addItem(24, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, Tier.OpV);
        SUPRACAUSAL_MAINFRAME_MAX = nepItems.addItem(25, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, Tier.MAX);
	
        // Universal Circuits
        UNIVERSAL_CIRCUIT_LV = nepItems.addItem(26, "circuit.universal.lv").setUnificationData(OrePrefix.circuit, Tier.LV);
        UNIVERSAL_CIRCUIT_MV = nepItems.addItem(27, "circuit.universal.mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        UNIVERSAL_CIRCUIT_HV = nepItems.addItem(28, "circuit.universal.hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        UNIVERSAL_CIRCUIT_EV = nepItems.addItem(29, "circuit.universal.ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        UNIVERSAL_CIRCUIT_IV = nepItems.addItem(30, "circuit.universal.iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        UNIVERSAL_CIRCUIT_LuV = nepItems.addItem(31, "circuit.universal.luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        UNIVERSAL_CIRCUIT_ZPM = nepItems.addItem(32, "circuit.universal.zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        UNIVERSAL_CIRCUIT_UV = nepItems.addItem(33, "circuit.universal.uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        UNIVERSAL_CIRCUIT_UHV = nepItems.addItem(34, "circuit.universal.uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        UNIVERSAL_CIRCUIT_UEV = nepItems.addItem(35, "circuit.universal.uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        UNIVERSAL_CIRCUIT_UIV = nepItems.addItem(36, "circuit.universal.uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        UNIVERSAL_CIRCUIT_UXV = nepItems.addItem(37, "circuit.universal.uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        UNIVERSAL_CIRCUIT_OpV = nepItems.addItem(38, "circuit.universal.opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        //UNIVERSAL_CIRCUIT_MAX = nepItems.addItem(39, "circuit.universal.max").setUnificationData(OrePrefix.circuit, Tier.MAX);
        
        // Infinite spray can
        INFINITE_SPRAY_CAN = nepItems.addItem(40, "spray.infinite")
        		.addComponents(new ColorSprayInfiniteBehaviour())
        		.setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        
        BASIC_MINING_DRONE = nepItems.addItem(41, "basic_mining_drone");
        ADVANCED_MINING_DRONE = nepItems.addItem(42, "advanced_mining_drone");
        LEGENDARY_MINING_DRONE = nepItems.addItem(43, "legendary_mining_drone");
	}

}
