package com.shadcanard.fbm.items.guitar.parts;

import com.shadcanard.fbm.items.ItemFBM;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class bodyGuitar extends ItemFBM {
    public bodyGuitar(){
        super(Names.Items.GUITAR_BODY);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.GUITAR_BODY;
    }
}
