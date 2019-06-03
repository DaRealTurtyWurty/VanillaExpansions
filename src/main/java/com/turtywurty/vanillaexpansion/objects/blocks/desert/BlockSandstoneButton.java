package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import net.minecraft.block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSandstoneButton extends BlockButtonBase
{
	public BlockSandstoneButton(String name, boolean isWooden) 
	{
		super(name, isWooden);
		setHardness(1.0f);
		setResistance(5.0f);
		setHarvestLevel("pickaxe", 0);
		setSoundType(SoundType.STONE);
	}
	
	@Override
	protected void playReleaseSound(World worldIn, BlockPos pos) 
	{
		worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.5f, 0.5f, false);
	}

	@Override
	protected void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) 
	{
		worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.5f, 0.5f, false);
	}
}
