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
    public static ArmorMaterial armorFBM, cosplayFanta, cosplayBob, armorFBMbis;
    public static ArmorFBM hairPotion,fantaGlasses,cobbleTie;
    public static ArmorFBM fantaHead, fantaChest, fantaLegs, fantaBoots, bobHead, bobChest, bobLegs, bobBoots;

    public static void init(){
        armorFBMbis = EnumHelper.addArmorMaterial("armorFBM2","fbm:armorFBMbis",10,new int[] {2,4,3,1},20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,5.0F);
        armorFBM = EnumHelper.addArmorMaterial("armorFBM","fbm:armorFBM",10,new int[] {2,4,3,1},20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,5.0F);
        cosplayFanta = EnumHelper.addArmorMaterial("cosplayFanta","fbm:armorFanta",10,new int[] {2,4,3,1},20,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,2.0F);
        cosplayBob = EnumHelper.addArmorMaterial("cosplayBob","fbm:armorBob",10,new int[] {2,4,3,1},20,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,2.0F);

        hairPotion = register(new ArmorFBM(Names.Items.HAIR_POTION,armorFBM,1, EntityEquipmentSlot.HEAD));
        fantaGlasses = register(new ArmorFBM(Names.Items.FANTA_GLASSES,armorFBMbis,1,EntityEquipmentSlot.HEAD));
        cobbleTie = register(new ArmorFBM(Names.Items.COBBLE_TIE,armorFBMbis,1,EntityEquipmentSlot.CHEST));
        fantaHead = register(new ArmorFBM(Names.Items.FANTA_HEAD,cosplayFanta,1,EntityEquipmentSlot.HEAD));
        fantaChest = register(new ArmorFBM(Names.Items.FANTA_CHEST,cosplayFanta,1,EntityEquipmentSlot.CHEST));
        fantaLegs = register(new ArmorFBM(Names.Items.FANTA_LEGS,cosplayFanta,2,EntityEquipmentSlot.LEGS));
        fantaBoots = register(new ArmorFBM(Names.Items.FANTA_BOOTS,cosplayFanta,1,EntityEquipmentSlot.FEET));
        fantaHead = register(new ArmorFBM(Names.Items.BOB_HEAD,cosplayBob,1,EntityEquipmentSlot.HEAD));
        fantaChest = register(new ArmorFBM(Names.Items.BOB_CHEST,cosplayBob,1,EntityEquipmentSlot.CHEST));
        fantaLegs = register(new ArmorFBM(Names.Items.BOB_LEGS,cosplayBob,2,EntityEquipmentSlot.LEGS));
        fantaBoots = register(new ArmorFBM(Names.Items.BOB_BOOTS,cosplayBob,1,EntityEquipmentSlot.FEET));
    }
    static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if(item instanceof IItemModelProvider) {
            ((IItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }
}
