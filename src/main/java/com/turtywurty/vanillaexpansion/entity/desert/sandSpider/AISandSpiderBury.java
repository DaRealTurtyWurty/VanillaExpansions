package com.turtywurty.vanillaexpansion.entity.desert.sandSpider;

import java.util.Random;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSandSpider;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AISandSpiderBury extends EntityAIWander
{
	private EnumFacing facing;
    private boolean doMerge;
    Random rand = new Random();

    public AISandSpiderBury(EntitySandSpider sandSpider)
    {
        super(sandSpider, 1.0D, 10);
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.getAttackTarget() != null)
        {
            return false;
        }
        else if (!this.entity.getNavigator().noPath())
        {
            return false;
        }
        else
        {
            Random random = this.entity.getRNG();

            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entity.world, this.entity) && random.nextInt(10) == 0)
            {
                this.facing = EnumFacing.random(random);
                BlockPos blockpos = (new BlockPos(this.entity.posX, this.entity.posY + 0.5D, this.entity.posZ)).offset(this.facing);
                IBlockState iblockstate = this.entity.world.getBlockState(blockpos);

                if (BlockSandSpider.canContainSandSpider(iblockstate))
                {
                    this.doMerge = true;
                    return true;
                }
            }

            this.doMerge = false;
            return super.shouldExecute();
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return this.doMerge ? false : super.shouldContinueExecuting();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        if (!this.doMerge)
        {
            super.startExecuting();
        }
        else
        {
            World world = this.entity.world;
            BlockPos blockpos = (new BlockPos(this.entity.posX, this.entity.posY + 0.5D, this.entity.posZ)).offset(this.facing);
            IBlockState iblockstate = world.getBlockState(blockpos);

            if(BlockSandSpider.canContainSandSpider(iblockstate))
            {
                world.setBlockState(blockpos, BlockInit.SAND_SPIDER.getDefaultState());
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                double d2 = this.rand.nextGaussian() * 0.02D;
                double d3 = 10.0D;
                world.spawnParticle(EnumParticleTypes.FALLING_DUST, entity.posX + (double)(this.rand.nextFloat() * entity.width * 2.0F) - (double)entity.width - d0 * 10.0D, entity.posY + (double)(this.rand.nextFloat() * entity.height) - d1 * 10.0D, entity.posZ + (double)(this.rand.nextFloat() * entity.width * 2.0F) - (double)entity.width - d2 * 10.0D, d0, d1, d2);
                this.entity.setDead();
            }
        }
    }
}

class AISummonSandSpider extends EntityAIBase
{
    private final EntitySandSpider sandSpider;
    private int lookForFriends;

    public AISummonSandSpider(EntitySandSpider sandSpider)
    {
        this.sandSpider = sandSpider;
    }

    public void notifyHurt()
    {
        if (this.lookForFriends == 0)
        {
            this.lookForFriends = 50;
        }
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.lookForFriends > 0;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        --this.lookForFriends;

        if (this.lookForFriends <= 0)
        {
            World world = this.sandSpider.world;
            Random random = this.sandSpider.getRNG();
            BlockPos blockpos = new BlockPos(this.sandSpider);

            for (int i = 0; i <= 5 && i >= -5; i = (i <= 0 ? 1 : 0) - i)
            {
                for (int j = 0; j <= 10 && j >= -10; j = (j <= 0 ? 1 : 0) - j)
                {
                    for (int k = 0; k <= 10 && k >= -10; k = (k <= 0 ? 1 : 0) - k)
                    {
                        BlockPos blockpos1 = blockpos.add(j, i, k);
                        IBlockState iblockstate = world.getBlockState(blockpos1);

                        if (iblockstate.getBlock() == BlockInit.SAND_SPIDER && !world.isDaytime())
                        {
                            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, this.sandSpider))
                            {
                                world.destroyBlock(blockpos1, true);
                            }
                            else
                            {
                                world.setBlockState(blockpos1, BlockInit.SAND_SPIDER.getDefaultState());
                            }

                            if (random.nextBoolean())
                            {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}