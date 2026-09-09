package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.circuit;

import gregtech.api.GTValues;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockCleanroomCasing.CasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.common.blocks.BlockBeamSplitter.BeamSplitter;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.NTMetaTileEntities;

public class AsslineRecipes 
{
	public static void init()
	{
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.inputs(NTMetaBlocks.NT_CASINGS.getItemVariant(NTCasingType.NAQUADAH_ALLOY, 8))
			.input(circuit, Tier.ZPM, 8)
			.input(MetaItems.ELECTRIC_PISTON_ZPM, 16)
			.input(MetaItems.ELECTRIC_PISTON_ZPM, 16)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1152))
			.fluidInputs(Materials.NiobiumTitanium.getFluid(1152))
			.EUt(GTValues.VA[UV])
			.outputs(NTMetaTileEntities.ELECTRIC_IMPLOSION_COMPRESSOR.getStackForm())
			.stationResearch(b -> b
					.researchStack(MetaTileEntities.IMPLOSION_COMPRESSOR.getStackForm())
					.CWUt(32)
					.EUt(VA[ZPM]))
			.duration(800)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LuV])
			.input(MetaItems.EMITTER_LuV, 8)
			.input(MetaItems.EMITTER_LuV, 8)
			.input(OrePrefix.circuit, Tier.LuV, 8)
			.input(OrePrefix.circuit, Tier.LuV, 8)
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1152))
			.fluidInputs(Materials.NiobiumTitanium.getFluid(1152))
			.EUt(VA[ZPM])
			.outputs(NTMetaTileEntities.LARGE_LASER_ENGRAVER.getStackForm())
			.scannerResearch(b -> b
					.researchStack(MetaTileEntities.LASER_ENGRAVER[GTValues.LuV].getStackForm())
					.EUt(VA[ZPM]))
			.duration(1600)
			.buildAndRegister();
			
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.IV])
			.input(MetaItems.EMITTER_IV, 1)
			.input(MetaItems.ELECTRIC_PUMP_IV, 1)
			.input(OrePrefix.lens, Materials.NetherStar, 1)
			.input(OrePrefix.circuit, Tier.IV, 1)
			.input(OrePrefix.cableGtSingle, Materials.Platinum, 4)
			.EUt(VA[IV])
			.outputs(NTMetaBlocks.BEAM_SPLITTER.getItemVariant(BeamSplitter.BASIC))
			.scannerResearch(b -> b
					.researchStack(MetaTileEntities.LASER_INPUT_HATCH_256[0].getStackForm())
					.EUt(VA[IV]))
			.duration(400)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LuV])
			.input(MetaItems.EMITTER_LuV, 2)
			.input(MetaItems.ELECTRIC_PUMP_LuV, 2)
			.input(OrePrefix.lens, Materials.NetherStar, 2)
			.input(OrePrefix.circuit, Tier.LuV, 2)
			.input(OrePrefix.cableGtDouble, Materials.NiobiumTitanium, 4)
			.EUt(VA[LuV])
			.outputs(NTMetaBlocks.BEAM_SPLITTER.getItemVariant(BeamSplitter.ADVANCED))
			.stationResearch(b -> b
					.researchStack(MetaTileEntities.LASER_INPUT_HATCH_1024[1].getStackForm())
					.CWUt(16)
					.EUt(VA[LuV]))
			.duration(400)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.ZPM])
			.input(MetaItems.EMITTER_ZPM, 4)
			.input(MetaItems.ELECTRIC_PUMP_ZPM, 4)
			.input(OrePrefix.lens, Materials.NetherStar, 4)
			.input(OrePrefix.circuit, Tier.ZPM, 4)
			.input(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 4)
			.EUt(VA[ZPM])
			.outputs(NTMetaBlocks.BEAM_SPLITTER.getItemVariant(BeamSplitter.EXTREME))
			.stationResearch(b -> b
					.researchStack(MetaTileEntities.LASER_INPUT_HATCH_4096[2].getStackForm())
					.CWUt(32)
					.EUt(VA[ZPM]))
			.duration(400)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UV])
			.input(MetaItems.EMITTER_UV, 8)
			.input(MetaItems.ELECTRIC_PUMP_UV, 8)
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(OrePrefix.circuit, Tier.UV, 8)
			.input(OrePrefix.cableGtOctal, Materials.YttriumBariumCuprate, 4)
			.EUt(VA[UV])
			.outputs(NTMetaBlocks.BEAM_SPLITTER.getItemVariant(BeamSplitter.INSANE))
			.stationResearch(b -> b
					.researchStack(NTMetaTileEntities.LASER_INPUT_HATCH_16384[3].getStackForm())
					.CWUt(64)
					.EUt(VA[UV]))
			.duration(400)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UHV])
			.input(MetaItems.EMITTER_UHV, 16)
			.input(MetaItems.ELECTRIC_PUMP_UHV, 16)
			.input(OrePrefix.lens, Materials.NetherStar, 16)
			.input(OrePrefix.circuit, Tier.UHV, 16)
			.input(OrePrefix.cableGtHex, Materials.Europium, 4)
			.EUt(VA[UHV])
			.outputs(NTMetaBlocks.BEAM_SPLITTER.getItemVariant(BeamSplitter.LUDICROUS))
			.stationResearch(b -> b
					.researchStack(NTMetaTileEntities.LASER_INPUT_HATCH_65536[4].getStackForm())
					.CWUt(128)
					.EUt(VA[UHV]))
			.duration(400)
			.buildAndRegister();
		
		if(NTConfig.neptech.harderMaintenanceHatches)
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
		}
		
		if(NTConfig.neptech.enableSterileCleaningHatch)
		{
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
}
