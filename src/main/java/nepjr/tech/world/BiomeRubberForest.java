package nepjr.tech.world;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeRubberForest extends BiomeForest
{
	protected static final WorldGenLargeRubberTree ROOF_TREE = new WorldGenLargeRubberTree(false);
	public BiomeRubberForest() 
	{
		super(BiomeForest.Type.ROOFED, new Biome.BiomeProperties("Rubber Forest").setTemperature(0.7F).setRainfall(0.8F));
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
		return ROOF_TREE;
    }
}
