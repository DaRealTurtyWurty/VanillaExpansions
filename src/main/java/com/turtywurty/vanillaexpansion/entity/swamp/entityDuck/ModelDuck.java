package com.turtywurty.vanillaexpansion.entity.swamp.entityDuck;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelDuck extends ModelBase 
{
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer mainhead;
	private final ModelRenderer neckconnector;
	private final ModelRenderer neck;
	private final ModelRenderer beak;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer bottom;
	private final ModelRenderer top;

	public ModelDuck() 
	{
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);

		mainhead = new ModelRenderer(this);
		mainhead.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(mainhead);
		mainhead.cubeList.add(new ModelBox(mainhead, 0, 0, -1.0F, -13.0F, -9.0F, 2, 2, 4, 0.0F, false));

		neckconnector = new ModelRenderer(this);
		neckconnector.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(neckconnector);
		neckconnector.cubeList.add(new ModelBox(neckconnector, 8, 2, -1.0F, -9.0F, -7.0F, 2, 1, 1, 0.0F, false));

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(neck);
		neck.cubeList.add(new ModelBox(neck, 0, 6, -1.0F, -11.0F, -7.0F, 2, 2, 2, 0.0F, false));

		beak = new ModelRenderer(this);
		beak.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(beak);
		beak.cubeList.add(new ModelBox(beak, 8, 8, -1.0F, -12.0F, -10.0F, 2, 1, 1, 0.0F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(leftleg);
		leftleg.cubeList.add(new ModelBox(leftleg, 33, 37, 1.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 8, 10, 1.5F, -3.0F, 0.0F, 1, 3, 0, 0.0F, false));

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rightleg);
		rightleg.cubeList.add(new ModelBox(rightleg, 33, 37, -3.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 1, 10, -2.5F, -3.0F, 0.0F, 1, 3, 0, 0.0F, false));

		bottom = new ModelRenderer(this);
		bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(bottom);
		bottom.cubeList.add(new ModelBox(bottom, 23, 15, -4.0F, -5.0F, -4.0F, 8, 2, 8, 0.0F, false));
		bottom.cubeList.add(new ModelBox(bottom, 30, 3, -4.0F, -5.0F, -6.0F, 8, 1, 2, 0.0F, false));
		bottom.cubeList.add(new ModelBox(bottom, 30, 0, -4.0F, -5.0F, 4.0F, 8, 1, 2, 0.0F, false));
		bottom.cubeList.add(new ModelBox(bottom, 0, 0, -4.0F, -6.0F, -7.0F, 8, 1, 14, 0.0F, false));

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(top);
		top.cubeList.add(new ModelBox(top, 0, 28, -3.0F, -10.0F, -4.0F, 6, 1, 6, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 25, 25, -3.0F, -9.0F, -6.0F, 6, 1, 9, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 15, -3.0F, -8.0F, -7.0F, 6, 2, 11, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 18, 28, -3.0F, -7.0F, 4.0F, 6, 1, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		body.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}