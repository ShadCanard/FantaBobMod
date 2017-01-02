package com.shadcanard.fbm.entity.buddy;

import com.shadcanard.fbm.helpers.ChatHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BuddyBob extends Buddy {

    public BuddyBob(World worldIn) {
        super(worldIn);
        setSounds("bob");
    }

    @Override
    public void onDeath(DamageSource cause) {
        ChatHelper.AddBuddyKill("Mini-Bob", cause.getEntity().getName());
    }
}
