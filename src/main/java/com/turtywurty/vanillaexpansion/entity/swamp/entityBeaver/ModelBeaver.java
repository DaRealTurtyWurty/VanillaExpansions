package com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBeaver extends ModelBase 
{
	private final ModelRenderer bone;

	public ModelBeaver() 
	{
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 22, 4, -3.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -2.0F, 4.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 22, 0, 1.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, 1.0F, -2.0F, 4.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -8.0F, -4.0F, 6, 6, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -3.0F, -8.0F, -7.0F, 6, 5, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 15, 16, -1.5F, -5.0F, -8.0F, 3, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -0.5F, -3.0F, -8.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 6, 0, 3.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 6, 4, -4.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 18, -2.0F, -7.0F, 6.0F, 4, 1, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		bone.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}