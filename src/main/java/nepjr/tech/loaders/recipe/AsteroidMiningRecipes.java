package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.builders.GasCollectorRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.chance.output.ChancedOutputLogic;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.chance.output.NTChancedOutputLogic;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AsteroidMiningRecipes 
{
	public static void init()
	{
		addMiningRecipe(MiningType.BASIC_NOTCONSUMED, GTValues.LV, 16, 0, Item.getItemFromBlock(Blocks.STONE).getDefaultInstance(), 
				OrePrefix.stone,
				Materials.Marble,
				Materials.GraniteBlack,
				Materials.GraniteRed,
				Materials.Granite,
				Materials.Andesite,
				Materials.Diorite,
				Materials.Basalt
				);
		
		addMiningRecipe(MiningType.BASIC_NOTCONSUMED, GTValues.LV, 16, -1, Item.getItemFromBlock(Blocks.NETHERRACK).getDefaultInstance(),
				Item.getItemFromBlock(Blocks.NETHERRACK).getDefaultInstance(),
				Item.getItemFromBlock(Blocks.SOUL_SAND).getDefaultInstance(),
				Item.getItemFromBlock(Blocks.GLOWSTONE).getDefaultInstance());
		
		addMiningRecipe(MiningType.ADVANCED_NOTCONSUMED, GTValues.EV, 16, 1, Item.getItemFromBlock(Blocks.END_STONE).getDefaultInstance(),
				Item.getItemFromBlock(Blocks.END_STONE).getDefaultInstance());
		
		addMiningRecipe(MiningType.BASIC, GTValues.LV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Iron.getId()),
				OrePrefix.ore,
				Materials.Iron,
				Materials.BandedIron,
				Materials.BrownLimonite,
				Materials.Magnetite,
				Materials.Pyrite,
				Materials.YellowLimonite,
				Materials.GraniticMineralSand,
				Materials.BasalticMineralSand);
		
		addMiningRecipe(MiningType.BASIC, GTValues.MV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Magnetite.getId()),
				OrePrefix.ore,
				Materials.Magnetite,
				Materials.Magnetite,
				Materials.Magnetite,
				Materials.VanadiumMagnetite,
				Materials.Gold);
		
		addMiningRecipe(MiningType.BASIC, GTValues.MV, 2, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Magnetite.getId()),
				OrePrefix.oreNetherrack,
				Materials.Magnetite,
				Materials.VanadiumMagnetite,
				Materials.Gold,
				Materials.Gold,
				Materials.Gold);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.ore,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 2, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.oreNetherrack,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 3, 1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Platinum.getId()),
				OrePrefix.oreEndstone,
				Materials.Chalcopyrite,
				Materials.Chalcocite,
				Materials.Bornite,
				Materials.Tetrahedrite,
				Materials.Pentlandite,
				Materials.Cooperite,
				Materials.Cooperite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Titanium.getId()),
				OrePrefix.ore,
				Materials.Bauxite,
				Materials.Aluminium,
				Materials.Ilmenite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.MV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Aluminium.getId()),
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
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"),1 , Materials.Monazite.getId()),
				OrePrefix.oreNetherrack,
				Materials.Monazite,
				Materials.Bastnasite,
				Materials.Neodymium);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Diamond.getId()),
				OrePrefix.ore,
				Materials.Coal,
				Materials.Graphite,
				Materials.Diamond);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Sulfur.getId()),
				OrePrefix.oreNetherrack,
				Materials.Sulfur,
				Materials.Sulfur,
				Materials.Pyrite,
				Materials.Sphalerite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Tin.getId()),
				OrePrefix.ore,
				Materials.Tin,
				Materials.Cassiterite,
				Materials.CassiteriteSand);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Zinc.getId()),
				OrePrefix.ore,
				Materials.Zinc,
				Materials.Sphalerite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Nickel.getId()),
				OrePrefix.ore,
				Materials.Nickel,
				Materials.Garnierite,
				Materials.Cobaltite,
				Materials.Pentlandite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Lead.getId()),
				OrePrefix.ore,
				Materials.Lead,
				Materials.Galena,
				Materials.Silver);
		
		addMiningRecipe(MiningType.BASIC, GTValues.HV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Manganese.getId()),
				OrePrefix.ore,
				Materials.Grossular,
				Materials.Spessartine,
				Materials.Pyrolusite,
				Materials.Tantalite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Molybdenum.getId()),
				OrePrefix.oreNetherrack,
				Materials.Molybdenum,
				Materials.Wulfenite,
				Materials.Molybdenite,
				Materials.Powellite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Thorium.getId()),
				OrePrefix.oreNetherrack,
				Materials.Beryllium,
				Materials.Emerald,
				Materials.Thorium);
		
		addMiningRecipe(MiningType.BASIC, GTValues.EV, 1, 1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Uraninite.getId()),
				OrePrefix.oreEndstone,
				Materials.Pitchblende,
				Materials.Uraninite);
		
		addMiningRecipe(MiningType.ADVANCED, GTValues.IV, 1, 1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Tungsten.getId()),
				OrePrefix.oreEndstone,
				Materials.Tungstate,
				Materials.Scheelite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.MV, 1, -1, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.CertusQuartz.getId()),
				OrePrefix.oreNetherrack,
				Materials.Quartzite,
				Materials.CertusQuartz,
				Materials.CertusQuartz,
				Materials.Barite);
		
		addMiningRecipe(MiningType.BASIC, GTValues.LV, 1, 0, new ItemStack(Item.getByNameOrId("gregtech:meta_dust"), 1, Materials.Salt.getId()),
				OrePrefix.ore,
				Materials.Salt,
				Materials.RockSalt,
				Materials.Lepidolite,
				Materials.Spodumene);
		
		// Unique Recipes. I didn't want to bother adding a helper function for these so I'll just define them manually as of for right now
		NTRecipeMaps.ASTEROID_MINING.recipeBuilder()
			.fluidInputs(Materials.HighOctaneGasoline.getFluid(8000))
			.inputs(NTMetaItems.MINING_DRONE.getStackForm())
			.EUt(GTValues.VA[GTValues.EV])
			.duration(180*20)
			.input(OrePrefix.dust, Materials.Uranium235, 64)
			.output(OrePrefix.ore, Materials.Plutonium239, 64)
			.circuitMeta(1)
			.dimension(1)
			.buildAndRegister();
	}
	
	private enum MiningType
	{
		BASIC,
		ADVANCED,
		BASIC_NOTCONSUMED,
		ADVANCED_NOTCONSUMED;
	}
	
	private static void addMiningRecipe(MiningType level, int tier, int circuitMeta, int dimension, ItemStack catalyst, OrePrefix prefix, Material... outputs)
	{
		GasCollectorRecipeBuilder recipe = NTRecipeMaps.ASTEROID_MINING.recipeBuilder();
		if(level == MiningType.ADVANCED)
		{
			recipe.fluidInputs(Materials.HighOctaneGasoline.getFluid(8000));
			recipe.inputs(NTMetaItems.MINING_DRONE.getStackForm());
		}
		if(level == MiningType.BASIC)
		{
			recipe.fluidInputs(Materials.RocketFuel.getFluid(4000));
			recipe.inputs(NTMetaItems.MINING_DRONE.getStackForm());
		}
		
		if(level == MiningType.ADVANCED_NOTCONSUMED)
		{
			recipe.fluidInputs(Materials.HighOctaneGasoline.getFluid(8000));
			recipe.notConsumable(NTMetaItems.MINING_DRONE.getStackForm());
		}
		if(level == MiningType.BASIC_NOTCONSUMED)
		{
			recipe.fluidInputs(Materials.RocketFuel.getFluid(4000));
			recipe.notConsumable(NTMetaItems.MINING_DRONE.getStackForm());
		}
		
		recipe.notConsumable(catalyst);
		
		recipe.EUt(GTValues.VA[tier]);
		recipe.duration(180 * 20);
		recipe.circuitMeta(circuitMeta);
		recipe.chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM);
		recipe.dimension(dimension);
		
		for (Material m : outputs)
		{
			recipe.chancedOutput(prefix, m, 64, 10000 / outputs.length, 0);
		}
		
		recipe.buildAndRegister();
	}
	
	private static void addMiningRecipe(MiningType level, int tier, int circuitMeta, int dimension, ItemStack catalyst, ItemStack... outputs)
	{
		GasCollectorRecipeBuilder recipe = NTRecipeMaps.ASTEROID_MINING.recipeBuilder();
		if(level == MiningType.ADVANCED)
		{
			recipe.fluidInputs(Materials.HighOctaneGasoline.getFluid(8000));
			recipe.inputs(NTMetaItems.MINING_DRONE.getStackForm());
		}
		if(level == MiningType.BASIC)
		{
			recipe.fluidInputs(Materials.RocketFuel.getFluid(4000));
			recipe.inputs(NTMetaItems.MINING_DRONE.getStackForm());
		}
		
		if(level == MiningType.ADVANCED_NOTCONSUMED)
		{
			recipe.fluidInputs(Materials.HighOctaneGasoline.getFluid(8000));
			recipe.notConsumable(NTMetaItems.MINING_DRONE.getStackForm());
		}
		if(level == MiningType.BASIC_NOTCONSUMED)
		{
			recipe.fluidInputs(Materials.RocketFuel.getFluid(4000));
			recipe.notConsumable(NTMetaItems.MINING_DRONE.getStackForm());
		}
		recipe.notConsumable(catalyst);
		recipe.EUt(GTValues.VA[tier]);
		recipe.duration(180 * 20);
		recipe.circuitMeta(circuitMeta);
		recipe.chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM);
		recipe.dimension(dimension);
		
		for (ItemStack i : outputs)
		{
			recipe.chancedOutput(new ItemStack(i.getItem(), 64, i.getMetadata()), 10000 / outputs.length, 0);
		}
		
		recipe.buildAndRegister();
	}
}
