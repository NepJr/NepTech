package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.metatileentities.NTMetaTileEntities;

public class CraftingRecipes 
{
	public static void init()
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
		
		ModHandler.addShapedRecipe("steam_crusher_upgrade", NTMetaTileEntities.STEAM_HP_CRUSHER.getStackForm(), 
				"CGC",
				"CMC",
				"CGC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'G', new UnificationEntry(OrePrefix.gear, Materials.WroughtIron),
				'M', NTMetaTileEntities.STEAM_CRUSHER.getStackForm());
		
		ModHandler.addShapedRecipe("hp_steam_crusher", NTMetaTileEntities.STEAM_HP_CRUSHER.getStackForm(), 
				"CGC",
				"CMC",
				"CGC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'G', new UnificationEntry(OrePrefix.gear, Materials.WroughtIron),
				'M', MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm());
		
		// Steam Smasher
		
		ModHandler.addShapedRecipe("steam_smasher", NTMetaTileEntities.STEAM_SMASHER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
				'P', OreDictNames.craftingPiston,
				'M', MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm());
		
		ModHandler.addShapedRecipe("steam_smasher_upgrade", NTMetaTileEntities.STEAM_HP_SMASHER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'P', MetaItems.ELECTRIC_PISTON_LV,
				'M', NTMetaTileEntities.STEAM_SMASHER.getStackForm());
		
		ModHandler.addShapedRecipe("hp_steam_smasher", NTMetaTileEntities.STEAM_HP_SMASHER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'P', MetaItems.ELECTRIC_PISTON_LV,
				'M', MetaTileEntities.STEAM_HAMMER_STEEL.getStackForm());
		
		// Steam Fuser
		
		ModHandler.addShapedRecipe("steam_fuser", NTMetaTileEntities.STEAM_FUSER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.BRONZE_BRICKS),
				'P', new UnificationEntry(OrePrefix.plate, Materials.Invar),
				'M', MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm());
		
		ModHandler.addShapedRecipe("steam_fuser_upgrade", NTMetaTileEntities.STEAM_HP_FUSER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'P', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF),
				'M', NTMetaTileEntities.STEAM_FUSER.getStackForm());
		
		ModHandler.addShapedRecipe("hp_steam_fuser", NTMetaTileEntities.STEAM_HP_FUSER.getStackForm(), 
				"CPC",
				"CMC",
				"CPC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'P', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF),
				'M', MetaTileEntities.STEAM_ALLOY_SMELTER_STEEL.getStackForm());
		
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
