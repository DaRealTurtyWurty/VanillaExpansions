package com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone;

import java.util.Random;

import com.turtywurty.vanillaexpansion.init.BlockInit;
import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockBluestoneDiode extends BlockHorizontal
{
	protected static final AxisAlignedBB BLUESTONE_DIODE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
    /** Tells whether the repeater is powered or not */
    protected final boolean isRepeaterPowered;

    protected BlockBluestoneDiode(String name, boolean powered)
    {
        super(Material.CIRCUITS);
        this.isRepeaterPowered = powered;
        setUnlocalizedName(name);
        setRegistryName(name);
        
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BLUESTONE_DIODE_AABB;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID) ? super.canPlaceBlockAt(worldIn, pos) : false;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
    }

    /**
     * Called randomly when setTickRandomly is set to true (used by e.g. crops to grow, etc.)
     */
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
    	
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!this.isLocked(worldIn, pos, state))
        {
            boolean flag = this.shouldBePowered(worldIn, pos, state);

            if (this.isRepeaterPowered && !flag)
            {
                worldIn.setBlockState(pos, this.getUnpoweredState(state), 2);
            }
            else if (!this.isRepeaterPowered)
            {
                worldIn.setBlockState(pos, this.getPoweredState(state), 2);

                if (!flag)
                {
                    worldIn.updateBlockTick(pos, this.getPoweredState(state).getBlock(), this.getTickDelay(state), -1);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side.getAxis() != EnumFacing.Axis.Y;
    }

    protected boolean isPowered(IBlockState state)
    {
        return this.isRepeaterPowered;
    }

    public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return blockState.getWeakPower(blockAccess, pos, side);
    }

    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        if (!this.isPowered(blockState))
        {
            return 0;
        }
        else
        {
            return blockState.getValue(FACING) == side ? this.getActiveSignal(blockAccess, pos, blockState) : 0;
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when bluestone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (this.canBlockStay(worldIn, pos))
        {
            this.updateState(worldIn, pos, state);
        }
        else
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);

            for (EnumFacing enumfacing : EnumFacing.values())
            {
                worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
            }
        }
    }

    protected void updateState(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.isLocked(worldIn, pos, state))
        {
            boolean flag = this.shouldBePowered(worldIn, pos, state);

            if (this.isRepeaterPowered != flag && !worldIn.isBlockTickPending(pos, this))
            {
                int i = -1;

                if (this.isFacingTowardsRepeater(worldIn, pos, state))
                {
                    i = -3;
                }
                else if (this.isRepeaterPowered)
                {
                    i = -2;
                }

                worldIn.updateBlockTick(pos, this, this.getDelay(state), i);
            }
        }
    }

    public boolean isLocked(IBlockAccess worldIn, BlockPos pos, IBlockState state)
    {
        return false;
    }

    protected boolean shouldBePowered(World worldIn, BlockPos pos, IBlockState state)
    {
        return this.calculateInputStrength(worldIn, pos, state) > 0;
    }

    protected int calculateInputStrength(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        BlockPos blockpos = pos.offset(enumfacing);
        int i = worldIn.getRedstonePower(blockpos, enumfacing);

        if (i >= 15)
        {
            return i;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
            return Math.max(i, iblockstate.getBlock() == BlockInit.BLUESTONE ? ((Integer)iblockstate.getValue(BlockBluestoneWire.POWER)).intValue() : 0);
        }
    }

    protected int getPowerOnSides(IBlockAccess worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        EnumFacing enumfacing1 = enumfacing.rotateY();
        EnumFacing enumfacing2 = enumfacing.rotateYCCW();
        return Math.max(this.getPowerOnSide(worldIn, pos.offset(enumfacing1), enumfacing1), this.getPowerOnSide(worldIn, pos.offset(enumfacing2), enumfacing2));
    }

    protected int getPowerOnSide(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (this.isAlternateInput(iblockstate))
        {
            if(block == BlockInit.BLUESTONE_BLOCK)
            {
                return 15;
            }
            else
            {
                return block == BlockInit.BLUESTONE ? ((Integer)iblockstate.getValue(BlockBluestoneWire.POWER)).intValue() : worldIn.getStrongPower(pos, side);
            }
        }
        else
        {
            return 0;
        }
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower(IBlockState state)
    {
        return true;
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if (this.shouldBePowered(worldIn, pos, state))
        {
            worldIn.scheduleUpdate(pos, this, 1);
        }
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.notifyNeighbors(worldIn, pos, state);
    }

    protected void notifyNeighbors(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        BlockPos blockpos = pos.offset(enumfacing.getOpposite());
        if(net.minecraftforge.event.ForgeEventFactory.onNeighborNotify(worldIn, pos, worldIn.getBlockState(pos), java.util.EnumSet.of(enumfacing.getOpposite()), false).isCanceled())
            return;
        worldIn.neighborChanged(blockpos, this, pos);
        worldIn.notifyNeighborsOfStateExcept(blockpos, this, enumfacing);
    }

    /**
     * Called after a player destroys this Block - the posiiton pos may no longer hold the state indicated.
     */
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.isRepeaterPowered)
        {
            for (EnumFacing enumfacing : EnumFacing.values())
            {
                worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
            }
        }

        super.onBlockDestroyedByPlayer(worldIn, pos, state);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    protected boolean isAlternateInput(IBlockState state)
    {
        return state.canProvidePower();
    }

    protected int getActiveSignal(IBlockAccess worldIn, BlockPos pos, IBlockState state)
    {
        return 15;
    }

    public static boolean isDiode(IBlockState state)
    {
        return Blocks.UNPOWERED_REPEATER.isSameDiode(state) || Blocks.UNPOWERED_COMPARATOR.isSameDiode(state);
    }

    public boolean isSameDiode(IBlockState state)
    {
        Block block = state.getBlock();
        return block == this.getPoweredState(this.getDefaultState()).getBlock() || block == this.getUnpoweredState(this.getDefaultState()).getBlock();
    }

    public boolean isFacingTowardsRepeater(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = ((EnumFacing)state.getValue(FACING)).getOpposite();
        BlockPos blockpos = pos.offset(enumfacing);

        if (isDiode(worldIn.getBlockState(blockpos)))
        {
            return worldIn.getBlockState(blockpos).getValue(FACING) != enumfacing;
        }
        else
        {
            return false;
        }
    }

    protected int getTickDelay(IBlockState state)
    {
        return this.getDelay(state);
    }

    protected abstract int getDelay(IBlockState state);

    protected abstract IBlockState getPoweredState(IBlockState unpoweredState);

    protected abstract IBlockState getUnpoweredState(IBlockState poweredState);

    public boolean isAssociatedBlock(Block other)
    {
        return this.isSameDiode(other.getDefaultState());
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
    {
        if (super.rotateBlock(world, pos, axis))
        {
            IBlockState state = world.getBlockState(pos);
            state = getUnpoweredState(state);
            world.setBlockState(pos, state);

            if (shouldBePowered(world, pos, state))
            {
                world.scheduleUpdate(pos, this, 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
}
