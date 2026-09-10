package nepjr.tech.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.loaders.recipe.CraftingComponent.Component;
import nepjr.tech.api.unification.material.NTMaterials;
import nepjr.tech.common.items.NTMetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NTCraftingComponents
{
	public static void init()
	{
		WIRE_ELECTRIC = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold) },
            { 1, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold) },
            { 2, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Silver) },
            { 3, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Electrum) },
            { 4, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Platinum) },
            { 5, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium) },
            { 6, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium) },
            { 7, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium) },
            { 8, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium) },
            { 9, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    WIRE_QUAD = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Lead) },
            { 1, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tungsten) },
            { 6, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    WIRE_OCT = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Lead) },
            { 1, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tungsten) },
            { 6, new UnificationEntry(OrePrefix.wireGtOctal, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.wireGtOctal, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.wireGtOctal, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    WIRE_HEX = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtHex, Materials.Lead) },
            { 1, new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.wireGtHex, Materials.Tungsten) },
            { 6, new UnificationEntry(OrePrefix.wireGtHex, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.wireGtHex, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.wireGtHex, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.wireGtHex, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.wireGtHex, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtSingle, Materials.RedAlloy) },
            { 1, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Platinum) },
            { 6, new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE_QUAD = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.RedAlloy) },
            { 1, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Platinum) },
            { 6, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE_OCT = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtOctal, Materials.RedAlloy) },
            { 1, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Platinum) },
            { 6, new UnificationEntry(OrePrefix.cableGtOctal, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.cableGtOctal, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.cableGtOctal, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE_HEX = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtHex, Materials.RedAlloy) },
            { 1, new UnificationEntry(OrePrefix.cableGtHex, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.cableGtHex, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.cableGtHex, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.cableGtHex, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.cableGtHex, Materials.Platinum) },
            { 6, new UnificationEntry(OrePrefix.cableGtHex, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.cableGtHex, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.cableGtHex, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.cableGtHex, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.cableGtHex, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE_TIER_UP = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin) },
            { 1, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper) },
            { 2, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold) },
            { 3, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium) },
            { 4, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Platinum) },
            { 5, new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium) },
            { 6, new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium) },
            { 7, new UnificationEntry(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate) },
            { 8, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },
            { 9, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Holmium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    CABLE_QUAD_TIER_UP = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Tin) },
            { 1, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Copper) },
            { 2, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold) },
            { 3, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Aluminium) },
            { 4, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Platinum) },
            { 5, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium) },
            { 6, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium) },
            { 7, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.YttriumBariumCuprate) },
            { 8, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },
            { 9, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Holmium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    PIPE_NORMAL = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Bronze) },
            { 1, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Bronze) },
            { 2, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Steel) },
            { 3, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.StainlessSteel) },
            { 4, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Titanium) },
            { 5, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.TungstenSteel) },
            { 6, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Iridium) },
            { 8, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Naquadah) },
            { 9, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Neutronium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    PIPE_LARGE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Bronze) },
            { 1, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Bronze) },
            { 2, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Steel) },
            { 3, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.StainlessSteel) },
            { 4, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Titanium) },
            { 5, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.TungstenSteel) },
            { 6, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Ultimet) },
            { 8, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Naquadah) },
            { 9, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Neutronium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    // TODO, Glass Tiers:
    /*
     * Glass: Steam-MV
     * Tempered: HV, EV
     * Laminated Glass: IV, LuV
     * Fusion: ZPM, UV
     * Some gregicality thing: UHV+
     */
    GLASS = new Component(Stream.of(new Object[][] {

            { GTValues.FALLBACK, new ItemStack(Blocks.GLASS, 1, GTValues.W) },
            { ULV, Blocks.GLASS },
            { LV, Blocks.GLASS },
            { MV, Blocks.GLASS },
            { HV, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.TEMPERED_GLASS) },
            { EV, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.TEMPERED_GLASS) },
            { IV, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.LAMINATED_GLASS) },
            { LuV, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.LAMINATED_GLASS) },
            { ZPM, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.FUSION_GLASS) },
            { UV, MetaBlocks.TRANSPARENT_CASING.getItemVariant(
                    BlockGlassCasing.CasingType.FUSION_GLASS) }

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    PLATE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
            { 1, new UnificationEntry(OrePrefix.plate, Materials.Steel) },
            { 2, new UnificationEntry(OrePrefix.plate, Materials.Aluminium) },
            { 3, new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel) },
            { 4, new UnificationEntry(OrePrefix.plate, Materials.Titanium) },
            { 5, new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel) },
            { 6, new UnificationEntry(OrePrefix.plate, Materials.RhodiumPlatedPalladium) },
            { 7, new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy) },
            { 8, new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium) },
            { 9, new UnificationEntry(OrePrefix.plate, Materials.Neutronium) },
            { 10, new UnificationEntry(OrePrefix.plate, NTMaterials.Draconium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    DOUBLE_PLATE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.plateDouble, Materials.WroughtIron) },
            { 1, new UnificationEntry(OrePrefix.plateDouble, Materials.Steel) },
            { 2, new UnificationEntry(OrePrefix.plateDouble, Materials.Aluminium) },
            { 3, new UnificationEntry(OrePrefix.plateDouble, Materials.StainlessSteel) },
            { 4, new UnificationEntry(OrePrefix.plateDouble, Materials.Titanium) },
            { 5, new UnificationEntry(OrePrefix.plateDouble, Materials.TungstenSteel) },
            { 6, new UnificationEntry(OrePrefix.plateDouble, Materials.RhodiumPlatedPalladium) },
            { 7, new UnificationEntry(OrePrefix.plateDouble, Materials.NaquadahAlloy) },
            { 8, new UnificationEntry(OrePrefix.plateDouble, Materials.Darmstadtium) },
            { 9, new UnificationEntry(OrePrefix.plateDouble, Materials.Neutronium) },
            { 10, new UnificationEntry(OrePrefix.plateDouble, NTMaterials.Draconium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    HULL_PLATE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.plate, Materials.Wood) },
            { 1, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
            { 2, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
            { 3, new UnificationEntry(OrePrefix.plate, Materials.Polyethylene) },
            { 4, new UnificationEntry(OrePrefix.plate, Materials.Polyethylene) },
            { 5, new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene) },
            { 6, new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene) },
            { 7, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },
            { 8, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    ROTOR = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.rotor, Materials.Tin) },
            { 1, new UnificationEntry(OrePrefix.rotor, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.rotor, Materials.Bronze) },
            { 3, new UnificationEntry(OrePrefix.rotor, Materials.Steel) },
            { 4, new UnificationEntry(OrePrefix.rotor, Materials.StainlessSteel) },
            { 5, new UnificationEntry(OrePrefix.rotor, Materials.TungstenSteel) },
            { 6, new UnificationEntry(OrePrefix.rotor, Materials.RhodiumPlatedPalladium) },
            { 7, new UnificationEntry(OrePrefix.rotor, Materials.NaquadahAlloy) },
            { 8, new UnificationEntry(OrePrefix.rotor, Materials.Darmstadtium) },
            { 9, new UnificationEntry(OrePrefix.rotor, Materials.Neutronium) },
            { 10, new UnificationEntry(OrePrefix.rotor, NTMaterials.Draconium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    GRINDER = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.gem, Materials.Diamond) },
            { 1, new UnificationEntry(OrePrefix.gem, Materials.Diamond) },
            { 2, new UnificationEntry(OrePrefix.gem, Materials.Diamond) },
            { 3, MetaItems.COMPONENT_GRINDER_DIAMOND.getStackForm() },
            { 4, MetaItems.COMPONENT_GRINDER_DIAMOND.getStackForm() },
            { 5, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm() },
            { GTValues.FALLBACK, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm() },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    SAWBLADE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Bronze) },
            { 1, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.CobaltBrass) },
            { 2, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.VanadiumSteel) },
            { 3, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.BlueSteel) },
            { 4, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Ultimet) },
            { 5, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.TungstenCarbide) },
            { 6, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.HSSE) },
            { 7, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.NaquadahAlloy) },
            { 8, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Duranium) },
            { 9, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Neutronium) },
            { 10, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, NTMaterials.Draconium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.toolHeadBuzzSaw, Materials.Duranium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    COIL_HEATING = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
            { 1, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
            { 2, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Cupronickel) },
            { 3, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Kanthal) },
            { 4, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Nichrome) },
            { 5, new UnificationEntry(OrePrefix.wireGtDouble, Materials.RTMAlloy) },
            { 6, new UnificationEntry(OrePrefix.wireGtDouble, Materials.HSSG) },
            { 7, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Naquadah) },
            { 8, new UnificationEntry(OrePrefix.wireGtDouble, Materials.NaquadahAlloy) },
            { 9, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Tritanium) },
            { 10, new UnificationEntry(OrePrefix.wireGtDouble, NTMaterials.AwakenedDraconium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    COIL_HEATING_DOUBLE = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
            { 1, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
            { 2, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel) },
            { 3, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Kanthal) },
            { 4, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Nichrome) },
            { 5, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.RTMAlloy) },
            { 6, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.HSSG) },
            { 7, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Naquadah) },
            { 8, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy) },
            { 9, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tritanium) },
            { 10, new UnificationEntry(OrePrefix.wireGtQuadruple, NTMaterials.AwakenedDraconium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    COIL_ELECTRIC = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tin) },
            { 1, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Silver) },
            { 4, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Steel) },
            { 5, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Graphene) },
            { 6, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NiobiumNitride) },
            { 7, new UnificationEntry(OrePrefix.wireGtOctal, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.wireGtOctal, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    STICK_MAGNETIC = new Component(Stream.of(new Object[][] {
    		// TODO: magnetic holmium
            { 0, new UnificationEntry(OrePrefix.stick, Materials.IronMagnetic) },
            { 1, new UnificationEntry(OrePrefix.stick, Materials.IronMagnetic) },
            { 2, new UnificationEntry(OrePrefix.stick, Materials.SteelMagnetic) },
            { 3, new UnificationEntry(OrePrefix.stick, Materials.SteelMagnetic) },
            { 4, new UnificationEntry(OrePrefix.stick, Materials.NeodymiumMagnetic) },
            { 5, new UnificationEntry(OrePrefix.stick, Materials.NeodymiumMagnetic) },
            { 6, new UnificationEntry(OrePrefix.stickLong, Materials.NeodymiumMagnetic) },
            { 7, new UnificationEntry(OrePrefix.stickLong, Materials.NeodymiumMagnetic) },
            { 8, new UnificationEntry(OrePrefix.block, Materials.NeodymiumMagnetic) },
            { 9, new UnificationEntry(OrePrefix.block, Materials.Holmium) },
            { 10, new UnificationEntry(OrePrefix.block, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    STICK_DISTILLATION = new Component(Stream.of(new Object[][] {
            { 0, new UnificationEntry(OrePrefix.stick, Materials.Blaze) },
            { 1, new UnificationEntry(OrePrefix.spring, Materials.Copper) },
            { 2, new UnificationEntry(OrePrefix.spring, Materials.Cupronickel) },
            { 3, new UnificationEntry(OrePrefix.spring, Materials.Kanthal) },
            { 4, new UnificationEntry(OrePrefix.spring, Materials.Nichrome) },
            { 5, new UnificationEntry(OrePrefix.spring, Materials.RTMAlloy) },
            { 6, new UnificationEntry(OrePrefix.spring, Materials.HSSG) },
            { 7, new UnificationEntry(OrePrefix.spring, Materials.Naquadah) },
            { 8, new UnificationEntry(OrePrefix.spring, Materials.NaquadahAlloy) },
            { 9, new UnificationEntry(OrePrefix.spring, Materials.Tritanium) },
            { 10, new UnificationEntry(OrePrefix.spring, NTMaterials.AwakenedDraconium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.stick, Materials.Blaze) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    STICK_ELECTROMAGNETIC = new Component(Stream.of(new Object[][] {
    		// TODO: Magnetic Holmium
            { 0, new UnificationEntry(OrePrefix.stick, Materials.Iron) },
            { 1, new UnificationEntry(OrePrefix.stick, Materials.Iron) },
            { 2, new UnificationEntry(OrePrefix.stick, Materials.Steel) },
            { 3, new UnificationEntry(OrePrefix.stick, Materials.Steel) },
            { 4, new UnificationEntry(OrePrefix.stick, Materials.Neodymium) },
            { 9, new UnificationEntry(OrePrefix.stick, Materials.Holmium) },
            { 10, new UnificationEntry(OrePrefix.stick, Materials.Holmium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.stick, Materials.VanadiumGallium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    STICK_RADIOACTIVE = new Component(Stream.of(new Object[][] {

            { 4, new UnificationEntry(OrePrefix.stick, Materials.Uranium235) },
            { 5, new UnificationEntry(OrePrefix.stick, Materials.Plutonium241) },
            { 6, new UnificationEntry(OrePrefix.stick, Materials.NaquadahEnriched) },
            { 7, new UnificationEntry(OrePrefix.stick, Materials.Americium) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.stick, Materials.Tritanium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    PIPE_REACTOR = new Component(Stream.of(new Object[][] {

            { 0, new ItemStack(Blocks.GLASS, 1, GTValues.W) },
            { 1, new ItemStack(Blocks.GLASS, 1, GTValues.W) },
            { 2, new ItemStack(Blocks.GLASS, 1, GTValues.W) },
            { 3, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polyethylene) },
            { 4, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Polyethylene) },
            { 5, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polyethylene) },
            { 6, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polytetrafluoroethylene) },
            { 7, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Polytetrafluoroethylene) },
            { 8, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polytetrafluoroethylene) },
            { 9, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polybenzimidazole) },
            { 10, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polybenzimidazole) },
            { GTValues.FALLBACK, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polyethylene) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    POWER_COMPONENT = new Component(Stream.of(new Object[][] {

            { 2, MetaItems.ULTRA_LOW_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 3, MetaItems.LOW_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 4, MetaItems.POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 5, MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 6, MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 7, MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 8, MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 9, MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm() },
            { 10, NTMetaItems.EHPIC.getStackForm() },
            { 11, NTMetaItems.EHPIC.getStackForm() },
            { GTValues.FALLBACK, MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    VOLTAGE_COIL = new Component(Stream.of(new Object[][] {

            { 0, MetaItems.VOLTAGE_COIL_ULV.getStackForm() },
            { 1, MetaItems.VOLTAGE_COIL_LV.getStackForm() },
            { 2, MetaItems.VOLTAGE_COIL_MV.getStackForm() },
            { 3, MetaItems.VOLTAGE_COIL_HV.getStackForm() },
            { 4, MetaItems.VOLTAGE_COIL_EV.getStackForm() },
            { 5, MetaItems.VOLTAGE_COIL_IV.getStackForm() },
            { 6, MetaItems.VOLTAGE_COIL_LuV.getStackForm() },
            { 7, MetaItems.VOLTAGE_COIL_ZPM.getStackForm() },
            { 8, MetaItems.VOLTAGE_COIL_UV.getStackForm() },
            { 9, NTMetaItems.VOLTAGE_COIL_UHV.getStackForm() },
            { 10, NTMetaItems.VOLTAGE_COIL_UEV.getStackForm() },
            { 11, NTMetaItems.VOLTAGE_COIL_UIV.getStackForm() },
            { 12, NTMetaItems.VOLTAGE_COIL_UXV.getStackForm() },
            { 13, NTMetaItems.VOLTAGE_COIL_OpV.getStackForm() },
            { 14, NTMetaItems.VOLTAGE_COIL_MAX.getStackForm() },
            { GTValues.FALLBACK, MetaItems.VOLTAGE_COIL_UV },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

    SPRING = new Component(Stream.of(new Object[][] {

            { 0, new UnificationEntry(OrePrefix.spring, Materials.Lead) },
            { 1, new UnificationEntry(OrePrefix.spring, Materials.Tin) },
            { 2, new UnificationEntry(OrePrefix.spring, Materials.Copper) },
            { 3, new UnificationEntry(OrePrefix.spring, Materials.Gold) },
            { 4, new UnificationEntry(OrePrefix.spring, Materials.Aluminium) },
            { 5, new UnificationEntry(OrePrefix.spring, Materials.Tungsten) },
            { 6, new UnificationEntry(OrePrefix.spring, Materials.NiobiumTitanium) },
            { 7, new UnificationEntry(OrePrefix.spring, Materials.VanadiumGallium) },
            { 8, new UnificationEntry(OrePrefix.spring, Materials.YttriumBariumCuprate) },
            { 9, new UnificationEntry(OrePrefix.spring, Materials.Europium) },
            { 10, new UnificationEntry(OrePrefix.spring, Materials.Holmium) },

    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
	}
}
