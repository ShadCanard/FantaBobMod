package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.item.ItemSword;

public class BobAxe extends ItemSword {

    public BobAxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(Names.Items.BOB_AXE);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.BOB_AXE);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }
}
