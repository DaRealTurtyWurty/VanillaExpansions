package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.turtywurty.vanillaexpansion.damageSource.DamageSourceSpikeTrap;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpikeTrap extends Block 
{
	private static final AxisAlignedBB BASE = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.062, 0.875);
	private static final AxisAlignedBB ELEMENT = new AxisAlignedBB(0.266, 0.062, 0.219, 0.359, 0.312, 0.312);
	private static final AxisAlignedBB ELEMENT1 = new AxisAlignedBB(0.281, 0.312, 0.234, 0.344, 0.5, 0.297);
	private static final AxisAlignedBB ELEMENT2 = new AxisAlignedBB(0.266, 0.062, 0.453, 0.359, 0.312, 0.547);
	private static final AxisAlignedBB ELEMENT3 = new AxisAlignedBB(0.281, 0.312, 0.469, 0.344, 0.5, 0.531);
	private static final AxisAlignedBB ELEMENT4 = new AxisAlignedBB(0.266, 0.062, 0.688, 0.359, 0.312, 0.781);
	private static final AxisAlignedBB ELEMENT5 = new AxisAlignedBB(0.281, 0.312, 0.703, 0.344, 0.5, 0.766);
	private static final AxisAlignedBB ELEMENT6 = new AxisAlignedBB(0.391, 0.062, 0.688, 0.484, 0.312, 0.781);
	private static final AxisAlignedBB ELEMENT7 = new AxisAlignedBB(0.391, 0.062, 0.453, 0.484, 0.312, 0.547);
	private static final AxisAlignedBB ELEMENT8 = new AxisAlignedBB(0.391, 0.062, 0.219, 0.484, 0.312, 0.312);
	private static final AxisAlignedBB ELEMENT9 = new AxisAlignedBB(0.406, 0.312, 0.703, 0.469, 0.5, 0.766);
	private static final AxisAlignedBB ELEMENT10 = new AxisAlignedBB(0.406, 0.312, 0.469, 0.469, 0.5, 0.531);
	private static final AxisAlignedBB ELEMENT11 = new AxisAlignedBB(0.406, 0.312, 0.234, 0.469, 0.5, 0.297);
	private static final AxisAlignedBB ELEMENT12 = new AxisAlignedBB(0.641, 0.062, 0.688, 0.734, 0.312, 0.781);
	private static final AxisAlignedBB ELEMENT13 = new AxisAlignedBB(0.641, 0.062, 0.453, 0.734, 0.312, 0.547);
	private static final AxisAlignedBB ELEMENT14 = new AxisAlignedBB(0.641, 0.062, 0.219, 0.734, 0.312, 0.312);
	private static final AxisAlignedBB ELEMENT15 = new AxisAlignedBB(0.656, 0.312, 0.703, 0.719, 0.5, 0.766);
	private static final AxisAlignedBB ELEMENT16 = new AxisAlignedBB(0.656, 0.312, 0.469, 0.719, 0.5, 0.531);
	private static final AxisAlignedBB ELEMENT17 = new AxisAlignedBB(0.656, 0.312, 0.234, 0.719, 0.5, 0.297);
	private static final AxisAlignedBB ELEMENT18 = new AxisAlignedBB(0.531, 0.312, 0.7, 0.594, 0.5, 0.762);
	private static final AxisAlignedBB ELEMENT19 = new AxisAlignedBB(0.516, 0.062, 0.688, 0.609, 0.312, 0.781);
	private static final AxisAlignedBB ELEMENT20 = new AxisAlignedBB(0.531, 0.312, 0.469, 0.594, 0.5, 0.531);
	private static final AxisAlignedBB ELEMENT21 = new AxisAlignedBB(0.516, 0.062, 0.453, 0.609, 0.312, 0.547);
	private static final AxisAlignedBB ELEMENT22 = new AxisAlignedBB(0.531, 0.312, 0.234, 0.594, 0.5, 0.297);
	private static final AxisAlignedBB ELEMENT23 = new AxisAlignedBB(0.516, 0.062, 0.219, 0.609, 0.312, 0.312);
	
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(BASE, ELEMENT, ELEMENT1, ELEMENT2, ELEMENT3, ELEMENT4, ELEMENT5, ELEMENT6, ELEMENT7, ELEMENT8, ELEMENT9, ELEMENT10, ELEMENT11, ELEMENT12, ELEMENT13, ELEMENT14, ELEMENT15, ELEMENT16, ELEMENT17, ELEMENT18, ELEMENT19, ELEMENT20, ELEMENT21, ELEMENT22, ELEMENT23);
	private static final AxisAlignedBB SPIKETRAP_AABB = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.5, 0.875);
	
	public BlockSpikeTrap(String name) 
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setLightOpacity(0);
		setHardness(4.8f);
		setResistance(30.0f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) 
	{
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return SPIKETRAP_AABB;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
	{
		if(!(worldIn.getBlockState(pos.down()).isTopSolid()))
		{
			return false;
		}
		return true;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) 
	{
		if(entityIn instanceof EntityLivingBase)
		{
			EntityLivingBase entity = ((EntityLivingBase)entityIn);
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = ((EntityPlayer)entity);
				if(!player.capabilities.isCreativeMode)
				{
					player.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", player), 1.0f);
					player.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", player), 2.0f);
					player.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", player), 3.0f);
					worldIn.setBlockState(pos, BlockInit.SPIKE_TRAP_DOWN.getDefaultState());
				}
				return;
			}
			
			else
			{
				entity.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", entity), 1.0f);
				entity.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", entity), 2.0f);
				entity.attackEntityFrom(new DamageSourceSpikeTrap("spike_trap", entity), 3.0f);
				worldIn.setBlockState(pos, BlockInit.SPIKE_TRAP_DOWN.getDefaultState());
			}
		}
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	        {
	            collidingBoxes.add(box.offset(pos));
	        }
	    }
	}
	
	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
	    double distanceSq;
	    double distanceSqShortest = Double.POSITIVE_INFINITY;
	    RayTraceResult resultClosest = null;
	    RayTraceResult result;
	    start = start.subtract(pos.getX(), pos.getY(), pos.getZ());
	    end = end.subtract(pos.getX(), pos.getY(), pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        result = box.calculateIntercept(start, end);
	        if (result == null)
	        {
	            continue;
	        }
	        
	        distanceSq = result.hitVec.squareDistanceTo(start);
	        if (distanceSq < distanceSqShortest)
	        {
	            distanceSqShortest = distanceSq;
	            resultClosest = result;
	        }
	    }
	    return resultClosest == null ? null : new RayTraceResult(RayTraceResult.Type.BLOCK, resultClosest.hitVec.addVector(pos.getX(), pos.getY(), pos.getZ()), resultClosest.sideHit, pos);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}	
}
