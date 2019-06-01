package com.turtywurty.vanillaexpansion.entity.desert.sandSpider;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSandSpider<T extends EntitySandSpider> extends RenderLiving<T>
{
	public static final ResourceLocation SANDSPIDER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sandSpider/sand_spider.png");
	
	public RenderSandSpider(RenderManager manager) 
	{
		super(manager, new ModelSandSpider(), 1.0f);
		this.addLayer(new LayerSandSpiderEyes(this)); 
	}
	
	@Override
	protected float getDeathMaxRotation(T entityLivingBaseIn) 
	{
		return 180.0f;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(T entity) 
	{
		return SANDSPIDER_TEXTURE;
	}
}
