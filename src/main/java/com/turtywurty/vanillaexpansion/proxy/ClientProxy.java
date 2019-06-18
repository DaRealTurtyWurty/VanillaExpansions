package com.turtywurty.vanillaexpansion.proxy;

import com.turtywurty.vanillaexpansion.entity.underground.EntityPebble;
import com.turtywurty.vanillaexpansion.handlers.RenderHandler;
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
	}
}
