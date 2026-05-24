package nepjr.tech.loaders.recipe;

import static nepjr.tech.loaders.recipe.LaserEngraverRecipes.addEngraverRecipe;
import static nepjr.tech.api.AE2Items.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import appeng.api.AEApi;
import appeng.api.features.IInscriberRecipe;
import dev.beecube31.crazyae2.core.CrazyAE;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.config.NTConfig;
import nepjr.tech.loaders.recipe.LaserEngraverRecipes.Wafers;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreIngredient;

public class AE2Recipes 
{	
	public static void init()
	{
		removeRecipes();
		removeAllInscriberRecipes();
		addRecipes();
	}
	
	private static void removeRecipes()
	{
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(MOLECULAR_ASSEMBLER).getDefaultInstance());
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(ME_CONTROLLER).getDefaultInstance());
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(ME_DRIVE).getDefaultInstance());
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(INSCRIBER).getDefaultInstance());
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(CRAFTING_UNIT).getDefaultInstance());
		ModHandler.removeRecipeByOutput(Item.getItemFromBlock(CRAFTING_COPROCESSOR).getDefaultInstance());
		
		ModHandler.removeRecipeByOutput(STORAGE_HOUSING);
		ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_1K);
		ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_4K);
		ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_16K);
		ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_64K);
		
		ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_1K);
		ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_4K);
		ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_16K);
		ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_64K);
		
		ModHandler.removeRecipeByOutput(P2P_ME);
		ModHandler.removeRecipeByOutput(IMPORT_BUS);
		ModHandler.removeRecipeByOutput(FLUID_IMPORT_BUS);
		ModHandler.removeRecipeByOutput(EXPORT_BUS);
		ModHandler.removeRecipeByOutput(FLUID_EXPORT_BUS);
		
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/storage_cell_1k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/storage_cell_4k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/storage_cell_16k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/storage_cell_64k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/fluid_storage_cell_1k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/fluid_storage_cell_4k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/fluid_storage_cell_16k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/cells/fluid_storage_cell_64k");
		ModHandler.removeRecipeByName("appliedenergistics2:network/blocks/interfaces_interface");
		ModHandler.removeRecipeByName("appliedenergistics2:network/blocks/fluid_interfaces_interface");
		
		if(NTConfig.modcompat.enableAE2FCRecipes && Loader.isModLoaded("ae2fc"))
		{
			ModHandler.removeRecipeByOutput(Item.getItemFromBlock(FLUID_DISCRETIZER).getDefaultInstance());
		}
		if(NTConfig.modcompat.enableCrazyAERecipes && Loader.isModLoaded("crazyae"))
		{	
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_1K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_4K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_16K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_64K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_256K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_1024K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_4096K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_16384K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_65536K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_262144K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_1048576K);
			ModHandler.removeRecipeByOutput(ENERGY_COMPONENT_2097152K);
			
			ModHandler.removeRecipeByOutput(ENERGY_CELL_1K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_4K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_16K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_64K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_256K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_1024K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_4096K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_16384K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_65536K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_262144K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_1048576K);
			ModHandler.removeRecipeByOutput(ENERGY_CELL_2097152K);
			
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_256K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_1024K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_4096K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_16384K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_65536K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_262144K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_1048576K);
			ModHandler.removeRecipeByOutput(STORAGE_COMPONENT_2097152K);
			
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_256K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_1024K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_4096K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_16384K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_65536K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_262144K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_1048576K);
			ModHandler.removeRecipeByOutput(FLUID_STORAGE_COMPONENT_2097152K);
			
			ModHandler.removeRecipeByOutput(ENERGY_TERMINAL);
			ModHandler.removeRecipeByOutput(ENERGY_EXPORT);
			ModHandler.removeRecipeByOutput(ENERGY_IMPORT);
		}
	}
	
	// Looked at the code for how GroovyScript removes inscriber recipes and put it here.
	private static void removeAllInscriberRecipes()
	{
		Collection<IInscriberRecipe> recipes = new ArrayList<>(AEApi.instance().registries().inscriber().getRecipes());
		for(IInscriberRecipe recipe : recipes)
		{
			AEApi.instance().registries().inscriber().removeRecipe(recipe);
		}
	}
	
	private static void addRecipes()
	{
		if(NTConfig.modcompat.enableAE2FCRecipes && Loader.isModLoaded("ae2fc"))
		{	
			ModHandler.addShapedRecipe("fluid_discretizer_new", Item.getItemFromBlock(FLUID_DISCRETIZER).getDefaultInstance(), 
					"PEP",
					"FCI",
					"PEP",
					'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
					'F', FLUID_STORAGE_BUS,
					'I', STORAGE_BUS,
					'E', ENGINEERING_PROCESSOR,
					'C', MATTER_CONDENSER);
		}
		
		if(NTConfig.modcompat.enableCrazyAERecipes && Loader.isModLoaded("crazyae"))
		{
			RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
				.inputs(LOGIC_PROCESSOR)
				.inputs(ENGINEERING_PROCESSOR)
				.input(OrePrefix.circuit, Tier.IV)
				.outputs(QUANTUM_PROCESSOR)
				.EUt(GTValues.VA[GTValues.IV])
				.duration(200)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_64K.getItem(), 4, STORAGE_COMPONENT_64K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.EV, 4)
				.outputs(STORAGE_COMPONENT_256K)
				.EUt(GTValues.VA[GTValues.EV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_256K.getItem(), 4, STORAGE_COMPONENT_256K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.IV, 4)
				.outputs(STORAGE_COMPONENT_1024K)
				.EUt(GTValues.VA[GTValues.IV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_1024K.getItem(), 4, STORAGE_COMPONENT_1024K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.LuV, 4)
				.outputs(STORAGE_COMPONENT_4096K)
				.EUt(GTValues.VA[GTValues.LuV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_4096K.getItem(), 4, STORAGE_COMPONENT_4096K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.ZPM, 4)
				.outputs(STORAGE_COMPONENT_16384K)
				.EUt(GTValues.VA[GTValues.ZPM])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_16384K.getItem(), 4, STORAGE_COMPONENT_16384K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.UV, 4)
				.outputs(STORAGE_COMPONENT_65536K)
				.EUt(GTValues.VA[GTValues.UV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_65536K.getItem(), 4, STORAGE_COMPONENT_65536K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.UHV, 4)
				.outputs(STORAGE_COMPONENT_262144K)
				.EUt(GTValues.VA[GTValues.UHV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_262144K.getItem(), 4, STORAGE_COMPONENT_262144K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.UEV, 4)
				.outputs(STORAGE_COMPONENT_1048576K)
				.EUt(GTValues.VA[GTValues.UEV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(STORAGE_COMPONENT_1048576K.getItem(), 2, STORAGE_COMPONENT_1048576K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.circuit, Tier.UIV, 4)
				.outputs(STORAGE_COMPONENT_2097152K)
				.EUt(GTValues.VA[GTValues.UIV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(1)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_64K.getItem(), 4, FLUID_STORAGE_COMPONENT_64K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.EV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_256K)
				.EUt(GTValues.VA[GTValues.EV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
		
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_256K.getItem(), 4, FLUID_STORAGE_COMPONENT_256K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.IV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_1024K)
				.EUt(GTValues.VA[GTValues.IV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(CALCULATION_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_1024K.getItem(), 4, FLUID_STORAGE_COMPONENT_1024K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.LuV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_4096K)
				.EUt(GTValues.VA[GTValues.LuV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_4096K.getItem(), 4, FLUID_STORAGE_COMPONENT_4096K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.ZPM, 4)
				.outputs(FLUID_STORAGE_COMPONENT_16384K)
				.EUt(GTValues.VA[GTValues.ZPM])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_16384K.getItem(), 4, FLUID_STORAGE_COMPONENT_16384K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.UV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_65536K)
				.EUt(GTValues.VA[GTValues.UV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_65536K.getItem(), 4, FLUID_STORAGE_COMPONENT_65536K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.UHV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_262144K)
				.EUt(GTValues.VA[GTValues.UHV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_262144K.getItem(), 4, FLUID_STORAGE_COMPONENT_262144K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.UEV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_1048576K)
				.EUt(GTValues.VA[GTValues.UEV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
			
			RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(QUANTUM_PROCESSOR)
				.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_1048576K.getItem(), 2, FLUID_STORAGE_COMPONENT_1048576K.getMetadata()))
				.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
				.input(OrePrefix.plate, Materials.Lapis, 4)
				.input(OrePrefix.circuit, Tier.UIV, 4)
				.outputs(FLUID_STORAGE_COMPONENT_2097152K)
				.EUt(GTValues.VA[GTValues.UIV])
				.cleanroom(CleanroomType.CLEANROOM)
				.duration(5*20)
				.circuitMeta(2)
				.buildAndRegister();
		}
		
		// Make AE2 Printred Circuits in Laser Engraver
		addEngraverRecipe(Wafers.SILICON, INSCRIBER_CALCULATION_PRESS, PRINTED_CALCULATION_CIRCUIT);
		addEngraverRecipe(Wafers.SILICON, INSCRIBER_SILICON_PRESS, new ItemStack(PRINTED_SILICON.getItem(), 4, PRINTED_SILICON.getMetadata()));
		addEngraverRecipe(Wafers.SILICON, INSCRIBER_ENGINEERING_PRESS, PRINTED_ENGINEERING_CIRCUIT);
		addEngraverRecipe(Wafers.SILICON, INSCRIBER_LOGIC_PRESS, PRINTED_LOGIC_CIRCUIT);
		
		// ME Controller
		ModHandler.addShapedRecipe("me_controller_new", Item.getItemFromBlock(ME_CONTROLLER).getDefaultInstance(), 
				"PFP",
				"FCF",
				"PFP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'F', PURE_FLUIX,
				'C', new UnificationEntry(OrePrefix.circuit, Tier.IV));
		
		// ME Drive
		ModHandler.addShapedRecipe("me_drive_new", Item.getItemFromBlock(ME_DRIVE).getDefaultInstance(), 
				"PEP",
				"FCF",
				"PEP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'F', FLUIX_CABLE,
				'E', ENGINEERING_PROCESSOR,
				'C', new UnificationEntry(OrePrefix.circuit, Tier.HV));
		
		// Crafting Unit
		ModHandler.addShapedRecipe("crafting_unit_new", Item.getItemFromBlock(CRAFTING_UNIT).getDefaultInstance(), 
				"PCP",
				"FHF",
				"PCP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'C', CALCULATION_PROCESSOR,
				'F', FLUIX_CABLE,
				'H', new UnificationEntry(OrePrefix.circuit, Tier.HV));
		
		// Crafting Co-Processor
		ModHandler.addShapelessRecipe("coprocessor_new", Item.getItemFromBlock(CRAFTING_COPROCESSOR).getDefaultInstance(),
				Item.getItemFromBlock(CRAFTING_UNIT).getDefaultInstance(), 
				new UnificationEntry(OrePrefix.circuit, Tier.EV));
		
		// Interfaces
		
		ModHandler.addShapedRecipe("interface_new", Item.getItemFromBlock(INTERFACE).getDefaultInstance(), 
				"PGP",
				"A F",
				"PGP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'A', ANNIHILATION_CORE,
				'F', FORMATION_CORE,
				'G', new OreIngredient("blockGlass"));
		
		ModHandler.addShapedRecipe("fluid_interface_new", Item.getItemFromBlock(FLUID_INTERFACE).getDefaultInstance(), 
				"PLP",
				"A F",
				"PLP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'A', ANNIHILATION_CORE,
				'F', FORMATION_CORE,
				'L', new UnificationEntry(OrePrefix.plate, Materials.Lapis));
		
		// Import / Export busses
		
		ModHandler.addShapedRecipe("import_bus_new", IMPORT_BUS, 
				"   ",
				" A ",
				"PSP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'A', ANNIHILATION_CORE,
				'S', Item.getItemFromBlock(Blocks.STICKY_PISTON));
		
		ModHandler.addShapedRecipe("fluid_import_bus_new", FLUID_IMPORT_BUS, 
				"   ",
				"LAL",
				"PSP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'L', new UnificationEntry(OrePrefix.plate, Materials.Lapis),
				'A', ANNIHILATION_CORE,
				'S', Item.getItemFromBlock(Blocks.STICKY_PISTON));
		
		ModHandler.addShapedRecipe("export_bus_new", EXPORT_BUS, 
				"   ",
				"PFP",
				" S ",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'F', FORMATION_CORE,
				'S', Item.getItemFromBlock(Blocks.STICKY_PISTON));
		
		ModHandler.addShapedRecipe("fluid_export_bus_new", FLUID_EXPORT_BUS, 
				"   ",
				"PFP",
				"LSL",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'L', new UnificationEntry(OrePrefix.plate, Materials.Lapis),
				'F', FORMATION_CORE,
				'S', Item.getItemFromBlock(Blocks.STICKY_PISTON));
		
		// P2P Tunnels
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.inputs(FLUIX_CABLE)
			.outputs(P2P_ME)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.input(MetaItems.LAPOTRON_CRYSTAL)
			.outputs(P2P_GTEU)
			.EUt(GTValues.VA[GTValues.LuV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.input(Blocks.CHEST)
			.outputs(P2P_ITEM)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.input(OrePrefix.dust, Materials.Redstone)
			.outputs(P2P_REDSTONE)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.input(OrePrefix.dust, Materials.Glowstone)
			.outputs(P2P_LIGHT)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
			.input(OrePrefix.plate, Materials.Titanium, 4)
			.inputs(ENGINEERING_PROCESSOR)
			.inputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 4, FLUIX_CRYSTAL.getMetadata()))
			.input(Items.BUCKET)
			.outputs(P2P_FLUID)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		// Molecular Assembler
		ModHandler.addShapedRecipe("molecular_assembler_new", Item.getItemFromBlock(MOLECULAR_ASSEMBLER).getDefaultInstance(),
				"TGT",
				"ACF",
				"TGT",
				'T', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
				'A', ANNIHILATION_CORE,
				'F', FORMATION_CORE,
				'G', QUARTZ_GLASS,
				'C', MetaTileEntities.ASSEMBLER[GTValues.HV].getStackForm());
		
		// Creative Energy Cell
		ModHandler.addShapedRecipe("creative_energy_cell", Item.getItemFromBlock(CREATIVE_ENERGY_CELL).getDefaultInstance(), 
				"PFP",
				"FBF",
				"PFP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Neutronium),
				'F', new UnificationEntry(OrePrefix.wireFine, NTMaterials.Holmium),
				'B', MetaItems.ULTIMATE_BATTERY.getStackForm());
		
		// Charged Certus
		RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
			.input(OrePrefix.gem, Materials.CertusQuartz)
			.fluidInputs(Materials.DistilledWater.getFluid(1000))
			.outputs(CHARGED_CERTUS)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(15*20)
			.buildAndRegister();
		
		// Fluix Crystals
		RecipeMaps.MIXER_RECIPES.recipeBuilder()
			.inputs(CHARGED_CERTUS)
			.input(OrePrefix.dust, Materials.Redstone)
			.input(OrePrefix.gem, Materials.NetherQuartz)
			.notConsumable(Materials.DistilledWater.getFluid(1000))
			.outputs(new ItemStack(FLUIX_CRYSTAL.getItem(), 2, FLUIX_CRYSTAL.getMetadata()))
			.EUt(GTValues.VA[GTValues.MV])
			.duration(15*20)
			.buildAndRegister();
		
		// Pure Seeds
		
		RecipeMaps.FERMENTING_RECIPES.recipeBuilder()
			.inputs(PURE_CERTUS_SEED)
			.fluidInputs(Materials.DistilledWater.getFluid(250))
			.outputs(PURE_CERTUS)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.FERMENTING_RECIPES.recipeBuilder()
			.inputs(PURE_FLUIX_SEED)
			.fluidInputs(Materials.DistilledWater.getFluid(250))
			.outputs(PURE_FLUIX)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.FERMENTING_RECIPES.recipeBuilder()
			.inputs(PURE_QUARTZ_SEED)
			.fluidInputs(Materials.DistilledWater.getFluid(250))
			.outputs(PURE_QUARTZ)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(200)
			.buildAndRegister();
		
		// ME Storage Components
		
		ModHandler.addShapedRecipe("storage_housing_new", STORAGE_HOUSING,
				"PFP",
				"F F",
				"PFP",
				'P', new UnificationEntry(OrePrefix.plate, Materials.Steel),
				'F', new UnificationEntry(OrePrefix.wireFine, Materials.RedAlloy));
		
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(LOGIC_PROCESSOR)
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.circuit, Tier.ULV, 4)
			.outputs(STORAGE_COMPONENT_1K)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(5*20)
			.circuitMeta(1)
			.buildAndRegister();
		
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(STORAGE_COMPONENT_1K.getItem(), 4, STORAGE_COMPONENT_1K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.circuit, Tier.LV, 4)
			.outputs(STORAGE_COMPONENT_4K)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(5*20)
			.circuitMeta(1)
			.buildAndRegister();
		
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(STORAGE_COMPONENT_4K.getItem(), 4, STORAGE_COMPONENT_4K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.circuit, Tier.MV, 4)
			.outputs(STORAGE_COMPONENT_16K)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(5*20)
			.circuitMeta(1)
			.buildAndRegister();
		
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(STORAGE_COMPONENT_16K.getItem(), 4, STORAGE_COMPONENT_16K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.circuit, Tier.HV, 4)
			.outputs(STORAGE_COMPONENT_64K)
			.EUt(GTValues.VA[GTValues.HV])
			.cleanroom(CleanroomType.CLEANROOM)
			.duration(5*20)
			.circuitMeta(1)
			.buildAndRegister();
		
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(LOGIC_PROCESSOR)
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.plate, Materials.Lapis, 4)
			.input(OrePrefix.circuit, Tier.ULV, 4)
			.outputs(FLUID_STORAGE_COMPONENT_1K)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(5*20)
			.circuitMeta(2)
			.buildAndRegister();
	
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_1K.getItem(), 4, FLUID_STORAGE_COMPONENT_1K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.plate, Materials.Lapis, 4)
			.input(OrePrefix.circuit, Tier.LV, 4)
			.outputs(FLUID_STORAGE_COMPONENT_4K)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(5*20)
			.circuitMeta(2)
			.buildAndRegister();
	
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_4K.getItem(), 4, FLUID_STORAGE_COMPONENT_4K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.plate, Materials.Lapis, 4)
			.input(OrePrefix.circuit, Tier.MV, 4)
			.outputs(FLUID_STORAGE_COMPONENT_16K)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(5*20)
			.circuitMeta(2)
			.buildAndRegister();
	
		RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.inputs(CALCULATION_PROCESSOR)
			.inputs(new ItemStack(FLUID_STORAGE_COMPONENT_16K.getItem(), 4, FLUID_STORAGE_COMPONENT_16K.getMetadata()))
			.input(OrePrefix.wireFine, Materials.RedAlloy, 4)
			.input(OrePrefix.plate, Materials.Lapis, 4)
			.input(OrePrefix.circuit, Tier.HV, 4)
			.outputs(FLUID_STORAGE_COMPONENT_64K)
			.EUt(GTValues.VA[GTValues.HV])
			.cleanroom(CleanroomType.CLEANROOM)
			.duration(5*20)
			.circuitMeta(2)
			.buildAndRegister();
		
		// Make the actual AE2 Processors in a Forming Press. No Soldering required!
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 18))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 22))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 17))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 24))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 16))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 23))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.input(OrePrefix.block, Materials.Redstone)
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 25))
			.input(OrePrefix.block, Materials.Lapis)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 60))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 2, 47))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 28))
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 59))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
	}
}
