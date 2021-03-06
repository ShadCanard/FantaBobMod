package com.shadcanard.fbm.blocks;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.entity.buddy.Buddy;
import com.shadcanard.fbm.references.Names;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by kurt_ on 04/10/2016.
 */
public class BlockStatue extends BlockFBM {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockStatue(String name) {
        super(name);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    protected void spawnBuddy(Buddy buddy){
        buddy.getEntityWorld().createExplosion(null,buddy.getPosition().getX(), buddy.getPosition().getY(), buddy.getPosition().getZ(), 0, true);
        buddy.getEntityWorld().setBlockToAir(buddy.getPosition());
        buddy.getEntityWorld().spawnEntityInWorld(buddy);
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing());
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }


    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }



}
