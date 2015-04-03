package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.entity.EntityBob;
import fr.shadcanard.fbm.entity.EntityBot;
import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class PyroAxe extends ItemSword {
    public PyroAxe(Item.ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(Names.Items.PYROBARBARE_AXE);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.BOB_AXE);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.PYROBARBARE_AXE;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }


    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        return super.onEntityItemUpdate(entityItem);
    }

}