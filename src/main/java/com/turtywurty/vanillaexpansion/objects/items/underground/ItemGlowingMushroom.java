package com.turtywurty.vanillaexpansion.objects.items.underground;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemGlowingMushroom extends ItemFood implements IPlantable
{
	public ItemGlowingMushroom(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack itemstack = player.getHeldItem(hand);
		IBlockState state = worldIn.getBlockState(pos);
		if(state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this))
		{
            IBlockState state1 = worldIn.getBlockState(pos);
        	worldIn.playSound(player, pos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0f, 0.8f);
        	worldIn.setBlockState(pos.up(), BlockInit.GLOWING_MUSHROOM.getDefaultState());
        	if(!player.capabilities.isCreativeMode)
        	{
        		itemstack.shrink(1);
        	}
        	return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1800, 5));
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 90, 200));
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Cave;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) 
	{
		return BlockInit.GLOWING_MUSHROOM.getDefaultState();
	}
}
