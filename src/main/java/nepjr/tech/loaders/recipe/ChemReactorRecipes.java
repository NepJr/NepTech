package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;

import static gregtech.api.GTValues.*;
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
			.EUt(VA[MV])
			.duration(50)
			.buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
				.fluidInputs(NTMaterials.UnactivatedNaqFuelMk1.getFluid(4000))
				.fluidInputs(NTMaterials.DragonsBreath.getFluid(2000))
				.fluidOutputs(NTMaterials.NaqFuelMk1.getFluid(6000))
				.EUt(VA[LuV])
				.duration(400)
				.buildAndRegister();
		
		RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.Titanite)
			.fluidInputs(Materials.HydrochloricAcid.getFluid(4000))
			.fluidOutputs(Materials.TitaniumTetrachloride.getFluid(1000))
			.fluidOutputs(Materials.Water.getFluid(2000))
			.fluidOutputs(Materials.Oxygen.getFluid(3000))
			.output(OrePrefix.dust, Materials.Silicon)
			.output(OrePrefix.dust, Materials.Calcium)
			.EUt(VA[EV])
			.duration(200)
			.buildAndRegister();
			
	}
}
