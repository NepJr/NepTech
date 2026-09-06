package nepjr.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import gregtech.GTInternalTags;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import nepjr.tech.proxy.CommonProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NTTags.MODID, 
	 version = NTTags.VERSION, 
	 name = NTTags.MODNAME, 
	 acceptedMinecraftVersions = "[1.12.2]",
	 dependencies = GTInternalTags.DEP_VERSION_STRING
	 			  + "after:gcym;"
	 			  + "after:ae2fc;"
	 			  + "after:crazyae;"
	 			  + "after:enderio;"
	 			  + "before:exnihilocreatio;")
public class NepTech {

    public static final Logger LOGGER = LogManager.getLogger(NTTags.MODID);
    
    @SidedProxy(modId = NTTags.MODID, clientSide = "nepjr.tech.proxy.ClientProxy", serverSide = "nepjr.tech.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static NepTech instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {	
    	// Init items
    	NTMetaItems.init();
    	
    	// Register MetaBlocks
    	NTMetaBlocks.init();
    	
    	// Register MTEs	
    	NTMetaTileEntities.register();
    	if(Loader.isModLoaded("gcym"))
    	{
    		throw new RuntimeException("GCYM isn't supported with this mod. Please remove it and try launching the game again");
    	}
    	
    	proxy.preLoad();
    }

    @NotNull
    public static ResourceLocation nepId(@NotNull String path) 
    {
        return new ResourceLocation(NTTags.MODID, path);
    }
}
