package nepjr.tech.loaders.recipe;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing.CasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockSteamCasing.SteamCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import nepjr.tech.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingRecipes 
{
	public static void init()
	{	
		// Ring of Flight
		ModHandler.addShapedRecipe("ring_of_flight", new ItemStack(CommonProxy.RING_OF_FLIGHT),
				"GIG",
				"ISI",
				"GIG",
				'G', OreDictUnifier.get("blockGlass"),
				'I', Items.GOLD_INGOT,
				'S', Items.NETHER_STAR);
		
		// Drone Launcher
		if(NTConfig.neptech.enableDroneLauncher)
		{
			ModHandler.addShapedRecipe("drone_launcher", NTMetaTileEntities.DRONE_LAUNCHER.getStackForm(), 
					"CSC",
					"PHP",
					"CSC",
					'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
					'P', new UnificationEntry(OrePrefix.circuit, Tier.HV),
					'S', MetaItems.SENSOR_HV,
					'H', MetaTileEntities.HULL[GTValues.HV].getStackForm());
			
			// Mining Drone
			ModHandler.addShapedRecipe("mining_drone", NTMetaItems.MINING_DRONE.getStackForm(), 
					"DED",
					"SGS",
					"THT",
					'E', MetaItems.EMITTER_LV,
					'S', MetaItems.SENSOR_LV,
					'G', MetaTileEntities.COMBUSTION_GENERATOR[GTValues.LV].getStackForm(),
					'T', MetaItems.POWER_THRUSTER,
					'H', MetaTileEntities.HULL[GTValues.LV].getStackForm(),
					'D', new UnificationEntry(OrePrefix.toolHeadDrill, Materials.Steel));
		}
		
		ModHandler.addShapelessRecipe("pulsating_iron_dust", OreDictUnifier.get(OrePrefix.dust, NTMaterials.PulsatingIron, 1),
				new UnificationEntry(OrePrefix.dust, Materials.Iron),
				new UnificationEntry(OrePrefix.dust, Materials.EnderPearl));
	}
}
