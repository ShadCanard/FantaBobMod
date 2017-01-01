package com.shadcanard.fbm.entity.buddy;

import net.minecraft.world.World;

public class BuddyBob extends Buddy {

    public BuddyBob(World worldIn) {
        super(worldIn);
        setSounds("bob");
        setCustomNameTag("MiniBob");
    }
}
