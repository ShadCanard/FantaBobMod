package com.shadcanard.fbm.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

/**
 * Created by Shad on 09/02/2016.
 */
public class ArmorFBM extends ItemArmor {
    public ArmorFBM(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }
}
