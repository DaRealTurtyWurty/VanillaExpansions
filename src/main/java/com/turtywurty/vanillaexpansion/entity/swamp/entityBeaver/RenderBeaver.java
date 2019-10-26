package com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver;

import java.util.Random;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBeaver extends RenderLiving<EntityBeaver>
{
	private static final ResourceLocation BEAVER_TEXTURE1 = new ResourceLocation(Reference.MOD_ID + ":textures/entity/beaver/beaver2.png");
	private static final ResourceLocation BEAVER_TEXTURE2 = new ResourceLocation(Reference.MOD_ID + ":textures/entity/beaver/beaver3.png");

    public RenderBeaver(RenderManager manager)
    {
        super(manager, new ModelBeaver(), 0.4F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityBeaver entity)
    {
    	if(entity.TYPE == 0)
    	{
    		return BEAVER_TEXTURE1;
    	}
    	else
    	{
    		return BEAVER_TEXTURE2;
    	}
    }
}
