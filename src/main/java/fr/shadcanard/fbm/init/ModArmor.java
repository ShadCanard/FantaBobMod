package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.items.ItemArmorFBM;
import fr.shadcanard.fbm.references.Names;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmor {
    public static Item fantaGlasses, cobbleTie, hairPotion;
    public static ArmorMaterial armorFBM;

    public static void init(){
        armorFBM = EnumHelper.addArmorMaterial("armorFBM",5,new int[] { 4,6,5,4}, 20);
        fantaGlasses = new ItemArmorFBM(0, Names.Items.FANTA_GLASSES);
        cobbleTie = new ItemArmorFBM(1, Names.Items.COBBLE_TIE);
        hairPotion = new ItemArmorFBM(0, Names.Items.HAIR_POTION);



        GameRegistry.registerItem(fantaGlasses, Names.Items.FANTA_GLASSES);
        GameRegistry.registerItem(cobbleTie, Names.Items.COBBLE_TIE);
        GameRegistry.registerItem(hairPotion,Names.Items.HAIR_POTION);
    }
}
