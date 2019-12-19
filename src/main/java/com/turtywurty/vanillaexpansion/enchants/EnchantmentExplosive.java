package com.turtywurty.vanillaexpansion.enchants;

import com.turtywurty.vanillaexpansion.init.EnchantmentInit;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentExplosive extends Enchantment
{
	public EnchantmentExplosive(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) 
	{
		super(rarityIn, typeIn, slots);
		this.setName("explosive");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":explosive"));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) 
	{
		return enchantmentLevel*11;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) 
	{
		return this.getMaxEnchantability(enchantmentLevel) * 11;
	}
	
	@Override
	public int getMaxLevel() 
	{
		return 3;
	}
}
