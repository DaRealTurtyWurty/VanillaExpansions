package com.turtywurty.vanillaexpansion.init;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundInit 
{
	public static SoundEvent MOSQUITO;
	
	public static void registerSounds()
	{
		MOSQUITO = registerSound("entity.mosquito");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
