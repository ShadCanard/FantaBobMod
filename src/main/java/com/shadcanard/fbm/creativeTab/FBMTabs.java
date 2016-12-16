package com.shadcanard.fbm.creativeTab;

import com.shadcanard.fbm.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FBMTabs extends CreativeTabs {
    public FBMTabs(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.pyroAxe);
    }
}
