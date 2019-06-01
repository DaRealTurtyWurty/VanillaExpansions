package com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBluestone extends Block
{
	public BlockBluestone(String name) 
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0f);
		setResistance(30.0f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setDefaultSlipperiness(0.1f);
		setLightLevel(0.625f);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean canProvidePower(IBlockState state) 
	{
		if(state.getBlock() == BlockInit.BLUESTONE || state.getBlock() == BlockInit.BLUESTONE_ORE || state.getBlock() == BlockInit.BLUESTONE_TORCH || state.getBlock() == BlockInit.UNLIT_BLUESTONE_REPEATER || state.getBlock() == BlockInit.UNLIT_BLUESTONE_TORCH || state.getBlock() == BlockInit.SPIKE_TRAP_DOWN || state.getBlock() == BlockInit.SPIKE_TRAP && state.getBlock() != Blocks.REDSTONE_WIRE)
		{
			return true;	
		}
		return false;
	}
	
	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) 
	{
		return 5;
	}
	
	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) 
	{
		return 15;
	}
}