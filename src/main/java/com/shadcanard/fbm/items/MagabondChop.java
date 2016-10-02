package com.shadcanard.fbm.items;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class MagabondChop extends ItemFBM {

    public MagabondChop(){
        super(Names.Items.MAGABOND_CHOP);
    }


    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.MAGABOND_CHOP;
    }
}
