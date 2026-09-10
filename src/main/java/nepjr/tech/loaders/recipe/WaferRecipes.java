package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import nepjr.tech.common.items.NTMetaItems;

public class WaferRecipes 
{
	public static void init()
	{
		wafers();
		ics();
	}
	
	private static void wafers()
	{
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
			.input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT_WAFER)
			.input(OrePrefix.dust, Materials.Holmium, 8)
			.fluidInputs(Materials.Neutronium.getFluid(576))
			.output(NTMetaItems.EHPIC_WAFER)
			.EUt(VA[UV])
			.duration(60*20)
			.cleanroom(CleanroomType.CLEANROOM)
			.buildAndRegister();
	}
	
	private static void ics()
	{
		RecipeMaps.CUTTER_RECIPES.recipeBuilder()
			.input(NTMetaItems.EHPIC_WAFER)
			.output(NTMetaItems.EHPIC)
			.duration(45*20)
			.EUt(VA[UV])
			.buildAndRegister();
	}
}
