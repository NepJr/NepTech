package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;

public class GasCollectorRecipes 
{
	public static void init()
	{
		RecipeMaps.GAS_COLLECTOR_RECIPES.recipeBuilder()
			.input(NTMetaItems.SYNTHETIC_DRAGON_EGG)
			.fluidOutputs(NTMaterials.DragonsBreath.getFluid(100))
			.EUt(GTValues.VA[GTValues.ZPM])
			.duration(200)
			.buildAndRegister();
	}
}
