package nepjr.tech.api;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class AE2Items 
{
	// Until I figure out how to actually call for the item/block, I'm doing it this way
	public static ItemStack FORMATION_CORE = getMaterialItem(43);
	public static ItemStack ANNIHILATION_CORE = getMaterialItem(44);
	
	public static ItemStack INSCRIBER_CALCULATION_PRESS = getMaterialItem(13);
	public static ItemStack INSCRIBER_ENGINEERING_PRESS = getMaterialItem(14);
	public static ItemStack INSCRIBER_LOGIC_PRESS = getMaterialItem(15);
	public static ItemStack INSCRIBER_SILICON_PRESS = getMaterialItem(19);
	
	public static ItemStack PRINTED_CALCULATION_CIRCUIT = getMaterialItem(16);
	public static ItemStack PRINTED_ENGINEERING_CIRCUIT = getMaterialItem(17);
	public static ItemStack PRINTED_LOGIC_CIRCUIT = getMaterialItem(18);
	public static ItemStack PRINTED_SILICON = getMaterialItem(20);
	
	public static ItemStack CALCULATION_PROCESSOR = getMaterialItem(23);
	public static ItemStack ENGINEERING_PROCESSOR = getMaterialItem(24);
	public static ItemStack LOGIC_PROCESSOR = getMaterialItem(22);
	
	public static ItemStack STORAGE_HOUSING = getMaterialItem(39);
	public static ItemStack STORAGE_COMPONENT_1K = getMaterialItem(35);
	public static ItemStack STORAGE_COMPONENT_4K = getMaterialItem(36);
	public static ItemStack STORAGE_COMPONENT_16K = getMaterialItem(37);
	public static ItemStack STORAGE_COMPONENT_64K = getMaterialItem(38);
	
	public static ItemStack FLUID_STORAGE_COMPONENT_1K = getMaterialItem(54);
	public static ItemStack FLUID_STORAGE_COMPONENT_4K = getMaterialItem(55);
	public static ItemStack FLUID_STORAGE_COMPONENT_16K = getMaterialItem(56);
	public static ItemStack FLUID_STORAGE_COMPONENT_64K = getMaterialItem(57);
	
	public static ItemStack FLUIX_CRYSTAL = getMaterialItem(7);
	public static ItemStack CHARGED_CERTUS = getMaterialItem(1);
	public static ItemStack PURE_CERTUS = getMaterialItem(10);
	public static ItemStack PURE_FLUIX = getMaterialItem(12);
	public static ItemStack PURE_QUARTZ = getMaterialItem(11);
	public static ItemStack PURE_CERTUS_SEED = new ItemStack(Item.getByNameOrId("appliedenergistics2:crystal_seed"), 1, 0);
	public static ItemStack PURE_FLUIX_SEED = new ItemStack(Item.getByNameOrId("appliedenergistics2:crystal_seed"), 1, 1200);
	public static ItemStack PURE_QUARTZ_SEED = new ItemStack(Item.getByNameOrId("appliedenergistics2:crystal_seed"), 1, 600);
	
	public static ItemStack P2P_GTEU = getPartItem(470);
	public static ItemStack P2P_FE = getPartItem(469);
	public static ItemStack P2P_ITEM = getPartItem(462);
	public static ItemStack P2P_FLUID = getPartItem(463);
	public static ItemStack P2P_ME = getPartItem(460);
	public static ItemStack P2P_REDSTONE = getPartItem(461);
	public static ItemStack P2P_LIGHT = getPartItem(467);
	
	public static ItemStack FLUIX_CABLE = getPartItem(16);
	public static ItemStack STORAGE_BUS = getPartItem(220);
	public static ItemStack FLUID_STORAGE_BUS = getPartItem(221);

	public static ItemStack IMPORT_BUS = getPartItem(240);
	public static ItemStack FLUID_IMPORT_BUS = getPartItem(241);
	public static ItemStack EXPORT_BUS = getPartItem(260);
	public static ItemStack FLUID_EXPORT_BUS = getPartItem(261);
	
	public static Block QUARTZ_GLASS = Block.getBlockFromName("appliedenergistics2:quartz_glass");
	public static Block MOLECULAR_ASSEMBLER = Block.getBlockFromName("appliedenergistics2:molecular_assembler");
	public static Block CREATIVE_ENERGY_CELL = Block.getBlockFromName("appliedenergistics2:creative_energy_cell");
	public static Block ME_CONTROLLER = Block.getBlockFromName("appliedenergistics2:controller");
	public static Block ME_DRIVE = Block.getBlockFromName("appliedenergistics2:drive");
	public static Block INTERFACE = Block.getBlockFromName("appliedenergistics2:interface");
	public static Block FLUID_INTERFACE = Block.getBlockFromName("appliedenergistics2:fluid_interface");
	public static Block MATTER_CONDENSER = Block.getBlockFromName("appliedenergistics2:condenser");
	public static Block INSCRIBER = Block.getBlockFromName("appliedenergistics2:inscriber");
	public static Block CRAFTING_UNIT = Block.getBlockFromName("appliedenergistics2:crafting_unit");
	public static Block CRAFTING_COPROCESSOR = Block.getBlockFromName("appliedenergistics2:crafting_accelerator");
	
	// AE2 Fluid Crafting
	public static Block FLUID_DISCRETIZER = Block.getBlockFromName("ae2fc:fluid_discretizer");
	
	// Crazy AE
	public static ItemStack STORAGE_COMPONENT_256K = getCrazyAEMaterialItem(0);
	public static ItemStack STORAGE_COMPONENT_1024K = getCrazyAEMaterialItem(1);
	public static ItemStack STORAGE_COMPONENT_4096K = getCrazyAEMaterialItem(2);
	public static ItemStack STORAGE_COMPONENT_16384K = getCrazyAEMaterialItem(3);
	public static ItemStack STORAGE_COMPONENT_65536K = getCrazyAEMaterialItem(4);
	public static ItemStack STORAGE_COMPONENT_262144K = getCrazyAEMaterialItem(5);
	public static ItemStack STORAGE_COMPONENT_1048576K = getCrazyAEMaterialItem(6);
	public static ItemStack STORAGE_COMPONENT_2097152K = getCrazyAEMaterialItem(7);
	
	public static ItemStack FLUID_STORAGE_COMPONENT_256K = getCrazyAEMaterialItem(8);
	public static ItemStack FLUID_STORAGE_COMPONENT_1024K = getCrazyAEMaterialItem(9);
	public static ItemStack FLUID_STORAGE_COMPONENT_4096K = getCrazyAEMaterialItem(10);
	public static ItemStack FLUID_STORAGE_COMPONENT_16384K = getCrazyAEMaterialItem(11);
	public static ItemStack FLUID_STORAGE_COMPONENT_65536K = getCrazyAEMaterialItem(12);
	public static ItemStack FLUID_STORAGE_COMPONENT_262144K = getCrazyAEMaterialItem(13);
	public static ItemStack FLUID_STORAGE_COMPONENT_1048576K = getCrazyAEMaterialItem(14);
	public static ItemStack FLUID_STORAGE_COMPONENT_2097152K = getCrazyAEMaterialItem(15);
	
	public static ItemStack ENERGY_COMPONENT_1K = getCrazyAEMaterialItem(36);
	public static ItemStack ENERGY_COMPONENT_4K = getCrazyAEMaterialItem(37);
	public static ItemStack ENERGY_COMPONENT_16K = getCrazyAEMaterialItem(38);
	public static ItemStack ENERGY_COMPONENT_64K = getCrazyAEMaterialItem(39);
	public static ItemStack ENERGY_COMPONENT_256K = getCrazyAEMaterialItem(40);
	public static ItemStack ENERGY_COMPONENT_1024K = getCrazyAEMaterialItem(41);
	public static ItemStack ENERGY_COMPONENT_4096K = getCrazyAEMaterialItem(42);
	public static ItemStack ENERGY_COMPONENT_16384K = getCrazyAEMaterialItem(43);
	public static ItemStack ENERGY_COMPONENT_65536K = getCrazyAEMaterialItem(44);
	public static ItemStack ENERGY_COMPONENT_262144K = getCrazyAEMaterialItem(45);
	public static ItemStack ENERGY_COMPONENT_1048576K = getCrazyAEMaterialItem(46);
	public static ItemStack ENERGY_COMPONENT_2097152K = getCrazyAEMaterialItem(47);
	
	public static ItemStack ENERGY_CELL_1K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_1k"), 1, 0);
	public static ItemStack ENERGY_CELL_4K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_4k"), 1, 0);
	public static ItemStack ENERGY_CELL_16K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_16k"), 1, 0);
	public static ItemStack ENERGY_CELL_64K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_64k"), 1, 0);
	public static ItemStack ENERGY_CELL_256K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_256k"), 1, 0);
	public static ItemStack ENERGY_CELL_1024K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_1mb"), 1, 0);
	public static ItemStack ENERGY_CELL_4096K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_4mb"), 1, 0);
	public static ItemStack ENERGY_CELL_16384K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_16mb"), 1, 0);
	public static ItemStack ENERGY_CELL_65536K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_64mb"), 1, 0);
	public static ItemStack ENERGY_CELL_262144K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_256mb"), 1, 0);
	public static ItemStack ENERGY_CELL_1048576K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_1gb"), 1, 0);
	public static ItemStack ENERGY_CELL_2097152K = new ItemStack(Item.getByNameOrId("crazyae:energy_cell_2gb"), 1, 0);
	
	public static ItemStack ENERGY_TERMINAL = getCrazyAEPartItem(9);
	public static ItemStack ENERGY_EXPORT = getCrazyAEPartItem(8);
	public static ItemStack ENERGY_IMPORT = getCrazyAEPartItem(7);

	public static ItemStack QUANTUM_PROCESSOR = getCrazyAEMaterialItem(16);
	public static ItemStack ENERGY_PROCESSOR = getCrazyAEMaterialItem(48);
	
	public static Block PERFECT_INTERFACE_THAT_CRASHES_THE_FUCKING_GAME = Block.getBlockFromName("crazyae:perfect_interface");
	
	private static ItemStack getMaterialItem(int index)
	{
		return new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, index);
	}
	
	private static ItemStack getPartItem(int index)
	{
		return new ItemStack(Item.getByNameOrId("appliedenergistics2:part"), 1, index);
	}
	
	private static ItemStack getCrazyAEMaterialItem(int index)
	{
		return Loader.isModLoaded("crazyae") ? new ItemStack(Item.getByNameOrId("crazyae:material"), 1, index)
											 : new ItemStack(Items.AIR);
	}
	
	private static ItemStack getCrazyAEPartItem(int index)
	{
		return Loader.isModLoaded("crazyae") ? new ItemStack(Item.getByNameOrId("crazyae:part"), 1, index)
											 : new ItemStack(Items.AIR);
	}
}
