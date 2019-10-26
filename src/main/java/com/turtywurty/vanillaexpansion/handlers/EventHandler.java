package com.turtywurty.vanillaexpansion.handlers;

import com.turtywurty.vanillaexpansion.events.CactusJuiceEvent;
import com.turtywurty.vanillaexpansion.events.LootTableEvent;

import net.minecraft.inventory.InventoryHelper;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler 
{
	public static void registerEvents()
	{
		LootTableEvent lootEvent = new LootTableEvent();
		CactusJuiceEvent cactusEvent = new CactusJuiceEvent();
		
		MinecraftForge.EVENT_BUS.register(lootEvent);
		MinecraftForge.EVENT_BUS.register(cactusEvent);
	}
}
