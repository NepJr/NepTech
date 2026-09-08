package nepjr.tech.loaders.recipe;

import gregtech.api.recipes.RecipeMaps;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.blocks.BlockGeneric.GenericType;
import net.minecraft.init.Blocks;

public class ForgeHammerRecipes 
{
	public static void init()
	{
		RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
			.input(Blocks.SAND)
			.outputs(NTMetaBlocks.GENERIC_BLOCKS.getItemVariant(GenericType.DUST))
			.EUt(16)
			.duration(10)
			.buildAndRegister();
	}
}
