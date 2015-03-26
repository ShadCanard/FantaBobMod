package fr.shadcanard.fbm.items;


import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.init.ModArmor;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorFBM extends ItemArmor {

    public final String name;

    public ItemArmorFBM(int type, String name) {
        super(ModArmor.armorFBM, 0, type);
        setUnlocalizedName(name);
        this.name = name;
        setTextureName(Reference.MOD_ID + ":" + name);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);

    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + this.name;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModArmor.fantaGlasses || stack.getItem() == ModArmor.cobbleTie)
        {
            return Reference.MOD_ID + ":textures/models/armor/FantaBob1.png";
        }
        return Reference.MOD_ID + ":textures/models/armor/FantaBob2.png";
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        {
            itemIcon = iconRegister.registerIcon("fbm:" + getUnlocalizedName().substring(5));
        }
    }
}
