package com.turtywurty.vanillaexpansion.world.desert;

import java.util.List;
import java.util.Random;

import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCreeper.EntitySandCreeper;
import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.EntitySandySkeleton;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class BiomeNewDesert extends Biome
{
	protected static final IBlockState WATER = Blocks.AIR.getDefaultState();
	public BiomeNewDesert()
    {
		super(new BiomeProperties("NewDesert").setBaseHeight(0.1F).setHeightVariation(0.01F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());
		
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        
        this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 60, 1, 8));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySandSpider.class, 50, 2, 10));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySandySkeleton.class, 40, 2, 15));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySandCreeper.class, 40, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySandCat.class, 30, 2, 5));
        
        this.decorator.treesPerChunk = -999;
        this.decorator.deadBushPerChunk = -999;
        this.decorator.reedsPerChunk = 7;
        this.decorator.cactiPerChunk = 5;
    }

	@Override
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.DESERT_WELL))
        if (rand.nextInt(1000) == 0)
        {
            int i = rand.nextInt(16) + 8;
            int j = rand.nextInt(16) + 8;
            BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
            (new WorldGenDesertWells()).generate(worldIn, rand, blockpos);
        }

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FOSSIL))
        if (rand.nextInt(10) == 0)
        {
            (new WorldGenFossils()).generate(worldIn, rand, pos);
        }
    }
	
	@Override
	public int getModdedBiomeGrassColor(int original) 
	{
		return 14533776;
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) 
	{
		return 26879;
	}
}	
