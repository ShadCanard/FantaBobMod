package com.shadcanard.fbm.items.guitar.parts;

import com.shadcanard.fbm.items.ItemFBM;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class headGuitar extends ItemFBM {

    public headGuitar(){
        super(Names.Items.GUITAR_HEAD);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.GUITAR_HEAD;
    }
}
