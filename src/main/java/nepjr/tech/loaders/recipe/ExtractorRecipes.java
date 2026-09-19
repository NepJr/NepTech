package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Items;

public class ExtractorRecipes
{
	public static void init()
	{
		RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
			.input(NTMetaItems.SYNTHETIC_DRAGON_EGG)
			.fluidOutputs(NTMaterials.DragonBlood.getFluid(144))
			.EUt(GTValues.VA[GTValues.LuV])
			.duration(200)
			.buildAndRegister();
		
		RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
			.input(Items.DRAGON_BREATH)
			.fluidOutputs(NTMaterials.DragonsBreath.getFluid(250))
			.EUt(GTValues.VA[GTValues.IV])
			.duration(50)
			.buildAndRegister();
	}
}
