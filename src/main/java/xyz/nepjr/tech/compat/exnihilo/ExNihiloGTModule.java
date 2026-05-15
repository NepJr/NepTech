package xyz.nepjr.tech.compat.exnihilo;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.items.ore.ItemOre;
import exnihilocreatio.modules.IExNihiloCreatioModule;
import exnihilocreatio.recipes.defaults.IRecipeDefaults;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.registries.OreRegistry;
import exnihilocreatio.registries.registries.SieveRegistry;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.ItemInfo;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExNihiloGTModule implements IExNihiloCreatioModule, IRecipeDefaults
{
	public void registerOreChunks(OreRegistry registry) 
	{	
		// Shouldn't need to check if these four are added, but only here incase someone adds extra mods to the pack
		if(!registry.isRegistered("copper"))
		{
			registerMaterial(registry, Materials.Copper, false, false);
		}
		if(!registry.isRegistered("tin"))
		{
			registerMaterial(registry, Materials.Tin, false, false);
		}
		if(!registry.isRegistered("silver"))
		{
			registerMaterial(registry, Materials.Silver, false, false);
		}
		if(!registry.isRegistered("sulfur"))
		{
			registerMaterial(registry, Materials.Sulfur, true, true);
		}
		
		registerMaterial(registry, Materials.Galena, true, true);
		registerMaterial(registry, Materials.Cobaltite, true, true);
		registerMaterial(registry, Materials.Sphalerite, true, true);
		registerMaterial(registry, Materials.Calcite, true, true);
		registerMaterial(registry, Materials.Gypsum, true, true);
		registerMaterial(registry, Materials.Oilsands, true, true);
		registerMaterial(registry, Materials.Tungstate, true, true);
		registerMaterial(registry, Materials.Scheelite, true, true);
	}
	
	public void registerSieve(SieveRegistry registry) {
		addSieveRecipe(registry, Materials.Sulfur, ModBlocks.netherrackCrushed, 0.05f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Calcite, ModBlocks.dust, 0.02f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Gypsum, ModBlocks.dust, 0.02f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Oilsands, Blocks.SAND, 0.01f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Sphalerite, Blocks.GRAVEL, 0.05f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Cobaltite, Blocks.GRAVEL, 0.05f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Galena, Blocks.GRAVEL, 0.05f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Tungstate, ModBlocks.endstoneCrushed, 0.05f, BlockSieve.MeshType.DIAMOND);
		addSieveRecipe(registry, Materials.Scheelite, ModBlocks.endstoneCrushed, 0.05f, BlockSieve.MeshType.DIAMOND);
    }
	
	@Override
	public String getMODID() 
	{
		return GTValues.MODID;
	}
	
	private void addSieveRecipe(SieveRegistry registry, Material material, Block blockToSift, float chance, BlockSieve.MeshType meshType)
	{
		ItemOre materialOre = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem(material.getName());
		ItemStack block = Item.getItemFromBlock(blockToSift).getDefaultInstance();
		
		if(materialOre != null)
		{
			registry.register(block, new ItemInfo(materialOre), chance, meshType.getID());
		}
	}
	
	private void registerMaterial(OreRegistry registry, Material material, boolean dustOnly, boolean blacklist)
	{
		Item ingot = Item.getByNameOrId("gregtech:meta_ingot");
		Item dust = Item.getByNameOrId("gregtech:meta_dust");
		
		if(dustOnly == true)
		{
			registry.register(material.getName(), new Color(material.getMaterialRGB()), 
					new ItemInfo(dust, material.getId()),
					new ItemInfo(dust, material.getId()));
		}
		else
		{
			registry.register(material.getName(), new Color(material.getMaterialRGB()), 
					new ItemInfo(ingot, material.getId()),
					new ItemInfo(dust, material.getId()));
		}
		
		if(blacklist == true) // By default it adds everything to the gravel sieve so we blacklist it by default so it doesn't do that
		{
			ItemOre oreToAdd = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem(material.getName());
			registry.getSieveBlackList().add(oreToAdd);
		}
	}
}