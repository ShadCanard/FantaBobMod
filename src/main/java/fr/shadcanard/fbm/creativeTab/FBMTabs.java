package fr.shadcanard.fbm.creativeTab;

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
        ItemStack bobHead = new ItemStack(Items.skull,1,3);
        bobHead.setTagCompound(new NBTTagCompound());
        bobHead.getTagCompound().setString("SkullOwner","Boblennon");
        return bobHead.getItem();
    }
}
