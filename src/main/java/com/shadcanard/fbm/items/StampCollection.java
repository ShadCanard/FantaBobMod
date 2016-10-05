package com.shadcanard.fbm.items;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StampCollection extends ItemFBM {
    public StampCollection(){
        super(Names.Items.STAMP_COLLECTION);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.STAMP_COLLECTION;
    }


}
