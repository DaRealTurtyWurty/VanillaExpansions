package com.turtywurty.vanillaexpansion.particles;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ParticleTest extends Particle
{
	float testParticleScale;

    protected ParticleTest(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double speedX, double speedY, double speedZ)
    {
        this(worldIn, xCoordIn, yCoordIn, zCoordIn, speedX, speedY, speedZ, 2.0F);
    }

    protected ParticleTest(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double speedX, double speedY, double speedZ, float scale)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.009999999776482582D;
        this.motionY *= 0.009999999776482582D;
        this.motionZ *= 0.009999999776482582D;
        this.motionY += 0.2D;
        this.particleRed = MathHelper.sin(((float)speedX + 0.0F) * ((float)Math.PI * 2F)) * 0.65F + 0.35F;
        this.particleGreen = MathHelper.sin(((float)speedX + 0.33333334F) * ((float)Math.PI * 2F)) * 0.65F + 0.35F;
        this.particleBlue = MathHelper.sin(((float)speedX + 0.6666667F) * ((float)Math.PI * 2F)) * 0.65F + 0.35F;
        this.particleScale *= 0.75F;
        this.particleScale *= scale;
        this.testParticleScale = this.particleScale;
        this.particleMaxAge = 6;
    }
    
    @Override
    public void setParticleTexture(TextureAtlasSprite texture) 
    {
    	
    }

    /**
     * Renders the particle
     */
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge * 32.0F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        this.particleScale = this.testParticleScale * f;
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setExpired();
        }

        this.move(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.6600000262260437D;
        this.motionY *= 0.6600000262260437D;
        this.motionZ *= 0.6600000262260437D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }

    @SideOnly(Side.CLIENT)
    public static class Factory implements IParticleFactory
        {
            public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... params)
            {
                return new ParticleTest(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
            }
        }
}
