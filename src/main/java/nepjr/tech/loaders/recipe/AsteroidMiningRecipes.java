package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.builders.GasCollectorRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.chance.output.ChancedOutputLogic;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AsteroidMiningRecipes 
{
	public static void init()
	{
		addMiningRecipe(miningDroneType.BASIC, GTValues.LV, 16, 0, Item.getItemFromBlock(Blocks.STONE).getDefaultInstance(), 
				OrePrefix.stone,
				Materials.Marble,
				Materials.GraniteBlack,
				Materials.GraniteRed,
				Materials.Granite,
				Materials.Andesite,
				Materials.Diorite,
				Materials.Basalt
				);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.LV, 1, 0, Items.IRON_INGOT.getDefaultInstance(),
				OrePrefix.ore,
				Materials.Iron,
				Materials.BandedIron,
				Materials.BrownLimonite,
				Materials.Magnetite,
				Materials.Pyrite,
				Materials.YellowLimonite,
				Materials.GraniticMineralSand,
				Materials.BasalticMineralSand);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.MV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Magnetite.getId()),
				OrePrefix.ore,
				Materials.Magnetite,
				Materials.Magnetite,
				Materials.Magnetite,
				Materials.VanadiumMagnetite,
				Materials.Gold);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.MV, 2, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Magnetite.getId()),
				OrePrefix.ore,
				Materials.Magnetite,
				Materials.VanadiumMagnetite,
				Materials.Gold,
				Materials.Gold,
				Materials.Gold);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.EV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.ore,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.EV, 2, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.oreNetherrack,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.EV, 3, 1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.oreEndstone,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite,
				Materials.Cooperite);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Titanium.getId()),
				OrePrefix.ore,
				Materials.Bauxite,
				Materials.Aluminium,
				Materials.Ilmenite);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.MV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Aluminium.getId()),
				OrePrefix.ore,
				Materials.Aluminium,
				Materials.Spodumene,
				Materials.GlauconiteSand,
				Materials.Mica,
				Materials.Kyanite,
				Materials.Pollucite,
				Materials.Bentonite,
				Materials.FullersEarth,
				Materials.Zeolite);
		
		addMiningRecipe(miningDroneType.BASIC, GTValues.EV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"),1 , Materials.Monazite.getId()),
				OrePrefix.oreNetherrack,
				Materials.Monazite,
				Materials.Bastnasite,
				Materials.Neodymium);
		
		addMiningRecipe(miningDroneType.ADVANCED, GTValues.IV, 1, 1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Tungsten.getId()),
				OrePrefix.oreEndstone,
				Materials.Tungstate,
				Materials.Scheelite);
	}
	
	private enum miningDroneType
	{
		BASIC,
		ADVANCED,
		LEGENDARY;
	}
	
	private static void addMiningRecipe(miningDroneType level, int tier, int circuitMeta, int dimension, ItemStack catalyst, OrePrefix prefix, Material... outputs)
	{
		ItemStack drone = null;
		int fluidAmt = 1;
		if(level == miningDroneType.ADVANCED)
		{
			drone = NTMetaItems.ADVANCED_MINING_DRONE.getStackForm();
			fluidAmt = 8000;
		}
		if(level == miningDroneType.LEGENDARY)
		{
			drone = NTMetaItems.LEGENDARY_MINING_DRONE.getStackForm();
			fluidAmt = 16000;
		}
		if(level == miningDroneType.BASIC)
		{
			drone = NTMetaItems.BASIC_MINING_DRONE.getStackForm();
			fluidAmt = 4000;
		}
		
		GasCollectorRecipeBuilder recipe = NTRecipeMaps.ASTEROID_MINING.recipeBuilder();
		
		recipe.inputs(drone);
		recipe.notConsumable(catalyst);
		recipe.fluidInputs(Materials.RocketFuel.getFluid(fluidAmt));
		recipe.EUt(GTValues.VA[tier]);
		recipe.duration(180 * 20);
		recipe.circuitMeta(circuitMeta);
		recipe.chancedOutputLogic(ChancedOutputLogic.XOR);
		recipe.dimension(dimension);
		
		for (Material m : outputs)
		{
			recipe.chancedOutput(prefix, m, 64, 10000 / outputs.length, 0);
		}
		
		recipe.buildAndRegister();
	}
	
	private static void addMiningRecipe(miningDroneType level, int tier, int circuitMeta, int dimension, ItemStack catalyst, ItemStack... outputs)
	{
		ItemStack drone;
		int fluidAmt = 1;
		if(level == miningDroneType.ADVANCED)
		{
			drone = NTMetaItems.ADVANCED_MINING_DRONE.getStackForm();
			fluidAmt = 8000;
		}
		if(level == miningDroneType.LEGENDARY)
		{
			drone = NTMetaItems.LEGENDARY_MINING_DRONE.getStackForm();
			fluidAmt = 16000;
		}
		else
		{
			drone = NTMetaItems.BASIC_MINING_DRONE.getStackForm();
			fluidAmt = 4000;
		}
		
		GasCollectorRecipeBuilder recipe = NTRecipeMaps.ASTEROID_MINING.recipeBuilder();
		
		recipe.inputs(drone);
		recipe.notConsumable(catalyst);
		recipe.fluidInputs(Materials.RocketFuel.getFluid(fluidAmt));
		recipe.EUt(GTValues.VA[tier]);
		recipe.duration(180 * 20);
		recipe.circuitMeta(circuitMeta);
		recipe.chancedOutputLogic(ChancedOutputLogic.XOR);
		recipe.dimension(dimension);
		
		for (ItemStack i : outputs)
		{
			recipe.chancedOutput(new ItemStack(i.getItem(), 64, i.getMetadata()), 10000 / outputs.length, 0);
		}
		
		recipe.buildAndRegister();
	}
}
