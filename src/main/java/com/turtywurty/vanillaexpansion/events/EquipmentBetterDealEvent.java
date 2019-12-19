package com.turtywurty.vanillaexpansion.events;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

@EventBusSubscriber
public class EquipmentBetterDealEvent
{
	@SubscribeEvent
	public static void changeArmorOutput(ItemSmeltedEvent event) 
	{
		Item item = event.smelting.getItem();
		if(item instanceof ItemArmor) 
		{
			
		}
		
		if(item instanceof ItemTool) 
		{
			
		}
	}
}
