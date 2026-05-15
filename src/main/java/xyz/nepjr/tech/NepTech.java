package xyz.nepjr.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import exnihilocreatio.ExNihiloCreatio;
import gregtech.GTInternalTags;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.nepjr.tech.api.NepTechAPI;
import xyz.nepjr.tech.common.blocks.BlockFertilizedDirt;
import xyz.nepjr.tech.common.blocks.NTMetaBlocks;
import xyz.nepjr.tech.common.items.NTMetaItems;
import xyz.nepjr.tech.compat.exnihilo.ExNihiloGTModule;
import xyz.nepjr.tech.loaders.recipe.AssemblerRecipes;
import xyz.nepjr.tech.loaders.recipe.GreenhouseRecipes;
import xyz.nepjr.tech.loaders.recipe.RemovalRecipes;
import xyz.nepjr.tech.loaders.recipe.UniversalCircuitRecipes;
import xyz.nepjr.tech.metatileentities.NTMetaTileEntities;
import xyz.nepjr.tech.proxy.CommonProxy;

@Mod(modid = NTTags.MODID, 
	 version = NTTags.VERSION, 
	 name = NTTags.MODNAME, 
	 acceptedMinecraftVersions = "[1.12.2]",
	 dependencies = GTInternalTags.DEP_VERSION_STRING)
public class NepTech {

    public static final Logger LOGGER = LogManager.getLogger(NTTags.MODID);
    
    @SidedProxy(modId = NTTags.MODID, clientSide = "xyz.nepjr.tech.proxy.ClientProxy", serverSide = "xyz.nepjr.tech.proxy.CommonProxy")
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
