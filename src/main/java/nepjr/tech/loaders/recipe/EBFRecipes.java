package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;

public class EBFRecipes
{
    public static void init()
    {
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.ingot, NTMaterials.Draconium, 4)
                .input(NTMetaItems.DRAGON_HEART)
                .fluidInputs(NTMaterials.Pyrotheum.getFluid(4000))
                .output(OrePrefix.ingotHot, NTMaterials.AwakenedDraconium, 4)
                .blastFurnaceTemp(9600)
                .EUt(GTValues.VA[GTValues.UV])
                .duration(400)
                .buildAndRegister();

    }
}
