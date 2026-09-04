package nepjr.tech;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import gregtech.GTInternalTags;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.config.NTConfig;
import nepjr.tech.loaders.recipe.AlloySmelterRecipes;
import nepjr.tech.loaders.recipe.AssemblerRecipes;
import nepjr.tech.loaders.recipe.AsslineRecipes;
import nepjr.tech.loaders.recipe.AsteroidMiningRecipes;
import nepjr.tech.loaders.recipe.AutoclaveRecipes;
import nepjr.tech.loaders.recipe.CentrifugeRecipes;
import nepjr.tech.loaders.recipe.ChemBathRecipes;
import nepjr.tech.loaders.recipe.ChemReactorRecipes;
import nepjr.tech.loaders.recipe.CraftingRecipes;
import nepjr.tech.loaders.recipe.ForgeHammerRecipes;
import nepjr.tech.loaders.recipe.FormingPressRecipes;
import nepjr.tech.loaders.recipe.GreenhouseRecipes;
import nepjr.tech.loaders.recipe.MaceratorRecipes;
import nepjr.tech.loaders.recipe.MixingRecipes;
import nepjr.tech.loaders.recipe.RemovalRecipes;
import nepjr.tech.loaders.recipe.UniversalCircuitRecipes;
import nepjr.tech.metatileentities.NTMetaTileEntities;
import nepjr.tech.proxy.CommonProxy;
import nepjr.tech.world.BiomeRubberForest;
import nepjr.tech.world.WorldGenLargeRubberTree;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
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
    	// Ex Nihilo support
    	// TODO: Move Ex Nihilo compat to a seperate mod.
    	//if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio")) { ExNihiloCreatio.loadedModules.add(new ExNihiloGTModule()); }
    	
    	// Init items
    	NTMetaItems.init();
    	
    	// Register MTEs	
    	NTMetaTileEntities.register();
    	if(Loader.isModLoaded("gcym"))
    	{
    		throw new RuntimeException("GCYM isn't supported with this mod. Please remove it and try launching the game again");
    	}
    	
    	// Register MetaBlocks
    	NTMetaBlocks.init();
    	
    	proxy.preLoad();
    }
    
    @EventHandler
    // TODO: Remove recipes not related to content added by the mod and move them to GroovyScript. I don't want to program recipes in like this anymore because it just plain sucks.
    public void init(FMLInitializationEvent event)
    {
    	RemovalRecipes.init();
    	if(NTConfig.neptech.enableDroneLauncher) { AsteroidMiningRecipes.init(); }
    	if(NTConfig.neptech.enableGreenhouse) { GreenhouseRecipes.init(); }
    	//if(NTConfig.modcompat.exNihiloSupport && Loader.isModLoaded("exnihilocreatio")) { AutoSifterRecipes.init(); }
    	AutoclaveRecipes.init();
    	AlloySmelterRecipes.init();
    	ChemBathRecipes.init();
    	ChemReactorRecipes.init();
    	CraftingRecipes.init();
    	// LaserEngraverRecipes.init();
    	FormingPressRecipes.init();
    	MaceratorRecipes.init();
    	MixingRecipes.init();
    	ForgeHammerRecipes.init();
    	AssemblerRecipes.init();
    	AsslineRecipes.init();
    	CentrifugeRecipes.init();
    	UniversalCircuitRecipes.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @NotNull
    public static ResourceLocation nepId(@NotNull String path) 
    {
        return new ResourceLocation(NTTags.MODID, path);
    }
}
