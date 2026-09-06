package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.ULV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.Rubber;
import static gregtech.api.unification.material.Materials.SiliconeRubber;
import static gregtech.api.unification.material.Materials.StyreneButadieneRubber;
import static gregtech.api.unification.ore.OrePrefix.cableGtDouble;
import static gregtech.api.unification.ore.OrePrefix.cableGtHex;
import static gregtech.api.unification.ore.OrePrefix.cableGtOctal;
import static gregtech.api.unification.ore.OrePrefix.cableGtQuadruple;
import static gregtech.api.unification.ore.OrePrefix.cableGtSingle;
import static gregtech.api.unification.ore.OrePrefix.wireGtDouble;
import static gregtech.api.unification.ore.OrePrefix.wireGtHex;
import static gregtech.api.unification.ore.OrePrefix.wireGtOctal;
import static gregtech.api.unification.ore.OrePrefix.wireGtQuadruple;
import static gregtech.api.unification.ore.OrePrefix.wireGtSingle;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.WireProperties;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import nepjr.tech.api.recipes.NTRecipeMaps;
import nepjr.tech.api.recipes.builders.WireSupercoaterBuilder;

public class SupercoaterRecipeHandler 
{
	private static final Map<OrePrefix, Integer> INSULATION_AMOUNT = ImmutableMap.of(
            cableGtSingle, 36,
            cableGtDouble, 36,
            cableGtQuadruple, 72,
            cableGtOctal, 108,
            cableGtHex, 180);
	
	private static final Map<OrePrefix, Integer> POLYMER_AMOUNT = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 1,
            cableGtQuadruple, 2,
            cableGtOctal, 3,
            cableGtHex, 5);
	
	public static void initHandler()
	{
        // Generate Cable Covering Recipes
        wireGtSingle.addProcessingHandler(PropertyKey.WIRE, SupercoaterRecipeHandler::generateCableCovering);
        wireGtDouble.addProcessingHandler(PropertyKey.WIRE, SupercoaterRecipeHandler::generateCableCovering);
        wireGtQuadruple.addProcessingHandler(PropertyKey.WIRE, SupercoaterRecipeHandler::generateCableCovering);
        wireGtOctal.addProcessingHandler(PropertyKey.WIRE, SupercoaterRecipeHandler::generateCableCovering);
        wireGtHex.addProcessingHandler(PropertyKey.WIRE, SupercoaterRecipeHandler::generateCableCovering);
    }
	
	public static void generateCableCovering(OrePrefix wirePrefix, Material material, WireProperties property) {
        // Superconductors have no Cables, so exit early
        if (property.isSuperconductor()) return;

        OrePrefix cablePrefix = OrePrefix.getPrefix("cable" + wirePrefix.name().substring(4));
        int voltageTier = GTUtility.getTierByVoltage(property.getVoltage());
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);
        int polymerAmount = POLYMER_AMOUNT.get(cablePrefix);

        // Rubber Recipe (ULV-EV cables)
        if (voltageTier <= GTValues.EV) {
            WireSupercoaterBuilder builder = NTRecipeMaps.WIRE_SUPERCOATER.recipeBuilder().EUt(VA[ULV]).duration(100)
                    .input(wirePrefix, material)
                    .output(cablePrefix, material)
                    .circuitMeta(1)
                    .polymer(Rubber)
                    .polymerAmt(GTValues.L / 2 * polymerAmount);

            if (voltageTier == GTValues.EV) {
                builder.polyvinylChloride(insulationAmount);
            }
            builder.buildAndRegister();
        }

        // Silicone Rubber Recipe (all cables)
        WireSupercoaterBuilder builder = NTRecipeMaps.WIRE_SUPERCOATER.recipeBuilder().EUt(VA[ULV]).duration(100)
                .input(wirePrefix, material)
                .output(cablePrefix, material);

        // Apply a Polyphenylene Sulfate Foil if LuV or above.
        if (voltageTier >= GTValues.LuV) {
            builder.polyphenyleneSulfide(insulationAmount);
        }

        // Apply a PVC Foil if EV or above.
        if (voltageTier >= GTValues.EV) {
            builder.polyvinylChloride(insulationAmount);
        }
        
        builder.circuitMeta(2);
        builder.polymer(SiliconeRubber);
        builder.polymerAmt(GTValues.L / 2 * polymerAmount)
                .buildAndRegister();

        // Styrene Butadiene Rubber Recipe (all cables)
        builder = NTRecipeMaps.WIRE_SUPERCOATER.recipeBuilder().EUt(VA[ULV]).duration(100)
                .input(wirePrefix, material)
                .output(cablePrefix, material);

        // Apply a Polyphenylene Sulfate Foil if LuV or above.
        if (voltageTier >= GTValues.LuV) {
        	builder.polyphenyleneSulfide(insulationAmount);
        }

        // Apply a PVC Foil if EV or above.
        if (voltageTier >= GTValues.EV) {
        	builder.polyvinylChloride(insulationAmount);
        }
        
        builder.circuitMeta(3);
        builder.polymer(StyreneButadieneRubber);
        builder.polymerAmt(GTValues.L / 2 * polymerAmount / 4)
                .buildAndRegister();
    }
}
