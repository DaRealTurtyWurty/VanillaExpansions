package com.turtywurty.vanillaexpansion.entity.ice.penguin;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public class ModelPenguin extends ModelBase
{
	private final ModelRenderer bone;
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer bone4;
	
	public ModelPenguin() 
	{
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 26, 26, 1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 0, -3.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -12.0F, -2.0F, 8, 9, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -2.5F, -17.0F, -3.0F, 5, 5, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 5, -1.0F, -14.0F, -5.0F, 2, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 15, 13, -3.0F, -1.0F, -2.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 15, 15, 1.0F, -1.0F, -2.0F, 2, 1, 1, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.0873F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 16, 19, -5.9128F, -11.61F, -2.0F, 1, 9, 4, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone2, 0.0F, 0.0F, -0.0873F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 22, 9, 4.9128F, -11.61F, -2.0F, 1, 9, 4, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone4, 0.4363F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 23, -3.0F, -4.0F, 3.0F, 6, 4, 1, 0.0F, false));
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
