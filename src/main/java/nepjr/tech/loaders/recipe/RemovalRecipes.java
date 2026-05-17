package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

public class RemovalRecipes 
{
	public static void init()
	{
		// Auto maintenance hatch
		ModHandler.removeRecipeByOutput(MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm());
		
		// Auto maintenance hatch filtered
		ModHandler.removeRecipeByOutput(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm());
		
		// Steam Grinder
		ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_GRINDER.getStackForm());
		
		// Steam Oven
		ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_OVEN.getStackForm());
	}
}
