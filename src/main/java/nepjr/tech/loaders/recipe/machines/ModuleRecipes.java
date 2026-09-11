package nepjr.tech.loaders.recipe.machines;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.BlockBeamSplitter.BeamSplitter;
import nepjr.tech.common.blocks.BlockCrushingWheels.CrushingWheels;
import nepjr.tech.common.blocks.BlockFertilizedDirt.FertilizerType;
import nepjr.tech.common.blocks.BlockLaserFoci.FociTier;
import nepjr.tech.common.blocks.BlockMixingModules.ModuleTier;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModuleRecipes
{
	public static void init()
	{
		farmland();
		mixingModules();
		laserFoci();
		beamSplitter();
		crushingWheels();
	}
	
	private static void farmland()
	{
		ModHandler.addShapedRecipe("basic_fertilzied_dirt", NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.BASIC, 4), 
				"CB",
				"BC",
				'C', Item.getItemFromBlock(Blocks.DIRT),
				'B', new ItemStack(Items.DYE, 1, 15));
		
		ModHandler.addShapedRecipe("advanced_fertilzied_dirt", NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.ADVANCED, 4), 
				"CB",
				"BC",
				'C', NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.BASIC),
				'B', MetaItems.FERTILIZER);
		
		MIXER_RECIPES.recipeBuilder()
			.inputs(NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.ADVANCED, 4))
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(250))
			.outputs(NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.LIVING, 4))
			.EUt(VA[IV])
			.duration(20*20)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.buildAndRegister();
		
		MIXER_RECIPES.recipeBuilder()
			.inputs(NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.LIVING, 4))
			.input(MetaItems.STEM_CELLS, 8)
			.fluidInputs(Materials.SterileGrowthMedium.getFluid(1000))
			.outputs(NTMetaBlocks.FERTILIZED_DIRT.getItemVariant(FertilizerType.EXTRATERRESTRIAL, 4))
			.EUt(VA[LuV])
			.duration(20*20)
			.cleanroom(CleanroomType.STERILE_CLEANROOM)
			.buildAndRegister();
	}
	
	private static void mixingModules()
	{
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.ULV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Iron, 4)
			.input(OrePrefix.stickLong, Materials.Iron, 8)
			.input("craftingPiston", 2)
			.input(OrePrefix.circuit, Tier.ULV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.ULV))
			.EUt(GTValues.VA[GTValues.ULV])
			.duration(100)
			.buildAndRegister();
	
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Steel, 4)
			.input(OrePrefix.stickLong, Materials.Steel, 8)
			.input(MetaItems.ELECTRIC_MOTOR_LV, 2)
			.input(OrePrefix.circuit, Tier.LV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.LV))
			.EUt(GTValues.VA[GTValues.LV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.MV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Aluminium, 4)
			.input(OrePrefix.stickLong, Materials.Aluminium, 8)
			.input(MetaItems.ELECTRIC_MOTOR_MV, 2)
			.input(OrePrefix.circuit, Tier.MV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.MV))
			.EUt(GTValues.VA[GTValues.MV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.HV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.StainlessSteel, 4)
			.input(OrePrefix.stickLong, Materials.StainlessSteel, 8)
			.input(MetaItems.ELECTRIC_MOTOR_HV, 2)
			.input(OrePrefix.circuit, Tier.HV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.HV))
			.EUt(GTValues.VA[GTValues.HV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.EV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Titanium, 4)
			.input(OrePrefix.stickLong, Materials.Titanium, 8)
			.input(MetaItems.ELECTRIC_MOTOR_EV, 2)
			.input(OrePrefix.circuit, Tier.EV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.EV))
			.EUt(GTValues.VA[GTValues.EV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.IV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.TungstenSteel, 4)
			.input(OrePrefix.stickLong, Materials.TungstenSteel, 8)
			.input(MetaItems.ELECTRIC_MOTOR_IV, 2)
			.input(OrePrefix.circuit, Tier.IV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.IV))
			.EUt(GTValues.VA[GTValues.IV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.LuV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.HSSS, 4)
			.input(OrePrefix.stickLong, Materials.HSSS, 8)
			.input(MetaItems.ELECTRIC_MOTOR_LuV, 2)
			.input(OrePrefix.circuit, Tier.LuV)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.LuV))
			.EUt(GTValues.VA[GTValues.LuV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.ZPM])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Osmiridium, 4)
			.input(OrePrefix.stickLong, Materials.Osmiridium, 8)
			.input(MetaItems.ELECTRIC_MOTOR_ZPM, 2)
			.input(OrePrefix.circuit, Tier.ZPM)
			.outputs(NTMetaBlocks.MIXING_MODULES.getItemVariant(ModuleTier.ZPM))
			.EUt(GTValues.VA[GTValues.ZPM])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Tritanium, 4)
			.input(OrePrefix.stickLong, Materials.Tritanium, 8)
			.input(MetaItems.ELECTRIC_MOTOR_UV, 2)
			.input(OrePrefix.circuit, Tier.UV)
			.outputs(NTMetaBlocks.MIXING_MODULES2.getItemVariant(nepjr.tech.common.blocks.BlockMixingModules2.ModuleTier.UV))
			.EUt(GTValues.VA[GTValues.UV])
			.duration(100)
			.buildAndRegister();
		
		ASSEMBLER_RECIPES.recipeBuilder()
			.input(MetaTileEntities.HULL[GTValues.UHV])
			.input(OrePrefix.plate, NTMaterials.HastelloyX, 4)
			.input(OrePrefix.rotor, Materials.Neutronium, 4)
			.input(OrePrefix.stickLong, Materials.Neutronium, 8)
			.input(MetaItems.ELECTRIC_MOTOR_UHV, 2)
			.input(OrePrefix.circuit, Tier.UHV)
			.outputs(NTMetaBlocks.MIXING_MODULES2.getItemVariant(nepjr.tech.common.blocks.BlockMixingModules2.ModuleTier.UHV))
			.EUt(GTValues.VA[GTValues.UHV])
			.duration(100)
			.buildAndRegister();
	}
	
	private static void laserFoci()
	{
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.LASER_ENGRAVER[GTValues.IV])
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(MetaItems.EMITTER_IV, 8)
			.input(MetaItems.SENSOR_IV, 8)
			.input(OrePrefix.circuit, Tier.IV)
			.scannerResearch(b -> b
					.researchStack(MetaTileEntities.LASER_ENGRAVER[GTValues.IV].getStackForm())
					.EUt(VA[IV]))
			.outputs(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.IV))
			.EUt(VA[IV])
			.duration(200)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.LASER_ENGRAVER[GTValues.LuV])
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(MetaItems.EMITTER_LuV, 8)
			.input(MetaItems.SENSOR_LuV, 8)
			.input(OrePrefix.circuit, Tier.LuV)
			.scannerResearch(b -> b
					.researchStack(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.IV))
					.EUt(VA[LuV]))
			.outputs(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.LuV))
			.EUt(VA[LuV])
			.duration(200)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.LASER_ENGRAVER[GTValues.ZPM])
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(MetaItems.EMITTER_ZPM, 8)
			.input(MetaItems.SENSOR_ZPM, 8)
			.input(OrePrefix.circuit, Tier.ZPM)
			.stationResearch(b -> b
					.researchStack(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.LuV))
					.CWUt(16)
					.EUt(VA[LuV]))
			.outputs(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.ZPM))
			.EUt(VA[ZPM])
			.duration(200)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.LASER_ENGRAVER[GTValues.UV])
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(MetaItems.EMITTER_UV, 8)
			.input(MetaItems.SENSOR_UV, 8)
			.input(OrePrefix.circuit, Tier.UV)
			.stationResearch(b -> b
					.researchStack(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.ZPM))
					.CWUt(64)
					.EUt(VA[ZPM]))
			.outputs(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.UV))
			.EUt(VA[UV])
			.duration(200)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaTileEntities.LASER_ENGRAVER[GTValues.UHV])
			.input(OrePrefix.lens, Materials.NetherStar, 8)
			.input(MetaItems.EMITTER_UHV, 8)
			.input(MetaItems.SENSOR_UHV, 8)
			.input(OrePrefix.circuit, Tier.UHV)
			.stationResearch(b -> b
					.researchStack(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.UV))
					.CWUt(192)
					.EUt(VA[UV]))
			.outputs(NTMetaBlocks.LASER_FOCI.getItemVariant(FociTier.UHV))
			.EUt(VA[UHV])
			.duration(200)
			.buildAndRegister();
	}
	
	private static void beamSplitter()
	{
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
	}
	
	private static void crushingWheels()
	{
		ModHandler.addShapedRecipe("cobalt_brass_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.COBALT_BRASS),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.CobaltBrass),
				'M', MetaItems.ELECTRIC_MOTOR_LV);
		
		ModHandler.addShapedRecipe("vanadiumsteel_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.VANADIUMSTEEL),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.VanadiumSteel),
				'M', MetaItems.ELECTRIC_MOTOR_MV);
		
		ModHandler.addShapedRecipe("bluesteel_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.BLUESTEEL),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.BlueSteel),
				'M', MetaItems.ELECTRIC_MOTOR_HV);
		
		ModHandler.addShapedRecipe("ultimet_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.ULTIMET),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Ultimet),
				'M', MetaItems.ELECTRIC_MOTOR_EV);
		
		ModHandler.addShapedRecipe("tungsten_carbide_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.TUNGSTEN_CARBIDE),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.TungstenCarbide),
				'M', MetaItems.ELECTRIC_MOTOR_IV);
		
		ModHandler.addShapedRecipe("hsse_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.HSSE),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.HSSE),
				'M', MetaItems.ELECTRIC_MOTOR_LuV);
		
		ModHandler.addShapedRecipe("naquadah_alloy_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.NAQUADAH_ALLOY),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.NaquadahAlloy),
				'M', MetaItems.ELECTRIC_MOTOR_ZPM);
		
		ModHandler.addShapedRecipe("duranium_crushing_wheels", NTMetaBlocks.CRUSHING_WHEELS.getItemVariant(CrushingWheels.DURANIUM),
				"PBP",
				"BMB",
				"PBP",
				'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100),
				'B', new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Duranium),
				'M', MetaItems.ELECTRIC_MOTOR_UV);
	}
}
