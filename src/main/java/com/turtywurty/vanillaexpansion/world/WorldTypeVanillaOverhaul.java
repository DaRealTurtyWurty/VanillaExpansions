package com.turtywurty.vanillaexpansion.world;

import com.turtywurty.vanillaexpansion.init.BiomeInit;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeVanillaOverhaul extends WorldType
{
	public WorldTypeVanillaOverhaul(String name) 
	{
		super(name);
	}

	@Override
	public BiomeProvider getBiomeProvider(World world) 
	{
		BiomeProvider provider = new BiomeProviderSingle(BiomeInit.NEW_DESERT);
		return provider;
	}
}
