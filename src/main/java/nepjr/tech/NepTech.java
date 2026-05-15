package nepjr.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import exnihilocreatio.ExNihiloCreatio;
import gregtech.GTInternalTags;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.compat.exnihilo.ExNihiloGTModule;
import nepjr.tech.loaders.recipe.AssemblerRecipes;
import nepjr.tech.loaders.recipe.GreenhouseRecipes;
import nepjr.tech.loaders.recipe.RemovalRecipes;
import nepjr.tech.loaders.recipe.UniversalCircuitRecipes;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import nepjr.tech.proxy.CommonProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NTTags.MODID, 
	 version = NTTags.VERSION, 
	 name = NTTags.MODNAME, 
	 acceptedMinecraftVersions = "[1.12.2]",
	 dependencies = GTInternalTags.DEP_VERSION_STRING)
public class NepTech {

    public static final Logger LOGGER = LogManager.getLogger(NTTags.MODID);
    
    @SidedProxy(modId = NTTags.MODID, clientSide = "nepjr.tech.proxy.ClientProxy", serverSide = "nepjr.tech.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	// Ex Nihilo support
    	ExNihiloCreatio.loadedModules.add(new ExNihiloGTModule());
    		
    	// Init items
    	NTMetaItems.init();
    	
    	// Register MTEs	
    	NTMetaTileEntities.register();
    	
    	// Register MetaBlocks
    	NTMetaBlocks.init();
    	
    	proxy.preLoad();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	RemovalRecipes.init();
    	AssemblerRecipes.init();
    	UniversalCircuitRecipes.init();
    	GreenhouseRecipes.init();
    }

    @NotNull
    public static ResourceLocation nepId(@NotNull String path) 
    {
        return new ResourceLocation(NTTags.MODID, path);
    }
}
