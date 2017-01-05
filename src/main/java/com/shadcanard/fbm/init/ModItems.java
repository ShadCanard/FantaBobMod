package com.shadcanard.fbm.init;

import com.shadcanard.fbm.items.*;
import com.shadcanard.fbm.items.axe.*;
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
    public static Item record_Avion, record_pyrobarbare, record_magabondMix, record_Metalleux, bambooSword, pyroAxe;
    public static ItemFood mamelouBucket, mamelouCheese;
    public static BarbAxe woodenBarbAxe,stoneBarbAxe,bambooBarbAxe,goldenBarbAxe,diamondBarbAxe;

    public static void init() {


        //Records
        record_pyrobarbare = register(new MusicDisc("pyroBarbare").setUnlocalizedName(Names.Items.PYROBARBARE_RECORD));
        record_magabondMix = register(new MusicDisc("magabondMix").setUnlocalizedName(Names.Items.MAGABOND_RECORD));
        record_Avion = register(new MusicDisc("fantaAvion").setUnlocalizedName(Names.Items.AVION_RECORD));
        record_Metalleux = register(new MusicDisc("metalleux").setUnlocalizedName(Names.Items.METALLEUX_RECORD));

        bambooSword = register(new BambooSword(Names.Items.BAMBOO_SWORD));

        //Useless stuff
        magabondChop = register(new MagabondChop());
        toothBrush = register(new ToothBrush());
        stampCollection = register(new StampCollection());

        //Clementine
        clementine = register(new Clementine());
        clementine_top = register(new topGuitar());
        clementine_body = register(new bodyGuitar());
        clementine_head = register(new headGuitar());
        clementine_string = register(new stringsGuitar());
        debugTool = register(new DebugTool());

        //Mamelou
        mamelouBucket = register(new MamelouBucket(3));
        mamelouCheese = register(new ItemMamelouCheese(8));

        //Money
        itemArgent = register(new ItemArgent());

        //Axes

        woodenBarbAxe = register(new WoodenBarbAxe());
        stoneBarbAxe = register(new StoneBarbAxe());
        bambooBarbAxe = register(new BambooBarbAxe());
        goldenBarbAxe = register(new GoldenBarbAxe());
        diamondBarbAxe = register(new DiamondBarbAxe());


    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if(item instanceof IItemModelProvider) {
            ((IItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }
}
