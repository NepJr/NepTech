package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.CENTRIFUGE_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CentrifugeRecipes 
{
	public static void init()
	{
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Oilsands)
			.fluidOutputs(Materials.OilHeavy.getFluid(1000))
			.circuitMeta(0)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(200)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Oilsands)
			.fluidOutputs(Materials.Oil.getFluid(2000))
			.circuitMeta(1)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(200)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Oilsands)
			.fluidOutputs(Materials.RawOil.getFluid(4000))
			.circuitMeta(2)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(200)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Oilsands)
			.fluidOutputs(Materials.OilLight.getFluid(8000))
			.circuitMeta(3)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(200)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.ore, Materials.Oilsands)
			.chancedOutput(new ItemStack(Item.getItemFromBlock(Blocks.SAND)), 5000, 5000)
			.fluidOutputs(Materials.OilHeavy.getFluid(2000))
			.circuitMeta(0)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.ore, Materials.Oilsands)
			.chancedOutput(new ItemStack(Item.getItemFromBlock(Blocks.SAND)), 5000, 5000)
			.fluidOutputs(Materials.Oil.getFluid(4000))
			.circuitMeta(1)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.ore, Materials.Oilsands)
			.chancedOutput(new ItemStack(Item.getItemFromBlock(Blocks.SAND)), 5000, 5000)
			.fluidOutputs(Materials.RawOil.getFluid(8000))
			.circuitMeta(2)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.ore, Materials.Oilsands)
			.chancedOutput(new ItemStack(Item.getItemFromBlock(Blocks.SAND)), 5000, 5000)
			.fluidOutputs(Materials.OilLight.getFluid(16000))
			.circuitMeta(3)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	}
}
