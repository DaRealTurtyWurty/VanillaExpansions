package com.turtywurty.vanillaexpansion.entity.desert.entityMummy;

import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAIMummyAttack extends EntityAIAttackMelee
{
	private final EntityMummy mummy;
    private int raiseArmTicks;

    public EntityAIMummyAttack(EntityMummy mummyIn, double speedIn, boolean longMemoryIn)
    {
        super(mummyIn, speedIn, longMemoryIn);
        this.mummy = mummyIn;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        super.resetTask();
        this.mummy.setArmsRaised(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10)
        {
            this.mummy.setArmsRaised(true);
        }
        else
        {
            this.mummy.setArmsRaised(false);
        }
    }
}
