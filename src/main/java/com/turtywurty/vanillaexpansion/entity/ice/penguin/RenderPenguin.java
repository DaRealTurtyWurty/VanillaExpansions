package com.turtywurty.vanillaexpansion.entity.ice.penguin;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPenguin extends RenderLiving<EntityPenguin>
{
	public RenderPenguin(RenderManager rendermanagerIn) 
	{
		super(rendermanagerIn, new ModelPenguin(), 0.3f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPenguin entity) 
	{
		return new ResourceLocation(Reference.MOD_ID + ":textures/entity/penguin/penguin.png");
	}

}
