package com.turtywurty.vanillaexpansion.init;

import com.turtywurty.vanillaexpansion.world.desert.BiomeNewDesert;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome NEW_DESERT = new BiomeNewDesert();
	
	public static void registerBiomes()
	{
		initBiome(NEW_DESERT, "New Desert", BiomeType.DESERT, Type.HOT, Type.DRY, Type.SANDY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType 	bType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
