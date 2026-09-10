package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.GTValues.*;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.unification.material.NTMaterials;

public class NetheriteProcessingRecipes
{
	public static void init()
	{
		BLAST_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.AncientDebris, 6)
			.input(OrePrefix.dust, Materials.Gold, 1)
			.circuitMeta(1)
			.output(OrePrefix.ingotHot, NTMaterials.Netherite)
			.EUt(VA[IV])
			.duration(20*20)
			.buildAndRegister();
		
		BLAST_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.AncientDebris, 6)
			.input(OrePrefix.dust, Materials.Gold, 1)
			.fluidInputs(Materials.Argon.getFluid(50))
			.circuitMeta(2)
			.output(OrePrefix.ingotHot, NTMaterials.Netherite)
			.EUt(VA[IV])
			.duration(268)
			.buildAndRegister();
	}
}
