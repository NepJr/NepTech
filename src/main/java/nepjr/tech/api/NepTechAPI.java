package nepjr.tech.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import nepjr.tech.api.block.*;
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
}
