package nepjr.tech.loaders.recipe;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.config.NTConfig;
import net.minecraft.item.ItemStack;

public class RemovalRecipes 
{
	public static void init()
	{
		if(NTConfig.neptech.harderMaintenanceHatches)
		{
			// Auto maintenance hatch
			ModHandler.removeRecipeByOutput(MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm());
			// Auto maintenance hatch filtered
			ModHandler.removeRecipeByOutput(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm());
		}
		if(NTConfig.neptech.reworkedSteamGrinderOver)
		{
			// Steam Grinder
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_GRINDER.getStackForm());
			
			// Steam Oven
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_OVEN.getStackForm());
		}
		if(NTConfig.neptech.reworkedSteamSolarBoilers)
		{
			// Steam Solar boiler
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm());
			
			// High Pressure Steam Solar boiler
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_BOILER_SOLAR_STEEL.getStackForm());
		}
		// Oilsands
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.ore, Materials.Oilsands)});
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Oilsands)});

	}
}
