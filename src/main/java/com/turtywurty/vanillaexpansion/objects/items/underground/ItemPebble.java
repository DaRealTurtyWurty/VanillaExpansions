package com.turtywurty.vanillaexpansion.objects.items.underground;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.entity.underground.EntityPebble;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemPebble extends Item
{
	public ItemPebble(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Vec3d look = playerIn.getLookVec();
        EntityPebble proj = new EntityPebble(worldIn, 1D, 1D, 1D);
        proj.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
        proj.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.5F);
        if(!worldIn.isRemote) { worldIn.spawnEntity(proj); }
        worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
        stack.shrink(1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}
