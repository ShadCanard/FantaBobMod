package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
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
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {

        return new ItemStack(this);
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        return super.onEntityItemUpdate(entityItem);
    }
}