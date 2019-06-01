package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntitySandSpider extends TileEntity implements ITickable
{	
	@Override
	public void update() 
	{
		if(world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(-2.5f, -2.5f, -2.5f, 2.5f, 2.5f, 2.5f)).size() > 0)
		{
			if(!(world.isDaytime()))
			{
				IBlockState state = world.getBlockState(pos);
				Block block = state.getBlock();
				if(block == BlockInit.SAND_SPIDER)
				{
					EntitySandSpider entitySandSpider = new EntitySandSpider(world);
					entitySandSpider.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					world.setBlockToAir(pos);
					world.spawnEntity(entitySandSpider);
					entitySandSpider.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 120, 20));
				}
			}
		}
	}
}
