package com.turtywurty.vanillaexpansion.events;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.end.DragonFightManager;
import net.minecraft.world.end.DragonSpawnManager;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.PortalSpawnEvent;

public class EnderDragonKillEvent 
{
	public static void killedEvent(LivingDeathEvent event)
	{
		if(event.getEntityLiving() instanceof EntityDragon)
		{
			
		}
	}
}
