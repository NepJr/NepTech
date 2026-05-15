package xyz.nepjr.tech.loaders.recipe;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.nepjr.tech.api.recipes.NTRecipeMaps;

public class GreenhouseRecipes 
{
	public static void init()
	{
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 0), // Oak Trees
							new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 0));
		
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1), // Spruce Trees
							new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 1));
		
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 2), // Birch Trees
							new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 2));
		
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 3), // Jungle Trees
							new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 3));
	
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING), 1, 0), // Rubber wood
							new ItemStack(Item.getItemFromBlock(MetaBlocks.RUBBER_LOG), 1, 0),
							MetaItems.STICKY_RESIN);
	}
	
	private static void addGreenhouseRecipe(ItemStack itemToGrow, ItemStack itemOutput)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 4, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.EUt(64)
			.duration(400)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(1)
			.buildAndRegister();
		
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.input(MetaItems.FERTILIZER, 4)
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 8, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.EUt(64)
			.duration(200)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(2)
			.buildAndRegister();
	}
	
	private static void addGreenhouseRecipe(ItemStack itemToGrow, ItemStack itemOutput, MetaItem<?>.MetaValueItem byproduct)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 4, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.output(byproduct, 32)	
			.EUt(64)
			.duration(400)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(1)
			.buildAndRegister();
		
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.input(MetaItems.FERTILIZER, 4)
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 8, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.output(byproduct, 64)	
			.EUt(64)
			.duration(200)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(2)
			.buildAndRegister();
	}
}
