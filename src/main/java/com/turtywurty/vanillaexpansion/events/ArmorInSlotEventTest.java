package com.turtywurty.vanillaexpansion.events;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.entity.player.PlayerEvent;
import scala.tools.reflect.quasiquotes.Parsers.Parser.QuasiquoteParser;

//@EventBusSubscriber
public class ArmorInSlotEventTest 
{
	public /*static*/ void checkArmor(PlayerEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		/**Example:*/
		if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ItemInit.PEBBLE)
		{
			
		}
	}
}
