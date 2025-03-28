package com.turtywurty.vanillaexpansion.objects.blocks.underground.bluestone;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.turtywurty.vanillaexpansion.init.BlockInit;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBluestoneComparator extends BlockBluestoneDiode implements ITileEntityProvider
{
	public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyEnum<BlockBluestoneComparator.Mode> MODE = PropertyEnum.<BlockBluestoneComparator.Mode>create("mode", BlockBluestoneComparator.Mode.class);

    public BlockBluestoneComparator(String name, boolean powered)
    {
        super(name, powered);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED, Boolean.valueOf(false)).withProperty(MODE, BlockBluestoneComparator.Mode.COMPARE));
        this.hasTileEntity = true;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockInit.UNPOWERED_BLUESTONE_COMPARATOR);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockInit.UNPOWERED_BLUESTONE_COMPARATOR);
    }

    protected int getDelay(IBlockState state)
    {
        return 2;
    }

    protected IBlockState getPoweredState(IBlockState unpoweredState)
    {
        Boolean obool = (Boolean)unpoweredState.getValue(POWERED);
        BlockBluestoneComparator.Mode blockbluestonecomparator$mode = (BlockBluestoneComparator.Mode)unpoweredState.getValue(MODE);
        EnumFacing enumfacing = (EnumFacing)unpoweredState.getValue(FACING);
        return BlockInit.BLUESTONE_COMPARATOR.getDefaultState().withProperty(FACING, enumfacing).withProperty(POWERED, obool).withProperty(MODE, blockbluestonecomparator$mode);
    }

    protected IBlockState getUnpoweredState(IBlockState poweredState)
    {
        Boolean obool = (Boolean)poweredState.getValue(POWERED);
        BlockBluestoneComparator.Mode blockbluestonecomparator$mode = (BlockBluestoneComparator.Mode)poweredState.getValue(MODE);
        EnumFacing enumfacing = (EnumFacing)poweredState.getValue(FACING);
        return BlockInit.UNPOWERED_BLUESTONE_COMPARATOR.getDefaultState().withProperty(FACING, enumfacing).withProperty(POWERED, obool).withProperty(MODE, blockbluestonecomparator$mode);
    }

    protected boolean isPowered(IBlockState state)
    {
        return this.isRepeaterPowered || ((Boolean)state.getValue(POWERED)).booleanValue();
    }

    protected int getActiveSignal(IBlockAccess worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof TileEntityBluestoneComparator ? ((TileEntityBluestoneComparator)tileentity).getOutputSignal() : 0;
    }

    private int calculateOutput(World worldIn, BlockPos pos, IBlockState state)
    {
        return state.getValue(MODE) == BlockBluestoneComparator.Mode.SUBTRACT ? Math.max(this.calculateInputStrength(worldIn, pos, state) - this.getPowerOnSides(worldIn, pos, state), 0) : this.calculateInputStrength(worldIn, pos, state);
    }

    protected boolean shouldBePowered(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = this.calculateInputStrength(worldIn, pos, state);

        if (i >= 15)
        {
            return true;
        }
        else if (i == 0)
        {
            return false;
        }
        else
        {
            int j = this.getPowerOnSides(worldIn, pos, state);

            if (j == 0)
            {
                return true;
            }
            else
            {
                return i >= j;
            }
        }
    }

    protected int calculateInputStrength(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = super.calculateInputStrength(worldIn, pos, state);
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        BlockPos blockpos = pos.offset(enumfacing);
        IBlockState iblockstate = worldIn.getBlockState(blockpos);

        if (iblockstate.hasComparatorInputOverride())
        {
            i = iblockstate.getComparatorInputOverride(worldIn, blockpos);
        }
        else if (i < 15 && iblockstate.isNormalCube())
        {
            blockpos = blockpos.offset(enumfacing);
            iblockstate = worldIn.getBlockState(blockpos);

            if (iblockstate.hasComparatorInputOverride())
            {
                i = iblockstate.getComparatorInputOverride(worldIn, blockpos);
            }
            else if (iblockstate.getMaterial() == Material.AIR)
            {
                EntityItemFrame entityitemframe = this.findItemFrame(worldIn, enumfacing, blockpos);

                if (entityitemframe != null)
                {
                    i = entityitemframe.getAnalogOutput();
                }
            }
        }

        return i;
    }

    @Nullable
    private EntityItemFrame findItemFrame(World worldIn, final EnumFacing facing, BlockPos pos)
    {
        List<EntityItemFrame> list = worldIn.<EntityItemFrame>getEntitiesWithinAABB(EntityItemFrame.class, new AxisAlignedBB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 1), (double)(pos.getZ() + 1)), new Predicate<Entity>()
        {
            public boolean apply(@Nullable Entity p_apply_1_)
            {
                return p_apply_1_ != null && p_apply_1_.getHorizontalFacing() == facing;
            }
        });
        return list.size() == 1 ? (EntityItemFrame)list.get(0) : null;
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.capabilities.allowEdit)
        {
            return false;
        }
        else
        {
            state = state.cycleProperty(MODE);
            float f = state.getValue(MODE) == BlockBluestoneComparator.Mode.SUBTRACT ? 0.55F : 0.5F;
            worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3F, f);
            worldIn.setBlockState(pos, state, 2);
            this.onStateChange(worldIn, pos, state);
            return true;
        }
    }

    protected void updateState(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isBlockTickPending(pos, this))
        {
            int i = this.calculateOutput(worldIn, pos, state);
            TileEntity tileentity = worldIn.getTileEntity(pos);
            int j = tileentity instanceof TileEntityBluestoneComparator ? ((TileEntityBluestoneComparator)tileentity).getOutputSignal() : 0;

            if (i != j || this.isPowered(state) != this.shouldBePowered(worldIn, pos, state))
            {
                if (this.isFacingTowardsRepeater(worldIn, pos, state))
                {
                    worldIn.updateBlockTick(pos, this, 2, -1);
                }
                else
                {
                    worldIn.updateBlockTick(pos, this, 2, 0);
                }
            }
        }
    }

    private void onStateChange(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = this.calculateOutput(worldIn, pos, state);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        int j = 0;

        if (tileentity instanceof TileEntityBluestoneComparator)
        {
        	TileEntityBluestoneComparator tileentitybluestonecomparator = (TileEntityBluestoneComparator)tileentity;
            j = tileentitybluestonecomparator.getOutputSignal();
            tileentitybluestonecomparator.setOutputSignal(i);
        }

        if (j != i || state.getValue(MODE) == BlockBluestoneComparator.Mode.COMPARE)
        {
            boolean flag1 = this.shouldBePowered(worldIn, pos, state);
            boolean flag = this.isPowered(state);

            if (flag && !flag1)
            {
                worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(false)), 2);
            }
            else if (!flag && flag1)
            {
                worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(true)), 2);
            }

            this.notifyNeighbors(worldIn, pos, state);
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isRepeaterPowered)
        {
            worldIn.setBlockState(pos, this.getUnpoweredState(state).withProperty(POWERED, Boolean.valueOf(true)), 4);
        }

        this.onStateChange(worldIn, pos, state);
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        worldIn.setTileEntity(pos, this.createNewTileEntity(worldIn, 0));
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
        this.notifyNeighbors(worldIn, pos, state);
    }

    /**
     * Called on server when World#addBlockEvent is called. If server returns true, then also called on the client. On
     * the Server, this may perform additional changes to the world, like pistons replacing the block with an extended
     * base. On the client, the update may involve replacing tile entities or effects such as sounds or particles
     */
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBluestoneComparator();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(POWERED, Boolean.valueOf((meta & 8) > 0)).withProperty(MODE, (meta & 4) > 0 ? BlockBluestoneComparator.Mode.SUBTRACT : BlockBluestoneComparator.Mode.COMPARE);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();

        if (((Boolean)state.getValue(POWERED)).booleanValue())
        {
            i |= 8;
        }

        if (state.getValue(MODE) == BlockBluestoneComparator.Mode.SUBTRACT)
        {
            i |= 4;
        }

        return i;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, MODE, POWERED});
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(POWERED, Boolean.valueOf(false)).withProperty(MODE, BlockBluestoneComparator.Mode.COMPARE);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor)
    {
        if (pos.getY() == neighbor.getY() && world instanceof World && !((World) world).isRemote)
        {
            neighborChanged(world.getBlockState(pos), (World)world, pos, world.getBlockState(neighbor).getBlock(), neighbor);
        }
    }

    @Override
    public boolean getWeakChanges(IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    public static enum Mode implements IStringSerializable
    {
        COMPARE("compare"),
        SUBTRACT("subtract");

        private final String name;

        private Mode(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }
}
