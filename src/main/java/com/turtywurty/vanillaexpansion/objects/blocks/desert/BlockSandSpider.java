package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.turtywurty.vanillaexpansion.entity.desert.sandSpider.EntitySandSpider;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSandSpider extends Block implements ITileEntityProvider
{	
	public BlockSandSpider(String name) 
	{
		super(Material.SAND);
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(0.0f);
		setResistance(11.0f);
		setSoundType(SoundType.SAND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	public static boolean canContainSandSpider(IBlockState blockState)
    {
        Block block = blockState.getBlock();
        return blockState == Blocks.SAND.getDefaultState();
    }
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Blocks.SAND);
    }
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        if (!worldIn.isRemote && worldIn.getGameRules().getBoolean("doTileDrops"))
        {
        	EntitySandSpider entitySandSpider = new EntitySandSpider(worldIn);
            entitySandSpider.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            worldIn.spawnEntity(entitySandSpider);
            entitySandSpider.spawnExplosionParticle();
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntitySandSpider();
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this, 1);
    }
}
