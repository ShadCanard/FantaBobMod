package com.shadcanard.fbm.entity.buddy;

import com.shadcanard.fbm.references.Reference;
import net.minecraft.world.World;

public class BuddyTipeee extends Buddy {

    private String name;


    @Override
    public String getName() {
        return name;
    }

    public BuddyTipeee(World worldIn) {
        super(worldIn);
        setSounds("null");
        int ref = (int)(Math.random() * ((Reference.TIPEEE_LIST.length)));
        name = Reference.TIPEEE_LIST[ref];
        setCustomNameTag("Mini-" + name);
    }
}
