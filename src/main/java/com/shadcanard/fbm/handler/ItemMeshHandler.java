package com.shadcanard.fbm.handler;

import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by kurt_ on 03/10/2016.
 */
public class ItemMeshHandler implements ItemMeshDefinition {
    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack) {
        return new ModelResourceLocation(Reference.MOD_ID + ":" + Item.getIdFromItem(stack.getItem()),"inventory");
    }
}
