package com.turtywurty.vanillaexpansion.entity.swamp.entitySkeeter;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAISkeeterSwell extends EntityAIBase
{
    /** The skeeter that is swelling. */
	EntitySkeeter swellingSkeeter;
    /** The skeeter's attack target. This is used for the changing of the skeeter's state. */
    EntityLivingBase skeeterAttackTarget;

    public EntityAISkeeterSwell(EntitySkeeter entityskeeterIn)
    {
        this.swellingSkeeter = entityskeeterIn;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingSkeeter.getAttackTarget();
        return this.swellingSkeeter.getSkeeterState() > 0 || entitylivingbase != null && this.swellingSkeeter.getDistanceSq(entitylivingbase) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.swellingSkeeter.getNavigator().clearPath();
        this.skeeterAttackTarget = this.swellingSkeeter.getAttackTarget();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.skeeterAttackTarget = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        if (this.skeeterAttackTarget == null)
        {
            this.swellingSkeeter.setSkeeterState(-1);
        }
        else if (this.swellingSkeeter.getDistanceSq(this.skeeterAttackTarget) > 49.0D)
        {
            this.swellingSkeeter.setSkeeterState(-1);
        }
        else if (!this.swellingSkeeter.getEntitySenses().canSee(this.skeeterAttackTarget))
        {
            this.swellingSkeeter.setSkeeterState(-1);
        }
        else
        {
            this.swellingSkeeter.setSkeeterState(1);
        }
    }
}