package com.turtywurty.vanillaexpansion.world.savanna;

import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;

public class BiomeNewSavanna extends Biome
{
	private static final WorldGenSavannaTree SAVANNA_TREE = new WorldGenSavannaTree(false);

    public BiomeNewSavanna(BiomeProperties properties)
    {
        super(new BiomeProperties("NewSavanna").setBaseHeight(0.5f).setHeightVariation(0.1f).setRainDisabled().setTemperature(0.8f));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 1, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDonkey.class, 1, 1, 1));

        if (this.getBaseHeight() > 1.1F)
        {
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityLlama.class, 8, 4, 4));
        }

        this.decorator.treesPerChunk = 1;
        this.decorator.flowersPerChunk = 4;
        this.decorator.grassPerChunk = 20;
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(5) > 0 ? SAVANNA_TREE : TREE_FEATURE);
    }

    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
        for (int i = 0; i < 7; ++i)
        {
            int j = rand.nextInt(16) + 8;
            int k = rand.nextInt(16) + 8;
            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
            DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
        }

        super.decorate(worldIn, rand, pos);
    }

    public Class <? extends Biome > getBiomeClass()
    {
        return BiomeNewSavanna.class;
    }
    
    @Override
    public int getModdedBiomeGrassColor(int original) 
    {
    	return 13234560;
    }
}
