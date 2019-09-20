package com.turtywurty.vanillaexpansion.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.turtywurty.vanillaexpansion.world.desert.BiomeNewDesert;
import com.turtywurty.vanillaexpansion.world.desert.structures.WorldGenSandRock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureInit implements IWorldGenerator
{
	public Block block;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(random.nextInt(2) == 0) 
		{
			generateStructure(new WorldGenSandRock("sand_rock", 0, BlockInit.SANDSTONE_WALL), world, random, chunkX, chunkZ, 1, Blocks.SAND, BiomeNewDesert.class);
		}
	    if(random.nextInt(2) == 1) 
	    {
	    	generateStructure(new WorldGenSandRock("sand_rock", 1, Blocks.SAND), world, random, chunkX, chunkZ, 1, Blocks.SAND, BiomeNewDesert.class);
	    }
	    if(random.nextInt(3) == 2) 
	    {
			generateStructure(new WorldGenSandRock("sand_rock", 0, Blocks.SANDSTONE), world, random, chunkX, chunkZ, 1, Blocks.SAND, BiomeNewDesert.class);
	    }
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(16) + 8;
		int z = (chunkZ * 16) + random.nextInt(16) + 8;
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					//System.out.println("The structure is at: " + x + ", " + y + ", " + z + " in " + biome);
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = block == topBlock;
		}
		return y+1;
	}
}
