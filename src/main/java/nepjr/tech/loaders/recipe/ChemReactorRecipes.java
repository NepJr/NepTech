package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;

import static gregtech.api.GTValues.LuV;
import static gregtech.api.GTValues.VA;

public class ChemReactorRecipes 
{
	public static void init()
	{
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Sodium)
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(OrePrefix.dust, Materials.SodiumHydroxide, 3)
			.fluidOutputs(Materials.Hydrogen.getFluid(1000))
			.EUt(VA[GTValues.MV])
			.duration(50)
			.buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
				.fluidInputs(NTMaterials.UnactivatedNaqFuelMk1.getFluid(4000))
				.fluidInputs(NTMaterials.DragonsBreath.getFluid(2000))
				.fluidOutputs(NTMaterials.NaqFuelMk1.getFluid(6000))
				.EUt(VA[LuV])
				.duration(400)
				.buildAndRegister();
	}
}
