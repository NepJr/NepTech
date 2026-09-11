package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.config.NTConfig;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RemovalRecipes 
{
	public static void init()
	{
		if(NTConfig.neptech.harderMaintenanceHatches)
		{
			// Auto maintenance hatch
			ModHandler.removeRecipeByOutput(MetaTileEntities.AUTO_MAINTENANCE_HATCH.getStackForm());
			// Auto maintenance hatch filtered
			ModHandler.removeRecipeByOutput(MetaTileEntities.CLEANING_MAINTENANCE_HATCH.getStackForm());
		}
		if(NTConfig.neptech.reworkedSteamGrinderOver)
		{
			// Steam Grinder
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_GRINDER.getStackForm());
			
			// Steam Oven
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_OVEN.getStackForm());
		}
		if(NTConfig.neptech.reworkedSteamSolarBoilers)
		{
			// Steam Solar boiler
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm());
			
			// High Pressure Steam Solar boiler
			ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_BOILER_SOLAR_STEEL.getStackForm());
		}
		// Oilsands
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.ore, Materials.Oilsands)});
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Oilsands)});
		
		// UHV Energy/Dynamo Hatch
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, 
						new ItemStack[] {
								MetaTileEntities.HULL[GTValues.UHV].getStackForm(),
								OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Europium, 4),
								MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
								OreDictUnifier.get(OrePrefix.circuit, Tier.UHV),
								OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.RutheniumTriniumAmericiumNeutronate, 2)
						}, 
						new FluidStack[] {
								Materials.SodiumPotassium.getFluid(12000),
								Materials.SolderingAlloy.getFluid(5760)
						});
		
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLY_LINE_RECIPES, 
						new ItemStack[] {
								MetaTileEntities.HULL[GTValues.UHV].getStackForm(),
								OreDictUnifier.get(OrePrefix.spring, Materials.Europium, 4),
								MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
								OreDictUnifier.get(OrePrefix.circuit, Tier.UHV),
								OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.RutheniumTriniumAmericiumNeutronate, 2)
						}, 
						new FluidStack[] {
								Materials.SodiumPotassium.getFluid(12000),
								Materials.SolderingAlloy.getFluid(5760)
						});
		
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.UV].getStackForm());
		GTRecipeHandler.removeRecipesByInputs(RecipeMaps.RESEARCH_STATION_RECIPES, MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.UV].getStackForm());
	}
}
