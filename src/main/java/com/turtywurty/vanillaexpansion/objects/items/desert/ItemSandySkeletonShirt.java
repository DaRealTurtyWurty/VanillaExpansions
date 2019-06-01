package com.turtywurty.vanillaexpansion.objects.items.desert;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSandySkeletonShirt extends ItemArmor
{
	public ItemSandySkeletonShirt(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if(!world.isRemote)
		{
			if(player.isPotionActive(MobEffects.BLINDNESS))
			{
				player.removePotionEffect(MobEffects.BLINDNESS);
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 320, 10));
			}
			
			if(player.isPotionActive(MobEffects.SLOWNESS))
			{
				player.removePotionEffect(MobEffects.SLOWNESS);
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 160, 10));
			}
		}
	}
}
