package com.turtywurty.vanillaexpansion.world;

import com.turtywurty.vanillaexpansion.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOverhaul extends GenLayer
{
	private Biome[] allowedBiomes = {BiomeInit.NEW_DESERT, BiomeInit.NEW_PLAINS, BiomeInit.NEW_JUNGLE, BiomeInit.NEW_JUNGLE_EDGE, BiomeInit.NEW_FOREST_BIRCH, BiomeInit.NEW_FOREST_FLOWER, BiomeInit.NEW_FOREST_NORMAL, BiomeInit.NEW_FOREST_ROOFED, BiomeInit.RED_DESERT};
	public GenLayerOverhaul(long seed) 
	{
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) 
	{
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) 
		{
			for (int dx = 0; dx < width; dx++) 
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
	
	public Biome[] getAllowedBiomes() 
	{
		return allowedBiomes;
	}
}
