package com.turtywurty.vanillaexpansion.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBounceBall extends EntityThrowable
{
	public EntityBounceBall(World worldIn) 
	{
		super(worldIn);
	}

	public EntityBounceBall(World worldIn, EntityLivingBase throwerIn) 
	{
		super(worldIn, throwerIn);
	}

	public EntityBounceBall(World worldIn, double x, double y, double z) 
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) 
	{
		if(result.typeOfHit == RayTraceResult.Type.BLOCK) 
		{
			Vec3d sideDirectionVector = new Vec3d(result.sideHit.getDirectionVec());
			Vec3d motionVector = new Vec3d(this.motionX, this.motionY, this.motionZ).scale(0.7D);
			Vec3d reflectionVector = calculateReflection(motionVector, sideDirectionVector);
			this.motionX = reflectionVector.x;
			this.motionY = reflectionVector.y;
			this.motionZ = reflectionVector.z;

			Vec3d hitVec = result.hitVec;
			RayTraceResult reflectedRayTraceResult = rayTraceReflection(getPositionVector(), hitVec, reflectionVector);
			this.posX = hitVec.x;
			this.posY = hitVec.y;
			this.posZ = hitVec.z;

			// Make sure we won't go into another block (like could happen if we hit a corner)
			if(reflectedRayTraceResult != null && reflectedRayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) 
			{
				// We can't go this way, so switch to reversing the original motion
				this.motionX = -motionVector.x;
				this.motionY = -motionVector.y;
				this.motionZ = -motionVector.z;
			}
			
			if((this.posX == this.lastTickPosX && this.posX == this.prevPosX) || (this.posZ == this.lastTickPosZ && this.posZ == this.prevPosZ))
			{
				this.setDead();
			}
		}
	}
	
	public static Vec3d calculateReflection(Vec3d incoming, Vec3d normal) 
	{
		// Most reflections will be for simple normals, so lets have shortcuts for them
		if(Math.abs(normal.x) == 1)
		{
			return new Vec3d(-incoming.x, incoming.y, incoming.z);
		}

		if(Math.abs(normal.y) == 1)
		{
			return new Vec3d(incoming.x, -incoming.y, incoming.z);
		}

		if(Math.abs(normal.z) == 1)
		{
			return new Vec3d(incoming.x, incoming.y, -incoming.z);
		}

		// r = d - 2(d*n)n
		return incoming.subtract(normal.scale(2 * normal.dotProduct(incoming)));
	}

	private RayTraceResult rayTraceReflection(Vec3d position, Vec3d hitPosition, Vec3d reflectionVector) 
	{
		Vec3d positionAfterMotion = hitPosition.add(reflectionVector);
		return this.world.rayTraceBlocks(position, positionAfterMotion);
	}

}
