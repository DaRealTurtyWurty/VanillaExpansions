package com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver;

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

public class EntityBeaver extends EntityAnimal
{
	public EntityBeaver(World worldIn) 
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
		EntityBeaver entityBeaver = new EntityBeaver(this.world);
		return entityBeaver;
	}

	public static void registerFixesSandCat(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityBeaver.class);
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(13.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.12D);
    }
}
