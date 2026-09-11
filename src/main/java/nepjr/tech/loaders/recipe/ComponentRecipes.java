package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import nepjr.tech.api.unification.material.NTMaterials;

public class ComponentRecipes 
{
	public static void init()
	{
		uhvRecipes();
	}
	
	private static void uhvRecipes()
	{
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.stickLong, NTMaterials.MagneticHolmium)
			.input(OrePrefix.stickLong, Materials.Actinium, 4)
			.input(OrePrefix.ring, Materials.Actinium, 4)
			.input(OrePrefix.round, Materials.Actinium, 8)
			.input(OrePrefix.wireFine, Materials.Neutronium, 64)
			.input(OrePrefix.wireFine, Materials.Neutronium, 64)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 2)
			.fluidInputs(Materials.SolderingAlloy.getFluid(576),
						 Materials.Lubricant.getFluid(1000),
						 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.ELECTRIC_MOTOR_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.ELECTRIC_MOTOR_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaItems.ELECTRIC_MOTOR_UHV, 2)
			.input(OrePrefix.plate, Materials.Actinium, 2)
			.input(OrePrefix.ring, Materials.Actinium, 4)
			.input(OrePrefix.round, Materials.Actinium, 16)
			.input(OrePrefix.screw, Materials.Actinium, 4)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 2)
			.fluidInputs(Materials.SolderingAlloy.getFluid(576),
						 Materials.Lubricant.getFluid(1000),
						 Materials.StyreneButadieneRubber.getFluid(3456),
						 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.CONVEYOR_MODULE_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.CONVEYOR_MODULE_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaItems.ELECTRIC_MOTOR_UHV)
			.input(OrePrefix.pipeLargeFluid, Materials.Neutronium)
			.input(OrePrefix.plate, Materials.Actinium, 2)
			.input(OrePrefix.screw, Materials.Actinium, 8)
			.input(OrePrefix.ring, Materials.SiliconeRubber, 16)
			.input(OrePrefix.rotor, Materials.Darmstadtium)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 2)
			.fluidInputs(Materials.SolderingAlloy.getFluid(576),
					 Materials.Lubricant.getFluid(1000),
					 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.ELECTRIC_PUMP_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.ELECTRIC_PUMP_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(MetaItems.ELECTRIC_MOTOR_UHV)
			.input(OrePrefix.plate, Materials.Actinium, 4)
			.input(OrePrefix.ring, Materials.Actinium, 4)
			.input(OrePrefix.round, Materials.Actinium, 16)
			.input(OrePrefix.stick, Materials.Actinium, 4)
			.input(OrePrefix.gear, Materials.Darmstadtium)
			.input(OrePrefix.gearSmall, Materials.Darmstadtium, 2)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 2)
			.fluidInputs(Materials.SolderingAlloy.getFluid(576),
					 Materials.Lubricant.getFluid(1000),
					 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.ELECTRIC_PISTON_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.ELECTRIC_PISTON_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.stickLong, Materials.Actinium, 4)
			.input(OrePrefix.gear, Materials.Actinium)
			.input(OrePrefix.gearSmall, Materials.Actinium, 3)
			.input(MetaItems.ELECTRIC_MOTOR_UHV, 2)
			.input(MetaItems.ELECTRIC_PISTON_UHV)
			.input(OrePrefix.circuit, Tier.UHV)
			.input(OrePrefix.circuit, Tier.UV, 2)
			.input(OrePrefix.circuit, Tier.ZPM, 4)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1728),
					 Materials.Lubricant.getFluid(1000),
					 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.ROBOT_ARM_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.ROBOT_ARM_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.frameGt, Materials.Actinium)
			.input(MetaItems.ELECTRIC_MOTOR_UHV)
			.input(OrePrefix.plate, Materials.Actinium, 4)
			.input(MetaItems.GRAVI_STAR)
			.input(OrePrefix.circuit, Tier.UHV, 2)
			.input(OrePrefix.foil, Materials.Tritanium, 64)
			.input(OrePrefix.foil, Materials.Tritanium, 32)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 4)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1152),
					 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.SENSOR_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.SENSOR_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.frameGt, Materials.Actinium)
			.input(MetaItems.ELECTRIC_MOTOR_UHV)
			.input(OrePrefix.stickLong, Materials.Actinium, 4)
			.input(MetaItems.GRAVI_STAR)
			.input(OrePrefix.circuit, Tier.UHV, 2)
			.input(OrePrefix.foil, Materials.Tritanium, 64)
			.input(OrePrefix.foil, Materials.Tritanium, 32)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 4)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1152),
					 	 Materials.Americium.getFluid(576))
			.stationResearch(b -> b
					.researchStack(MetaItems.EMITTER_UV.getStackForm())
					.EUt(VA[UV])
					.CWUt(64))
			.output(MetaItems.EMITTER_UHV)
			.EUt(VA[UHV])
			.duration(30*20)
			.buildAndRegister();
		
		ASSEMBLY_LINE_RECIPES.recipeBuilder()
			.input(OrePrefix.frameGt, Materials.Actinium)
			.input(OrePrefix.plate, Materials.Actinium, 6)
			.input(MetaItems.GRAVI_STAR)
			.input(MetaItems.EMITTER_UHV, 2)
			.input(OrePrefix.circuit, Tier.UHV, 2)
			.input(OrePrefix.wireFine, Materials.RutheniumTriniumAmericiumNeutronate, 64)
			.input(OrePrefix.wireFine, Materials.RutheniumTriniumAmericiumNeutronate, 64)
			.input(OrePrefix.cableGtSingle, Materials.Europium, 4)
			.fluidInputs(Materials.SolderingAlloy.getFluid(1728),
				 	 	 Materials.Americium.getFluid(576))
		.stationResearch(b -> b
				.researchStack(MetaItems.FIELD_GENERATOR_UV.getStackForm())
				.EUt(VA[UV])
				.CWUt(64))
		.output(MetaItems.FIELD_GENERATOR_UHV)
		.EUt(VA[UHV])
		.duration(30*20)
		.buildAndRegister();
	}
}
