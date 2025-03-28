package com.turtywurty.vanillaexpansion.world.desert.structures;

import java.util.Random;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.util.interfaces.IStructure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSandRock extends WorldGenerator implements IStructure
{
	private Block block;
	public static String structureName;
    private final int startRadius;

	public WorldGenSandRock(String name, int startRadiusIn, Block blockIn) 
	{
		super(false);
		this.structureName = name;
		this.block = blockIn;
        this.startRadius = startRadiusIn;
	}

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        while (true)
        {
            label50:
            {
                if (position.getY() > 3)
                {
                    if (worldIn.isAirBlock(position.down()))
                    {
                        break label50;
                    }

                    Block block = worldIn.getBlockState(position.down()).getBlock();

                    if(block != Blocks.SAND)
                    {
                        break label50;
                    }
                }

                if (position.getY() <= 3)
                {
                    return false;
                }

                int i1 = this.startRadius;

                for (int i = 0; i1 >= 0 && i < 3; ++i)
                {
                    int j = i1 + rand.nextInt(2);
                    int k = i1 + rand.nextInt(2);
                    int l = i1 + rand.nextInt(2);
                    float f = (float)(j + k + l) * 0.333F + 0.5F;

                    for(BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -k, -l), position.add(j, k, l)))
                    {
                    	if(blockpos.distanceSq(position) <= (double)(f * f))
                        {
                            worldIn.setBlockState(blockpos, this.block.getDefaultState(), 4);
                        }
                    }
                    position = position.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2), -(i1 + 1) + rand.nextInt(2 + i1 * 2));
                }

                return true;
            }
            position = position.down();
        }
    }
}