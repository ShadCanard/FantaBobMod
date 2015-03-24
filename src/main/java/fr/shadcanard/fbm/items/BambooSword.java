package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.item.ItemSword;

public class BambooSword extends ItemSword {

    public BambooSword(String name) {
        super(ToolMaterial.WOOD);
        this.setUnlocalizedName(name);
        this.setTextureName(Reference.MOD_ID + ":" + name);
        this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }
}
