package nepjr.tech.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import nepjr.tech.metatileentities.multi.electric.MetaTileEntityGreenhouse;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamCrusher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamFuser;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmasher;

public class NTMetaTileEntities 
{
	// Electric Multiblocks (6000 - 7000)
	public static MetaTileEntityGreenhouse GREENHOUSE;
	
	// Steam multiblocks (7001 - 7100)
	public static MetaTileEntitySteamSmasher STEAM_SMASHER;
	public static MetaTileEntitySteamSmasher STEAM_HP_SMASHER;
	
	public static MetaTileEntitySteamCrusher STEAM_CRUSHER;
	public static MetaTileEntitySteamCrusher STEAM_HP_CRUSHER;
	
	public static MetaTileEntitySteamFuser STEAM_FUSER;
	public static MetaTileEntitySteamFuser STEAM_HP_FUSER;
	
	public static void register()
	{
		GREENHOUSE = registerMetaTileEntity(6000, new MetaTileEntityGreenhouse(nepId("greenhouse")));
		
		STEAM_SMASHER = registerMetaTileEntity(7001, new MetaTileEntitySteamSmasher(1, nepId("steam_smasher")));
		STEAM_HP_SMASHER = registerMetaTileEntity(7002, new MetaTileEntitySteamSmasher(2, nepId("hp_steam_smasher")));
		
		STEAM_CRUSHER = registerMetaTileEntity(7003, new MetaTileEntitySteamCrusher(1, nepId("steam_crusher")));
		STEAM_HP_CRUSHER = registerMetaTileEntity(7004, new MetaTileEntitySteamCrusher(2, nepId("hp_steam_crusher")));
		
		STEAM_FUSER = registerMetaTileEntity(7005, new MetaTileEntitySteamFuser(1, nepId("steam_fuser")));
		STEAM_HP_FUSER = registerMetaTileEntity(7006, new MetaTileEntitySteamFuser(2, nepId("hp_steam_fuser")));
	}
}
