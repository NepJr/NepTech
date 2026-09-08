package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import nepjr.tech.common.blocks.BlockGeneric.GenericType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.init.Blocks;

public class ChemBathRecipes 
{
	public static void init()
	{
		RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
			.inputs(NTMetaBlocks.GENERIC_BLOCKS.getItemVariant(GenericType.DUST))
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(Blocks.CLAY)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(200)
			.buildAndRegister();
	}
}
