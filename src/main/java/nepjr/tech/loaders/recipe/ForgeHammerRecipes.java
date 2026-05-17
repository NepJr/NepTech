package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.FORGE_HAMMER_RECIPES;

import exnihilocreatio.ModBlocks;
import net.minecraft.init.Blocks;

public class ForgeHammerRecipes 
{
	public static void init()
	{
		FORGE_HAMMER_RECIPES.recipeBuilder()
			.input(Blocks.SAND)
			.output(ModBlocks.dust)
			.EUt(16)
			.duration(10)
			.buildAndRegister();
	}
}
