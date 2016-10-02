package com.shadcanard.fbm.init;

import com.shadcanard.fbm.armor.ArmorFBM;
import com.shadcanard.fbm.items.IItemModelProvider;
import com.shadcanard.fbm.references.Names;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmor {
    public static ArmorMaterial armorFBM, cosplayFanta, cosplayBob;
    public static ArmorFBM hairPotion,fantaGlasses,cobbleTie;

    public static void init(){
        armorFBM = EnumHelper.addArmorMaterial("armorFBM","fbm:armorFBM",10,new int[] {2,4,3,1},20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,5.0F);
        cosplayFanta = EnumHelper.addArmorMaterial("cosplayFanta","fbm:armorFanta",10,new int[] {2,4,3,1},20,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,2.0F);
        cosplayBob = EnumHelper.addArmorMaterial("cosplayBob","fbm:armorBob",10,new int[] {2,4,3,1},20,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,2.0F);

        hairPotion = register(new ArmorFBM(Names.Items.HAIR_POTION,armorFBM,0, EntityEquipmentSlot.HEAD));
        fantaGlasses = register(new ArmorFBM(Names.Items.FANTA_GLASSES,armorFBM,1,EntityEquipmentSlot.HEAD));
        cobbleTie = register(new ArmorFBM(Names.Items.COBBLE_TIE,armorFBM,1,EntityEquipmentSlot.CHEST));


    }
    static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if(item instanceof IItemModelProvider) {
            ((IItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }
}
