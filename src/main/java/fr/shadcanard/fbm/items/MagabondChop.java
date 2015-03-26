package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;

public class MagabondChop extends ItemFBM {

    public MagabondChop(){
        super();
        this.setUnlocalizedName(Names.Items.MAGABOND_CHOP);
    }


    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.MAGABOND_CHOP;
    }
}
