package nepjr.tech.loaders.recipe.machines;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.circuit;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockGlassCasing.CasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import net.minecraft.init.Blocks;

public class MultiblockRecipes
{
	public static void init()
	{
		// Greenhouse
				ModHandler.addShapedRecipe("greenhouse", NTMetaTileEntities.GREENHOUSE.getStackForm(), 
						"SCS",
						"CHC",
						"SCS",
						'S', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.LV),
						'H', MetaTileEntities.HULL[GTValues.LV].getStackForm());
				
				ModHandler.addShapedRecipe("hellish_ebf", NTMetaTileEntities.HELLISH_BLAST_FURNACE.getStackForm(), 
							"EEE",
							"PCP",
							"WPW",
							'E', MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm(),
							'P', new UnificationEntry(OrePrefix.circuit, Tier.IV),
							'C', NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.NETHERITE),
							'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten));
				
				ModHandler.addShapedRecipe("hellish_multi_smelter", NTMetaTileEntities.HELLISH_MULTI_SMELTER.getStackForm(), 
						"EEE",
						"PCP",
						"WPW",
						'E', MetaTileEntities.MULTI_FURNACE.getStackForm(),
						'P', new UnificationEntry(OrePrefix.circuit, Tier.IV),
						'C', NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.NETHERITE),
						'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten));
				
				ModHandler.addShapedRecipe("alloy_blast_smelter", NTMetaTileEntities.ALLOY_BLAST_SMELTER.getStackForm(),
			                "TCT", 
			                "WSW",
			                "TCT",
			                'T', new UnificationEntry(OrePrefix.plate, NTMaterials.TitaniumCarbide),
			                'C', new UnificationEntry(OrePrefix.circuit, Tier.HV),
			                'S', MetaTileEntities.ALLOY_SMELTER[GTValues.HV].getStackForm(),
			                'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
				
				ModHandler.addShapedRecipe("arc_smelter", NTMetaTileEntities.ARC_SMELTER.getStackForm(),
							"PCP",
							"WSW",
							"PCP",
							'P', new UnificationEntry(OrePrefix.plate, NTMaterials.TitaniumCarbide),
							'C', new UnificationEntry(OrePrefix.circuit, Tier.EV),
							'W', new UnificationEntry(OrePrefix.cableGtHex, Materials.Aluminium),
							'S', MetaTileEntities.ARC_FURNACE[GTValues.EV].getStackForm());
				
				ModHandler.addShapedRecipe("hellish_alloy_blast_smelter", NTMetaTileEntities.HELLISH_ABS.getStackForm(),
		                "TCT", 
		                "WSW",
		                "TCT",
		                'T', new UnificationEntry(OrePrefix.plate, NTMaterials.Netherite),
		                'C', new UnificationEntry(OrePrefix.circuit, Tier.LuV),
		                'S', NTMetaTileEntities.ALLOY_BLAST_SMELTER.getStackForm(),
		                'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium));
				
				ModHandler.addShapedRecipe("mixing_vessel", NTMetaTileEntities.MIXING_VESSEL.getStackForm(),
						"PRP",
						"CMC",
						"PRP",
						'P', new UnificationEntry(OrePrefix.plate, NTMaterials.HastelloyX),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.EV),
						'R', new UnificationEntry(OrePrefix.rotor, Materials.StainlessSteel),
						'M', MetaTileEntities.MIXER[GTValues.HV].getStackForm());
				
				ModHandler.addShapedRecipe("wire_supercoater", NTMetaTileEntities.WIRE_SUPERCOATER.getStackForm(), 
						"CPC",
						"EHE",
						"CPC",
						'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.PTFE_INERT_CASING),
						'E', new UnificationEntry(OrePrefix.circuit, Tier.EV),
						'P', MetaItems.ELECTRIC_PUMP_EV,
						'H', MetaTileEntities.HULL[GTValues.EV].getStackForm());
				
				ModHandler.addShapedRecipe("titanium_air_vacuum", NTMetaTileEntities.TITANIUM_AIR_VACUUM.getStackForm(),
						"PMP",
						"CSC",
						"PMP",
						'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.EV),
						'M', MetaItems.ELECTRIC_PUMP_EV,
						'S', MetaTileEntities.GAS_COLLECTOR[GTValues.EV].getStackForm());
				
				ModHandler.addShapedRecipe("tungstensteel_air_vacuum", NTMetaTileEntities.TUNGSTENSTEEL_AIR_VACUUM.getStackForm(),
						"PMP",
						"CSC",
						"PMP",
						'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.IV),
						'M', MetaItems.ELECTRIC_PUMP_IV,
						'S', MetaTileEntities.GAS_COLLECTOR[GTValues.IV].getStackForm());
				
				ModHandler.addShapedRecipe("pulverizer", NTMetaTileEntities.PULVERIZER.getStackForm(),
						"PMP",
						"CSC",
						"PMP",
						'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.HV),
						'M', MetaItems.COMPONENT_GRINDER_DIAMOND,
						'S', MetaTileEntities.MACERATOR[GTValues.HV].getStackForm());
				
				ModHandler.addShapedRecipe("industrial_centrifuge", NTMetaTileEntities.INDUSTRIAL_CENTRIFUGE.getStackForm(), 
						"PCP",
						"WSW",
						"PCP",
						'P', new UnificationEntry(OrePrefix.plate, NTMaterials.IncoloyMA956),
						'W', new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.HV),
						'S', MetaTileEntities.CENTRIFUGE[HV].getStackForm());
				
				ModHandler.addShapedRecipe("industrial_thermal_centrifuge", NTMetaTileEntities.INDUSTRIAL_THERMAL_CENTRIFUGE.getStackForm(), 
						"PCP",
						"WSW",
						"PCP",
						'P', new UnificationEntry(OrePrefix.plate, NTMaterials.IncoloyMA956),
						'W', MetaBlocks.WIRE_COIL.getItemVariant(CoilType.NICHROME),
						'C', new UnificationEntry(OrePrefix.circuit, Tier.HV),
						'S', MetaTileEntities.THERMAL_CENTRIFUGE[HV].getStackForm());
				
				if(NTConfig.neptech.reworkedSteamGrinderOver)
				{
					// Steam Grinder 
					
					ModHandler.addShapelessRecipe("steam_grinder_to_crusher", 
							NTMetaTileEntities.STEAM_CRUSHER.getStackForm(), 
							MetaTileEntities.STEAM_GRINDER.getStackForm());
					
					ModHandler.addShapedRecipe("steam_crusher", NTMetaTileEntities.STEAM_CRUSHER.getStackForm(), 
							"CGC",
							"CMC",
							"CGC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'G', new UnificationEntry(OrePrefix.gear, Materials.Potin),
							'M', MetaTileEntities.STEAM_MACERATOR_BRONZE.getStackForm());
					
					// Steam Smelter
					ModHandler.addShapelessRecipe("steam_oven_to_smelter", 
							NTMetaTileEntities.STEAM_SMELTER.getStackForm(), 
							MetaTileEntities.STEAM_OVEN.getStackForm());
					
					ModHandler.addShapedRecipe("steam_smelter", NTMetaTileEntities.STEAM_SMELTER.getStackForm(), 
							"CGC",
							"CMC",
							"CGC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'G', new UnificationEntry(OrePrefix.gear, Materials.Invar),
							'M', MetaTileEntities.STEAM_FURNACE_BRONZE.getStackForm());
					
					ModHandler.addShapedRecipe("steam_smelter_furnace", NTMetaTileEntities.STEAM_SMELTER.getStackForm(), 
							"CGC",
							"CMC",
							"CGC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'G', new UnificationEntry(OrePrefix.gear, Materials.Invar),
							'M', Blocks.FURNACE);
					
					if(NTConfig.neptech.enableHPMultiblocks)
					{
						ModHandler.addShapedRecipe("steam_crusher_upgrade", NTMetaTileEntities.HP_STEAM_CRUSHER.getStackForm(), 
								"CGC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'G', new UnificationEntry(OrePrefix.gear, Materials.WroughtIron),
								'M', NTMetaTileEntities.STEAM_CRUSHER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_crusher", NTMetaTileEntities.HP_STEAM_CRUSHER.getStackForm(), 
								"CGC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'G', new UnificationEntry(OrePrefix.gear, Materials.WroughtIron),
								'M', MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm());
						
						ModHandler.addShapedRecipe("steam_smelter_upgrade", NTMetaTileEntities.HP_STEAM_SMELTER.getStackForm(), 
								"CGC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'G', new UnificationEntry(OrePrefix.gear, Materials.Invar),
								'M', NTMetaTileEntities.STEAM_SMELTER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_smelter", NTMetaTileEntities.HP_STEAM_SMELTER.getStackForm(), 
								"CGC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'G', new UnificationEntry(OrePrefix.gear, Materials.Invar),
								'M', MetaTileEntities.STEAM_FURNACE_STEEL.getStackForm());
					}
				}
				
				if(NTConfig.neptech.enableNewSteamMultis)
				{
					// Steam Smasher
					ModHandler.addShapedRecipe("steam_smasher", NTMetaTileEntities.STEAM_SMASHER.getStackForm(), 
							"CPC",
							"CMC",
							"CPC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'P', OreDictNames.craftingPiston,
							'M', MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm());
					
					// Steam Fuser
					ModHandler.addShapedRecipe("steam_fuser", NTMetaTileEntities.STEAM_FUSER.getStackForm(), 
							"CPC",
							"CMC",
							"CPC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'P', new UnificationEntry(OrePrefix.plate, Materials.Invar),
							'M', MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm());
					
					// Steam Squasher
					ModHandler.addShapedRecipe("steam_squasher", NTMetaTileEntities.STEAM_SQUASHER.getStackForm(), 
							"CPC",
							"CMC",
							"CPC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'P', OreDictNames.craftingPiston,
							'M', MetaTileEntities.STEAM_COMPRESSOR_BRONZE.getStackForm());
					
					// Steam Squeezer
					ModHandler.addShapedRecipe("steam_squeezer", NTMetaTileEntities.STEAM_SQUEEZER.getStackForm(), 
							"CPC",
							"CMC",
							"CGC",
							'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
							'P', OreDictNames.craftingPiston,
							'G', Blocks.GLASS,
							'M', MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm());
					
					
					if(NTConfig.neptech.enableHPMultiblocks)
					{
						ModHandler.addShapedRecipe("steam_smasher_upgrade", NTMetaTileEntities.HP_STEAM_SMASHER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'M', NTMetaTileEntities.STEAM_SMASHER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_smasher", NTMetaTileEntities.HP_STEAM_SMASHER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'M', MetaTileEntities.STEAM_HAMMER_STEEL.getStackForm());
						
						ModHandler.addShapedRecipe("steam_fuser_upgrade", NTMetaTileEntities.HP_STEAM_FUSER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF),
								'M', NTMetaTileEntities.STEAM_FUSER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_fuser", NTMetaTileEntities.HP_STEAM_FUSER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF),
								'M', MetaTileEntities.STEAM_ALLOY_SMELTER_STEEL.getStackForm());
						
						ModHandler.addShapedRecipe("steam_squasher_upgrade", NTMetaTileEntities.HP_STEAM_SQUASHER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'M', NTMetaTileEntities.STEAM_SQUASHER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_squasher", NTMetaTileEntities.HP_STEAM_SQUASHER.getStackForm(), 
								"CPC",
								"CMC",
								"CPC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'M', MetaTileEntities.STEAM_COMPRESSOR_STEEL.getStackForm());
						
						ModHandler.addShapedRecipe("steam_squeezer_upgrade", NTMetaTileEntities.HP_STEAM_SQUEEZER.getStackForm(), 
								"CPC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(CasingType.TEMPERED_GLASS),
								'M', NTMetaTileEntities.STEAM_SQUEEZER.getStackForm());
						
						ModHandler.addShapedRecipe("hp_steam_squeezer", NTMetaTileEntities.HP_STEAM_SQUEEZER.getStackForm(), 
								"CPC",
								"CMC",
								"CGC",
								'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
								'P', MetaItems.ELECTRIC_PISTON_LV,
								'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(CasingType.TEMPERED_GLASS),
								'M', MetaTileEntities.STEAM_EXTRACTOR_STEEL.getStackForm());
					}
				}
				
				if(NTConfig.neptech.reworkedSteamSolarBoilers)
				{
					// Steam Solar boiler
					ModHandler.addShapedRecipe("nt_steam_solar_boiler", NTMetaTileEntities.STEAM_SOLAR_BOILER.getStackForm(), 
							"GGG",
							"PPP",
							"FHF",
							'G', Blocks.GLASS,
							'F', new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Bronze),
							'P', new UnificationEntry(OrePrefix.plate, Materials.Silver),
							'H', MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_BRICKS_HULL));
					
					// High Pressure Steam Solar boiler
					ModHandler.addShapedRecipe("nt_hp_steam_solar_boiler", NTMetaTileEntities.HP_STEAM_SOLAR_BOILER.getStackForm(), 
							"GGG",
							"PPP",
							"FHF",
							'G', Blocks.GLASS,
							'F', new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Steel),
							'P', new UnificationEntry(OrePrefix.plateDouble, Materials.Silver),
							'H', MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.STEEL_BRICKS_HULL));
				}
				
				if(NTConfig.neptech.harderMaintenanceHatches)
				{
					// Auto maintenance Hatch
					ModHandler.addShapedRecipe("new_auto_maintenance_hatch", MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm(), 
							"CMC",
							"RHR",
							"YCY",
							'C', new UnificationEntry(OrePrefix.circuit, Tier.UV),
							'M', MetaTileEntities.MAINTENANCE_HATCH.getStackForm(),
							'R', MetaItems.ROBOT_ARM_UV,
							'H', MetaTileEntities.HULL[GTValues.UV].getStackForm(),
							'Y', new UnificationEntry(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate));
				}
			
			ASSEMBLER_RECIPES.recipeBuilder()
				.input(MetaTileEntities.PACKER[GTValues.LV], 64)
				.output(NTMetaTileEntities.SUPER_PACKER)
				.EUt(VA[LV])
				.duration(3600*20)
				.buildAndRegister();
				
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.NAQUADAH_ALLOY, 8))
				.input(circuit, Tier.ZPM, 8)
				.input(MetaItems.ELECTRIC_PISTON_ZPM, 16)
				.input(MetaItems.ELECTRIC_PISTON_ZPM, 16)
				.fluidInputs(Materials.SolderingAlloy.getFluid(1152))
				.fluidInputs(Materials.NiobiumTitanium.getFluid(1152))
				.EUt(GTValues.VA[UV])
				.outputs(NTMetaTileEntities.ELECTRIC_IMPLOSION_COMPRESSOR.getStackForm())
				.stationResearch(b -> b
						.researchStack(MetaTileEntities.IMPLOSION_COMPRESSOR.getStackForm())
						.CWUt(32)
						.EUt(VA[ZPM]))
				.duration(800)
				.buildAndRegister();
			
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.input(MetaTileEntities.HULL[GTValues.LuV])
				.input(MetaItems.EMITTER_LuV, 8)
				.input(MetaItems.EMITTER_LuV, 8)
				.input(OrePrefix.circuit, Tier.LuV, 8)
				.input(OrePrefix.circuit, Tier.LuV, 8)
				.input(OrePrefix.lens, Materials.NetherStar, 8)
				.fluidInputs(Materials.SolderingAlloy.getFluid(1152))
				.fluidInputs(Materials.NiobiumTitanium.getFluid(1152))
				.EUt(VA[ZPM])
				.outputs(NTMetaTileEntities.LARGE_LASER_ENGRAVER.getStackForm())
				.scannerResearch(b -> b
						.researchStack(MetaTileEntities.LASER_ENGRAVER[GTValues.LuV].getStackForm())
						.EUt(VA[ZPM]))
				.duration(1600)
				.buildAndRegister();
			
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.input(NTMetaTileEntities.HELLISH_BLAST_FURNACE, 8)
				.input(NTMetaTileEntities.HELLISH_ABS, 8)
				.input(NTMetaTileEntities.HELLISH_MULTI_SMELTER, 8)
				.input(NTMetaTileEntities.ARC_SMELTER, 8)
				.stationResearch(b -> b
						.researchStack(NTMetaTileEntities.HELLISH_ABS.getStackForm())
						.CWUt(32)
						.EUt(VA[ZPM]))
				.EUt(VA[ZPM])
				.duration(200*20)
				.outputs(NTMetaTileEntities.UNIVERSAL_SMELTER.getStackForm())
				.buildAndRegister();
			
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.input(MetaTileEntities.HULL[ZPM])
				.input(OrePrefix.frameGt, Materials.NaquadahAlloy, 4)
				.input(OrePrefix.circuit, Tier.ZPM, 4)
				.input(MetaItems.ELECTRIC_MOTOR_ZPM, 4)
				.input(MetaItems.ELECTRIC_PUMP_ZPM, 4)
				.input(MetaItems.CONVEYOR_MODULE_ZPM, 4)
				.input(OrePrefix.gear, Materials.Naquadria, 4)
				.stationResearch(b -> b
						.researchStack(MetaTileEntities.ADVANCED_LARGE_MINER.getStackForm())
						.CWUt(32)
						.EUt(VA[LuV]))
				.output(NTMetaTileEntities.VOID_MINER_ZPM)
				.EUt(VA[ZPM])
				.duration(20*20)
				.buildAndRegister();
			
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.input(MetaTileEntities.HULL[UV])
				.input(OrePrefix.frameGt, Materials.Tritanium, 4)
				.input(OrePrefix.circuit, Tier.UV, 4)
				.input(MetaItems.ELECTRIC_MOTOR_UV, 4)
				.input(MetaItems.ELECTRIC_PUMP_UV, 4)
				.input(MetaItems.CONVEYOR_MODULE_UV, 4)
				.input(OrePrefix.gear, Materials.Darmstadtium, 4)
				.stationResearch(b -> b
						.researchStack(NTMetaTileEntities.VOID_MINER_ZPM.getStackForm())
						.CWUt(64)
						.EUt(VA[ZPM]))
				.output(NTMetaTileEntities.VOID_MINER_UV)
				.EUt(VA[UV])
				.duration(20*20)
				.buildAndRegister();
			
			ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.input(MetaTileEntities.HULL[UHV])
				.input(OrePrefix.frameGt, Materials.Neutronium, 4)
				.input(OrePrefix.circuit, Tier.UHV, 4)
				.input(MetaItems.ELECTRIC_MOTOR_UHV, 4)
				.input(MetaItems.ELECTRIC_PUMP_UHV, 4)
				.input(MetaItems.CONVEYOR_MODULE_UHV, 4)
				.input(OrePrefix.gear, Materials.Actinium, 4)
				.stationResearch(b -> b
						.researchStack(NTMetaTileEntities.VOID_MINER_UV.getStackForm())
						.CWUt(192)
						.EUt(VA[UV]))
				.output(NTMetaTileEntities.VOID_MINER_UHV)
				.EUt(VA[UHV])
				.duration(20*20)
				.buildAndRegister();
	}
}
