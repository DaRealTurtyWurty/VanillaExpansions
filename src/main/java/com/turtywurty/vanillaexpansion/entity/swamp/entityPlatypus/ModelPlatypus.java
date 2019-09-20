package com.turtywurty.vanillaexpansion.entity.swamp.entityPlatypus;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelPlatypus extends ModelBase 
{
	private final ModelRenderer bone;

	public ModelPlatypus() 
	{
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 3, 3.0F, -2.0F, -3.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 11, 13, 3.0F, -0.01F, -4.0F, 2, 0, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -2.0F, -3.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 15, 13, -5.0F, -0.01F, -4.0F, 2, 0, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 0, 3.0F, -2.0F, 2.0F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -0.01F, 1.0F, 2, 0, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -4.0F, -2.0F, 2.0F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -5.0F, -0.01F, 1.0F, 2, 0, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -6.0F, -4.0F, 6, 5, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 16, 16, -2.5F, -5.5F, -7.0F, 5, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -2.0F, -2.0F, 4.0F, 4, 1, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 20, -1.5F, -3.0F, -10.0F, 3, 1, 3, 0.0F, false));
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