package com.turtywurty.vanillaexpansion.objects.items.desert;

import com.turtywurty.vanillaexpansion.entity.desert.sandArrow.EntitySandArrow;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSandArrow extends ItemArrow
{
	public ItemSandArrow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		EntitySandArrow entitySandArrow = new EntitySandArrow(worldIn, shooter);
		return entitySandArrow;
	}
}
