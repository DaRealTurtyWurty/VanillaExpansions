package com.turtywurty.vanillaexpansion.init;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.entity.desert.entityMummy.EntityMummy;
import com.turtywurty.vanillaexpansion.entity.desert.sandArrow.EntitySandArrow;
import com.turtywurty.vanillaexpansion.entity.desert.sandCat.EntitySandCat;
import com.turtywurty.vanillaexpansion.entity.desert.sandCreeper.EntitySandCreeper;
import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.entity.desert.sandySkeleton.EntitySandySkeleton;
import com.turtywurty.vanillaexpansion.entity.underground.EntityPebble;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static final int SANDSPIDER = 432;
	public static final int SANDYSKELETON = 433;
	public static final int SANDARROW = 434;
	public static final int SANDCREEPER = 435;
	public static final int SANDCAT = 436;
	public static final int MUMMY = 237;
	public static final int PEBBLE = 238;
	
	public static void registerEntities()
	{
		registerEntity("sand_spider", EntitySandSpider.class, SANDSPIDER, 25, 16768916, 16766879);
		registerEntity("sandy_skeleton", EntitySandySkeleton.class, SANDYSKELETON, 35, 14207346, 16050911);
		registerArrow("sand", EntitySandArrow.class, SANDARROW);
		registerEntity("sand_creeper", EntitySandCreeper.class, SANDCREEPER, 25, 14745508, 15138762);
		registerEntity("sand_cat", EntitySandCat.class, SANDCAT, 30, 16768619, 16756842);
		registerEntity("mummy", EntityMummy.class, MUMMY, 30, 16759930, 16767657);
		registerProjectile("pebble", PEBBLE, EntityPebble.class, ItemInit.PEBBLE);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, VanillaExpansion.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, VanillaExpansion.instance, 64, 20, true);
	}

	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, VanillaExpansion.instance, 64, 10, true);
	}
}
