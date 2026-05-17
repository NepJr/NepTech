package nepjr.tech.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import nepjr.tech.metatileentities.multi.electric.MetaTileEntityGreenhouse;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSquasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSqueezer;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamCrusher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamFuser;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmasher;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmelter;

public class NTMetaTileEntities 
{
	// Electric Multiblocks (6000 - 7000)
	public static MetaTileEntityGreenhouse GREENHOUSE;
	
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
	
	public static void register()
	{
		GREENHOUSE = registerMetaTileEntity(6000, new MetaTileEntityGreenhouse(nepId("greenhouse")));
		
		STEAM_SMASHER = registerMetaTileEntity(7001, new MetaTileEntitySteamSmasher(1, nepId("steam_smasher")));
		HP_STEAM_SMASHER = registerMetaTileEntity(7002, new MetaTileEntitySteamSmasher(2, nepId("hp_steam_smasher")));
		
		STEAM_CRUSHER = registerMetaTileEntity(7003, new MetaTileEntitySteamCrusher(1, nepId("steam_crusher")));
		HP_STEAM_CRUSHER = registerMetaTileEntity(7004, new MetaTileEntitySteamCrusher(2, nepId("hp_steam_crusher")));
		
		STEAM_FUSER = registerMetaTileEntity(7005, new MetaTileEntitySteamFuser(1, nepId("steam_fuser")));
		HP_STEAM_FUSER = registerMetaTileEntity(7006, new MetaTileEntitySteamFuser(2, nepId("hp_steam_fuser")));
		
		STEAM_SQUASHER = registerMetaTileEntity(7007, new MetaTileEntitySteamSquasher(1, nepId("steam_squasher")));
		HP_STEAM_SQUASHER = registerMetaTileEntity(7008, new MetaTileEntitySteamSquasher(2, nepId("hp_steam_squasher")));
		
		STEAM_SQUEEZER = registerMetaTileEntity(7009, new MetaTileEntitySteamSqueezer(1, nepId("steam_squeezer")));
		HP_STEAM_SQUEEZER = registerMetaTileEntity(7010, new MetaTileEntitySteamSqueezer(2, nepId("hp_steam_squeezer")));
		
		STEAM_SMELTER = registerMetaTileEntity(7011, new MetaTileEntitySteamSmelter(1, nepId("steam_smelter")));
		HP_STEAM_SMELTER = registerMetaTileEntity(7012, new MetaTileEntitySteamSmelter(2, nepId("hp_steam_smelter")));
	}
}
