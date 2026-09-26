package nepjr.tech.loaders.recipe;

import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;

import static gregtech.api.GTValues.UV;
import static gregtech.api.GTValues.V;

public class NaqFuels
{
    public static void init()
    {
        NTRecipeMaps.NAQ_FUELS.recipeBuilder()
                .fluidInputs(NTMaterials.NaqFuelMk1.getFluid(1000))
                .EUt((int) V[UV] * 16)
                .duration(300)
                .buildAndRegister();
    }
}
