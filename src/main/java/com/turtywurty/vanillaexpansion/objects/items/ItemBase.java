package com.turtywurty.vanillaexpansion.objects.items;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ItemInit.ITEMS.add(this);
	}
}
