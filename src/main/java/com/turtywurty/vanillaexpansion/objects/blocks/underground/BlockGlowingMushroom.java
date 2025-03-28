package com.turtywurty.vanillaexpansion.objects.blocks.underground;

import java.util.Random;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowingMushroom extends BlockBush /*implements IGrowable*/
{	
	protected static final AxisAlignedBB GLOWING_MUSHROOM_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D);

    public BlockGlowingMushroom(String name)
    {
    	setUnlocalizedName(name);
    	setRegistryName(name);
        this.setTickRandomly(true);
        setLightLevel(0.9f);
        
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return GLOWING_MUSHROOM_AABB;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.spawnParticle(EnumParticleTypes.END_ROD, true, pos.getX(), pos.getY(), pos.getZ(), 0.0D, -0.1D, 0.0D);
        if (rand.nextInt(25) == 0)
        {
            int i = 5;
            int j = 4;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)))
            {
                if (worldIn.getBlockState(blockpos).getBlock() == this)
                {
                    --i;

                    if (i <= 0)
                    {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k)
            {
                if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState()))
                {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
            }
        }
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos, this.getDefaultState());
    }

    /**
     * Return true if the block can sustain a Bush
     */
    protected boolean canSustainBush(IBlockState state)
    {
        return state.isFullBlock();
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());

            if (iblockstate.getBlock() == Blocks.STONE)
            {
                return true;
            }
            else if(iblockstate.getBlock() == BlockInit.HARDENED_STONE || iblockstate.getBlock() == BlockInit.SOFT_STONE || iblockstate.getBlock() == Blocks.DIRT)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /*public boolean generateBigMushroom(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        worldIn.setBlockToAir(pos);
        WorldGenerator worldgenerator = null;

        if (this == Blocks.BROWN_MUSHROOM)
        {
            worldgenerator = new WorldGenBigMushroom(Blocks.BROWN_MUSHROOM_BLOCK);
        }
        else if (this == Blocks.RED_MUSHROOM)
        {
            worldgenerator = new WorldGenBigMushroom(Blocks.RED_MUSHROOM_BLOCK);
        }

        if (worldgenerator != null && worldgenerator.generate(worldIn, rand, pos))
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(pos, state, 3);
            return false;
        }
    }*/

    /*//Whether this IGrowable can grow
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)rand.nextFloat() < 0.4D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.generateBigMushroom(worldIn, pos, state, rand);
    }*/
}
