package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpikeTrapDown extends Block implements ITileEntityProvider
{
	private static final AxisAlignedBB BASE = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.062, 0.875);
	private static final AxisAlignedBB ELEMENT = new AxisAlignedBB(0.281, 0.062, 0.234, 0.344, 0.069, 0.297);
	private static final AxisAlignedBB ELEMENT1 = new AxisAlignedBB(0.281, 0.062, 0.469, 0.344, 0.069, 0.531);
	private static final AxisAlignedBB ELEMENT2 = new AxisAlignedBB(0.281, 0.062, 0.703, 0.344, 0.069, 0.766);
	private static final AxisAlignedBB ELEMENT3 = new AxisAlignedBB(0.406, 0.062, 0.703, 0.469, 0.069, 0.766);
	private static final AxisAlignedBB ELEMENT4 = new AxisAlignedBB(0.406, 0.062, 0.469, 0.469, 0.069, 0.531);
	private static final AxisAlignedBB ELEMENT5 = new AxisAlignedBB(0.406, 0.062, 0.234, 0.469, 0.069, 0.297);
	private static final AxisAlignedBB ELEMENT6 = new AxisAlignedBB(0.656, 0.062, 0.703, 0.719, 0.069, 0.766);
	private static final AxisAlignedBB ELEMENT7 = new AxisAlignedBB(0.656, 0.062, 0.469, 0.719, 0.069, 0.531);
	private static final AxisAlignedBB ELEMENT8 = new AxisAlignedBB(0.656, 0.062, 0.234, 0.719, 0.069, 0.297);
	private static final AxisAlignedBB ELEMENT9 = new AxisAlignedBB(0.531, 0.062, 0.7, 0.594, 0.069, 0.762);
	private static final AxisAlignedBB ELEMENT10 = new AxisAlignedBB(0.531, 0.062, 0.469, 0.594, 0.069, 0.531);
	private static final AxisAlignedBB ELEMENT11 = new AxisAlignedBB(0.531, 0.062, 0.234, 0.594, 0.069, 0.297);
	
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(BASE, ELEMENT, ELEMENT1, ELEMENT2, ELEMENT3, ELEMENT4, ELEMENT5, ELEMENT6, ELEMENT7, ELEMENT8, ELEMENT9, ELEMENT10, ELEMENT11);
	private static final AxisAlignedBB SPIKETRAPDOWN_AABB = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.069, 0.875);
	
	public BlockSpikeTrapDown(String name) 
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setLightOpacity(0);
		setHardness(4.2f);
		setResistance(27.0f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return SPIKETRAPDOWN_AABB;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) 
	{
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	            collidingBoxes.add(box.offset(pos));
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
	            continue;

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
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntitySandTrapDown();
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
