package com.turtywurty.vanillaexpansion.entity.swamp.entitySkeeter;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSkeeter extends RenderLiving<EntitySkeeter>
{
    private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skeeter/skeeter.png");

    public RenderSkeeter(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSkeeter(), 0.5F);
        this.addLayer(new LayerSkeeterCharge(this));
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntitySkeeter entitylivingbaseIn, float partialTickTime)
    {
        float f = entitylivingbaseIn.getSkeeterFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scale(f2, f3, f2);
    }

    /**
     * Gets an RGBA int color multiplier to apply.
     */
    protected int getColorMultiplier(EntitySkeeter entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        float f = entitylivingbaseIn.getSkeeterFlashIntensity(partialTickTime);

        if ((int)(f * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int i = (int)(f * 0.2F * 255.0F);
            i = MathHelper.clamp(i, 0, 255);
            return i << 24 | 822083583;
        }
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySkeeter entity)
    {
        return CREEPER_TEXTURES;
    }
}
