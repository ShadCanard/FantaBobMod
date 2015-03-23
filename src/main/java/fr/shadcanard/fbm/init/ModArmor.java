package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.armor.FBMArmor;
import fr.shadcanard.fbm.references.Names;

public class ModArmor {


    public static FBMArmor fantaGlasses, cobbleTie, hairPotion;

    public static void init(){
        fantaGlasses = new FBMArmor(FantaBobMod.FBMArmor,1,0, false);
        cobbleTie = new FBMArmor(FantaBobMod.FBMArmor,1,1, false);
        hairPotion = new FBMArmor(FantaBobMod.FBMArmor,1,0,true);

        GameRegistry.registerItem(fantaGlasses, Names.Items.FANTA_GLASSES);
        GameRegistry.registerItem(cobbleTie, Names.Items.COBBLE_TIE);
        GameRegistry.registerItem(hairPotion, Names.Items.HAIR_POTION);

    }
}
