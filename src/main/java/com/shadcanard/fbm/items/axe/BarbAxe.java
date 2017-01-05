package com.shadcanard.fbm.items.axe;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class BarbAxe extends ItemSword {


    public final String name;
    public final int MetaNumber;

    //TODO: Add common structure for Barb axes

    public BarbAxe(ToolMaterial material, String name, int MetaNumber) {
        super(material);
        this.name = name;
        this.MetaNumber = MetaNumber;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(FantaBobMod.fbmCreativeTabs);

    }



    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + this.name;
    }

    public void registerItemModel(Item item){ FantaBobMod.proxy.registerItemRenderer(this, MetaNumber, name);}
}
