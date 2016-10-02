package com.shadcanard.fbm.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.List;

public class BambooSword extends ItemSword implements IItemModelProvider {

    public final String name;
    public BambooSword(String name) {
        super(ToolMaterial.WOOD);
        this.name = name;
        this.setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add(ChatFormatting.DARK_GREEN + "Dédicacée par Bob Lennon !");
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + this.name;
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, name);
    }
}
