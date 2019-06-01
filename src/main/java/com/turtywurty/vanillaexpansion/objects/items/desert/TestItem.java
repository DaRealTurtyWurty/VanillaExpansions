package com.turtywurty.vanillaexpansion.objects.items.desert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TestItem extends Item
{
	public TestItem(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		Random rand = new Random();
		int index = rand.nextInt(4);
		List<Item> items = new ArrayList<Item>();
		items.add(Items.FISH);
		items.add(Items.CAKE);
		items.add(Items.BAKED_POTATO);
		items.add(Item.getItemFromBlock(Blocks.EMERALD_ORE));
		boolean slotFilled = false;
		for(Slot slot : playerIn.inventoryContainer.inventorySlots)
		{
			if((slot.getHasStack() && slot.getStack().getItem() != items.get(index)) && slot.getStack().getItem() != Item.getItemFromBlock(Blocks.AIR))
			{
				slotFilled = true;
			}
		}
		
		if(!slotFilled)
		{
			playerIn.inventory.addItemStackToInventory(new ItemStack(items.get(index)));
			ItemStack stack = playerIn.getHeldItemMainhand();
			if(!playerIn.capabilities.isCreativeMode)
			{
				stack.shrink(1);
			}
		}
		else if(slotFilled = true && !worldIn.isRemote)
		{
			InventoryHelper.spawnItemStack(worldIn, playerIn.posX, playerIn.posY+1, playerIn.posZ, new ItemStack(items.get(index)));
			ItemStack stack = playerIn.getHeldItemMainhand();
			if(!playerIn.capabilities.isCreativeMode)
			{
				stack.shrink(1);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
