package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.items.*;
import fr.shadcanard.fbm.references.Names;
import net.minecraft.item.Item;

public class ModItems {
    public static ItemFBM magabondChop, magabondRecord, toothBrush, stampCollection;
    public static Item record_Avion, record_pyrobarbare, record_magabondMix, bobAxe, bambooSword, pyroAxe;

    public static void init() {

        pyroAxe = new PyroAxe(Item.ToolMaterial.EMERALD);
        bobAxe = new BobAxe(Item.ToolMaterial.EMERALD).setUnlocalizedName(Names.Items.BOB_AXE);
        record_pyrobarbare = new MusicDisc("pyroBarbare").setUnlocalizedName(Names.Items.PYROBARBARE_RECORD);
        record_magabondMix = new MusicDisc("magabondMix").setUnlocalizedName(Names.Items.MAGABOND_RECORD);
        record_Avion = new MusicDisc("fantaAvion").setUnlocalizedName(Names.Items.AVION_RECORD);
        bambooSword = new BambooSword(Names.Items.BAMBOO_SWORD);
        magabondChop = new MagabondChop();
        toothBrush = new ToothBrush();
        stampCollection = new StampCollection();

        GameRegistry.registerItem(pyroAxe, Names.Items.PYROBARBARE_AXE);
        System.out.println(pyroAxe);
        GameRegistry.registerItem(bobAxe, Names.Items.BOB_AXE);
        System.out.println(bobAxe);
        GameRegistry.registerItem(record_magabondMix,Names.Items.MAGABOND_RECORD);
        System.out.println(record_magabondMix);
        GameRegistry.registerItem(record_Avion,Names.Items.AVION_RECORD);
        System.out.println(record_Avion);
        GameRegistry.registerItem(record_pyrobarbare,Names.Items.PYROBARBARE_RECORD);
        System.out.println(record_pyrobarbare);
        GameRegistry.registerItem(bambooSword, Names.Items.BAMBOO_SWORD);
        System.out.println(bambooSword);
        GameRegistry.registerItem(magabondChop, Names.Items.MAGABOND_CHOP);
        System.out.println(magabondChop);
        GameRegistry.registerItem(toothBrush, Names.Items.TOOTH_BRUSH);
        System.out.println(toothBrush);
        GameRegistry.registerItem(stampCollection, Names.Items.STAMP_COLLECTION);
        System.out.println(stampCollection);
    }
}
