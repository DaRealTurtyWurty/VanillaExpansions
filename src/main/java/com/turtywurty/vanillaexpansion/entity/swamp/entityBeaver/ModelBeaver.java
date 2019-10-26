package com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBeaver extends ModelBase
{
	private final ModelRenderer body;

	public ModelBeaver() 
	{
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 22, 4, -3.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -2.0F, 4.0F, 2, 2, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 22, 0, 1.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 4, 1.0F, -2.0F, 4.0F, 2, 2, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -8.0F, -4.0F, 6, 6, 10, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 16, -3.0F, -8.0F, -7.0F, 6, 5, 3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 15, 16, -1.5F, -5.0F, -8.0F, 3, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 8, -0.5F, -3.0F, -8.0F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 6, 0, 3.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 6, 4, -4.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 18, 18, -2.0F, -7.0F, 6.0F, 4, 1, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		body.render(f5);
		
		EntityBeaver beaver = (EntityBeaver)entity;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}