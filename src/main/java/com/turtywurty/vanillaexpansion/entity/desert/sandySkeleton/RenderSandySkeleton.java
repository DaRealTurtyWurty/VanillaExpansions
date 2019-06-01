package com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerStrayClothing;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSandySkeleton extends RenderBiped<EntitySandySkeleton>
{
    private static final ResourceLocation SANDYSKELETON_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sandyskeleton/sandy_skeleton.png");

    public RenderSandySkeleton(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSandySkeleton(), 0.5F);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerSandySkeletonClothing(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelSandySkeleton(0.5F, true);
                this.modelArmor = new ModelSandySkeleton(1.0F, true);
            }
        });
    }

    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySandySkeleton entity)
    {
        return SANDYSKELETON_TEXTURES;
    }
}