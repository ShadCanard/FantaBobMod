package com.shadcanard.fbm.init;

import com.shadcanard.fbm.items.*;
import com.shadcanard.fbm.items.guitar.Clementine;
import com.shadcanard.fbm.items.guitar.parts.bodyGuitar;
import com.shadcanard.fbm.items.guitar.parts.headGuitar;
import com.shadcanard.fbm.items.guitar.parts.stringsGuitar;
import com.shadcanard.fbm.items.guitar.parts.topGuitar;
import com.shadcanard.fbm.references.Names;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemFBM magabondChop, toothBrush, stampCollection,
            clementine, clementine_top, clementine_body, clementine_head, clementine_string,
            debugTool, itemArgent;
    public static Item record_Avion, record_pyrobarbare, record_magabondMix, record_Metalleux, bobAxe, bambooSword, pyroAxe;
    public static ItemFood mamelouBucket, mamelouCheese;

    public static void init() {

        pyroAxe = new PyroAxe(Item.ToolMaterial.DIAMOND);
        pyroAxe = register(new PyroAxe(Item.ToolMaterial.DIAMOND));
        bobAxe = new BobAxe(Item.ToolMaterial.DIAMOND).setUnlocalizedName(Names.Items.BOB_AXE);
        pyroAxe = register(new BobAxe(Item.ToolMaterial.DIAMOND));
        record_pyrobarbare = register(new MusicDisc("pyroBarbare").setUnlocalizedName(Names.Items.PYROBARBARE_RECORD));
        record_magabondMix = register(new MusicDisc("magabondMix").setUnlocalizedName(Names.Items.MAGABOND_RECORD));
        record_Avion = register(new MusicDisc("fantaAvion").setUnlocalizedName(Names.Items.AVION_RECORD));
        record_Metalleux = register(new MusicDisc("metalleux").setUnlocalizedName(Names.Items.METALLEUX_RECORD));
        bambooSword = register(new BambooSword(Names.Items.BAMBOO_SWORD));
        magabondChop = register(new MagabondChop());
        toothBrush = register(new ToothBrush());
        stampCollection = register(new StampCollection());
        clementine = register(new Clementine());
        clementine_top = register(new topGuitar());
        clementine_body = register(new bodyGuitar());
        clementine_head = register(new headGuitar());
        clementine_string = register(new stringsGuitar());
        debugTool = register(new DebugTool());
        mamelouBucket = register(new MamelouBucket(3));
        mamelouCheese = register(new ItemMamelouCheese(8));
        itemArgent = register(new ItemArgent());
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if(item instanceof IItemModelProvider) {
            ((IItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }
}
