package nepjr.tech.config;

import nepjr.tech.NTTags;
import net.minecraftforge.common.config.Config;

@Config(modid = NTTags.MODID)
public class NTConfig 
{
	@Config.Comment("General Options for NepTech")
	@Config.Name("NepTech Options")
	public static NepTechOptions neptech = new NepTechOptions();
	
	@Config.Comment("Options related to working with other mods")
	@Config.Name("Mod Compatibility Options")
	public static ModCompatOptions modcompat = new ModCompatOptions();
	
	public static class NepTechOptions
	{
		@Config.Comment("Toggle whether the greenhouse is enabled or not")
		@Config.Name("Enable Greenhouse")
		@Config.RequiresMcRestart
		public boolean enableGreenhouse = true;
		
		@Config.Comment("Toggle whether the Drone Launcher is enabled or not")
		@Config.Name("Enable Drone Launcher")
		@Config.RequiresMcRestart
		public boolean enableDroneLauncher = true;
		
		@Config.Comment("Enable the worked Steam Solar Boilers which generate much more steam")
		@Config.Name("Enable reworked Steam Solar Boilers")
		@Config.RequiresMcRestart
		public boolean reworkedSteamSolarBoilers = true;
		
		@Config.Comment("How much steam does the Bronze Solar Boiler make per tick")
		@Config.Name("Bronze Solar Boiler Output")
		@Config.RequiresMcRestart
		public int bronzeSolarBoilerOutput = 64;
		
		@Config.Comment("How much steam does the Steel Solar Boiler make per tick")
		@Config.Name("Steel Solar Boiler Output")
		@Config.RequiresMcRestart
		public int steelSolarBoilerOutput = 128;
		
		@Config.Comment("Enable the reworked Steam Grinder and Steam Oven")
		@Config.Name("Enable reworked Steam Grinder/Oven")
		@Config.RequiresMcRestart
		public boolean reworkedSteamGrinderOver = true;
		
		@Config.Comment("Enable the new Steam Squasher, Squeezer, Smasher, and Fuser multiblocks")
		@Config.Name("Enable new Steam Multis")
		@Config.RequiresMcRestart
		public boolean enableNewSteamMultis = true;
		
		@Config.Comment("Enable the High Pressure Multiblocks (requires New Steam Multis or Reworked Steam Grinder/Oven enabled")
		@Config.Name("High Pressure Steam Multiblocks")
		public boolean enableHPMultiblocks = true;
		
		@Config.Comment("Make the recipes for the Automatic and Cleaning maintenance hatches harder")
		@Config.Name("Harder Automatic Maintenance Hatches")
		public boolean harderMaintenanceHatches = true;
		
		@Config.Comment("Enable the new Sterile Cleaing Maintenance Hatch for running recipes outside a Sterile Cleanroom")
		@Config.Name("Automatic Sterile Cleaning Hatch")
		public boolean enableSterileCleaningHatch = true;
	}
	
	public static class ModCompatOptions
	{
		@Config.Comment("Changes various AE2 Recipes to be more Gregified")
		@Config.Name("Change AE2 Recipes")
		@Config.RequiresMcRestart
		@Deprecated
		public boolean enableAE2Recipes = true;
		
		@Config.Comment("Changes various AE2 Fluid Crafting to be more Gregified")
		@Config.Name("Change AE2 Fluid Crafting Recipes")
		@Config.RequiresMcRestart
		@Deprecated
		public boolean enableAE2FCRecipes = true;
		
		@Config.Comment("Changes various CrazyAE Recipes to be more Gregified")
		@Config.Name("Change CrazyAE Recipes")
		@Config.RequiresMcRestart
		@Deprecated
		public boolean enableCrazyAERecipes = true;
		
		@Config.Comment("Enable Ex Nihilo support")
		@Config.Name("Ex Nihilo Support")
		@Config.RequiresMcRestart
		@Deprecated
		public boolean exNihiloSupport = true;
		
//		@Config.Comment("Enable EnderIO support")
//		@Config.Name("EnderIO Support")
//		@Config.RequiresMcRestart
//		@Deprecated
//		public boolean enderIOSupport = true;
		
		@Config.Comment("Enable support for Mystical Agriculture")
		@Config.Name("Mystical Agriculture Support")
		@Config.RequiresMcRestart
		public boolean mysticalAgricultureSupport = true;
	}
}
