package nepjr.tech.loaders.recipe;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.unification.properties.AlloyBlastProperty;
import nepjr.tech.api.unification.properties.NTPropertyKey;

public class ABSRecipes 
{
	public static void initHandler()
	{
		 OrePrefix.ingot.addProcessingHandler(NTPropertyKey.ALLOY_BLAST,
				 ABSRecipes::generateAlloyBlastRecipes);
	}
	
	public static void init()
	{
		registerBinaryAlloy(Materials.Copper, 3, Materials.Tin, 1,
                Materials.Bronze, 4, 400);
        registerBinaryAlloy(Materials.Copper, 3, Materials.Zinc, 1,
                Materials.Brass, 4, 400);
        registerBinaryAlloy(Materials.Copper, 1, Materials.Nickel, 1,
                Materials.Cupronickel, 2, 200);
        registerBinaryAlloy(Materials.Copper, 1, Materials.Redstone, 4,
                Materials.RedAlloy, 1, 100);

        registerBinaryAlloy(Materials.Iron, 1, Materials.Tin, 1,
                Materials.TinAlloy, 2, 100);
        registerBinaryAlloy(Materials.Iron, 2, Materials.Nickel, 1,
                Materials.Invar, 3, 300);
        registerBinaryAlloy(Materials.Lead, 4, Materials.Antimony, 1,
                Materials.BatteryAlloy, 5, 250);
        registerBinaryAlloy(Materials.Gold, 1, Materials.Silver, 1,
                Materials.Electrum, 2, 200);
        registerBinaryAlloy(Materials.Magnesium, 1, Materials.Aluminium, 2,
                Materials.Magnalium, 3, 150);
        registerBinaryAlloy(Materials.Silver, 1, Materials.Electrotine, 4,
                Materials.BlueAlloy, 1, 100);
        registerBinaryAlloy(Materials.Glass, 7, Materials.Boron, 1,
                Materials.BorosilicateGlass, 8, 200);

        registerTrinaryAlloy(Materials.Brass, 7, Materials.Aluminium, 1,
                Materials.Cobalt, 1, Materials.CobaltBrass, 9, 900);
        registerTrinaryAlloy(Materials.Tin, 6, Materials.Lead, 3,
                Materials.Antimony, 1, Materials.SolderingAlloy, 10, 200);
        registerTrinaryAlloy(Materials.Copper, 6, Materials.Tin, 2,
                Materials.Lead, 1, Materials.Potin, 9, 400);
        
        NTRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
	        .input(OrePrefix.dust, Materials.Nickel)
	        .input(OrePrefix.dust, Materials.Zinc)
	        .input(OrePrefix.dust, Materials.Iron, 4)
	        .notConsumable(new IntCircuitIngredient(6))
	        .fluidInputs(Materials.Oxygen.getFluid(8000))
	        .fluidOutputs(Materials.NickelZincFerrite.getFluid(GTValues.L * 6))
	        .duration(2400 * 3 / 4)
	        .EUt(GTValues.VA[GTValues.MV])
	        .blastFurnaceTemp(1500)
	        .buildAndRegister();
	}
	private static void registerBinaryAlloy(@NotNull Material input1, int input1Amount,
            @NotNull Material input2, int input2Amount,
            @NotNull Material output, int outputAmount,
            int duration) 
	{
		NTRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
			.input(OrePrefix.dust, input1, input1Amount)
			.input(OrePrefix.dust, input2, input2Amount)
			.notConsumable(new IntCircuitIngredient((input1Amount + input2Amount)))
			.fluidOutputs(output.getFluid(GTValues.L * outputAmount))
			.duration(duration * 3 / 4)
			.EUt(16)
			.blastFurnaceTemp(output.getFluid().getTemperature())
			.buildAndRegister();
	}
	
	private static void registerTrinaryAlloy(@NotNull Material input1, int input1Amount,
                                             @NotNull Material input2, int input2Amount,
                                             @NotNull Material input3, int input3Amount,
                                             @NotNull Material output, int outputAmount,
                                             int duration) {
        NTRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, input1, input1Amount)
                .input(OrePrefix.dust, input2, input2Amount)
                .input(OrePrefix.dust, input3, input3Amount)
                .notConsumable(new IntCircuitIngredient(input1Amount + input2Amount + input3Amount))
                .fluidOutputs(output.getFluid(GTValues.L * outputAmount))
                .duration(duration * 3 / 4)
                .EUt(16)
                .blastFurnaceTemp(output.getFluid().getTemperature())
                .buildAndRegister();
    }
	
    public static void generateAlloyBlastRecipes(@Nullable OrePrefix unused, @NotNull Material material,
            @NotNull AlloyBlastProperty property) 
    {
    			if (material.hasProperty(PropertyKey.BLAST)) 
    			{
    				property.getRecipeProducer().produce(material, material.getProperty(PropertyKey.BLAST));
    			}
    }
}
