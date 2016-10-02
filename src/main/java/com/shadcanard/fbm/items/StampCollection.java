package com.shadcanard.fbm.items;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class StampCollection extends ItemFBM {
    public StampCollection(){
        super(Names.Items.STAMP_COLLECTION);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.STAMP_COLLECTION;
    }
}
