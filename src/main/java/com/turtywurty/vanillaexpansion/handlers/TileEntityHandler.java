package com.turtywurty.vanillaexpansion.handlers;

import com.turtywurty.vanillaexpansion.objects.blocks.desert.TileEntitySandSpider;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.TileEntitySandTrapDown;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.TileEntitySarcophagus;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySandSpider.class, new ResourceLocation(Reference.MOD_ID + ":sand_spider"));
		GameRegistry.registerTileEntity(TileEntitySandTrapDown.class, new ResourceLocation(Reference.MOD_ID + ":sand_trap_down"));
		GameRegistry.registerTileEntity(TileEntitySarcophagus.class, new ResourceLocation(Reference.MOD_ID + ":sarcophagus"));
	}
}
