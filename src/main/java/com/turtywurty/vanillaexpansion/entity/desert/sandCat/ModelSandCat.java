package com.turtywurty.vanillaexpansion.entity.desert.sandCat;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSandCat extends ModelBase 
{
	private final ModelRenderer FrontLeft;
	private final ModelRenderer FrontRight;
	private final ModelRenderer BackLeft;
	private final ModelRenderer BackRight;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer EarLeft;
	private final ModelRenderer EarRight;
	private final ModelRenderer Tail;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelSandCat() 
	{
		textureWidth = 128;
		textureHeight = 128;

		FrontLeft = new ModelRenderer(this);
		FrontLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		FrontRight = new ModelRenderer(this);
		FrontRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		BackLeft = new ModelRenderer(this);
		BackLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		BackRight = new ModelRenderer(this);
		BackRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		FrontLeft.cubeList.add(new ModelBox(FrontLeft, 124, 124, -2.0F, -3.0F, 3.0F, 1, 3, 1, 0.0F, false));
		FrontRight.cubeList.add(new ModelBox(FrontRight, 120, 124, 1.0F, -3.0F, 3.0F, 1, 3, 1, 0.0F, false));
		BackLeft.cubeList.add(new ModelBox(BackLeft, 116, 124, 1.0F, -3.0F, -5.0F, 1, 3, 1, 0.0F, false));
		BackRight.cubeList.add(new ModelBox(BackRight, 112, 124, -2.0F, -3.0F, -5.0F, 1, 3, 1, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 115, -2.0F, -7.0F, -5.0F, 4, 4, 9, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -2.0F, -10.0F, -7.0F, 4, 2, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 4, -2.0F, -8.0F, -7.0F, 4, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 7, -2.0F, -10.0F, -5.0F, 4, 3, 1, 0.0F, false));

		EarLeft = new ModelRenderer(this);
		EarLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(EarLeft, 0.0F, 0.0F, 0.6109F);
		EarLeft.cubeList.add(new ModelBox(EarLeft, 1, 11, -4.7F, -10.0F, -6.0F, 1, 2, 1, 0.0F, false));

		EarRight = new ModelRenderer(this);
		EarRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(EarRight, 0.0F, 0.0F, -0.6109F);
		EarRight.cubeList.add(new ModelBox(EarRight, 6, 11, 3.8F, -10.0F, -6.0F, 1, 2, 1, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Tail, 0.0F, -0.2618F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 10, 121, 0.5F, -6.0F, 3.0F, 1, 1, 2, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.5236F, 0.0F);
		Tail.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 9, 119, -2.1F, -6.0F, 4.6F, 1, 1, 3, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone2, -0.2618F, 0.0873F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 11, 118, -2.7F, -7.7F, 5.5F, 1, 1, 1, 0.0F, false));
	}
	
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
  	{
		this.BackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.BackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
        this.FrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI + 0.3F) * limbSwingAmount;
        this.FrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
  	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		BackLeft.render(f5);
		BackRight.render(f5);
		FrontLeft.render(f5);
		FrontRight.render(f5);
		Body.render(f5);
		Head.render(f5);
		EarLeft.render(f5);
		EarRight.render(f5);
		Tail.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}