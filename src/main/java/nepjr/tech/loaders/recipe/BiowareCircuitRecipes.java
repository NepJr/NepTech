package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class BiowareCircuitRecipes
{
	public static void init()
	{
		LARGE_CHEMICAL_RECIPES.recipeBuilder()
			.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.DRAGON_EGG)))
			.input(MetaItems.STEM_CELLS, 64)
			.input(MetaItems.STEM_CELLS, 64)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(4000))
			.fluidInputs(Materials.Bacteria.getFluid(4000))
			.output(NTMetaItems.SYNTHETIC_DRAGON_EGG)
			.fluidOutputs(Materials.BacterialSludge.getFluid(4000))
			.EUt(VA[UEV])
			.duration(120*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(NTMetaItems.SYNTHETIC_DRAGON_EGG)
			.input(OrePrefix.dust, Materials.Tritanium)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(500))
			.fluidInputs(Materials.Bacteria.getFluid(500))
			.output(NTMetaItems.DRACONIC_STEM_CELLS)
			.fluidOutputs(Materials.BacterialSludge.getFluid(500))
			.EUt(VA[UV])
			.duration(15*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(NTMetaItems.SYNTHETIC_DRAGON_EGG, 3)
			.input(NTMetaItems.DRACONIC_STEM_CELLS)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(500))
			.fluidInputs(Materials.Bacteria.getFluid(500))
			.output(NTMetaItems.SYNTHETIC_DRAGON_EGG, 6)
			.fluidOutputs(Materials.BacterialSludge.getFluid(500))
			.EUt(VA[ZPM])
			.duration(15*20)
			.buildAndRegister();
		
		CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaItems.WETWARE_BOARD, 16)
			.input(MetaItems.PETRI_DISH, 4)
			.input(MetaItems.ELECTRIC_PUMP_UV)
			.input(MetaItems.SENSOR_ZPM)
			.input(OrePrefix.circuit, Tier.LuV)
			.input(OrePrefix.foil, Materials.YttriumBariumCuprate)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(8000))
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.output(NTMetaItems.BOARD_BIOWARE, 16)
			.EUt(VA[UV])
			.duration(60*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(NTMetaItems.BOARD_BIOWARE)
			.input(OrePrefix.foil, Materials.YttriumBariumCuprate, 32)
			.fluidInputs(Materials.SodiumPersulfate.getFluid(20000))
			.output(NTMetaItems.CIRCUIT_BOARD_BIOWARE)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.EUt(VA[IV])
			.duration(90*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(NTMetaItems.BOARD_BIOWARE)
			.input(OrePrefix.foil, Materials.YttriumBariumCuprate, 32)
			.fluidInputs(Materials.Iron3Chloride.getFluid(10000))
			.output(NTMetaItems.CIRCUIT_BOARD_BIOWARE)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.EUt(VA[IV])
			.duration(90*20)
			.buildAndRegister();
		
		CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.input(NTMetaItems.CIRCUIT_BOARD_BIOWARE)
			.input(NTMetaItems.DRACONIC_STEM_CELLS, 32)
			.input(OrePrefix.pipeHugeFluid, Materials.Polybenzimidazole, 8)
			.input(OrePrefix.plate, Materials.Americium, 16)
			.input(OrePrefix.foil, Materials.StyreneButadieneRubber, 32)
			.input(OrePrefix.bolt, Materials.Duranium, 16)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(1000))
			.output(NTMetaItems.DRACONIC_PROCESSING_UNIT)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.EUt(VA[UHV])
			.duration(45*20)
			.buildAndRegister();
		
		CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.input(NTMetaItems.DRACONIC_PROCESSING_UNIT)
			.input(MetaItems.CRYSTAL_SYSTEM_ON_CHIP)
			.input(MetaItems.QUBIT_CENTRAL_PROCESSING_UNIT)
			.input(MetaItems.ADVANCED_SMD_CAPACITOR, 16)
			.input(MetaItems.ADVANCED_SMD_TRANSISTOR, 16)
			.input(OrePrefix.wireFine, Materials.Europium, 8)
			.output(NTMetaItems.BIOWARE_PROCESSOR_ZPM, 2)
			.EUt(VA[UV])
			.duration(10*20)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.buildAndRegister();
		
		CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
			.input(NTMetaItems.CIRCUIT_BOARD_BIOWARE)
			.input(NTMetaItems.BIOWARE_PROCESSOR_ZPM, 2)
			.input(MetaItems.ADVANCED_SMD_INDUCTOR, 12)
			.input(MetaItems.ADVANCED_SMD_CAPACITOR, 24)
			.input(MetaItems.RANDOM_ACCESS_MEMORY, 48)
			.input(OrePrefix.wireFine, Materials.Europium, 32)
			.output(NTMetaItems.BIOWARE_PROCESSOR_ASSEMBLY_UV)
			.EUt(VA[UV])
			.duration(20*20)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(NTMetaItems.CIRCUIT_BOARD_BIOWARE)
			.input(NTMetaItems.BIOWARE_PROCESSOR_ASSEMBLY_UV)
			.input(MetaItems.ADVANCED_SMD_DIODE, 16)
			.input(MetaItems.NOR_MEMORY_CHIP, 32)
			.input(MetaItems.RANDOM_ACCESS_MEMORY, 32)
			.input(MetaItems.RANDOM_ACCESS_MEMORY, 32)
			.input(OrePrefix.wireFine, Materials.Europium, 48)
			.input(OrePrefix.wireFine, Materials.Europium, 48)
			.input(OrePrefix.foil, Materials.Europium, 64)
			.input(OrePrefix.foil, Materials.Europium, 64)
			.input(OrePrefix.plate, Materials.Holmium, 8)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1152))
			.stationResearch(b -> b
					.researchStack(NTMetaItems.BIOWARE_PROCESSOR_ASSEMBLY_UV.getStackForm())
					.CWUt(64)
					.EUt(VA[UHV]))
			.output(NTMetaItems.BIOWARE_SUPER_COMPUTER_UHV)
			.EUt(VA[UHV])
			.duration(20*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.frameGt, Materials.Neutronium, 2)
			.input(NTMetaItems.BIOWARE_SUPER_COMPUTER_UHV, 2)
			.input(MetaItems.ADVANCED_SMD_DIODE, 64)
			.input(MetaItems.ADVANCED_SMD_CAPACITOR, 64)
			.input(MetaItems.ADVANCED_SMD_TRANSISTOR, 64)
			.input(MetaItems.ADVANCED_SMD_RESISTOR, 64)
			.input(MetaItems.ADVANCED_SMD_INDUCTOR, 64)
			.input(OrePrefix.foil, Materials.Polybenzimidazole, 64)
			.input(OrePrefix.foil, Materials.Polybenzimidazole, 64)
			.input(MetaItems.RANDOM_ACCESS_MEMORY, 64)
			.input(MetaItems.RANDOM_ACCESS_MEMORY, 64)
			.input(OrePrefix.wireGtQuadruple, Materials.RutheniumTriniumAmericiumNeutronate, 16)
			.input(OrePrefix.plate, Materials.Holmium, 8)
			.fluidInputs(Materials.SolderingAlloy.getFluid(2880))
			.fluidInputs(Materials.Polybenzimidazole.getFluid(1152))
			.output(NTMetaItems.BIOWARE_MAINFRAME_UEV)
			.stationResearch(b -> b
					.researchStack(NTMetaItems.BIOWARE_SUPER_COMPUTER_UHV.getStackForm())
					.CWUt(192)
					.EUt(VA[UHV]))
			.EUt(VA[UHV])
			.duration(100*20)
			.buildAndRegister();
	}
}
