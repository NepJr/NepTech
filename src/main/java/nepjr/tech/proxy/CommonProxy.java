package nepjr.tech.proxy;

import java.util.Objects;
import java.util.function.Function;

import gregtech.api.block.VariantItemBlock;
import gregtech.api.event.HighTierEvent;
import gregtech.api.unification.material.event.MaterialEvent;
import nepjr.tech.api.NepTechAPI;
import nepjr.tech.api.block.IFertilizedDirtBlockStats;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.blocks.BlockFertilizedDirt;
import nepjr.tech.common.blocks.NTMetaBlocks;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import nepjr.tech.NTTags;

@EventBusSubscriber(modid = NTTags.MODID)
public class CommonProxy 
{
	public void preLoad()
	{
		initAbilities();
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

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
    {
    	IForgeRegistry<Item> registry = event.getRegistry();
    	
    	NTMetaItems.initSub();
    	
    	// Itemblocks
    	registry.register(createItemBlock(NTMetaBlocks.FERTILIZED_DIRT, VariantItemBlock::new));
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
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event) 
    {
    	NTMaterials.init();
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
