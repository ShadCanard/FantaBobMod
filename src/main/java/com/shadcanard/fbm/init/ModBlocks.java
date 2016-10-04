package com.shadcanard.fbm.init;

import com.shadcanard.fbm.blocks.*;
import com.shadcanard.fbm.items.IItemModelProvider;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static BlockFBM blockBouze, blockCreeperSkeleton, blockStatueFanta, blockStatueBob;

    public static void init() {
        blockBouze = register(new BlockBouze());
        blockCreeperSkeleton = register(new BlockPlasticCreeper());
        blockStatueFanta = register(new BlockStatueFanta());
        blockStatueBob = register(new BlockStatueBob());
    }

    private static <T extends Block> T register (T block, ItemBlock itemBlock) {

        GameRegistry.register(block);
        if(itemBlock != null) {
            GameRegistry.register(itemBlock);
        }

        if(block instanceof IItemModelProvider) {
            ((IItemModelProvider)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
