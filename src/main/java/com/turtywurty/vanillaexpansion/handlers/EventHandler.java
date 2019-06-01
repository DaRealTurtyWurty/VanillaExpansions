package com.turtywurty.vanillaexpansion.handlers;

import com.turtywurty.vanillaexpansion.events.LootTableEvent;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler 
{
	public static void registerEvents()
	{
		LootTableEvent lootEvent = new LootTableEvent();
		
		MinecraftForge.EVENT_BUS.register(lootEvent);
	}
}
