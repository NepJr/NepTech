package xyz.nepjr.tech.metatileentities;

import xyz.nepjr.tech.metatileentities.multi.electric.MetaTileEntityGreenhouse;
import xyz.nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmasher;

import static xyz.nepjr.tech.NepTech.nepId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class NTMetaTileEntities 
{
	// Electric Multiblocks (6000 - 7000)
	public static MetaTileEntityGreenhouse GREENHOUSE;
	
	// Steam multiblocks (7001 - 7100)
	public static MetaTileEntitySteamSmasher[] STEAM_SMASHER = new MetaTileEntitySteamSmasher[2];
	
	public static void register()
	{
		GREENHOUSE = registerMetaTileEntity(6000, new MetaTileEntityGreenhouse(nepId("greenhouse")));
		
		STEAM_SMASHER[0] = registerMetaTileEntity(7001, new MetaTileEntitySteamSmasher(1, nepId("steam_smasher")));
		STEAM_SMASHER[1] = registerMetaTileEntity(7002, new MetaTileEntitySteamSmasher(2, nepId("hp_steam_smasher")));
	}
}
