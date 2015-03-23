package fr.shadcanard.fbm.blocks;

import fr.shadcanard.fbm.references.Names;
import net.minecraft.block.material.Material;

public class BlockBouze extends BlockFBM {
    public BlockBouze(){
        super(Material.ground);
        this.setBlockName(Names.Blocks.BLOCK_BOUZE);
        this.setBlockTextureName(Names.Blocks.BLOCK_BOUZE);
    }
}
