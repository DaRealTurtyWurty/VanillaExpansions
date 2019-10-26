package com.turtywurty.vanillaexpansion.proxy;

import com.turtywurty.vanillaexpansion.entity.EntityBounceBall;
import com.turtywurty.vanillaexpansion.entity.EntityBounceBallTeleport;
import com.turtywurty.vanillaexpansion.entity.EntityBounceBallTeleport2;
import com.turtywurty.vanillaexpansion.entity.underground.EntityPebble;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void render()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new RenderSnowball<EntityPebble>(Minecraft.getMinecraft().getRenderManager(), ItemInit.PEBBLE, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBounceBall.class, new RenderSnowball<EntityBounceBall>(Minecraft.getMinecraft().getRenderManager(), ItemInit.BOUNCE_BALL, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBounceBallTeleport.class, new RenderSnowball<EntityBounceBallTeleport>(Minecraft.getMinecraft().getRenderManager(), ItemInit.BOUNCE_BALL_TELEPORT, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBounceBallTeleport2.class, new RenderSnowball<EntityBounceBallTeleport2>(Minecraft.getMinecraft().getRenderManager(), ItemInit.BOUNCE_BALL_TELEPORT2, Minecraft.getMinecraft().getRenderItem()));
	}
}
