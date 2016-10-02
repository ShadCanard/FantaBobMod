package com.shadcanard.fbm.blocks;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.SoundHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBouze extends BlockFBM {
    public BlockBouze(){
        super(Names.Blocks.BLOCK_BOUZE);
        setSoundType(new SoundType(
                1.0F,
                1.0F,
                SoundEvents.BLOCK_SLIME_BREAK,
                getWalkSound(),
                SoundEvents.BLOCK_SLIME_PLACE,
                SoundEvents.BLOCK_SLIME_HIT,
                SoundEvents.BLOCK_SLIME_FALL
        ));

    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Blocks.BLOCK_BOUZE;
    }


    public SoundEvent getWalkSound(){
        return new SoundEvent(new ResourceLocation("fbm:sounds.bouze.walk"));
    }
}
