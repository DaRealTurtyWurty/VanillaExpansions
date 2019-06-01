package com.turtywurty.vanillaexpansion.entity.desert.sandCat;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSandCat extends RenderLiving<EntitySandCat>
{
	private static final ResourceLocation SAND_CAT_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sandcat/sand_cat.png");

    public RenderSandCat(RenderManager manager)
    {
        super(manager, new ModelSandCat(), 0.4F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySandCat entity)
    {
        return SAND_CAT_TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntitySandCat sandCat, float partialTickTime)
    {
        super.preRenderCallback(sandCat, partialTickTime);

        if (sandCat.isTamed())
        {
            GlStateManager.scale(0.8F, 0.8F, 0.8F);
        }
    }
}
