package com.turtywurty.vanillaexpansion.entity.underground;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPebble extends EntityThrowable 
{
	public EntityPebble(World worldIn) 
	{
		super(worldIn);
	}

	public EntityPebble(World worldIn, EntityLivingBase throwerIn) 
	{
		super(worldIn, throwerIn);
	}

	public EntityPebble(World worldIn, double x, double y, double z) 
	{
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) 
	{
		if (!this.world.isRemote) 
		{
			setDead();
			if(result.entityHit instanceof EntityLiving)
			{
				result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), rand.nextFloat());
			}
		}
	}
}
