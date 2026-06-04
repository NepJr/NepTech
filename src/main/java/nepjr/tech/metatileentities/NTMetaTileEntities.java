package nepjr.tech.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import exnihilocreatio.ExNihiloCreatio;
import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityParallelHatch;
import gregtech.api.GTValues;
import nepjr.tech.compat.exnihilo.ExNihiloGTModule;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityAutoSifter;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityDroneLauncher;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityGreenhouse;
import nepjr.tech.metatileentities.multi.electric.generator.MetaTileEntityOverkillCombustionEngine;
import nepjr.tech.metatileentities.multi.multiblockpart.MetaTileEntityNTParallelHatch;
import nepjr.tech.metatileentities.multi.multiblockpart.MetaTileEntitySterileMaintenanceHatch;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSquasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSqueezer;
import nepjr.tech.metatileentities.steam.SteamAutoSifter;
import nepjr.tech.metatileentities.steam.boiler.NTSteamSolarBoiler;
import net.minecraftforge.fml.common.Loader;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamCrusher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamFuser;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmelter;

public class NTMetaTileEntities 
{
	// Electric Multiblocks (6000 - 7000)
	public static MetaTileEntityGreenhouse GREENHOUSE;
	public static MetaTileEntityDroneLauncher DRONE_LAUNCHER;
	public static MetaTileEntityAutoSifter AUTO_SIFTER;
	public static MetaTileEntityOverkillCombustionEngine OVERKILL_COMBUSTION_ENGINE;
	
	// Steam multiblocks (7001 - 7100)
	public static MetaTileEntitySteamSmasher STEAM_SMASHER;
	public static MetaTileEntitySteamSmasher HP_STEAM_SMASHER;
	
	public static MetaTileEntitySteamCrusher STEAM_CRUSHER;
	public static MetaTileEntitySteamCrusher HP_STEAM_CRUSHER;
	
	public static MetaTileEntitySteamFuser STEAM_FUSER;
	public static MetaTileEntitySteamFuser HP_STEAM_FUSER;
	
	public static MetaTileEntitySteamSquasher STEAM_SQUASHER;
	public static MetaTileEntitySteamSquasher HP_STEAM_SQUASHER;
	
	public static MetaTileEntitySteamSqueezer STEAM_SQUEEZER;
	public static MetaTileEntitySteamSqueezer HP_STEAM_SQUEEZER;
	
	public static MetaTileEntitySteamSmelter STEAM_SMELTER;
	public static MetaTileEntitySteamSmelter HP_STEAM_SMELTER;
	
	public static NTSteamSolarBoiler STEAM_SOLAR_BOILER;
	public static NTSteamSolarBoiler HP_STEAM_SOLAR_BOILER;
	
	public static SteamAutoSifter STEAM_AUTO_SIFTER;
	public static SteamAutoSifter HP_STEAM_AUTO_SIFTER;
	
	// Multiblock Parts (7101 - 7500)
	public static MetaTileEntityNTParallelHatch PARALLEL_HATCH_UHV;
	public static MetaTileEntityNTParallelHatch PARALLEL_HATCH_UEV;
	public static MetaTileEntityNTParallelHatch PARALLEL_HATCH_UIV;
	public static MetaTileEntityNTParallelHatch PARALLEL_HATCH_UXV;
	public static MetaTileEntityNTParallelHatch PARALLEL_HATCH_OpV;
	public static MetaTileEntitySterileMaintenanceHatch STERILE_MAINTENANCE_HATCH;
	
	public static void register()
	{
		if(NTConfig.neptech.enableGreenhouse)
		{
			GREENHOUSE = registerMetaTileEntity(6000, new MetaTileEntityGreenhouse(nepId("greenhouse")));			
		}
		if(NTConfig.neptech.enableDroneLauncher)
		{
			DRONE_LAUNCHER = registerMetaTileEntity(6001, new MetaTileEntityDroneLauncher(nepId("drone_launcher")));
		}
		
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
			AUTO_SIFTER = registerMetaTileEntity(6002, new MetaTileEntityAutoSifter(nepId("auto_sifter")));
		}
		
		OVERKILL_COMBUSTION_ENGINE = registerMetaTileEntity(6003, new MetaTileEntityOverkillCombustionEngine(nepId("overkill_combustion_engine")));
		STEAM_AUTO_SIFTER = registerMetaTileEntity(6004, new SteamAutoSifter(nepId("steam_auto_sifter"), false));
		HP_STEAM_AUTO_SIFTER = registerMetaTileEntity(6005, new SteamAutoSifter(nepId("hp_steam_auto_sifter"), true));
		
		if(NTConfig.neptech.reworkedSteamGrinderOver)
		{
			STEAM_CRUSHER = registerMetaTileEntity(7003, new MetaTileEntitySteamCrusher(1, nepId("steam_crusher")));
			STEAM_SMELTER = registerMetaTileEntity(7011, new MetaTileEntitySteamSmelter(1, nepId("steam_smelter")));
			if(NTConfig.neptech.enableHPMultiblocks)
			{
				HP_STEAM_CRUSHER = registerMetaTileEntity(7004, new MetaTileEntitySteamCrusher(2, nepId("hp_steam_crusher")));
				HP_STEAM_SMELTER = registerMetaTileEntity(7012, new MetaTileEntitySteamSmelter(2, nepId("hp_steam_smelter")));
			}
		}
		
		if(NTConfig.neptech.enableNewSteamMultis)
		{
			STEAM_SMASHER = registerMetaTileEntity(7001, new MetaTileEntitySteamSmasher(1, nepId("steam_smasher")));
			STEAM_FUSER = registerMetaTileEntity(7005, new MetaTileEntitySteamFuser(1, nepId("steam_fuser")));
			STEAM_SQUEEZER = registerMetaTileEntity(7009, new MetaTileEntitySteamSqueezer(1, nepId("steam_squeezer")));
			STEAM_SQUASHER = registerMetaTileEntity(7007, new MetaTileEntitySteamSquasher(1, nepId("steam_squasher")));
			if(NTConfig.neptech.enableHPMultiblocks)
			{
				HP_STEAM_SMASHER = registerMetaTileEntity(7002, new MetaTileEntitySteamSmasher(2, nepId("hp_steam_smasher")));
				HP_STEAM_FUSER = registerMetaTileEntity(7006, new MetaTileEntitySteamFuser(2, nepId("hp_steam_fuser")));
				HP_STEAM_SQUASHER = registerMetaTileEntity(7008, new MetaTileEntitySteamSquasher(2, nepId("hp_steam_squasher")));
				HP_STEAM_SQUEEZER = registerMetaTileEntity(7010, new MetaTileEntitySteamSqueezer(2, nepId("hp_steam_squeezer")));
			}
		}
		
		if(NTConfig.neptech.reworkedSteamSolarBoilers)
		{
			STEAM_SOLAR_BOILER = registerMetaTileEntity(7013, new NTSteamSolarBoiler(nepId("steam_solar_boiler"), false));
			HP_STEAM_SOLAR_BOILER = registerMetaTileEntity(7014, new NTSteamSolarBoiler(nepId("hp_steam_solar_boiler"), true));		
		}
		
		PARALLEL_HATCH_UHV = registerMetaTileEntity(7101, new MetaTileEntityNTParallelHatch(nepId("parallel_hatch.uhv"), GTValues.UHV));
		PARALLEL_HATCH_UEV = registerMetaTileEntity(7102, new MetaTileEntityNTParallelHatch(nepId("parallel_hatch.uev"), GTValues.UEV));
		PARALLEL_HATCH_UIV = registerMetaTileEntity(7103, new MetaTileEntityNTParallelHatch(nepId("parallel_hatch.uiv"), GTValues.UIV));
		PARALLEL_HATCH_UXV = registerMetaTileEntity(7104, new MetaTileEntityNTParallelHatch(nepId("parallel_hatch.uxv"), GTValues.UXV));
		PARALLEL_HATCH_OpV = registerMetaTileEntity(7105, new MetaTileEntityNTParallelHatch(nepId("parallel_hatch.opv"), GTValues.OpV));
		
		if(NTConfig.neptech.enableSterileCleaningHatch)
		{			
			STERILE_MAINTENANCE_HATCH = registerMetaTileEntity(7106, new MetaTileEntitySterileMaintenanceHatch(nepId("maintenance_hatch_sterile_cleanroom_auto")));
		}
	}
}
