package com.turtywurty.vanillaexpansion.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBounceBallTeleport2 extends EntityThrowable
{
	private int hits = 0;
	public EntityBounceBallTeleport2(World worldIn) 
	{
		super(worldIn);
	}

	public EntityBounceBallTeleport2(World worldIn, EntityLivingBase throwerIn) 
	{
		super(worldIn, throwerIn);
	}

	public EntityBounceBallTeleport2(World worldIn, double x, double y, double z) 
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) 
	{
		EntityLivingBase entitylivingbase = this.getThrower();
		if(this.hits != 2)
		{
			if(result.typeOfHit == RayTraceResult.Type.BLOCK) 
			{
				hits++;
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
			}
		}
		
		else
		{
			if (result.typeOfHit == RayTraceResult.Type.BLOCK)
	        {
	            BlockPos blockpos = result.getBlockPos();
	            TileEntity tileentity = this.world.getTileEntity(blockpos);

	            if (tileentity instanceof TileEntityEndGateway)
	            {
	                TileEntityEndGateway tileentityendgateway = (TileEntityEndGateway)tileentity;

	                if (entitylivingbase != null)
	                {
	                    if (entitylivingbase instanceof EntityPlayerMP)
	                    {
	                        CriteriaTriggers.ENTER_BLOCK.trigger((EntityPlayerMP)entitylivingbase, this.world.getBlockState(blockpos));
	                    }

	                    tileentityendgateway.teleportEntity(entitylivingbase);
	                    this.setDead();
	                    return;
	                }

	                tileentityendgateway.teleportEntity(this);
	                return;
	            }
	        }
			
			for (int i = 0; i < 32; ++i)
	        {
	            this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
	        }
            
			if (!this.world.isRemote)
	        {
	            if (entitylivingbase instanceof EntityPlayerMP)
	            {
	                EntityPlayerMP entityplayermp = (EntityPlayerMP)entitylivingbase;

	                if (entityplayermp.connection.getNetworkManager().isChannelOpen() && entityplayermp.world == this.world && !entityplayermp.isPlayerSleeping())
	                {
	                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
	                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
	                    { // Don't indent to lower patch size
	                    if (this.rand.nextFloat() < 0.05F && this.world.getGameRules().getBoolean("doMobSpawning"))
	                    {
	                    	EntityEndermite entityendermite = new EntityEndermite(this.world);
	                        entityendermite.setSpawnedByPlayer(true);
	                        entityendermite.setLocationAndAngles(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, entitylivingbase.rotationYaw, entitylivingbase.rotationPitch);
	                        this.world.spawnEntity(entityendermite);
	                    }
	                    	
	                    if (entitylivingbase.isRiding())
	                    {
	                        entitylivingbase.dismountRidingEntity();
	                    }

	                    entitylivingbase.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
	                    entitylivingbase.fallDistance = 0.0F;
	                    entitylivingbase.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
	                    }
	                }
	            }
	            else if (entitylivingbase != null)
	            {
	                entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
	                entitylivingbase.fallDistance = 0.0F;
	            }

	            this.setDead();
	        }
		}
	}
	
	public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();
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
