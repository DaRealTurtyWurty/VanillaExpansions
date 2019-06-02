package com.turtywurty.vanillaexpansion.world.plains;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeNewPlains extends BiomePlains
{
	Random rand = new Random();
	public BiomeNewPlains() 
	{
		super(false, new BiomeProperties("NewPlains").setBaseHeight(0.0f).setHeightVariation(0.0001f).setTemperature(0.5f).setRainfall(0.3f));
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.decorator.treesPerChunk = Integer.MIN_VALUE + 1;
		this.decorator.extraTreeChance = Float.MIN_VALUE + 0.1f;
		this.decorator.flowersPerChunk = rand.nextInt(15) + 5;
		this.decorator.reedsPerChunk = rand.nextInt(6) + 1;
		this.decorator.grassPerChunk = rand.nextInt(1) + 2;
		this.decorator.deadBushPerChunk = rand.nextInt(3);
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) 
	{
		currentTemperature = currentTemperature / 3.0F;
        currentTemperature = MathHelper.clamp(currentTemperature, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - currentTemperature * 0.05F, 0.5F + currentTemperature * 0.1F, 1.0F);
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) 
	{
		return null;
	}
}
