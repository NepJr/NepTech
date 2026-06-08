package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.init.Blocks;

public class AlloySmelterRecipes 
{
	public static void init()
	{
		RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
			.input(Blocks.SOUL_SAND)
			.input(OrePrefix.ingot, Materials.Gold)
			.output(OrePrefix.ingot, NTMaterials.Soularium)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	}
}
