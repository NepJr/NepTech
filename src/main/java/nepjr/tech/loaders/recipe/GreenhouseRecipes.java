package nepjr.tech.loaders.recipe;

import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import nepjr.tech.api.recipes.NTRecipeMaps;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GreenhouseRecipes 
{
	public static void init()
	{
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 0), // Oak Trees
								new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 0),
								new ItemStack(Items.APPLE));
		
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1), // Spruce Trees
								new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 1));
		
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 2), // Birch Trees
								new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 2));
		
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 3), // Jungle Trees
								new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 3));
	
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING), 1, 0), // Rubber wood
								new ItemStack(Item.getItemFromBlock(MetaBlocks.RUBBER_LOG), 1, 0),
								MetaItems.STICKY_RESIN.getStackForm());
		
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM), 1, 0),
								new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM_BLOCK), 1, 0));
		
		addGreenhouseTreeRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM), 1, 0),
								new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM_BLOCK), 1, 0));
		
		addGreenhouseRecipe(new ItemStack(Items.REEDS));
		addGreenhouseRecipe(new ItemStack(Items.POTATO));
		addGreenhouseRecipe(new ItemStack(Items.POISONOUS_POTATO));
		addGreenhouseRecipe(new ItemStack(Items.CARROT));
		
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 1, 0)); // Dandelion
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 0)); // Poppy
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 1)); // Blue Orchid
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 2)); // Allium
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 3)); // Azure Bluet
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 4)); // Red Tulip
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 5)); // Orange Tulip
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 6)); // White Tulip
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 7)); // Pink Tulip
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 8)); // Oxeye Daisy
		
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, 0)); // Sunflower
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, 1)); // Lilac
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, 4)); // Rose Bush
		addGreenhouseRecipe(new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, 5)); // Peony
		
		addGreenhouseSeedRecipe(new ItemStack(Items.WHEAT_SEEDS), new ItemStack(Items.WHEAT));
		addGreenhouseSeedRecipe(new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Item.getItemFromBlock(Blocks.PUMPKIN)));
		addGreenhouseSeedRecipe(new ItemStack(Items.MELON_SEEDS), new ItemStack(Items.MELON));
		addGreenhouseSeedRecipe(new ItemStack(Items.BEETROOT_SEEDS), new ItemStack(Items.BEETROOT));
		
		addNetherGreenhouseRecipe(new ItemStack(Items.NETHER_WART));
	}
	
	private static void addGreenhouseRecipe(ItemStack itemToGrow)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.fluidInputs(Materials.Water.getFluid(1000))
			.EUt(16)
			.duration(100)
			.circuitMeta(1)
			.buildAndRegister();
		
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.input(MetaItems.FERTILIZER, 4)
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.fluidInputs(Materials.Water.getFluid(1000))
			.EUt(16)
			.duration(100)
			.circuitMeta(1)
			.buildAndRegister();
	}
	
	
	private static void addNetherGreenhouseRecipe(ItemStack itemToGrow)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.EUt(16)
			.duration(400)
			.fluidInputs(Materials.Lava.getFluid(1000))
			.circuitMeta(1)
			.buildAndRegister();
		
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.input(MetaItems.FERTILIZER, 4)
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemToGrow.getItem(), 64, itemToGrow.getMetadata()))
			.EUt(16)
			.duration(200)
			.fluidInputs(Materials.Lava.getFluid(1000))
			.circuitMeta(2)
			.buildAndRegister();
	}
	
	private static void addGreenhouseSeedRecipe(ItemStack itemToGrow, ItemStack itemOutput)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 16, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.fluidInputs(Materials.Water.getFluid(1000))
			.EUt(16)
			.duration(100)
			.circuitMeta(1)
			.buildAndRegister();
		
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.input(MetaItems.FERTILIZER, 4)
			.outputs(new ItemStack(itemToGrow.getItem(), 32, itemToGrow.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.fluidInputs(Materials.Water.getFluid(1000))
			.EUt(16)
			.duration(100)
			.circuitMeta(1)
			.buildAndRegister();
	}
	
	private static void addGreenhouseTreeRecipe(ItemStack itemToGrow, ItemStack itemOutput)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 4, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.EUt(16)
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
			.EUt(16)
			.duration(200)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(2)
			.buildAndRegister();
	}
	
	private static void addGreenhouseTreeRecipe(ItemStack itemToGrow, ItemStack itemOutput, ItemStack byproduct)
	{
		NTRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder()
			.notConsumable(itemToGrow)
			.outputs(new ItemStack(itemToGrow.getItem(), 4, itemToGrow.getMetadata()))	
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(itemOutput.getItem(), 64, itemOutput.getMetadata()))
			.outputs(new ItemStack(byproduct.getItem(), 32, byproduct.getMetadata()))		
			.EUt(16)
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
			.outputs(new ItemStack(byproduct.getItem(), 64, byproduct.getMetadata()))	
			.EUt(16)
			.duration(200)
			.fluidInputs(Materials.Water.getFluid(1000))
			.circuitMeta(2)
			.buildAndRegister();
	}
}
