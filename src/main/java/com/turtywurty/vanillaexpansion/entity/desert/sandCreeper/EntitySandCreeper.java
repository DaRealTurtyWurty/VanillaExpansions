package com.turtywurty.vanillaexpansion.entity.desert.sandCreeper;

import com.turtywurty.vanillaexpansion.init.BiomeInit;
import com.turtywurty.vanillaexpansion.world.desert.BiomeNewDesert;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySandCreeper extends EntityCreeper
{
	private int lastActiveTime;
	private int timeSinceIgnited;
    private int fuseTime = 30;
    int y, xz;
    
	public EntitySandCreeper(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.7F);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICreeperSwell(this));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.21D);
    }
    
    private void explode()
    {
        if(!this.world.isRemote)
        {    	
           boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
           float f = this.getPowered() ? 2.0F : 1.0F;
           this.dead = true;
           this.buildsand((int) this.posX, (int) this.posY, (int) this.posZ, this.getPowered() ? 20 : 10, this.world);
           this.setDead();
    	}
    }
    
    protected void buildsand(int ox, int oy, int oz, int height, World par1World) 
    {
    	int blockX, blockY, blockZ;
        int searchRange = height * 2;
        for (int x = -1 * searchRange; x < searchRange; ++x) 
        {
            blockX = x + ox;
            for (int y = (int) (-0.25 * searchRange); y < (int) (0.25 * searchRange); ++y) 
            {
                blockY = y + oy;
                for (int z = -1 * searchRange; z < searchRange; ++z) 
                {
                    blockZ = z + oz;

                    BlockPos pos = new BlockPos(blockX, blockY, blockZ);
                    if (par1World.getBlockState(pos).getBlockHardness(world, pos) != -1 && !world.isRemote) 
                    {
                        this.world.setBlockState(pos, Blocks.SAND.getDefaultState());
                    }
                }
            }
        }
    }
    
    public void onUpdate()
    {
        if (this.isEntityAlive())
        {
            this.lastActiveTime = this.timeSinceIgnited;

            if (this.hasIgnited())
            {
                this.setCreeperState(1);
            }

            int i = this.getCreeperState();

            if (i > 0 && this.timeSinceIgnited == 0)
            {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;

            if (this.timeSinceIgnited < 0)
            {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime)
            {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }

        super.onUpdate();
    }
}
