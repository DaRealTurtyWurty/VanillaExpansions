package com.turtywurty.vanillaexpansion.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class AbstractProjectile extends EntityThrowable
{
	public EntityLivingBase shootingEntity;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
    public AbstractProjectile(World worldIn) 
    {
        super(worldIn);
        this.setSize(0.3125F, 0.3125F);
    }
    
    protected float getGravityVelocity()
    {
        return 0.0F;
    }
    
    public AbstractProjectile(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }
    
    public AbstractProjectile(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn);
        this.shootingEntity = shooter;
        this.setSize(1.0F, 1.0F);
    }
    
    @Override
    public void onUpdate() 
    {
        super.onUpdate();
    }
 
    @Override
    protected void onImpact(RayTraceResult result) 
    {
    	if(!this.world.isRemote) 
    	{	
    		setDead();
    	}
    }
    
    @Override
    public boolean canBeCollidedWith() 
    {
    	return true;
    }
    
    @Override
    public boolean isBurning() 
    {
    	return false;
    }
}
