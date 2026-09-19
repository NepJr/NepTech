package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;

public class FusionRecipes
{
	public static void init()
	{
		RecipeMaps.FUSION_RECIPES.recipeBuilder()
			.fluidInputs(NTMaterials.Wyvernium.getFluid(576))
			.fluidInputs(NTMaterials.DragonBlood.getFluid(144))
			.fluidOutputs(NTMaterials.Draconium.getFluid(576))
			.EUt(GTValues.VA[GTValues.UHV])
			.EUToStart(800000000)
			.duration(50)
			.buildAndRegister();
	}
}
