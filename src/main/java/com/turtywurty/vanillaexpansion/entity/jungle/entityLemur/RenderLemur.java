package com.turtywurty.vanillaexpansion.entity.jungle.entityLemur;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLemur extends RenderLiving<EntityLemur>
{
	private static final ResourceLocation LEMUR_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/lemur/lemur.png");
	
	public RenderLemur(RenderManager rendermanagerIn) 
	{
		super(rendermanagerIn, new ModelLemur(), 0.4f);
	}

	/**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(EntityLemur entity) 
	{
		return LEMUR_TEXTURES;
	}
}
