package com.turtywurty.vanillaexpansion.init;

import com.turtywurty.vanillaexpansion.world.desert.BiomeNewDesert;
import com.turtywurty.vanillaexpansion.world.desert.BiomeRedDesert;
import com.turtywurty.vanillaexpansion.world.forests.BiomeNewForest;
import com.turtywurty.vanillaexpansion.world.jungle.BiomeNewJungle;
import com.turtywurty.vanillaexpansion.world.plains.BiomeNewPlains;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome NEW_DESERT = new BiomeNewDesert();
	public static final Biome NEW_PLAINS = new BiomeNewPlains();
	public static final Biome NEW_JUNGLE = new BiomeNewJungle(false);
	public static final Biome NEW_JUNGLE_EDGE = new BiomeNewJungle(true);
	public static final Biome NEW_FOREST_NORMAL = new BiomeNewForest(BiomeNewForest.Type.NORMAL);
	public static final Biome NEW_FOREST_FLOWER = new BiomeNewForest(BiomeNewForest.Type.FLOWER);
	public static final Biome NEW_FOREST_BIRCH = new BiomeNewForest(BiomeNewForest.Type.BIRCH);
	public static final Biome NEW_FOREST_ROOFED = new BiomeNewForest(BiomeNewForest.Type.ROOFED);
	public static final Biome RED_DESERT = new BiomeRedDesert();
	
	public static void registerBiomes()
	{
		initBiome(NEW_DESERT, "New Desert", BiomeType.DESERT, Type.HOT, Type.DRY, Type.SANDY);
		initBiome(NEW_PLAINS, "New Plains", BiomeType.COOL, Type.PLAINS);
		initBiome(NEW_JUNGLE, "New Jungle", BiomeType.WARM, Type.LUSH, Type.JUNGLE, Type.DENSE, Type.WET);
		initBiome(NEW_JUNGLE_EDGE, "New Jungle Edge", BiomeType.WARM, Type.LUSH, Type.JUNGLE, Type.DENSE, Type.WET);
		initBiome(NEW_FOREST_NORMAL, "New Forest", BiomeType.COOL, Type.LUSH, Type.DENSE, Type.FOREST, Type.SPOOKY);
		initBiome(NEW_FOREST_FLOWER, "New Flower Forest", BiomeType.COOL, Type.LUSH, Type.DENSE, Type.FOREST, Type.SPOOKY);
		initBiome(NEW_FOREST_BIRCH, "New Birch Forest", BiomeType.COOL, Type.LUSH, Type.DENSE, Type.FOREST, Type.SPOOKY);
		initBiome(NEW_FOREST_ROOFED, "New Roofed Forest", BiomeType.COOL, Type.LUSH, Type.DENSE, Type.FOREST, Type.SPOOKY);
		initBiome(RED_DESERT, "Red Desert", BiomeType.DESERT, Type.HOT, Type.DRY, Type.SANDY);
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
