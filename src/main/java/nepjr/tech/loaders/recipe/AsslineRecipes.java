package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.circuit;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.common.blocks.BlockCleanroomCasing.CasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.metatileentities.NTMetaTileEntities;

public class AsslineRecipes 
{
	public static void init()
	{
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm())
        .input(circuit, Tier.UEV, 4)
        .input(MetaItems.ROBOT_ARM_UHV, 2)
        .input(MetaItems.ROBOT_ARM_UHV, 2)
        .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(CasingType.FILTER_CASING, 32))
        .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(CasingType.FILTER_CASING, 32))
        .outputs(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm())
        .stationResearch(b -> b
                .researchStack(MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm())
                .CWUt(32)
                .EUt(VA[UV]))
        .duration(800).EUt(VA[UV]).buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm())
        .input(circuit, Tier.UIV, 4)
        .input(MetaItems.ROBOT_ARM_UEV, 2)
        .input(MetaItems.ROBOT_ARM_UEV, 2)
        .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(CasingType.FILTER_CASING_STERILE, 32))
        .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(CasingType.FILTER_CASING_STERILE, 32))
        .outputs(NTMetaTileEntities.STERILE_MAINTENANCE_HATCH.getStackForm())
        .stationResearch(b -> b
                .researchStack(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm())
                .CWUt(128)
                .EUt(VA[UHV]))
        .duration(800).EUt(VA[UEV]).buildAndRegister();
	}
}
