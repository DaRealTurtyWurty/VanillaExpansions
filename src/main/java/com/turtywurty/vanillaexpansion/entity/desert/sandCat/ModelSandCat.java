package com.turtywurty.vanillaexpansion.entity.desert.sandCat;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSandCat extends ModelBase 
{
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer Head;
	private final ModelRenderer EarLeft;
	private final ModelRenderer EarRight;
	private final ModelRenderer Tail;
	private final ModelRenderer Tail1;
	private final ModelRenderer Tail2;

	public ModelSandCat() 
	{
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 22.75F, -0.125F);
		Body.cubeList.add(new ModelBox(Body, 0, 115, -2.0F, -5.75F, -4.875F, 4, 4, 9, 0.0F, false));

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, -0.25F, -0.375F);
		Body.addChild(Legs);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setRotationPoint(-1.5F, 0.0F, 4.0F);
		Legs.addChild(BackRightLeg);
		BackRightLeg.cubeList.add(new ModelBox(BackRightLeg, 124, 124, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F, false));

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setRotationPoint(1.5F, 0.0F, 4.0F);
		Legs.addChild(BackLeftLeg);
		BackLeftLeg.cubeList.add(new ModelBox(BackLeftLeg, 120, 124, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F, false));

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setRotationPoint(-1.5F, 0.0F, -4.0F);
		Legs.addChild(FrontRightLeg);
		FrontRightLeg.cubeList.add(new ModelBox(FrontRightLeg, 112, 124, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F, false));

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setRotationPoint(1.5F, 0.0F, -4.0F);
		Legs.addChild(FrontLeftLeg);
		FrontLeftLeg.cubeList.add(new ModelBox(FrontLeftLeg, 116, 124, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 4.0f, 1.0F);
		Body.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -2.0F, -10.0F, -7.0F, 4, 2, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 4, -2.0F, -8.0F, -7.0F, 4, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 7, -2.0F, -10.0F, -5.0F, 4, 3, 1, 0.0F, false));

		EarLeft = new ModelRenderer(this);
		EarLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(EarLeft, 0.0F, 0.0F, 0.6109F);
		Head.addChild(EarLeft);
		EarLeft.cubeList.add(new ModelBox(EarLeft, 1, 11, -4.7F, -10.0F, -6.0F, 1, 2, 1, 0.0F, false));

		EarRight = new ModelRenderer(this);
		EarRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(EarRight, 0.0F, 0.0F, -0.6109F);
		Head.addChild(EarRight);
		EarRight.cubeList.add(new ModelBox(EarRight, 6, 11, 3.8F, -10.0F, -6.0F, 1, 2, 1, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 1.25F, 0.125F);
		setRotationAngle(Tail, 0.0F, -0.2618F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 3, 121, 0.5F, -6.0F, 3.0F, 1, 1, 2, 0.0F, false));

		Tail1 = new ModelRenderer(this);
		Tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Tail1, 0.0F, 0.5236F, 0.0F);
		Tail.addChild(Tail1);
		Tail1.cubeList.add(new ModelBox(Tail1, 3, 118, -2.3F, -6.0F, 5.0F, 1, 1, 2, 0.0F, false));

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Tail2, 0.0F, 0.4363F, 0.0F);
		Tail.addChild(Tail2);
		Tail2.cubeList.add(new ModelBox(Tail2, 5, 116, -1.65F, -6.0F, 7.5F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		Body.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
	{
		if(!entityIn.isDead)
		{
			Body.rotateAngleY = entityIn.getAdjustedHorizontalFacing().getHorizontalAngle();
		}
		Legs.rotateAngleX = (MathHelper.cos(limbSwing) * limbSwingAmount * 0.5f);
		Head.rotateAngleX = (float)(headPitch * Math.PI/180);
        Head.rotateAngleY = (float)(netHeadYaw * Math.PI/180);
	}
}