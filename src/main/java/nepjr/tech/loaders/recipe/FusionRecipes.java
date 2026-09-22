package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import nepjr.tech.api.unification.material.NTMaterials;

public class FusionRecipes
{
	public static void init()
	{
		RecipeMaps.FUSION_RECIPES.recipeBuilder()
			.fluidInputs(NTMaterials.Wyvernium.getFluid(24))
			.fluidInputs(NTMaterials.DragonBlood.getFluid(6))
			.fluidOutputs(NTMaterials.Draconium.getFluid(24))
			.EUt(GTValues.VA[GTValues.ZPM])
			.EUToStart(800000000)
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FUSION_RECIPES.recipeBuilder()
			.fluidInputs(Materials.Silicon.getFluid(18))
			.fluidInputs(NTMaterials.Mostimite.getFluid(144))
			.fluidOutputs(NTMaterials.TimeDialatedSilicon.getFluid(18))
			.EUt(GTValues.VA[GTValues.UHV])
			.EUToStart(800000000)
			.duration(200)
			.buildAndRegister();
	}
}
