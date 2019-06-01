package com.turtywurty.vanillaexpansion.entity.desert.sandSpider;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSandSpider extends ModelBase
{
	/** The sandSand Spider's head box */
    public ModelRenderer sandSpiderHead;
    /** The sandSand Spider's neck box */
    public ModelRenderer sandSpiderNeck;
    /** The sandSand Spider's body box */
    public ModelRenderer sandSpiderBody;
    /** Sand Spider's first leg */
    public ModelRenderer sandSpiderLeg1;
    /** Sand Spider's second leg */
    public ModelRenderer sandSpiderLeg2;
    /** Sand Spider's third leg */
    public ModelRenderer sandSpiderLeg3;
    /** Sand Spider's fourth leg */
    public ModelRenderer sandSpiderLeg4;
    /** Sand Spider's fifth leg */
    public ModelRenderer sandSpiderLeg5;
    /** Sand Spider's sixth leg */
    public ModelRenderer sandSpiderLeg6;
    /** Sand Spider's seventh leg */
    public ModelRenderer sandSpiderLeg7;
    /** Sand Spider's eight leg */
    public ModelRenderer sandSpiderLeg8;

    public ModelSandSpider()
    {
        float f = 0.0F;
        int i = 15;
        this.sandSpiderHead = new ModelRenderer(this, 32, 4);
        this.sandSpiderHead.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.sandSpiderHead.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.sandSpiderNeck = new ModelRenderer(this, 0, 0);
        this.sandSpiderNeck.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.sandSpiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.sandSpiderBody = new ModelRenderer(this, 0, 12);
        this.sandSpiderBody.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F);
        this.sandSpiderBody.setRotationPoint(0.0F, 15.0F, 9.0F);
        this.sandSpiderLeg1 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.sandSpiderLeg2 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.sandSpiderLeg3 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.sandSpiderLeg4 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.sandSpiderLeg5 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.sandSpiderLeg6 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg6.setRotationPoint(4.0F, 15.0F, 0.0F);
        this.sandSpiderLeg7 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
        this.sandSpiderLeg8 = new ModelRenderer(this, 18, 0);
        this.sandSpiderLeg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.sandSpiderLeg8.setRotationPoint(4.0F, 15.0F, -1.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.sandSpiderHead.render(scale);
        this.sandSpiderNeck.render(scale);
        this.sandSpiderBody.render(scale);
        this.sandSpiderLeg1.render(scale);
        this.sandSpiderLeg2.render(scale);
        this.sandSpiderLeg3.render(scale);
        this.sandSpiderLeg4.render(scale);
        this.sandSpiderLeg5.render(scale);
        this.sandSpiderLeg6.render(scale);
        this.sandSpiderLeg7.render(scale);
        this.sandSpiderLeg8.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.sandSpiderHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.sandSpiderHead.rotateAngleX = headPitch * 0.017453292F;
        float f = ((float)Math.PI / 4F);
        this.sandSpiderLeg1.rotateAngleZ = -((float)Math.PI / 4F);
        this.sandSpiderLeg2.rotateAngleZ = ((float)Math.PI / 4F);
        this.sandSpiderLeg3.rotateAngleZ = -0.58119464F;
        this.sandSpiderLeg4.rotateAngleZ = 0.58119464F;
        this.sandSpiderLeg5.rotateAngleZ = -0.58119464F;
        this.sandSpiderLeg6.rotateAngleZ = 0.58119464F;
        this.sandSpiderLeg7.rotateAngleZ = -((float)Math.PI / 4F);
        this.sandSpiderLeg8.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        this.sandSpiderLeg1.rotateAngleY = ((float)Math.PI / 4F);
        this.sandSpiderLeg2.rotateAngleY = -((float)Math.PI / 4F);
        this.sandSpiderLeg3.rotateAngleY = 0.3926991F;
        this.sandSpiderLeg4.rotateAngleY = -0.3926991F;
        this.sandSpiderLeg5.rotateAngleY = -0.3926991F;
        this.sandSpiderLeg6.rotateAngleY = 0.3926991F;
        this.sandSpiderLeg7.rotateAngleY = -((float)Math.PI / 4F);
        this.sandSpiderLeg8.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.sandSpiderLeg1.rotateAngleY += f3;
        this.sandSpiderLeg2.rotateAngleY += -f3;
        this.sandSpiderLeg3.rotateAngleY += f4;
        this.sandSpiderLeg4.rotateAngleY += -f4;
        this.sandSpiderLeg5.rotateAngleY += f5;
        this.sandSpiderLeg6.rotateAngleY += -f5;
        this.sandSpiderLeg7.rotateAngleY += f6;
        this.sandSpiderLeg8.rotateAngleY += -f6;
        this.sandSpiderLeg1.rotateAngleZ += f7;
        this.sandSpiderLeg2.rotateAngleZ += -f7;
        this.sandSpiderLeg3.rotateAngleZ += f8;
        this.sandSpiderLeg4.rotateAngleZ += -f8;
        this.sandSpiderLeg5.rotateAngleZ += f9;
        this.sandSpiderLeg6.rotateAngleZ += -f9;
        this.sandSpiderLeg7.rotateAngleZ += f10;
        this.sandSpiderLeg8.rotateAngleZ += -f10;
    }
}
