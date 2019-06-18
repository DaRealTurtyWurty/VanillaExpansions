package com.turtywurty.vanillaexpansion.objects.blocks;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
	public BlockBase(String name) 
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
