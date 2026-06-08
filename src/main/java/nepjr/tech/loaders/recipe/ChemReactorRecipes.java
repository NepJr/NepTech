package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

public class ChemReactorRecipes 
{
	public static void init()
	{
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Sodium)
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(OrePrefix.dust, Materials.SodiumHydroxide, 3)
			.fluidOutputs(Materials.Hydrogen.getFluid(1000))
			.EUt(GTValues.VA[GTValues.MV])
			.duration(50)
			.buildAndRegister();
	}
}
