package com.turtywurty.vanillaexpansion.events;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EquipmentBetterDealEvent
{
	@SubscribeEvent
	public static void changeArmorOutput(ItemSmeltedEvent event) 
	{
		System.out.println("event fired");
		boolean ingot;
		ItemStack stack = event.smelting;
		Item item = stack.getItem();
		EntityPlayer player = event.player;
		if(item instanceof ItemArmor) 
		{
			System.out.println("item armour");
			double durability = item.getDurabilityForDisplay(stack);
			if(item.isValidArmor(stack, EntityEquipmentSlot.HEAD, player))
			{
				int amount = ((int)(durability*3)%2);
				System.out.println(amount);
			}
			if(item.isValidArmor(stack, EntityEquipmentSlot.CHEST, player))
			{
				
			}
			if(item.isValidArmor(stack, EntityEquipmentSlot.LEGS, player))
			{
				
			}
			if(item.isValidArmor(stack, EntityEquipmentSlot.FEET, player))
			{
				
			}
			return;
		}
		
		if(item instanceof ItemTool) 
		{
			double durability = item.getDurabilityForDisplay(stack);
		}
	}
}
