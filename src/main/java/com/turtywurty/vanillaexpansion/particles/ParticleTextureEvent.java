package com.turtywurty.vanillaexpansion.particles;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//@EventBusSubscriber
public class ParticleTextureEvent 
{
	@SubscribeEvent
	public static void textureStitchEvent(TextureStitchEvent event)
	{
		event.getMap().registerSprite(new ResourceLocation(Reference.MOD_ID + ":particles/test"));	
	}
}
