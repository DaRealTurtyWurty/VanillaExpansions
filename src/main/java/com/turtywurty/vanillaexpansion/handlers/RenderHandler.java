package com.turtywurty.vanillaexpansion.handlers;

import com.turtywurty.vanillaexpansion.entity.desert.entityMummy.EntityMummy;
import com.turtywurty.vanillaexpansion.entity.desert.entityMummy.RenderMummy;
import com.turtywurty.vanillaexpansion.entity.desert.sandArrow.EntitySandArrow;
import com.turtywurty.vanillaexpansion.entity.desert.sandArrow.RenderSandArrow;
import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCat.RenderSandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCreeper.EntitySandCreeper;
import com.turtywurty.vanillaexpansion.entity.desert.sandCreeper.RenderSandCreeper;
import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.RenderSandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.EntitySandySkeleton;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.RenderSandySkeleton;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySandSpider.class, new IRenderFactory<EntitySandSpider>()
		{
			@Override
			public Render<? super EntitySandSpider> createRenderFor(RenderManager manager) 
			{
				return new RenderSandSpider<>(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySandySkeleton.class, new IRenderFactory<EntitySandySkeleton>()
		{
			@Override
			public Render<? super EntitySandySkeleton> createRenderFor(RenderManager manager) 
			{
				return new RenderSandySkeleton(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySandArrow.class, new IRenderFactory<EntitySandArrow>() 
		{
			@Override
			public Render<? super EntitySandArrow> createRenderFor(RenderManager manager)
			{
				return new RenderSandArrow(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySandCreeper.class, new IRenderFactory<EntitySandCreeper>()
		{
			@Override
			public Render<? super EntitySandCreeper> createRenderFor(RenderManager manager) 
			{
				return new RenderSandCreeper(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySandCat.class, new IRenderFactory<EntitySandCat>()
		{
			@Override
			public Render<? super EntitySandCat> createRenderFor(RenderManager manager) 
			{
				return new RenderSandCat(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new IRenderFactory<EntityMummy>()
		{
			@Override
			public Render<? super EntityMummy> createRenderFor(RenderManager manager) 
			{
				return new RenderMummy(manager);
			}
		});
	}
}
