package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;

import exnihilocreatio.ModFluids;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import nepjr.tech.config.NTConfig;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class AutoclaveRecipes 
{
	public static void init()
	{
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
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
		}
	}
}
