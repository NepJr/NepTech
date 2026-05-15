package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

public class RemovalRecipes 
{
	public static void init()
	{
		// Water Reservoir
		//GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, MetaItems.COVER_INFINITE_WATER.getStackForm(), MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.EV].getStackForm(), MetaItems.ELECTRIC_PUMP_EV.getStackForm());
	}
}
