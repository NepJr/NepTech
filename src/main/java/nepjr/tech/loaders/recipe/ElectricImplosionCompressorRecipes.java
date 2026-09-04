package nepjr.tech.loaders.recipe;

import static gregtech.api.unification.material.info.MaterialFlags.EXPLOSIVE;
import static gregtech.api.unification.material.info.MaterialFlags.FLAMMABLE;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import nepjr.tech.api.recipes.NTRecipeMaps;
import net.minecraft.item.ItemStack;

public class ElectricImplosionCompressorRecipes 
{
	public static void init()
	{
		
	}
	public static void initHandler()
	{
		OrePrefix.dust.addProcessingHandler(PropertyKey.DUST, ElectricImplosionCompressorRecipes::processDust);
	}
	
	public static void processDust(OrePrefix dustPrefix, Material mat, DustProperty property)
	{
		ItemStack dustStack = OreDictUnifier.get(dustPrefix, mat);
		if (mat.hasProperty(PropertyKey.GEM)) {
            ItemStack gemStack = OreDictUnifier.get(OrePrefix.gem, mat);
            if (!mat.hasFlag(EXPLOSIVE) && !mat.hasFlag(FLAMMABLE)) {
                NTRecipeMaps.ELECTRIC_IMPLOSION_RECIPES.recipeBuilder()
                        .inputs(GTUtility.copy(4, dustStack))
                        .outputs(GTUtility.copy(4, gemStack))
                        .buildAndRegister();
            }
		}
	}
}
