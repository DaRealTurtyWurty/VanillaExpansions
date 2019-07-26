package com.turtywurty.vanillaexpansion.events;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//@EventBusSubscriber
public class BlockBreakingEventTest
{
	@SubscribeEvent
	public /*static*/ void breakingBlock(BlockEvent.BreakEvent event)
	{
		NonNullList<ItemStack> drops;
		if(event.getState().getBlock() == Blocks.SAND)
		{
			Item item = event.getPlayer().getHeldItemMainhand().getItem();
			if(item instanceof ItemSpade && item.getHarvestLevel(new ItemStack(item), "shovel", event.getPlayer(), event.getState()) == 3)
			{
				
			}
			else
			{
				event.setCanceled(true);
				event.getWorld().setBlockToAir(event.getPos());
			}
		}
		
		for(Slot slot : event.getPlayer().inventoryContainer.inventorySlots)
		{
			if(event.getPlayer().inventory.getStackInSlot(slot.getSlotIndex()).getItem() == Items.EGG)
			{
				event.getPlayer().capabilities.allowFlying = true;
			}
		}
	}
}
