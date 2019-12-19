package com.turtywurty.vanillaexpansion.events;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.layers.LayerEndermanEyes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EnderDragonKillEvent 
{
	@SubscribeEvent
	public static void killedEvent(LivingDeathEvent event)
	{
		LayerEndermanEyes.RES_ENDERMAN_EYES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/enderman/enderman_neutral.png");
		System.out.println("eek");
		List<Entity> entities = new ArrayList(event.getEntity().getEntityWorld().loadedEntityList);
		entities.forEach((entity) -> {
			List<Class<Entity>> classes = new ArrayList<Class<Entity>>();
			classes.add((Class<Entity>)entity.getClass());
			classes.forEach((clas) -> {
				if(entities.contains(EntityDragon.class))
				{
					
				}
			});
		});
	}
	
	@SubscribeEvent
	public static void spawnedEvent(LivingSpawnEvent event)
	{
		if(event.getEntity() instanceof EntityDragon)
		{
			System.out.println("noobly");
			LayerEndermanEyes.RES_ENDERMAN_EYES = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
		}
	}
}
