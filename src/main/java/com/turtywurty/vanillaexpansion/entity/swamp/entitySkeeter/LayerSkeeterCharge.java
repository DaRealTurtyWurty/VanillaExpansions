package com.turtywurty.vanillaexpansion.entity.swamp.entitySkeeter;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSkeeterCharge implements LayerRenderer<EntitySkeeter>
{
    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private final RenderSkeeter skeeterRenderer;
    private final ModelSkeeter skeeterModel = new ModelSkeeter(2.0F);

    public LayerSkeeterCharge(RenderSkeeter skeeterRendererIn)
    {
        this.skeeterRenderer = skeeterRendererIn;
    }

    public void doRenderLayer(EntitySkeeter entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (entitylivingbaseIn.getPowered())
        {
            boolean flag = entitylivingbaseIn.isInvisible();
            GlStateManager.depthMask(!flag);
            this.skeeterRenderer.bindTexture(LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float f = (float)entitylivingbaseIn.ticksExisted + partialTicks;
            GlStateManager.translate(f * 0.01F, f * 0.01F, 0.0F);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            float f1 = 0.5F;
            GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            this.skeeterModel.setModelAttributes(this.skeeterRenderer.getMainModel());
            Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
            this.skeeterModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(flag);
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
