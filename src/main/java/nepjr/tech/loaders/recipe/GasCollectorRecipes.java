package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GasCollectorRecipes 
{
	public static void init()
	{
		RecipeMaps.GAS_COLLECTOR_RECIPES.recipeBuilder()
				.notConsumable(NTMetaItems.SYNTHETIC_DRAGON_EGG)
				.fluidOutputs(NTMaterials.DragonsBreath.getFluid(100))
				.EUt(GTValues.VA[GTValues.ZPM])
				.duration(200)
				.buildAndRegister();

		RecipeMaps.GAS_COLLECTOR_RECIPES.recipeBuilder()
				.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.DRAGON_EGG)))
				.fluidOutputs(NTMaterials.DragonsBreath.getFluid(100))
				.EUt(GTValues.VA[GTValues.ZPM])
				.duration(200)
				.buildAndRegister();
	}
}
