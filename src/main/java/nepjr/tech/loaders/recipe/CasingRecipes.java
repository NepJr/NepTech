package nepjr.tech.loaders.recipe;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.ConfigHolder;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;

public class CasingRecipes 
{
	public static void init()
	{
		final int numCasings = ConfigHolder.recipes.casingsPerCraft;
		
		// Multiblock Casings
		ModHandler.addShapedRecipe(true, "casing_netherite",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.NETHERITE, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Netherite), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.Netherite));
		
		ModHandler.addShapedRecipe(true, "casing_naquadah_alloy",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.NAQUADAH_ALLOY, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
		
        ModHandler.addShapedRecipe(true, "casing_large_macerator",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.MACERATOR_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Zeron100), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.Titanium));
        
        ModHandler.addShapedRecipe(true, "casing_high_temperature",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.HIGH_TEMPERATURE_CASING, numCasings),
                "DhD", "PFP", "DwD", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.TitaniumCarbide), 'D',
                new UnificationEntry(OrePrefix.plate, NTMaterials.HSLASteel), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.TungstenCarbide));
        
        ModHandler.addShapedRecipe(true, "casing_large_assembler",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ASSEMBLING_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.Stellite100), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.Tungsten));
        
        ModHandler.addShapedRecipe(true, "casing_stress_proof",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.STRESS_PROOF_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.MaragingSteel300), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.StainlessSteel));
        
        ModHandler.addShapedRecipe(true, "casing_corrosion_proof",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.CORROSION_PROOF_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.CobaltBrass), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.HSLASteel));
        
        ModHandler.addShapedRecipe(true, "casing_vibration_safe",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.VIBRATION_SAFE_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.IncoloyMA956), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.IncoloyMA956));
        
        ModHandler.addShapedRecipe(true, "casing_watertight",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.WATERTIGHT_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.WatertightSteel), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.WatertightSteel));
        
        ModHandler.addShapedRecipe(true, "casing_large_cutter",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.CUTTER_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.HastelloyC276), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.HastelloyC276));
        
        ModHandler.addShapedRecipe(true, "casing_nonconducting",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.NONCONDUCTING_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.HSLASteel), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.HSLASteel));
        
        ModHandler.addShapedRecipe(true, "casing_large_mixer",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.MIXER_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.HastelloyX), 'F',
                new UnificationEntry(OrePrefix.frameGt, NTMaterials.MaragingSteel300));
        
        ModHandler.addShapedRecipe(true, "casing_large_engraver",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ENGRAVER_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, NTMaterials.TitaniumTungstenCarbide),
                'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium));
        
        ModHandler.addShapedRecipe(true, "casing_atomic",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ATOMIC_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plateDouble, NTMaterials.Trinaquadalloy),
                'F', new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
        
        ModHandler.addShapedRecipe(true, "casing_steam",
                NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.STEAM_CASING, numCasings),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Brass), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.Brass));
        
        
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
		        .input(OrePrefix.plate, NTMaterials.Netherite, 6)
		        .input(OrePrefix.frameGt, NTMaterials.Netherite)
		        .notConsumable(new IntCircuitIngredient(6))
		        .outputs(NTMetaBlocks.NT_CASINGS
		                .getItemVariant(NTCasingType.NETHERITE, numCasings))
		        .duration(50).EUt(16).buildAndRegister();
        
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
		        .input(OrePrefix.plate, Materials.NaquadahAlloy, 6)
		        .input(OrePrefix.frameGt, Materials.NaquadahAlloy)
		        .notConsumable(new IntCircuitIngredient(6))
		        .outputs(NTMetaBlocks.NT_CASINGS
		                .getItemVariant(NTCasingType.NAQUADAH_ALLOY, numCasings))
		        .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.Zeron100, 6)
                .input(OrePrefix.frameGt, Materials.Titanium)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.MACERATOR_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.HSLASteel, 4)
                .input(OrePrefix.plate, NTMaterials.TitaniumCarbide, 2)
                .input(OrePrefix.frameGt, Materials.TungstenCarbide)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.HIGH_TEMPERATURE_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.Stellite100, 6)
                .input(OrePrefix.frameGt, Materials.Tungsten)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ASSEMBLING_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.MaragingSteel300, 6)
                .input(OrePrefix.frameGt, Materials.StainlessSteel)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.STRESS_PROOF_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, Materials.CobaltBrass, 6)
                .input(OrePrefix.frameGt, NTMaterials.HSLASteel)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.CORROSION_PROOF_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.IncoloyMA956, 6)
                .input(OrePrefix.frameGt, NTMaterials.IncoloyMA956)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.VIBRATION_SAFE_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.WatertightSteel, 6)
                .input(OrePrefix.frameGt, NTMaterials.WatertightSteel)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.WATERTIGHT_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.HastelloyC276, 6)
                .input(OrePrefix.frameGt, NTMaterials.HastelloyC276)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.CUTTER_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.HSLASteel, 6)
                .input(OrePrefix.frameGt, NTMaterials.HSLASteel)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.NONCONDUCTING_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.HastelloyX, 6)
                .input(OrePrefix.frameGt, NTMaterials.MaragingSteel300)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.MIXER_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, NTMaterials.TitaniumTungstenCarbide, 6)
                .input(OrePrefix.frameGt, Materials.Titanium)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ENGRAVER_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plateDouble, NTMaterials.Trinaquadalloy, 6)
                .input(OrePrefix.frameGt, Materials.NaquadahAlloy)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.ATOMIC_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, Materials.Brass, 6)
                .input(OrePrefix.frameGt, Materials.Brass)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(NTMetaBlocks.NT_CASINGS
                        .getItemVariant(NTCasingType.STEAM_CASING, numCasings))
                .duration(50).EUt(16).buildAndRegister();
	}
}
