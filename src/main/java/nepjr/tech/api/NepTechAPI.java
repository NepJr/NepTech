package nepjr.tech.api;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.BaseCreativeTab;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import nepjr.tech.NTTags;
import nepjr.tech.api.block.*;
import nepjr.tech.api.unification.material.NTMaterials;
import net.minecraft.block.state.IBlockState;

public class NepTechAPI 
{
	public static final Object2ObjectMap<IBlockState, IFertilizedDirtBlockStats> FERTILIZED_DIRTS = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, IMixingModuleStats> MIXING_MODULES = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, ILaserFociStats> LASER_FOCI = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, IBeamSplitterStats> BEAM_SPLITTER = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, ICrushingWheelStats> CRUSHING_WHEELS = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, ICentrifugingMotorStats> CENTRIFUGING_MOTORS = new Object2ObjectOpenHashMap<>();
	public static final Object2ObjectMap<IBlockState, IMetalworkingModuleStats> METALWORKING_MODULES = new Object2ObjectOpenHashMap<>();
	
	public static final BaseCreativeTab TAB_NEPTECH = new BaseCreativeTab(NTTags.MODID + ".main",
            () -> OreDictUnifier.get(OrePrefix.ingot, NTMaterials.Wyvernium), true);
}
