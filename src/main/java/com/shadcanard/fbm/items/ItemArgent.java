package com.shadcanard.fbm.items;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

/**
 * Created by Shad on 13/09/2016.
 */
public class ItemArgent extends ItemFBM {
    public ItemArgent() {
        super(Names.Items.ITEM_ARGENT);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.ITEM_ARGENT;
    }
}
