package com.shadcanard.fbm.items.guitar.parts;

import com.shadcanard.fbm.items.ItemFBM;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class stringsGuitar extends ItemFBM {

    public stringsGuitar(){
        super(Names.Items.GUITAR_STRING);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.GUITAR_STRING;
    }
}
