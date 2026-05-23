package nepjr.tech.loaders.recipe;

import static nepjr.tech.loaders.recipe.LaserEngraverRecipes.addEngraverRecipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.loaders.recipe.LaserEngraverRecipes.Wafers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AE2Recipes 
{
	public static void init()
	{
		removeRecipes();
		addRecipes();
	}
	
	private static void removeRecipes()
	{
		
	}
	
	private static void addRecipes()
	{
		addEngraverRecipe(Wafers.SILICON, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 13), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 16));
		addEngraverRecipe(Wafers.SILICON, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 19), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20));
		addEngraverRecipe(Wafers.SILICON, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 14), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 17));
		addEngraverRecipe(Wafers.SILICON, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 15), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 18));

		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 18))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 22))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 17))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 24))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 16))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 20))
			.input(OrePrefix.plate, Materials.Redstone)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 23))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.input(OrePrefix.block, Materials.Redstone)
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 25))
			.input(OrePrefix.block, Materials.Lapis)
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 60))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
		
		RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 2, 47))
			.inputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 28))
			.outputs(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 59))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(50)
			.buildAndRegister();
	}
}
