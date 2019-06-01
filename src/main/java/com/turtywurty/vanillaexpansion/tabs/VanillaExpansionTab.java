package com.turtywurty.vanillaexpansion.tabs;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class VanillaExpansionTab extends CreativeTabs
{
	public VanillaExpansionTab() 
	{
		super("vanilla_expansion");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.MOD_LOGO);
	}
}
