package xyz.nepjr.tech.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;
import xyz.nepjr.tech.api.block.IFertilizedDirtBlockStats;

public class NepTechAPI 
{
	public static final Object2ObjectMap<IBlockState, IFertilizedDirtBlockStats> FERTILIZED_DIRTS = new Object2ObjectOpenHashMap<>();
}
