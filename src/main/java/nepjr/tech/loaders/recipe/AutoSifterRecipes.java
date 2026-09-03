package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.FORGE_HAMMER_RECIPES;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import exnihilocreatio.modules.AppliedEnergistics2;
import gregtech.api.GTValues;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.AE2Items;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.chance.output.NTChancedOutputLogic;
import nepjr.tech.common.blocks.BlockGeneric.GenericType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

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
											  Materials.Cassiterite,
											  Materials.Garnierite);
		
		addSiftingRecipe(SiftingBlock.SLAG, Materials.Ruby,
											Materials.Emerald,
											Materials.Diamond,
											Materials.Sapphire,
											Materials.Sodalite,
											Materials.Spessartine,
											Materials.Monazite,
											Materials.Topaz);
		
		addSiftingRecipe(SiftingBlock.DUST, Materials.Calcite,
											Materials.Gypsum,
											Materials.Redstone);
		
		addSiftingRecipe(SiftingBlock.NETHERRACK, Materials.Gold,
												  Materials.Sulfur,
												  Materials.Glowstone);
		
		NTRecipeMaps.AUTO_SIFTER.recipeBuilder()
			.input(AppliedEnergistics2.skystoneCrushed)
			.chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM)
			.chancedOutput(AE2Items.CHARGED_CERTUS, 5000, 0)
			.chancedOutput(AE2Items.CERTUS_QUARTZ, 5000, 0)
			.EUt(8)
			.duration(100)
			.buildAndRegister();
		
		// These are not auto-sifter related, but I just needed a place for them to go to fix some game launching issues.
		
		AUTOCLAVE_RECIPES.recipeBuilder()
			.fluidInputs(new FluidStack(ModFluids.fluidWitchwater, 1000))
			.input(Blocks.SAND)
			.output(Blocks.SOUL_SAND)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(50)
			.buildAndRegister();
	
		AUTOCLAVE_RECIPES.recipeBuilder()
			.fluidInputs(Materials.Water.getFluid(1000))
			.inputs(new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 3))
			.fluidOutputs(new FluidStack(ModFluids.fluidWitchwater, 1000))
			.EUt(GTValues.VA[GTValues.LV])
			.duration(50)
			.buildAndRegister();
		
		FORGE_HAMMER_RECIPES.recipeBuilder()
			.input(Blocks.SAND)
			.output(ModBlocks.dust)
			.EUt(16)
			.duration(10)
			.buildAndRegister();
		
		FORGE_HAMMER_RECIPES.recipeBuilder()
			.input(Blocks.NETHERRACK)
			.output(ModBlocks.netherrackCrushed)
			.EUt(16)
			.duration(10)
			.buildAndRegister();
		
		CHEMICAL_BATH_RECIPES.recipeBuilder()
			.input(ModBlocks.dust)
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(Blocks.CLAY)
			.EUt(30)
			.duration(100)
			.buildAndRegister();
	
		CHEMICAL_BATH_RECIPES.recipeBuilder()
			.input(Blocks.GRAVEL)
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(NTMetaBlocks.GENERIC_BLOCKS.getState(GenericType.SLAG).getBlock())
			.EUt(30)
			.duration(100)
			.buildAndRegister();
		
		CHEMICAL_BATH_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Redstone)
			.fluidInputs(Materials.Lava.getFluid(1000))
			.output(Blocks.NETHERRACK)
			.EUt(30)
			.duration(100)
			.buildAndRegister();
		
		CHEMICAL_BATH_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Glowstone)
			.fluidInputs(Materials.Lava.getFluid(1000))
			.output(Blocks.END_STONE)
			.EUt(30)
			.duration(100)
			.buildAndRegister();
		
		CHEMICAL_BATH_RECIPES.recipeBuilder()
			.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.MYCELIUM)))
			.fluidInputs(Materials.Water.getFluid(1000))
			.fluidOutputs(new FluidStack(ModFluids.fluidWitchwater, 1000))
			.EUt(30)
			.duration(200)
			.buildAndRegister();
	}
	
	private enum SiftingBlock
	{
		SAND,
		GRAVEL,
		DIRT,
		DUST,
		SLAG,
		NETHERRACK,
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
		case NETHERRACK:
			siftingRecipe.input(ModBlocks.netherrackCrushed);
			break;
		}
		
		siftingRecipe.EUt(8);
		siftingRecipe.duration(100);
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
		case NETHERRACK:
			siftingRecipe.input(ModBlocks.netherrackCrushed);
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
