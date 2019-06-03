package com.turtywurty.vanillaexpansion.objects.blocks.desert;

import com.turtywurty.vanillaexpansion.init.ItemInit;

import net.minecraft.block.BlockBed;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntitySarcophagus extends TileEntity
{
    @SideOnly(Side.CLIENT)
    public boolean isHeadPiece()
    {
        return BlockSarcophagus.isHeadPiece(this.getBlockMetadata());
    }

    /*public ItemStack getItemStack()
    {
        return new ItemStack(ItemInit.SARCOPHAGUS_PLACER, 1);
    }*/
}
