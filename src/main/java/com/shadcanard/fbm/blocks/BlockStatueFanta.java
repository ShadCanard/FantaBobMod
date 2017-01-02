package com.shadcanard.fbm.blocks;

import com.shadcanard.fbm.entity.EntityFanta;
import com.shadcanard.fbm.entity.buddy.BuddyFanta;
import com.shadcanard.fbm.items.ItemArgent;
import com.shadcanard.fbm.references.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by kurt_ on 04/10/2016.
 */
public class BlockStatueFanta extends BlockStatue {
    public BlockStatueFanta() {
        super(Names.Blocks.BLOCK_STATUE_FANTA);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        AxisAlignedBB AABB = new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.12F, 0.75F);
        return AABB;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
        if(!worldIn.isRemote){
            if(playerIn.getHeldItem(hand).getItem() instanceof ItemArgent){
                spawnPet(new BuddyFanta(worldIn), pos);
            }
        }
        return true;
    }

}
