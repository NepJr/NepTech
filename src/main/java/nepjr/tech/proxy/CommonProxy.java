package nepjr.tech.proxy;

import java.util.Objects;
import java.util.function.Function;

import gregtech.api.block.VariantItemBlock;
import gregtech.api.event.HighTierEvent;
import gregtech.api.unification.material.event.MaterialEvent;
import nepjr.tech.NTTags;
import nepjr.tech.api.NepTechAPI;
import nepjr.tech.api.block.IFertilizedDirtBlockStats;
import nepjr.tech.api.unification.material.GTMaterialModifications;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.BlockFertilizedDirt;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTItemRingOfFlight;
import nepjr.tech.common.items.NTMetaItems;
import nepjr.tech.loaders.recipe.ElectricImplosionCompressorRecipes;
import nepjr.tech.world.BiomeRubberForest;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = NTTags.MODID)
public class CommonProxy 
{
	@GameRegistry.ObjectHolder(NTTags.MODID + ":ring_of_flight")
	public static final Item RING_OF_FLIGHT = null;
	
	public static BiomeRubberForest RUBBER_FOREST;
	
	public void preLoad()
	{
		initAbilities();
		
		RUBBER_FOREST = new BiomeRubberForest();
		RUBBER_FOREST.setRegistryName("rubber_forest");
	}
	
	private void initAbilities()
	{
		// Fill fertilizer stuff
        for (BlockFertilizedDirt.FertilizerType type : BlockFertilizedDirt.FertilizerType.values()) {
            NepTechAPI.FERTILIZED_DIRTS.put(NTMetaBlocks.FERTILIZED_DIRT.getState(type), type);
        }
        
        NepTechAPI.FERTILIZED_DIRTS.put(Blocks.DIRT.getDefaultState(), UnregisteredFertilizerType.DIRT);
        NepTechAPI.FERTILIZED_DIRTS.put(Blocks.GRASS.getDefaultState(), UnregisteredFertilizerType.DIRT);
	}
	
	@SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) 
    {
    	ElectricImplosionCompressorRecipes.initHandler();
    }
    
    
    @SubscribeEvent
    public static void syncConfig(ConfigChangedEvent.OnConfigChangedEvent event)
    {
    	if(event.getModID().equals(NTTags.MODID))
    	{
    		ConfigManager.sync(NTTags.MODID, Type.INSTANCE);
    	}
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
    {
    	IForgeRegistry<Item> registry = event.getRegistry();
    	
    	NTMetaItems.initSub();
    	
    	// TODO: move to its own mod
    	registry.register(new NTItemRingOfFlight().setRegistryName("ring_of_flight").setTranslationKey("ring_of_flight"));
    	
    	// Itemblocks
    	registry.register(createItemBlock(NTMetaBlocks.FERTILIZED_DIRT, VariantItemBlock::new));
    	registry.register(createItemBlock(NTMetaBlocks.GENERIC_BLOCKS, VariantItemBlock::new));
    	registry.register(createItemBlock(NTMetaBlocks.NT_CASINGS, VariantItemBlock::new));
    }
    
    // Taken from GYCM
    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
    {
    	IForgeRegistry<Block> registry = event.getRegistry();
    	
    	registry.register(NTMetaBlocks.FERTILIZED_DIRT);
    	registry.register(NTMetaBlocks.GENERIC_BLOCKS);
    	registry.register(NTMetaBlocks.NT_CASINGS);
    }
    
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event)
    {
    	IForgeRegistry<Biome> registry = event.getRegistry();
    	
    	registry.register(RUBBER_FOREST);
    	
    	BiomeDictionary.addTypes(RUBBER_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE);
    	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(RUBBER_FOREST, 10));
		BiomeManager.addSpawnBiome(RUBBER_FOREST);
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event) 
    {
    	GTMaterialModifications.init();
    	NTMaterials.init();
    }
    
    @SubscribeEvent
    public static void onOreRegister(OreRegisterEvent event)
    {
    	
    }
    
    @SubscribeEvent
    public static void HighTier(HighTierEvent event)
    {
    	event.enableHighTier();
    }
	
	public boolean isServerSide()
	{
		return true;
	}
	
	private enum UnregisteredFertilizerType implements IStringSerializable, IFertilizedDirtBlockStats 
	{
		DIRT("dirt", 0, 0.0F);
		
		private final String name;
		private final int fertilizerTier;
		private final float growthDiscount;
		
		UnregisteredFertilizerType(String name, int fertilizerTier, float growthDiscount)
		{
			this.name = name;
			this.fertilizerTier = fertilizerTier;
			this.growthDiscount = 1.0F - growthDiscount;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getTier() {
			return this.fertilizerTier;
		}

		@Override
		public float getDiscount() {
			return this.growthDiscount;
		}
	}
}
