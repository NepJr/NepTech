package nepjr.tech.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import gregtech.api.GTValues;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityLaserHatch;
import nepjr.tech.config.NTConfig;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityAlloyBlastSmelter;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityAutoSifter;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityDroneLauncher;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityElectricImplosionCompressor;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityGreenhouse;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityHellishABS;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityHellishBlastFurnace;
import nepjr.tech.metatileentities.multi.electric.MetaTileEntityMixingVessel;
import nepjr.tech.metatileentities.multi.electric.generator.MetaTileEntityOverkillCombustionEngine;
import nepjr.tech.metatileentities.multi.multiblockpart.MetaTileEntityNTEnergyHatch;
import nepjr.tech.metatileentities.multi.multiblockpart.MetaTileEntityNTSubstationEnergyHatch;
import nepjr.tech.metatileentities.multi.multiblockpart.MetaTileEntitySterileMaintenanceHatch;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamCrusher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamFuser;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmelter;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSquasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSqueezer;
import nepjr.tech.metatileentities.steam.SteamAutoSifter;
import nepjr.tech.metatileentities.steam.boiler.NTSteamSolarBoiler;
import net.minecraftforge.fml.common.Loader;

public class NTMetaTileEntities 
{	
	// Electric Multiblocks (6000 - 7000)
	public static MetaTileEntityGreenhouse GREENHOUSE;
	public static MetaTileEntityDroneLauncher DRONE_LAUNCHER;
	public static MetaTileEntityAutoSifter AUTO_SIFTER;
	public static MetaTileEntityOverkillCombustionEngine OVERKILL_COMBUSTION_ENGINE;
	public static MetaTileEntityHellishBlastFurnace HELLISH_BLAST_FURNACE;
	public static MetaTileEntityElectricImplosionCompressor ELECTRIC_IMPLOSION_COMPRESSOR;
	public static MetaTileEntityAlloyBlastSmelter ALLOY_BLAST_SMELTER;
	public static MetaTileEntityHellishABS HELLISH_ABS;
	public static MetaTileEntityMixingVessel MIXING_VESSEL;
	
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
	public static MetaTileEntitySterileMaintenanceHatch STERILE_MAINTENANCE_HATCH;
	
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_LV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_MV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_HV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_UEV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_UIV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_UXV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_OpV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_4A_MAX;
	
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_LV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_MV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_HV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_EV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_UEV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_UIV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_UXV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_OpV;
	public static MetaTileEntityNTEnergyHatch ENERGY_INPUT_HATCH_16A_MAX;
	
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_LV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_MV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_HV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_EV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_UEV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_UIV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_UXV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_OpV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_INPUT_MAX;
	
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_LV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_MV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_HV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_EV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_IV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_LuV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_ZPM;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_UV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_UHV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_UEV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_UIV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_UXV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_OpV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_INPUT_MAX;
	
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_LV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_MV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_HV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_UEV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_UIV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_UXV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_OpV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_4A_MAX;
	
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_LV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_MV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_HV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_EV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_UEV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_UIV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_UXV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_OpV;
	public static MetaTileEntityNTEnergyHatch ENERGY_OUTPUT_HATCH_16A_MAX;
	
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_LV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_MV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_HV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_EV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_UEV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_UIV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_UXV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_OpV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_OUTPUT_MAX;
	
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_LV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_MV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_HV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_EV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_IV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_LuV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_ZPM;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_UV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_UHV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_UEV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_UIV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_UXV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_OpV;
	public static MetaTileEntityNTSubstationEnergyHatch SUBSTATION_ENERGY_SUPER_OUTPUT_MAX;
	
	public static MetaTileEntityLaserHatch MAX_LASER_INPUT_HATCH_256;
    public static MetaTileEntityLaserHatch MAX_LASER_INPUT_HATCH_1024;
    public static MetaTileEntityLaserHatch MAX_LASER_INPUT_HATCH_4096;
    public static MetaTileEntityLaserHatch MAX_LASER_OUTPUT_HATCH_256;
    public static MetaTileEntityLaserHatch MAX_LASER_OUTPUT_HATCH_1024;
    public static MetaTileEntityLaserHatch MAX_LASER_OUTPUT_HATCH_4096;
    
    public static MetaTileEntityLaserHatch[] LASER_INPUT_HATCH_16384 = new MetaTileEntityLaserHatch[10];;
    public static MetaTileEntityLaserHatch[] LASER_INPUT_HATCH_65536 = new MetaTileEntityLaserHatch[10];;
    public static MetaTileEntityLaserHatch[] LASER_OUTPUT_HATCH_16384 = new MetaTileEntityLaserHatch[10];;
    public static MetaTileEntityLaserHatch[] LASER_OUTPUT_HATCH_65536 = new MetaTileEntityLaserHatch[10];;
	
	@SuppressWarnings("deprecation")
	public static void register()
	{	
		int endPos;
		if(NTConfig.neptech.enableGreenhouse)
		{
			GREENHOUSE = registerMetaTileEntity(6000, new MetaTileEntityGreenhouse(nepId("greenhouse")));			
		}
		if(NTConfig.neptech.enableDroneLauncher)
		{
			DRONE_LAUNCHER = registerMetaTileEntity(6001, new MetaTileEntityDroneLauncher(nepId("drone_launcher")));
		}
		
//		// TODO: Move Ex Nihilo compat to a seperate mod.
		if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio"))
		{
			AUTO_SIFTER = registerMetaTileEntity(6002, new MetaTileEntityAutoSifter(nepId("auto_sifter")));
			STEAM_AUTO_SIFTER = registerMetaTileEntity(7015, new SteamAutoSifter(nepId("steam_auto_sifter"), false));
			HP_STEAM_AUTO_SIFTER = registerMetaTileEntity(7016, new SteamAutoSifter(nepId("hp_steam_auto_sifter"), true));
		}
		
		OVERKILL_COMBUSTION_ENGINE = registerMetaTileEntity(6003, new MetaTileEntityOverkillCombustionEngine(nepId("overkill_combustion_engine")));
		HELLISH_BLAST_FURNACE = registerMetaTileEntity(6004, new MetaTileEntityHellishBlastFurnace(nepId("hellish_blast_furnace")));
		ELECTRIC_IMPLOSION_COMPRESSOR = registerMetaTileEntity(6005, new MetaTileEntityElectricImplosionCompressor(nepId("electric_implosion_compressor")));
		ALLOY_BLAST_SMELTER = registerMetaTileEntity(6006, new MetaTileEntityAlloyBlastSmelter(nepId("alloy_blast_smelter")));
		HELLISH_ABS = registerMetaTileEntity(6007, new MetaTileEntityHellishABS(nepId("hellish_alloy_blast_smelter")));
		MIXING_VESSEL = registerMetaTileEntity(6008, new MetaTileEntityMixingVessel(nepId("mixing_vessel")));
		
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
		
		if(NTConfig.neptech.enableSterileCleaningHatch)
		{			
			STERILE_MAINTENANCE_HATCH = registerMetaTileEntity(7106, new MetaTileEntitySterileMaintenanceHatch(nepId("maintenance_hatch_sterile_cleanroom_auto")));
		}
		
		ENERGY_INPUT_HATCH_4A_LV = registerMetaTileEntity(7107, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.lv"), GTValues.LV, 4, false));
		ENERGY_INPUT_HATCH_4A_MV = registerMetaTileEntity(7108, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.mv"), GTValues.MV, 4, false));
		ENERGY_INPUT_HATCH_4A_HV = registerMetaTileEntity(7109, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.hv"), GTValues.HV, 4, false));
		ENERGY_INPUT_HATCH_4A_UEV = registerMetaTileEntity(7110, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.uev"), GTValues.UEV, 4, false));
		ENERGY_INPUT_HATCH_4A_UIV = registerMetaTileEntity(7111, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.uiv"), GTValues.UIV, 4, false));
		ENERGY_INPUT_HATCH_4A_UXV = registerMetaTileEntity(7112, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.uxv"), GTValues.UXV, 4, false));
		ENERGY_INPUT_HATCH_4A_OpV = registerMetaTileEntity(7113, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.opv"), GTValues.OpV, 4, false));
		ENERGY_INPUT_HATCH_4A_MAX = registerMetaTileEntity(7114, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_4a.max"), GTValues.MAX, 4, false));
		
		ENERGY_INPUT_HATCH_16A_LV = registerMetaTileEntity(7115, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.lv"), GTValues.LV, 16, false));
		ENERGY_INPUT_HATCH_16A_MV = registerMetaTileEntity(7116, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.mv"), GTValues.MV, 16, false));
		ENERGY_INPUT_HATCH_16A_HV = registerMetaTileEntity(7117, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.hv"), GTValues.HV, 16, false));
		ENERGY_INPUT_HATCH_16A_EV = registerMetaTileEntity(7118, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.ev"), GTValues.EV, 16, false));
		ENERGY_INPUT_HATCH_16A_UEV = registerMetaTileEntity(7119, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.uev"), GTValues.UEV, 16, false));
		ENERGY_INPUT_HATCH_16A_UIV = registerMetaTileEntity(7120, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.uiv"), GTValues.UIV, 16, false));
		ENERGY_INPUT_HATCH_16A_UXV = registerMetaTileEntity(7121, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.uxv"), GTValues.UXV, 16, false));
		ENERGY_INPUT_HATCH_16A_OpV = registerMetaTileEntity(7122, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.opv"), GTValues.OpV, 16, false));
		ENERGY_INPUT_HATCH_16A_MAX = registerMetaTileEntity(7123, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.input_16a.max"), GTValues.MAX, 16, false));
		
		ENERGY_OUTPUT_HATCH_4A_LV = registerMetaTileEntity(7124, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.lv"), GTValues.LV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_MV = registerMetaTileEntity(7125, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.mv"), GTValues.MV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_HV = registerMetaTileEntity(7126, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.hv"), GTValues.HV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_UEV = registerMetaTileEntity(7127, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.uev"), GTValues.UEV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_UIV = registerMetaTileEntity(7128, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.uiv"), GTValues.UIV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_UXV = registerMetaTileEntity(7129, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.uxv"), GTValues.UXV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_OpV = registerMetaTileEntity(7130, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.opv"), GTValues.OpV, 4, true));
		ENERGY_OUTPUT_HATCH_4A_MAX = registerMetaTileEntity(7131, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_4a.max"), GTValues.MAX, 4, true));
		
		ENERGY_OUTPUT_HATCH_16A_LV = registerMetaTileEntity(7132, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.lv"), GTValues.LV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_MV = registerMetaTileEntity(7133, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.mv"), GTValues.MV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_HV = registerMetaTileEntity(7134, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.hv"), GTValues.HV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_EV = registerMetaTileEntity(7135, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.ev"), GTValues.EV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_UEV = registerMetaTileEntity(7136, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.uev"), GTValues.UEV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_UIV = registerMetaTileEntity(7137, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.uiv"), GTValues.UIV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_UXV = registerMetaTileEntity(7138, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.uxv"), GTValues.UXV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_OpV = registerMetaTileEntity(7139, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.opv"), GTValues.OpV, 16, true));
		ENERGY_OUTPUT_HATCH_16A_MAX = registerMetaTileEntity(7140, new MetaTileEntityNTEnergyHatch(nepId("energy_hatch.output_16a.max"), GTValues.MAX, 16, true));
		
		SUBSTATION_ENERGY_INPUT_LV = registerMetaTileEntity(7141, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.lv"), GTValues.LV, 64, false));
		SUBSTATION_ENERGY_INPUT_MV = registerMetaTileEntity(7142, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.mv"), GTValues.MV, 64, false));
		SUBSTATION_ENERGY_INPUT_HV = registerMetaTileEntity(7143, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.hv"), GTValues.HV, 64, false));
		SUBSTATION_ENERGY_INPUT_EV = registerMetaTileEntity(7144, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.ev"), GTValues.EV, 64, false));
		SUBSTATION_ENERGY_INPUT_UEV = registerMetaTileEntity(7145, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.uev"), GTValues.UEV, 64, false));
		SUBSTATION_ENERGY_INPUT_UIV = registerMetaTileEntity(7146, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.uiv"), GTValues.UIV, 64, false));
		SUBSTATION_ENERGY_INPUT_UXV = registerMetaTileEntity(7147, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.uxv"), GTValues.UXV, 64, false));
		SUBSTATION_ENERGY_INPUT_OpV = registerMetaTileEntity(7148, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.opv"), GTValues.OpV, 64, false));
		SUBSTATION_ENERGY_INPUT_MAX = registerMetaTileEntity(7149, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.64a.max"), GTValues.MAX, 64, false));
	
		SUBSTATION_ENERGY_OUTPUT_LV = registerMetaTileEntity(7150, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.lv"), GTValues.LV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_MV = registerMetaTileEntity(7151, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.mv"), GTValues.MV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_HV = registerMetaTileEntity(7152, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.hv"), GTValues.HV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_EV = registerMetaTileEntity(7153, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.ev"), GTValues.EV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_UEV = registerMetaTileEntity(7154, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.uev"), GTValues.UEV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_UIV = registerMetaTileEntity(7155, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.uiv"), GTValues.UIV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_UXV = registerMetaTileEntity(7156, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.uxv"), GTValues.UXV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_OpV = registerMetaTileEntity(7157, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.opv"), GTValues.OpV, 64, true));
		SUBSTATION_ENERGY_OUTPUT_MAX = registerMetaTileEntity(7158, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.64a.max"), GTValues.MAX, 64, true));
	
		SUBSTATION_ENERGY_SUPER_INPUT_LV = registerMetaTileEntity(7159, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.lv"), GTValues.LV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_MV = registerMetaTileEntity(7160, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.mv"), GTValues.MV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_HV = registerMetaTileEntity(7161, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.hv"), GTValues.HV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_EV = registerMetaTileEntity(7162, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.ev"), GTValues.EV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_IV = registerMetaTileEntity(7163, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.iv"), GTValues.IV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_LuV = registerMetaTileEntity(7164, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.luv"), GTValues.LuV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_ZPM = registerMetaTileEntity(7165, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.zpm"), GTValues.ZPM, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_UV = registerMetaTileEntity(7166, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.uv"), GTValues.UV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_UHV = registerMetaTileEntity(7167, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.uhv"), GTValues.UHV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_UEV = registerMetaTileEntity(7168, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.uev"), GTValues.UEV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_UIV = registerMetaTileEntity(7169, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.uiv"), GTValues.UIV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_UXV = registerMetaTileEntity(7170, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.uxv"), GTValues.UXV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_OpV = registerMetaTileEntity(7171, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.opv"), GTValues.OpV, 256, false));
		SUBSTATION_ENERGY_SUPER_INPUT_MAX = registerMetaTileEntity(7172, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.input.256a.max"), GTValues.MAX, 256, false));
	
		SUBSTATION_ENERGY_SUPER_OUTPUT_LV = registerMetaTileEntity(7173, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.lv"), GTValues.LV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_MV = registerMetaTileEntity(7174, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.mv"), GTValues.MV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_HV = registerMetaTileEntity(7175, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.hv"), GTValues.HV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_EV = registerMetaTileEntity(7176, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.ev"), GTValues.EV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_IV = registerMetaTileEntity(7177, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.iv"), GTValues.IV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_LuV = registerMetaTileEntity(7178, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.luv"), GTValues.LuV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_ZPM = registerMetaTileEntity(7179, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.zpm"), GTValues.ZPM, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_UV = registerMetaTileEntity(7180, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.uv"), GTValues.UV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_UHV = registerMetaTileEntity(7181, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.uhv"), GTValues.UHV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_UEV = registerMetaTileEntity(7182, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.uev"), GTValues.UEV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_UIV = registerMetaTileEntity(7183, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.uiv"), GTValues.UIV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_UXV = registerMetaTileEntity(7184, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.uxv"), GTValues.UXV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_OpV = registerMetaTileEntity(7185, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.opv"), GTValues.OpV, 256, true));
		SUBSTATION_ENERGY_SUPER_OUTPUT_MAX = registerMetaTileEntity(7186, new MetaTileEntityNTSubstationEnergyHatch(nepId("substation_hatch.output.256a.max"), GTValues.MAX, 256, true));
		
		MAX_LASER_INPUT_HATCH_256 = registerMetaTileEntity(7187, new MetaTileEntityLaserHatch(nepId("laser_hatch.target_256a.max"), false, GTValues.MAX, 256));
		MAX_LASER_INPUT_HATCH_1024 = registerMetaTileEntity(7188, new MetaTileEntityLaserHatch(nepId("laser_hatch.target_1024a.max"), false, GTValues.MAX, 1024));
		MAX_LASER_INPUT_HATCH_4096 = registerMetaTileEntity(7189, new MetaTileEntityLaserHatch(nepId("laser_hatch.target_4096a.max"), false, GTValues.MAX, 4096));
		MAX_LASER_OUTPUT_HATCH_256 = registerMetaTileEntity(7190, new MetaTileEntityLaserHatch(nepId("laser_hatch.source_256a.max"), true, GTValues.MAX, 256));
		MAX_LASER_OUTPUT_HATCH_1024 = registerMetaTileEntity(7191, new MetaTileEntityLaserHatch(nepId("laser_hatch.source_1024a.max"), true, GTValues.MAX, 1024));
		MAX_LASER_OUTPUT_HATCH_4096 = registerMetaTileEntity(7192, new MetaTileEntityLaserHatch(nepId("laser_hatch.source_4096a.max"), true, GTValues.MAX, 4096));
		
		endPos = LASER_INPUT_HATCH_16384.length;
		for(int i = 0; i < endPos; i++)
		{
			int v = i + GTValues.IV;
			String voltageName = GTValues.VN[v].toLowerCase();
			LASER_INPUT_HATCH_16384[i] = registerMetaTileEntity(7193 + i, new MetaTileEntityLaserHatch(nepId("laser_hatch.target_16384a." + voltageName), false, v, 16384));
			LASER_OUTPUT_HATCH_16384[i] = registerMetaTileEntity(7203 + i, new MetaTileEntityLaserHatch(nepId("laser_hatch.source_16384a." + voltageName), true, v, 16384));
			LASER_INPUT_HATCH_65536[i] = registerMetaTileEntity(7213 + i, new MetaTileEntityLaserHatch(nepId("laser_hatch.target_65536a." + voltageName), false, v, 65536));
			LASER_OUTPUT_HATCH_65536[i] = registerMetaTileEntity(7223 + i, new MetaTileEntityLaserHatch(nepId("laser_hatch.source_65536a." + voltageName), true, v, 65536));
		}
	}
}
