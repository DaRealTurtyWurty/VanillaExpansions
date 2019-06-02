package com.turtywurty.vanillaexpansion.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.storage.WorldInfo;

public class WorldTypeVanillaOverhaul extends WorldType
{
	public WorldTypeVanillaOverhaul(String name) 
	{
		super(name);
	}
	
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) 
	{
		return new GenLayerOverhaul(worldSeed);
	}
}
