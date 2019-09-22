package com.turtywurty.vanillaexpansion.entity.swamp.entitySkeeter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class ModelSkeeter extends ModelCreeper
{
    public ModelRenderer head;
    public ModelRenderer creeperArmor;
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelSkeeter()
    {
        this(0.0F);
    }

    public ModelSkeeter(float amount)
    {
    	this.textureHeight = 128;
    	this.textureWidth = 128;
    	int i = 6;
    	
    	this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0f);
        this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.head.cubeList.add(new ModelBox(head, 48, 56, -4.0F, -8.0F, -4.11F, 8, 8, 0, amount, false));
        this.head.cubeList.add(new ModelBox(head, 90, 33, -4.0F, -8.0F, 4.11F, 8, 10, 0, amount, false));
		this.head.cubeList.add(new ModelBox(head, 32, 32, -4.0F, -9.01F, -4.0F, 8, 1, 8, amount, false));
		this.head.cubeList.add(new ModelBox(head, 26, 78, 4.11F, -8.0F, -4.0F, 0, 10, 8, amount, false));
		this.head.cubeList.add(new ModelBox(head, 71, 87, -4.11F, -8.0F, -4.0F, 0, 11, 8, amount, false));
        
        this.creeperArmor = new ModelRenderer(this, 32, 0);
        this.creeperArmor.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, amount + 0.5F);
        this.creeperArmor.setRotationPoint(0.0F, 6.0F, 0.0F);
        
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0f);
        this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.body.cubeList.add(new ModelBox(body, 48, 14, -4.0F, 0.0F, -4.1F, 8, 12, 0, amount, false));
        this.body.cubeList.add(new ModelBox(body, 40, 14, -4.0F, 0.0F, 4.1F, 8, 12, 0, amount, false));
        this.body.cubeList.add(new ModelBox(body, 77, 63, 4.1F, 0.0F, -4.0F, 0, 12, 8, amount, false));
		this.body.cubeList.add(new ModelBox(body, 24, 44, -4.1F, 0.0F, -4.0F, 0, 12, 8, amount, false));
        
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, amount);
        this.leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
        
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, amount);
        this.leg2.setRotationPoint(2.0F, 18.0F, 4.0F);
        
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, amount);
        this.leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
        
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, amount);
        this.leg4.setRotationPoint(2.0F, 18.0F, -4.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        this.body.render(scale);
        this.leg1.render(scale);
        this.leg2.render(scale);
        this.leg3.render(scale);
        this.leg4.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
