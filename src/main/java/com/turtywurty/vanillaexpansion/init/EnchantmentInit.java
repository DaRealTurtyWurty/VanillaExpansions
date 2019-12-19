package com.turtywurty.vanillaexpansion.init;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.vanillaexpansion.enchants.EnchantmentExplosive;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit 
{
	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final Enchantment EXPLOSIVE = new EnchantmentExplosive(Rarity.RARE, EnumEnchantmentType.BREAKABLE, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	@SubscribeEvent
	public static void enchantAttack(BlockEvent.BreakEvent event)
	{
		System.out.println("event ran");
		EntityPlayer miner = event.getPlayer();
		System.out.println();
		int level = EnchantmentHelper.getEnchantmentLevel(EXPLOSIVE, miner.getHeldItemMainhand());
		if(!miner.getEntityWorld().isRemote && level > 0)
		{
			System.out.println("level > 0 and world not remote");
			if(event.getPlayer().getRNG().nextInt(11/level) == 0)
			{
				System.out.println("Explosion");
				miner.getEntityWorld().newExplosion(miner, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (float)level * 2, false, true);
			}
		}
	}
}

