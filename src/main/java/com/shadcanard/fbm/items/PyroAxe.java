package com.shadcanard.fbm.items;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class PyroAxe extends ItemSword implements IItemModelProvider {
    public PyroAxe(Item.ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(Names.Items.PYROBARBARE_AXE);
        setRegistryName(Names.Items.PYROBARBARE_AXE);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        stack.addEnchantment(Enchantments.FIRE_ASPECT,3);
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.PYROBARBARE_AXE;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        return super.onEntityItemUpdate(entityItem);
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, Names.Items.PYROBARBARE_AXE);
    }
}