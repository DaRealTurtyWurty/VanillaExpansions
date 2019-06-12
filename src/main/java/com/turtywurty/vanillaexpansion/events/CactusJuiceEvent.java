package com.turtywurty.vanillaexpansion.events;

import java.util.HashMap;
import java.util.Map;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CactusJuiceEvent 
{
    private int maxAmount = 8;
    private static Map<BlockPos, Integer> MAP = new HashMap<BlockPos, Integer>();
    
    @SubscribeEvent
    public void cactusWithBottle(RightClickBlock event)
    {
        World worldIn = event.getWorld();
        if(!worldIn.isRemote)
        {
        	BlockPos pos = event.getPos();
        	ItemStack stack = event.getItemStack();
        	IBlockState state = worldIn.getBlockState(pos);
        	Block block = state.getBlock();
        	EntityPlayer playerIn = event.getEntityPlayer();
        	EnumHand handIn = event.getHand();
        	EnumFacing facing = event.getFace();
        	if(block == Blocks.CACTUS && stack.getItem() == Items.GLASS_BOTTLE)
        	{
        		if (!MAP.containsKey(pos)) 
        		{
        			MAP.put(pos, maxAmount);
        		}
        		int currentAmount = MAP.get(pos);
        		MAP.put(pos, --currentAmount);
        		if(currentAmount <= 0)
        		{
        			worldIn.setBlockState(pos, BlockInit.DRAINED_CACTUS.getDefaultState());
        			MAP.remove(pos);
        		}
        		if(!playerIn.capabilities.isCreativeMode)
        		{
        			stack.shrink(1);
        		}
        		playerIn.addItemStackToInventory(new ItemStack(ItemInit.CACTI_JUICE, 1));
        	}
        }
    }
}
