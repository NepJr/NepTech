package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMaps;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

public class LaserEngraverRecipes 
{
	public static void init()
	{
	}
	
	public enum Wafers
	{
		SILICON,
		PHOSPHORUS,
		NAQUADAH,
		NEUTRONIUM;
	}
	
	public static void addEngraverRecipe(Wafers start, ItemStack lens, ItemStack output)
	{
		if(start == Wafers.SILICON)
		{
			addSiliconRecipe(lens, output, 1);
			addPhosphorusRecipe(lens, output, 4);
			addNaquadahRecipe(lens, output, 8);
			addNeutroniumRecipe(lens, output, 16);
		}
		
		if(start == Wafers.PHOSPHORUS)
		{
			addPhosphorusRecipe(lens, output, 1);
			addNaquadahRecipe(lens, output, 4);
			addNeutroniumRecipe(lens, output, 8);
		}
		
		if(start == Wafers.NAQUADAH)
		{
			addNaquadahRecipe(lens, output, 1);
			addNeutroniumRecipe(lens, output, 4);
		}
		
		if(start == Wafers.NEUTRONIUM)
		{
			addNeutroniumRecipe(lens, output, 1);
		}
	}
	
	private static void addSiliconRecipe(ItemStack lens, ItemStack output, int count)
	{
		RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
			.notConsumable(lens)
			.input(MetaItems.SILICON_WAFER)
			.outputs(new ItemStack(output.getItem(), output.getCount() * count, output.getMetadata()))
			.EUt(GTValues.VA[GTValues.MV])
			.duration(45*50)
			.buildAndRegister();
	}
	
	private static void addPhosphorusRecipe(ItemStack lens, ItemStack output, int count)
	{
		RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
			.notConsumable(lens)
			.input(MetaItems.PHOSPHORUS_WAFER)
			.outputs(new ItemStack(output.getItem(), output.getCount() * count, output.getMetadata()))
			.EUt(GTValues.VA[GTValues.HV])
			.cleanroom(CleanroomType.CLEANROOM)
			.duration(45*50)
			.buildAndRegister();
	}
	
	private static void addNaquadahRecipe(ItemStack lens, ItemStack output, int count)
	{
		RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
			.notConsumable(lens)
			.input(MetaItems.NAQUADAH_WAFER)
			.outputs(new ItemStack(output.getItem(), output.getCount() * count, output.getMetadata()))
			.EUt(GTValues.VA[GTValues.EV])
			.cleanroom(CleanroomType.CLEANROOM)
			.duration(45*50)
			.buildAndRegister();
	}
	
	private static void addNeutroniumRecipe(ItemStack lens, ItemStack output, int count)
	{
		RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
			.notConsumable(lens)
			.input(MetaItems.NEUTRONIUM_WAFER)
			.outputs(new ItemStack(output.getItem(), output.getCount() * count, output.getMetadata()))
			.EUt(GTValues.VA[GTValues.IV])
			.cleanroom(CleanroomType.CLEANROOM)
			.duration(10*50)
			.buildAndRegister();
	}
}
