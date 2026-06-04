package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Materials;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.init.Items;

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
	}
}
