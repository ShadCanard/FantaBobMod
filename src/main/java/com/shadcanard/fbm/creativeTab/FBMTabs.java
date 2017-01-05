package com.shadcanard.fbm.creativeTab;

import com.shadcanard.fbm.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class FBMTabs extends CreativeTabs {
    public FBMTabs(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.diamondBarbAxe;
    }
}
