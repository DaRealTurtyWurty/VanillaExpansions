package com.turtywurty.vanillaexpansion.objects.items.desert;

import java.util.List;
import java.util.Random;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemCactiJuice extends ItemFood
{
	public ItemCactiJuice(String name) 
	{
		super(2, 10, false);
		setUnlocalizedName(name);
		setRegistryName(name);
		setAlwaysEdible();
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		Random rand = new Random();
		if(rand.nextInt(3) == 0)
		{
			player.attackEntityFrom(DamageSource.CACTUS, 1);
		}
		else
		{
			if(player.isPotionActive(MobEffects.HEALTH_BOOST))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, (Integer.MAX_VALUE - 1), 5));
				player.curePotionEffects(stack);
			}
			else
			{
				player.heal(10.0f);
				player.curePotionEffects(stack);
			}
		}
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) 
	{
		return EnumAction.DRINK;
	}
}
