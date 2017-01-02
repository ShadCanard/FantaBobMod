package com.shadcanard.fbm.entity.buddy;

import com.shadcanard.fbm.helpers.ChatHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BuddyFanta extends Buddy {

    public BuddyFanta(World worldIn) {
        super(worldIn);
        setSounds("fanta");
    }

    @Override
    public void onDeath(DamageSource cause) {
        ChatHelper.AddBuddyKill("Mini-Fanta", cause.getEntity().getName());
    }
}
