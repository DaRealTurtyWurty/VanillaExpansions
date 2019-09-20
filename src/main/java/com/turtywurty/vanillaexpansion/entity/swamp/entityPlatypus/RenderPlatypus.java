package com.turtywurty.vanillaexpansion.entity.swamp.entityPlatypus;

import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCat.ModelSandCat;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlatypus extends RenderLiving<EntityPlatypus>
{
	private static final ResourceLocation PLATYPUS_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/platypus/platypus.png");

    public RenderPlatypus(RenderManager manager)
    {
        super(manager, new ModelPlatypus(), 0.4F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityPlatypus entity)
    {
        return PLATYPUS_TEXTURES;
    }
}
