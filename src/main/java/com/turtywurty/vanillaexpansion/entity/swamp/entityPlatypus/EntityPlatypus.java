package com.turtywurty.vanillaexpansion.entity.swamp.entityPlatypus;

import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

public class EntityPlatypus extends EntityAnimal
{
	public EntityPlatypus(World worldIn) 
	{
		super(worldIn);
		this.setSize(0.6F, 0.7F);
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5f));
		this.tasks.addTask(2, new EntityAIMate(this, 0.8D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		EntityPlatypus entityPlatypus = new EntityPlatypus(this.world);
		return entityPlatypus;
	}

	public static void registerFixesSandCat(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityPlatypus.class);
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }
}
