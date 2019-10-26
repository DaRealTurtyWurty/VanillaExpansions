package com.turtywurty.vanillaexpansion.events;

import java.util.Random;

import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.EntitySandySkeleton;
import com.turtywurty.vanillaexpansion.entity.ice.penguin.EntityPenguin;
import com.turtywurty.vanillaexpansion.entity.jungle.entityLemur.EntityLemur;
import com.turtywurty.vanillaexpansion.entity.swamp.entityBeaver.EntityBeaver;
import com.turtywurty.vanillaexpansion.entity.swamp.entityPlatypus.EntityPlatypus;
import com.turtywurty.vanillaexpansion.entity.swamp.entitySkeeter.EntitySkeeter;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		
		if(event.getEntity() instanceof EntitySkeeter)
		{
			event.getEntity().dropItem(Items.GUNPOWDER, rand.nextInt(2) + 1);
			event.getEntity().dropItem(ItemInit.MUCK, rand.nextInt(4));
		}
		
		if(event.getEntity() instanceof EntityBeaver)
		{
			if(rand.nextInt(1) == 0)
			{
				event.getEntity().dropItem(ItemInit.PELT, rand.nextInt(2)+1);
			}
		}
		
		if(event.getEntity() instanceof EntityPlatypus)
		{
			if(rand.nextInt(1) == 0)
			{
				event.getEntity().dropItem(ItemInit.PELT, rand.nextInt(2)+1);
			}
		}
		
		if(event.getEntity() instanceof EntityPenguin)
		{
			event.getEntity().dropItem(Items.FISH, rand.nextInt(2)+1);
		}
		
		if(event.getEntity() instanceof EntityLemur)
		{
			event.getEntity().dropItem(Items.MELON, rand.nextInt(5)+1);
			if(rand.nextInt(4) == 0)
			{
				event.getEntity().dropItem(Items.SPECKLED_MELON, rand.nextInt(1));
			}
		}
	}
}
