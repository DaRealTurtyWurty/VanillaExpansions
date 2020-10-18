package com.turtywurty.vanillaexpansion.objects.blocks.desert;

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
import net.minecraftforge.common.IPlantable;

public class BlockStabilizedSand extends Block
{
	public BlockStabilizedSand(String name) 
	{
		super(Material.SAND);
		setUnlocalizedName(name);
		setRegistryName(name);
		setResistance(2.5f);
		setHardness(0.5f);
		setSoundType(SoundType.SAND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isToolEffective(String type, IBlockState state) 
	{
		type = "shovel";
		if("shovel".equals(type) && this == BlockInit.STABILIZED_SAND)
		{
			return true;
		}
		return type.equals(this.getHarvestTool(state));
	}
	
	@Override
	public String getHarvestTool(IBlockState state) 
	{
		return null;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) 
	{
		return -1;
	}
	
	@Override
	public boolean canSustainPlant(IBlockState plant, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		if (plant.getBlock() == Blocks.CACTUS)
        {
            return true;
        }
		else if(plant.getBlock() == Blocks.DEADBUSH)
		{
			return true;
		}
		else if(plant.getBlock() == Blocks.REEDS)
		{
			return true;
		}
		return false;
	}
}
