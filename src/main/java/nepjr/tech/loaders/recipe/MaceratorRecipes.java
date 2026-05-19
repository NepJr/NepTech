package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.MACERATOR_RECIPES;

import gregtech.api.GTValues;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class MaceratorRecipes 
{
	public static void init()
	{
		MACERATOR_RECIPES.recipeBuilder()
			.input(Blocks.BROWN_MUSHROOM_BLOCK)
			.output(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM), 4)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(100)
			.buildAndRegister();
		
		MACERATOR_RECIPES.recipeBuilder()
		.input(Blocks.RED_MUSHROOM_BLOCK)
		.output(Item.getItemFromBlock(Blocks.RED_MUSHROOM), 4)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(100)
		.buildAndRegister();
	}
}
