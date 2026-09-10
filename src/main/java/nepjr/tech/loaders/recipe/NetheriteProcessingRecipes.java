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
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.AncientDebris, 6)
			.fluidInputs(Materials.AquaRegia.getFluid(2400))
			.output(OrePrefix.dust, NTMaterials.RawNetheritePowder, 3)
			.output(OrePrefix.dust, NTMaterials.RawActiniumPowder, 3)
			.output(OrePrefix.dust, NTMaterials.Holminide, 2)
			.output(OrePrefix.dust, NTMaterials.ExoticMetalMixture, 1)
			.output(OrePrefix.dust, NTMaterials.AncientSludgeResidue, 2)
			.EUt(VA[LuV])
			.duration(25*20)
			.buildAndRegister();
		
		BLAST_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.RawNetheritePowder, 3)
			.input(OrePrefix.dust, Materials.Gold, 1)
			.circuitMeta(1)
			.output(OrePrefix.ingotHot, NTMaterials.Netherite)
			.fluidOutputs(Materials.Chlorine.getFluid(800))
			.EUt(VA[IV])
			.duration(20*20)
			.buildAndRegister();
	
		BLAST_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.RawNetheritePowder, 3)
			.input(OrePrefix.dust, Materials.Gold, 1)
			.fluidInputs(Materials.Argon.getFluid(50))
			.fluidOutputs(Materials.Chlorine.getFluid(800))
			.circuitMeta(2)
			.output(OrePrefix.ingotHot, NTMaterials.Netherite)
			.EUt(VA[IV])
			.duration(268)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.RawActiniumPowder, 5)
			.fluidInputs(Materials.HydrochloricAcid.getFluid(1000))
			.output(OrePrefix.dust, Materials.Actinium)
			.output(OrePrefix.dust, Materials.AmmoniumChloride, 2)
			.EUt(VA[LuV])
			.duration(10*20)
			.buildAndRegister();
		
		// Holminide
		
		LARGE_CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.ExoticMetalMixture, 7)
			.fluidInputs(Materials.HydrochloricAcid.getFluid(4000))
			.output(OrePrefix.dust, NTMaterials.MostimiteMetalResidue, 5)
			.fluidOutputs(NTMaterials.AcidicWyverniumSolution.getFluid(2000))
			.fluidOutputs(Materials.Hydrogen.getFluid(3000))
			.EUt(VA[UHV])
			.duration(20*20)
			.buildAndRegister();
		
		DISTILLATION_RECIPES.recipeBuilder()
			.fluidInputs(NTMaterials.AcidicWyverniumSolution.getFluid(2000))
			.output(OrePrefix.dust, NTMaterials.WyverniumTetroxide, 5)
			.fluidOutputs(Materials.HydrochloricAcid.getFluid(1000))
			.fluidOutputs(Materials.Water.getFluid(1000))
			.EUt(VA[UHV])
			.duration(20*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.WyverniumTetroxide, 5)
			.fluidInputs(Materials.Hydrogen.getFluid(8000))
			.output(OrePrefix.dust, NTMaterials.Wyvernium)
			.fluidOutputs(Materials.Water.getFluid(8000))
			.EUt(VA[ZPM])
			.duration(10*20)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.MostimiteMetalResidue, 5)
			.output(OrePrefix.dust, NTMaterials.MostimiteChloride, 4)
			.output(OrePrefix.dust, NTMaterials.AncientSludgeResidue)
			.EUt(VA[IV])
			.duration(10*20)
			.buildAndRegister();
		
		CHEMICAL_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.MostimiteChloride, 4)
			.fluidInputs(Materials.Hydrogen.getFluid(3000))
			.output(OrePrefix.dust, NTMaterials.Mostimite)
			.fluidOutputs(Materials.HydrochloricAcid.getFluid(3000))
			.EUt(VA[IV])
			.duration(5*20)
			.buildAndRegister();
		
		CENTRIFUGE_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, NTMaterials.AncientSludgeResidue, 5)
			.output(OrePrefix.dust, Materials.Gold, 3)
			.output(OrePrefix.dust, Materials.PlatinumGroupSludge, 2)
			.EUt(VA[EV])
			.duration(45*20)
			.buildAndRegister();
	}
}
