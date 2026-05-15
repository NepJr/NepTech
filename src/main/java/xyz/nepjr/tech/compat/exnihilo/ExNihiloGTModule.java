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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExNihiloGTModule implements IExNihiloCreatioModule, IRecipeDefaults
{
	public void registerOreChunks(OreRegistry registry) 
	{	
		if(!registry.isRegistered("copper"))
		{
			registerMaterial(registry, Materials.Copper);
		}
		if(!registry.isRegistered("tin"))
		{
			registerMaterial(registry, Materials.Tin);
		}
		if(!registry.isRegistered("silver"))
		{
			registerMaterial(registry, Materials.Silver);
		}
		if(!registry.isRegistered("lead"))
		{
			registerMaterial(registry, Materials.Lead);
		}
		if(!registry.isRegistered("cobaltite"))
		{
			registerMaterial(registry, Materials.Cobaltite);
		}
		if(!registry.isRegistered("sphalerite"))
		{
			registerMaterial(registry, Materials.Sphalerite);
		}
		if(!registry.isRegistered("calcite"))
		{
			registerMaterial(registry, Materials.Calcite);
		}
		if(!registry.isRegistered("gypsum"))
		{
			registerMaterial(registry, Materials.Gypsum);
		}
		if(!registry.isRegistered("sulfur"))
		{
			registerMaterial(registry, Materials.Sulfur);
		}
		if(!registry.isRegistered("oilsands"))
		{
			registerMaterial(registry, Materials.Oilsands);
		}
		if(!registry.isRegistered("tungstate"))
		{
			registerMaterial(registry, Materials.Tungstate);
		}
		if(!registry.isRegistered("scheelite"))
		{
			registerMaterial(registry, Materials.Scheelite);
		}
		
		ItemOre oreCalcite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("calcite");
		ItemOre oreGypsum = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("gypsum");
		ItemOre oreSulfur = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sulfur");
		ItemOre oreOilsands = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("oilsands");
		ItemOre oreSphalerite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sphalerite");
		ItemOre oreCobaltite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("cobaltite");
		
        registry.getSieveBlackList().add(oreCalcite);
        registry.getSieveBlackList().add(oreGypsum);
        registry.getSieveBlackList().add(oreSulfur);
        registry.getSieveBlackList().add(oreOilsands);
        registry.getSieveBlackList().add(oreSphalerite);
        registry.getSieveBlackList().add(oreCobaltite);   
	}
	
	public void registerSieve(SieveRegistry registry) {
        ItemOre sulfur = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sulfur");
        ItemOre calcite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("calcite");
        ItemOre gypsum = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("gypsum");
        ItemOre oilsands = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("oilsands");
        ItemOre sphalerite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sphalerite");
		ItemOre cobaltite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("cobaltite");
        
        ItemStack crushedNetherrack = Item.getItemFromBlock(ModBlocks.netherrackCrushed).getDefaultInstance();
        @SuppressWarnings("unused")
		ItemStack crushedEndstone = Item.getItemFromBlock(ModBlocks.endstoneCrushed).getDefaultInstance();
        
        if (sulfur != null) {
            registry.register(crushedNetherrack, new ItemInfo(sulfur), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (calcite != null) {
            registry.register("dust", new ItemInfo(calcite), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (gypsum != null) {
            registry.register("dust", new ItemInfo(gypsum), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (oilsands != null) {
            registry.register("sand", new ItemInfo(oilsands), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (sphalerite != null) {
            registry.register("gravel", new ItemInfo(sphalerite), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (cobaltite != null) {
            registry.register("gravel", new ItemInfo(cobaltite), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
    }
	
	@Override
	public String getMODID() 
	{
		return GTValues.MODID;
	}
	
	private void registerMaterial(OreRegistry registry, Material material)
	{
		Item ingot = Item.getByNameOrId("gregtech:meta_ingot");
		Item dust = Item.getByNameOrId("gregtech:meta_dust");
		
		registry.register(material.getName(), new Color(material.getMaterialRGB()), 
				new ItemInfo(ingot, material.getId()),
				new ItemInfo(dust, material.getId()));
	}

}