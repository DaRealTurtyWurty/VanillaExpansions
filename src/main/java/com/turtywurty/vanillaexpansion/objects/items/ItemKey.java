package com.turtywurty.vanillaexpansion.objects.items;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemKey extends Item
{
	public ItemKey(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		if(block instanceof BlockDoor && state.getMaterial() == Material.IRON)
		{
			System.out.println("Iron Door");
			if(!((BlockDoor)block).isOpen(worldIn, pos))
			{
				System.out.println("Door Closed");
				worldIn.setBlockState(pos, state.withProperty(BlockDoor.OPEN, true));
				System.out.println("Door Opened");
				return EnumActionResult.SUCCESS;
			}
			System.out.println("Door Already Open");
			return EnumActionResult.FAIL;
		}
		
		if(state.getProperties().containsKey(BlockCrops.AGE))
		{
			int age = (int)state.getProperties().get(BlockCrops.AGE);
		}
		
		else if(block instanceof BlockTrapDoor && state.getMaterial() == Material.IRON)
		{
			System.out.println("Iron Trapdoor");
			if(state.getProperties().containsKey(BlockTrapDoor.OPEN) && state.getProperties().containsValue(false))
			{
				System.out.println("Door Closed");
				worldIn.setBlockState(pos, state.withProperty(BlockTrapDoor.OPEN, true));
				System.out.println("Door Opened");
				return EnumActionResult.SUCCESS;
			}
			System.out.println("Door Already Open");
			return EnumActionResult.FAIL;
		}
		System.out.println("Not a Door.");
		return EnumActionResult.FAIL;
	}
}
