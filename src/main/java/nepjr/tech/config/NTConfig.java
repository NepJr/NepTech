package nepjr.tech.config;

import nepjr.tech.NTTags;
import net.minecraftforge.common.config.Config;

@Config(modid = NTTags.MODID)
public class NTConfig 
{
	@Config.Comment("General Options for NepTech")
	@Config.Name("NepTech Options")
	public static NepTechOptions neptech = new NepTechOptions();
	
	@Config.Comment("Machine Options for NepTech")
	@Config.Name("Machine Options")
	public static MachineOptions machineOptions = new MachineOptions();
	
	public static class NepTechOptions
	{	
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
	
	public static class MachineOptions
	{
		@Config.Comment("Overworld Ores for the Void Ore Miner(s)")
		@Config.Name("Void Ore Miner(s) Overworld Ores")
		public String[] overworldOres = {
				"apatite",
				"tricalcium_phosphate",
				"pyrochlore",
				"tin",
				"cassiterite",
				"coal",
				"chalcopyrite",
				"zeolite",
				"realgar",
				"iron",
				"pyrite",
				"copper",
				"diamond",
				"graphite",
				"galena",
				"silver",
				"lead",
				"cassiterite_sand",
				"garnet_sand",
				"asbestos",
				"diatomite",
				"garnet_red",
				"garnet_yellow",
				"amethyst",
				"opal",
				"brown_limonite",
				"yellow_limonite",
				"banded_iron",
				"malachite",
				"lazurite",
				"sodalite",
				"lapis",
				"calcite",
				"soapstone",
				"talc",
				"glauconite_sand",
				"pentlandite",
				"magnetite",
				"vanadium_magnetite",
				"gold",
				"grossular",
				"spessartine",
				"pyrolusite",
				"tantalite",
				"kyanite",
				"mica",
				"bauxite",
				"pollucite",
				"basaltic_mineral_sand",
				"granitic_mineral_sand",
				"fullers_earth",
				"gypsum",
				"garnietite",
				"nickel",
				"cobaltite",
				"oilsands",
				"bentonite",
				"magnesite",
				"olivine",
				"redstone",
				"ruby",
				"cinnabar",
				"rock_salt",
				"salt",
				"lepidolite",
				"spodumene",
				"almandine",
				"pyrope",
				"sapphire",
				"green_sapphire"
		};
		
		@Config.Comment("Nether Ores for the Void Ore Miner(s)")
		@Config.Name("Void Ore Miner(s) Nether Ores")
		public String[] netherOres = {
				"ancient_debris",
				"nether_star",
				"brown_limonite",
				"yellow_limonite",
				"banded_iron",
				"gold",
				"beryllium",
				"emerald",
				"thorium",
				"quartzite",
				"certus_quartz",
				"barite",
				"grossular",
				"pyrolusite",
				"pyrochlore",
				"tantalite",
				"wulfenite",
				"molybdenite",
				"molybdenum",
				"powellite",
				"bastnasite",
				"monazite",
				"neodymium",
				"nether_quartz",
				"redstone",
				"ruby",
				"cinnabar",
				"saltpeter",
				"diatomite",
				"electrotine",
				"alunite",
				"sulfur",
				"pyrite",
				"sphalerite",
				"tetrahedrite",
				"copper",
				"stibnite",
				"blue_topaz",
				"topaz",
				"chalcocite",
				"bornite"
		};
		
		@Config.Comment("End Ores for the Void Ore Miner(s)")
		@Config.Name("Void Ore Miner(s) End Ores")
		public String[] endOres = {
				"bauxite",
				"ilmenite",
				"aluminium",
				"ilmenite",
				"magnetite",
				"vanadium_magnetite",
				"chromite",
				"gold",
				"naquadah",
				"plutonium",
				"pitchblende",
				"uraninite",
				"scheelite",
				"tungstate",
				"lithium",
				"bornite",
				"cooperite",
				"platinum",
				"palladium"
		};
	}
}
