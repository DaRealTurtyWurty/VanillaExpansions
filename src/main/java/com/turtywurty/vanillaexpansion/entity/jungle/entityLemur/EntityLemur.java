package com.turtywurty.vanillaexpansion.entity.jungle.entityLemur;

import com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver.EntityBeaver;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

public class EntityLemur extends EntityAnimal
{
	public EntityLemur(World worldIn) 
	{
		super(worldIn);
		this.setSize(0.6F, 0.7F);
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(1, new EntityAIWander(this, 0.5f));
		this.tasks.addTask(2, new EntityAIMate(this, 0.8D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(4, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIFleeSun(this, 0.4f));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		EntityLemur entityLemur = new EntityLemur(this.world);
		return entityLemur;
	}

	public static void registerFixesSandCat(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityLemur.class);
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22D);
    }
}
