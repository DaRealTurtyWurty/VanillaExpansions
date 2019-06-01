package com.turtywurty.vanillaexpansion.objects.items.desert;

import javax.annotation.Nullable;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSandBow extends ItemBow
{
	public ItemSandBow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxDamage(800);
		setMaxStackSize(1);
		
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != ItemInit.SAND_BOW ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemEnchantability() 
	{
		return 10;
	}
	
	@Override
	protected boolean isArrow(ItemStack stack) 
	{
		if(stack.getItem() == ItemInit.SAND_ARROW)
		{
			return true;
		}
		return false;
	}
}
