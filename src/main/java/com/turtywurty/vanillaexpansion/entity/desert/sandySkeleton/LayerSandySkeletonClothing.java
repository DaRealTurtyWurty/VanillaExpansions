package com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSandySkeletonClothing implements LayerRenderer<EntitySandySkeleton>
{
	private static final ResourceLocation SANDYSKELETON_CLOTHES_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sandyskeleton/sandyskeleton_clothing.png");
    private final RenderLivingBase<?> renderer;
    private final ModelSandySkeleton layerModel = new ModelSandySkeleton(0.25F, true);

    public LayerSandySkeletonClothing(RenderLivingBase<?> p_i47183_1_)
    {
        this.renderer = p_i47183_1_;
    }

    public void doRenderLayer(EntitySandySkeleton entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(SANDYSKELETON_CLOTHES_TEXTURES);
        this.layerModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
