package com.shadcanard.fbm.blocks;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;

public class BlockBouze extends BlockFBM {
    public BlockBouze(){
        super(Names.Blocks.BLOCK_BOUZE);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Blocks.BLOCK_BOUZE;
    }
}
