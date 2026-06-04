package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.common.blocks.BlockGeneric.GenericType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.config.NTConfig;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class ChemBathRecipes 
{
	public static void init()
	{
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
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
	}
}
