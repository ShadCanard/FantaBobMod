package com.shadcanard.fbm.items;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class BobAxe extends ItemSword implements IItemModelProvider {

    public BobAxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(Names.Items.BOB_AXE);
        setRegistryName(Names.Items.BOB_AXE);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.BOB_AXE;
    }

    @Override
    public void registerItemModel(Item item) {

        FantaBobMod.proxy.registerItemRenderer(this, 0, Names.Items.BOB_AXE);
    }
}
