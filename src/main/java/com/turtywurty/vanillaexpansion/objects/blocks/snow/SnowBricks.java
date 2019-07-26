package com.turtywurty.vanillaexpansion.objects.blocks.snow;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SnowBricks extends Block
{
	public PropertyInteger AMOUNT = PropertyInteger.create("amount", 1, 4);
	public SnowBricks(String name) 
	{
		super(Material.CRAFTED_SNOW);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VanillaExpansion.VANILLAEXPANSIONTAB);
		setHarvestLevel("shovel", 0);
		setSoundType(SoundType.SNOW);
		setDefaultState(this.blockState.getBaseState().withProperty(AMOUNT, Integer.valueOf(1)));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Block setResistance(float resistance) 
	{
		resistance = 15.0f;
		return this;
	}
	
	@Override
	public Block setHardness(float hardness) 
	{
		hardness = 3.0f;
		return this;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		
		return true;
	}
	
	public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AMOUNT)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AMOUNT});
    }
    
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AMOUNT, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
    {
    	/*if(playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(BlockInit.SNOW_BRICK))
    	{
    		ItemStack stack = playerIn.getHeldItemMainhand();
    		stack.shrink(1);
    	}*/
    }
}
