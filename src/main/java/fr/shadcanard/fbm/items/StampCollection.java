package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;

public class StampCollection extends ItemFBM {
    public StampCollection(){
        super();
        this.setUnlocalizedName(Names.Items.STAMP_COLLECTION);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.STAMP_COLLECTION;
    }
}
