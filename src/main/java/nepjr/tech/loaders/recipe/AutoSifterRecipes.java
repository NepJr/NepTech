package nepjr.tech.loaders.recipe;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.modules.AppliedEnergistics2;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.chance.output.NTChancedOutputLogic;
import nepjr.tech.common.blocks.BlockGeneric.GenericType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AutoSifterRecipes 
{
	public static void init()
	{
		addSiftingRecipe(SiftingBlock.SAND, Materials.Silver, Materials.Oilsands);
		addSiftingRecipe(SiftingBlock.GRAVEL, Materials.Gold,
											  Materials.Iron,
											  Materials.Sphalerite,
											  Materials.Cobaltite,
											  Materials.Galena,
											  Materials.Tetrahedrite,
											  Materials.Cassiterite);
		
		addSiftingRecipe(SiftingBlock.SLAG, Materials.Ruby,
											Materials.Emerald,
											Materials.Diamond,
											Materials.Sapphire,
											Materials.Sodalite,
											Materials.Spessartine,
											Materials.Monazite,
											Materials.Topaz);
		
		addSiftingRecipe(SiftingBlock.DUST, Materials.Calcite,
											Materials.Gypsum);
	}
	
	private enum SiftingBlock
	{
		SAND,
		GRAVEL,
		DIRT,
		DUST,
		SLAG,
		SKY_STONE;
	}
	
	private static void addSiftingRecipe(SiftingBlock blockToSift, Material... outputs)
	{
		SimpleRecipeBuilder siftingRecipe = NTRecipeMaps.AUTO_SIFTER.recipeBuilder();
		switch(blockToSift)
		{
		case SAND:
			siftingRecipe.input(Blocks.SAND);
			break;
		case GRAVEL:
			siftingRecipe.input(Blocks.GRAVEL);
			break;
		case DIRT:
			siftingRecipe.input(Blocks.DIRT);
			break;
		case DUST:
			siftingRecipe.input(ModBlocks.dust);
			break;
		case SLAG:
			siftingRecipe.input(NTMetaBlocks.GENERIC_BLOCKS.getState(GenericType.SLAG).getBlock());
			break;
		case SKY_STONE:
			siftingRecipe.input(AppliedEnergistics2.skystoneCrushed);
			break;
		}
		
		siftingRecipe.EUt(8);
		siftingRecipe.duration(200);
		siftingRecipe.chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM);
		for (Material m : outputs)
		{
			siftingRecipe.chancedOutput(new ItemStack(Item.getByNameOrId("exnihilocreatio:item_ore_" + m.getName()), 1, 1), 10000 / outputs.length, 0);
		}
		siftingRecipe.buildAndRegister();
	}
	
	@SuppressWarnings("unused")
	private static void addSiftingRecipe(SiftingBlock blockToSift, ItemStack... outputs)
	{
		SimpleRecipeBuilder siftingRecipe = NTRecipeMaps.AUTO_SIFTER.recipeBuilder();
		switch(blockToSift)
		{
		case SAND:
			siftingRecipe.input("blockSand", 1);
			break;
		case GRAVEL:
			siftingRecipe.input(Blocks.GRAVEL);
			break;
		case DIRT:
			siftingRecipe.input(Blocks.DIRT);
			break;
		case DUST:
			siftingRecipe.input(ModBlocks.dust);
			break;
		case SLAG:
			siftingRecipe.input(NTMetaBlocks.GENERIC_BLOCKS.getState(GenericType.SLAG).getBlock());
			break;
		case SKY_STONE:
			siftingRecipe.input(AppliedEnergistics2.skystoneCrushed);
			break;
		}
		
		siftingRecipe.EUt(8);
		siftingRecipe.duration(200);
		siftingRecipe.chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM);
		for (ItemStack i : outputs)
		{
			siftingRecipe.chancedOutput(i, 10000 / outputs.length, 0);
		}
		siftingRecipe.buildAndRegister();
	}
}
