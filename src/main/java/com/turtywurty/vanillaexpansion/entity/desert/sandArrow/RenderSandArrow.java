package com.turtywurty.vanillaexpansion.entity.desert.sandArrow;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSandArrow extends RenderArrow<EntitySandArrow>
{
	public static final ResourceLocation SANDARROW_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sandyskeleton/sand_arrow.png");
	
	public RenderSandArrow(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntitySandArrow entity) 
	{
		return SANDARROW_TEXTURE;
	}
}
