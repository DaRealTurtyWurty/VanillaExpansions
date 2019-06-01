package com.turtywurty.vanillaexpansion.init;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSandSpider;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSandstoneWall;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSandyString;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSarcophagus;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSpikeTrap;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockSpikeTrapDown;
import com.turtywurty.vanillaexpansion.objects.blocks.desert.BlockStabilizedSand;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestone;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestoneComparator;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestoneOre;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestoneRepeater;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestoneTorch;
import com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone.BlockBluestoneWire;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockInit 
{
	static CreativeTabs TAB = VanillaExpansion.VANILLAEXPANSIONTAB;
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block SAND_SPIDER = new BlockSandSpider("block_sand_spider").setCreativeTab(TAB);
	public static final Block SANDY_STRING = new BlockSandyString("sandy_string", Material.WEB).setCreativeTab(TAB);
	public static final Block STABILIZED_SAND = new BlockStabilizedSand("stabilized_sand").setCreativeTab(TAB);
	public static final Block SANDSTONE_WALL = new BlockSandstoneWall("sandstone_wall", Blocks.SANDSTONE).setCreativeTab(TAB);
	public static final Block SPIKE_TRAP = new BlockSpikeTrap("spike_trap").setCreativeTab(TAB);
	public static final Block SPIKE_TRAP_DOWN = new BlockSpikeTrapDown("spike_trap_down");
	public static final Block SARCOPHAGUS = new BlockSarcophagus("sarcophagus_block");
	
	//Bluestone
	public static final Block BLUESTONE = new BlockBluestoneWire("bluestone").setCreativeTab(TAB);
	public static final Block BLUESTONE_ORE = new BlockBluestoneOre("bluestone_ore", false).setCreativeTab(TAB);
	public static final Block LIT_BLUESTONE_ORE = new BlockBluestoneOre("lit_bluestone_ore", true).setLightLevel(0.625f);
	public static final Block UNLIT_BLUESTONE_TORCH = new BlockBluestoneTorch("unlit_bluestone_torch", false);
	public static final Block BLUESTONE_TORCH = new BlockBluestoneTorch("bluestone_torch", true).setLightLevel(0.75f).setCreativeTab(TAB);
	public static final Block POWERED_BLUESTONE_REPEATER = new BlockBluestoneRepeater("powered_bluestone_repeater", true).setLightLevel(0.5f);
	public static final Block UNLIT_BLUESTONE_REPEATER = new BlockBluestoneRepeater("unpowered_bluestone_repeater", false).setCreativeTab(TAB);
	public static final Block BLUESTONE_BLOCK = new BlockBluestone("bluestone_block").setCreativeTab(TAB);
	public static final Block BLUESTONE_COMPARATOR = new BlockBluestoneComparator("bluestone_comparator", true).setCreativeTab(TAB);
}