package com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver;

import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCat.ModelSandCat;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBeaver extends RenderLiving<EntityBeaver>
{
	private static final ResourceLocation BEAVER_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/beaver/beaver2.png");

    public RenderBeaver(RenderManager manager)
    {
        super(manager, new ModelBeaver(), 0.4F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBeaver entity)
    {
        return BEAVER_TEXTURES;
    }
}
