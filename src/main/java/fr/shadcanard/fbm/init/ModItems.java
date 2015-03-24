package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.items.*;
import fr.shadcanard.fbm.references.Names;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;

public class ModItems {
    public static ItemFBM bambooSword;
    public static ItemFBM magabondChop;
    public static ItemFBM magabondRecord;
    public static ItemFBM toothBrush;
    public static ItemFBM stampCollection;
    public static Item record_Avion;

    public static void init() {

        record_Avion = new MusicDisc("Avion").setUnlocalizedName(Names.Items.AVION_RECORD).setCreativeTab(FantaBobMod.fbmCreativeTabs);
        bambooSword = new BambooSword();
        magabondChop = new MagabondChop();
        magabondRecord = new MagabondRecord();
        toothBrush = new ToothBrush();
        stampCollection = new StampCollection();

        GameRegistry.registerItem(record_Avion,Names.Items.AVION_RECORD);
        GameRegistry.registerItem(bambooSword, Names.Items.BAMBOO_SWORD);
        GameRegistry.registerItem(magabondChop, Names.Items.MAGABOND_CHOP);
        GameRegistry.registerItem(magabondRecord, Names.Items.MAGABOND_RECORD);
        GameRegistry.registerItem(toothBrush, Names.Items.TOOTH_BRUSH);
        GameRegistry.registerItem(stampCollection, Names.Items.STAMP_COLLECTION);
    }
}
