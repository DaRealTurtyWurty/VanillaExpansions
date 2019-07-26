package com.turtywurty.vanillaexpansion.events;

import java.util.Random;

import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.EntitySandySkeleton;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableEvent 
{
	@SubscribeEvent
	public void mobDropLoot(LivingDropsEvent event)
	{
		Random rand = new Random();
		if(event.getEntity() instanceof EntitySandSpider)
		{
			if(rand.nextInt(1) == 0)
			{
				event.getEntity().dropItem(Item.getItemFromBlock(BlockInit.SANDY_STRING), rand.nextInt(3) + 1);
			}
		}
		
		if(event.getEntity() instanceof EntitySandySkeleton)
		{
			if(rand.nextInt(20) == 0)
			{
				event.getEntity().dropItem(ItemInit.SANDY_SKELETON_SHIRT, 1);
			}
		}
	}
}
