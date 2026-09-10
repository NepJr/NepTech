package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.builders.GasCollectorRecipeBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.core.unification.material.internal.MaterialRegistryManager;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.chance.output.NTChancedOutputLogic;
import nepjr.tech.config.NTConfig;

public class VoidOreMinerRecipes
{
	public static void init()
	{
		GasCollectorRecipeBuilder overworldOres = NTRecipeMaps.VOID_ORE_MINER.recipeBuilder();
		GasCollectorRecipeBuilder netherOres = NTRecipeMaps.VOID_ORE_MINER.recipeBuilder();
		GasCollectorRecipeBuilder endOres = NTRecipeMaps.VOID_ORE_MINER.recipeBuilder();
		
		for(String s : NTConfig.machineOptions.overworldOres)
		{
			overworldOres.chancedOutput(OrePrefix.ore, MaterialRegistryManager.getInstance().getMaterial(s), 64, 1, 0);
		}
		overworldOres.EUt(GTValues.VA[GTValues.ZPM])
					 .chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM)
					 .fluidInputs(Materials.DrillingFluid.getFluid(1000))
					 .duration(256*20)
					 .dimension(0)
					 .circuitMeta(1)
					 .buildAndRegister();
		
		for(String s : NTConfig.machineOptions.netherOres)
		{
			netherOres.chancedOutput(OrePrefix.oreNetherrack, MaterialRegistryManager.getInstance().getMaterial(s), 64, 1, 0);
		}
		netherOres.EUt(GTValues.VA[GTValues.ZPM])
					 .chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM)
					 .fluidInputs(Materials.DrillingFluid.getFluid(1000))
					 .duration(256*20)
					 .dimension(-1)
					 .circuitMeta(2)
					 .buildAndRegister();
		
		for(String s : NTConfig.machineOptions.endOres)
		{
			endOres.chancedOutput(OrePrefix.oreEndstone, MaterialRegistryManager.getInstance().getMaterial(s), 64, 1, 0);
		}
		endOres.EUt(GTValues.VA[GTValues.ZPM])
					 .chancedOutputLogic(NTChancedOutputLogic.SINGLEITEM)
					 .fluidInputs(Materials.DrillingFluid.getFluid(1000))
					 .duration(256*20)
					 .dimension(1)
					 .circuitMeta(3)
					 .buildAndRegister();
	}
}
