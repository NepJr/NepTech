package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import nepjr.tech.api.unification.material.NTMaterials;

public class FluidHeaterRecipes
{
    public static void init()
    {
        RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Blaze.getFluid(250))
                .fluidOutputs(NTMaterials.Pyrotheum.getFluid(250))
                .EUt(GTValues.VA[GTValues.IV])
                .duration(200)
                .buildAndRegister();
    }
}
