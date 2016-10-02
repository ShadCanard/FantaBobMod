package com.shadcanard.fbm.items;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.item.Item;

public class ItemFBM extends Item implements IItemModelProvider {

    protected String name;

    public ItemFBM(String name){

        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);

    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + this.name;
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, name);
    }
}