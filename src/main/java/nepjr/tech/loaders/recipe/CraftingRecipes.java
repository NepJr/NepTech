package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockGlassCasing.CasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Loader;

public class CraftingRecipes 
{
	public static void init()
	{
		// Greenhouse
		if(NTConfig.neptech.enableGreenhouse)
		{
			ModHandler.addShapedRecipe("greenhouse", NTMetaTileEntities.GREENHOUSE.getStackForm(), 
					"SCS",
					"CHC",
					"SCS",
					'S', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
					'C', new UnificationEntry(OrePrefix.circuit, Tier.LV),
					'H', MetaTileEntities.HULL[GTValues.LV].getStackForm());
		}
		
		// Auto Sifter
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
			ModHandler.addShapedRecipe("auto_sifter", NTMetaTileEntities.AUTO_SIFTER.getStackForm(),
					"CPC",
					"BHB",
					"CPC",
					'C', new UnificationEntry(OrePrefix.circuit, Tier.LV),
					'B', MetaItems.CONVEYOR_MODULE_LV,
					'P', MetaItems.ELECTRIC_PISTON_LV,
					'H', MetaTileEntities.HULL[GTValues.LV].getStackForm());
			
			ModHandler.addShapedRecipe("bronze_auto_sifter", NTMetaTileEntities.STEAM_AUTO_SIFTER.getStackForm(), 
					"IPI",
					"BHB",
					"IPI",
					'I', Blocks.IRON_BARS,
					'B', new UnificationEntry(OrePrefix.plate, Materials.Bronze),
					'H', MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_HULL),
					'P', OreDictNames.craftingPiston);
			
			ModHandler.addShapedRecipe("hp_auto_sifter", NTMetaTileEntities.HP_STEAM_AUTO_SIFTER.getStackForm(), 
					"WSW",
					"PHP",
					"WWW",
					'W', new UnificationEntry(OrePrefix.plate, Materials.WroughtIron),
					'S', new UnificationEntry(OrePrefix.plate, Materials.Steel),
					'H', NTMetaTileEntities.STEAM_AUTO_SIFTER.getStackForm(),
					'P', new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.TinAlloy));
		}
		
		// Drone Launcher
		if(NTConfig.neptech.enableDroneLauncher)
		{
			ModHandler.addShapedRecipe("drone_launcher", NTMetaTileEntities.DRONE_LAUNCHER.getStackForm(), 
					"CSC",
					"PHP",
					"CSC",
					'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
					'P', new UnificationEntry(OrePrefix.circuit, Tier.HV),
					'S', MetaItems.SENSOR_HV,
					'H', MetaTileEntities.HULL[GTValues.HV].getStackForm());
			
			// Mining Drone
			ModHandler.addShapedRecipe("mining_drone", NTMetaItems.MINING_DRONE.getStackForm(), 
					"DED",
					"SGS",
					"THT",
					'E', MetaItems.EMITTER_LV,
					'S', MetaItems.SENSOR_LV,
					'G', MetaTileEntities.COMBUSTION_GENERATOR[GTValues.LV].getStackForm(),
					'T', MetaItems.POWER_THRUSTER,
					'H', MetaTileEntities.HULL[GTValues.LV].getStackForm(),
					'D', new UnificationEntry(OrePrefix.toolHeadDrill, Materials.Steel));
		}
		
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
	}
}
