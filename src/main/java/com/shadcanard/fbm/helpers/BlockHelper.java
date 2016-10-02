package com.shadcanard.fbm.helpers;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Shad on 30/09/2016.
 */
public class BlockHelper {

    public static BlockPos getBlockNeighbor(BlockPos pos, EnumFacing facing) {
        switch(facing){
            case UP:
                return new BlockPos(pos.getX(),pos.getY() + 1, pos.getZ());
            case DOWN:
                return new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            case EAST:
                return new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            case WEST:
                return new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            case NORTH:
                return new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
            case SOUTH:
                return new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 1);
        }
        return pos;
    }
}
