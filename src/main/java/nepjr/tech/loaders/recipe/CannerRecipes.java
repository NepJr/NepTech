package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.init.Items;

public class CannerRecipes
{
    public static void init()
    {
        RecipeMaps.CANNER_RECIPES.recipeBuilder()
                .fluidInputs(NTMaterials.DragonsBreath.getFluid(250))
                .input(Items.GLASS_BOTTLE)
                .output(Items.DRAGON_BREATH)
                .EUt(GTValues.VA[GTValues.IV])
                .duration(50)
                .buildAndRegister();
    }
}
