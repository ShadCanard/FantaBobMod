package com.shadcanard.fbm.items;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class BambooSword extends ItemSword implements IItemModelProvider {

    public final String name;
    public BambooSword(String name) {
        super(ToolMaterial.WOOD);
        this.name = name;
        this.setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
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
