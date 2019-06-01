package com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton;

import com.turtywurty.vanillaexpansion.entity.desert.sandArrow.EntitySandArrow;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySandySkeleton extends AbstractSkeleton
{
	private final EntityAIAttackRangedSandBow<EntitySandySkeleton> aiArrowAttack = new EntityAIAttackRangedSandBow<EntitySandySkeleton>(this, 1.0D, 20, 15.0F);
    
    public EntitySandySkeleton(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.99F);
        this.setCombatTask();
    }
    
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityWolf.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTargetSandSkeleton(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }
    
    public static void registerFixesSkeleton(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntitySandySkeleton.class);
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24D);
    }

    protected EntityArrow getArrow(float p_190726_1_)
    {
        EntitySandArrow entityarrow = new EntitySandArrow(this.world, this);
        return entityarrow;
    }
    
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemInit.SAND_BOW));
    }

	@Override
	protected SoundEvent getStepSound() 
	{
		return SoundEvents.ENTITY_SKELETON_STEP;
	}
	
	public void setCombatTask()
    {
        Entity entity = this;
        if (this.world != null && !this.world.isRemote)
        {
            this.tasks.removeTask(this.aiArrowAttack);
            ItemStack itemstack = this.getHeldItemMainhand();

            if (itemstack.getItem() == ItemInit.SAND_BOW)
            {
                int i = 20;

                if (this.world.getDifficulty() != EnumDifficulty.HARD)
                {
                    i = 40;
                }

                this.aiArrowAttack.setAttackCooldown(i);
                this.tasks.addTask(4, this.aiArrowAttack);
            }
        }
    }

	private class EntityAIHurtByTargetSandSkeleton extends EntityAITarget
	{
		private final boolean entityCallsForHelp;
	    /** Store the previous revengeTimer value */
	    private int revengeTimerOld;
	    private final Class<?>[] excludedReinforcementTypes;

	    public EntityAIHurtByTargetSandSkeleton(EntityCreature creatureIn, boolean entityCallsForHelpIn, Class<?>... excludedReinforcementTypes)
	    {
	        super(creatureIn, true);
	        this.entityCallsForHelp = entityCallsForHelpIn;
	        this.excludedReinforcementTypes = excludedReinforcementTypes;
	        this.setMutexBits(1);
	    }

	    /**
	     * Returns whether the EntityAIBase should begin execution.
	     */
	    public boolean shouldExecute()
	    {
	    	Entity entity = this.taskOwner.getAttackingEntity();
	    	if(!(entity instanceof EntitySandySkeleton))
	    	{
	    		int i = this.taskOwner.getRevengeTimer();
	    		EntityLivingBase entitylivingbase = this.taskOwner.getRevengeTarget();
	    		return i != this.revengeTimerOld && entitylivingbase != null && this.isSuitableTarget(entitylivingbase, false);
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }

	    /**
	     * Execute a one shot task or start executing a continuous task
	     */
	    public void startExecuting()
	    {
	    	Entity entity = this.taskOwner.getAttackingEntity();
	    	if(!(entity instanceof EntitySandySkeleton))
	    	{
	    		this.taskOwner.setAttackTarget(this.taskOwner.getRevengeTarget());
		        this.target = this.taskOwner.getAttackTarget();
		        this.revengeTimerOld = this.taskOwner.getRevengeTimer();
		        this.unseenMemoryTicks = 300;

		        if (this.entityCallsForHelp)
		        {
		            this.alertOthers();
		        }

		        super.startExecuting();
	    	}
	    }

	    protected void alertOthers()
	    {
	        double d0 = this.getTargetDistance();

	        for (EntityCreature entitycreature : this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), (new AxisAlignedBB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D)).grow(d0, 10.0D, d0)))
	        {
	            if (this.taskOwner != entitycreature && entitycreature.getAttackTarget() == null && (!(this.taskOwner instanceof EntityTameable) || ((EntityTameable)this.taskOwner).getOwner() == ((EntityTameable)entitycreature).getOwner()) && !entitycreature.isOnSameTeam(this.taskOwner.getRevengeTarget()))
	            {
	                boolean flag = false;

	                for (Class<?> oclass : this.excludedReinforcementTypes)
	                {
	                    if (entitycreature.getClass() == oclass)
	                    {
	                        flag = true;
	                        break;
	                    }
	                }

	                if (!flag)
	                {
	                    this.setEntityAttackTarget(entitycreature, this.taskOwner.getRevengeTarget());
	                }
	            }
	        }
	    }

	    protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
	    {
	    	Entity entity = this.taskOwner.getAttackingEntity();
	    	if(!(entity instanceof EntitySandySkeleton))
	    	{
	    		creatureIn.setAttackTarget(entityLivingBaseIn);
	    	}
	    }
	}
}
