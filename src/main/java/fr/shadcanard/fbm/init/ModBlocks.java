package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.blocks.BlockBouze;
import fr.shadcanard.fbm.blocks.BlockFBM;
import fr.shadcanard.fbm.references.Names;

public class ModBlocks {
    public static BlockFBM blockBouze = new BlockBouze();
    public static void init() {

        GameRegistry.registerBlock(blockBouze, Names.Blocks.BLOCK_BOUZE);
    }
}
