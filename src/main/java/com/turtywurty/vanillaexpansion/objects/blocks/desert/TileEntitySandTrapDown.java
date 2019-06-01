package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import com.turtywurty.vanillaexpansion.init.BlockInit;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.storage.WorldInfo;

public class TileEntitySandTrapDown extends TileEntity implements ITickable
{
	private int ticks = 0;
	
	@Override
	public void update() 
	{
		ticks++;
		if(ticks > 100)
		{
			world.setBlockState(pos, BlockInit.SPIKE_TRAP.getDefaultState());
		}
	}
}
