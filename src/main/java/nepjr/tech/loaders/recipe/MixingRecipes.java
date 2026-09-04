package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.config.NTConfig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class MixingRecipes 
{
	public static void init()
	{
		MIXER_RECIPES.recipeBuilder()
			.fluidInputs(Materials.Oxygen.getFluid(FluidStorageKeys.LIQUID, 4000))
			.fluidInputs(Materials.Ice.getFluid(4000))
			.input(Items.SNOWBALL, 16)
			.fluidOutputs(NTMaterials.Cryotheum.getFluid(10000))
			.EUt(GTValues.VA[GTValues.IV])
			.duration(400)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Iron)
			.input(OrePrefix.dust, Materials.Redstone)
			.output(OrePrefix.dust, NTMaterials.ConductiveIron, 2)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Gold)
			.input(OrePrefix.dust, Materials.Redstone)
			.input(OrePrefix.dust, Materials.Glowstone)
			.output(OrePrefix.dust, NTMaterials.EnergeticAlloy, 3)
			.EUt(GTValues.VA[GTValues.MV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.EnergeticAlloy)
			.input(OrePrefix.dust, Materials.EnderPearl)
			.output(OrePrefix.dust, NTMaterials.VibrantAlloy, 2)
			.EUt(GTValues.VA[GTValues.HV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Steel)
			.input(OrePrefix.dust, Materials.Silicon)
			.output(OrePrefix.dust, NTMaterials.ElectricalSteel, 2)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Redstone)
			.input(OrePrefix.dust, Materials.Silicon)
			.output(OrePrefix.dust, NTMaterials.RedstoneAlloy, 2)
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Iron)
			.input(OrePrefix.dust, Materials.EnderPearl)
			.output(OrePrefix.dust, NTMaterials.PulsatingIron, 2)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, Materials.Steel)
			.input(OrePrefix.dust, Materials.Obsidian)
			.output(OrePrefix.dust, NTMaterials.DarkSteel, 2)
			.EUt(GTValues.VA[GTValues.EV])
			.duration(200)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.DarkSteel)
			.input(OrePrefix.dust, Materials.Obsidian)
			.input(OrePrefix.dust, Materials.Endstone)
			.input(OrePrefix.dust, Materials.TungstenSteel)
			.output(OrePrefix.dust, NTMaterials.EndSteel, 4)
			.EUt(GTValues.VA[GTValues.IV])
			.duration(200)
			.buildAndRegister();
		
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
			MIXER_RECIPES.recipeBuilder()
			.inputs(new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 4))
			.input(Item.getItemFromBlock(Blocks.DIRT))
			.output(Item.getItemFromBlock(Blocks.GRASS))
			.EUt(8)
			.duration(20)
			.buildAndRegister();
		}
	}
}
