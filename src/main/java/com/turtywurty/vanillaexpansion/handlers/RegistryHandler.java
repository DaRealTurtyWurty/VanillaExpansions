package com.turtywurty.vanillaexpansion.handlers;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.BiomeInit;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.EntityInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;
import com.turtywurty.vanillaexpansion.init.StructureInit;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.TileEntitySarcophagus;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.TileEntitySarcophagusRenderer;
import com.turtywurty.vanillaexpansion.world.WorldTypeVanillaOverhaul;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySarcophagus.class, new TileEntitySarcophagusRenderer());
		for(Item item : ItemInit.ITEMS)
		{
			VanillaExpansion.proxy.registerItemRenderer(item, 0, "inventory");
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			VanillaExpansion.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
		}
	}	
	
	@SubscribeEvent
	public static void furnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event)
	{
		/*if(event.getItemStack().getItem() == Item.getItemFromBlock(BlockInit.BLOCKNAME))
	    {
	    	event.setBurnTime(numberTicks);
	    }*/
	}
	
	public static void preInitRegistries()
	{
		BiomeInit.registerBiomes();
		GameRegistry.registerWorldGenerator(new StructureInit(), 0);
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		EventHandler.registerEvents();
	}
	
	public static void initRegistries()
	{
		
	}
	
	public static void postInitRegistries()
	{
		WorldType OVERHAUL = new WorldTypeVanillaOverhaul("Biome Overhaul");
	}
	
	public static void serverInitRegistries()
	{
		
	}
}
