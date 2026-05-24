package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

public class FormingPressRecipes 
{
	public static void init()
	{
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
		.input(OrePrefix.plate, Materials.Steel, 4)
		.input(OrePrefix.plateDouble, Materials.Steel, 2)
		.output(OrePrefix.toolHeadDrill, Materials.Steel)
		.EUt(GTValues.VA[GTValues.MV])
		.duration(15*20)
		.buildAndRegister();
	}
}
