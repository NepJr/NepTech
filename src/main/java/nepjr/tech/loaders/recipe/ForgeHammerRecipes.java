package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.FORGE_HAMMER_RECIPES;

import exnihilocreatio.ModBlocks;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.config.NTConfig;
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
