package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.item.ItemStack;

public class PolarizingRecipes
{
	private static final OrePrefix[] POLARIZING_PREFIXES = new OrePrefix[]
	{
            OrePrefix.stick, OrePrefix.stickLong, OrePrefix.plate, OrePrefix.ingot, OrePrefix.plateDense,
            OrePrefix.rotor,
            OrePrefix.bolt, OrePrefix.screw, OrePrefix.wireFine, OrePrefix.foil, OrePrefix.ring 
    };

    public static void init()
    {
        for (OrePrefix orePrefix : POLARIZING_PREFIXES)
        {
            processPolarizing(orePrefix, Materials.Holmium, NTMaterials.MagneticHolmium, ZPM);
        }
    }

    public static void processPolarizing(OrePrefix polarizingPrefix, Material material, Material magneticMaterial, int tier)
    {
        if (magneticMaterial != null && polarizingPrefix.doGenerateItem(magneticMaterial)) {
            ItemStack magneticStack = OreDictUnifier.get(polarizingPrefix, magneticMaterial);
            RecipeMaps.POLARIZER_RECIPES.recipeBuilder() // polarizing
                    .input(polarizingPrefix, material)
                    .outputs(magneticStack)
                    .duration((int) ((int) material.getMass() * polarizingPrefix.getMaterialAmount(material) /
                            GTValues.M))
                    .EUt(VA[tier])
                    .buildAndRegister();

            ModHandler.addSmeltingRecipe(new UnificationEntry(polarizingPrefix, magneticMaterial),
                    OreDictUnifier.get(polarizingPrefix, material)); // de-magnetizing
        }
    }
}
