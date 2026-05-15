package nepjr.tech.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

public class AssemblerRecipes 
{
	public static void init()
	{
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.PRIMITIVE_WATER_PUMP)
			.inputs(MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.PUMP_DECK, 10))
			.input(OrePrefix.frameGt, Materials.TreatedWood, 10)
			.input(MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV])
			.input(MetaItems.ELECTRIC_PUMP_LV)
			.output(MetaTileEntities.RESERVOIR_HATCH)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(300)
			.buildAndRegister();
	}
}
