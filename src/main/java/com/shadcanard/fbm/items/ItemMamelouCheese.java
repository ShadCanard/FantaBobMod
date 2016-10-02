package com.shadcanard.fbm.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Shad on 13/09/2016.
 */
public class ItemMamelouCheese extends ItemFood implements IItemModelProvider {

    public ItemMamelouCheese(int amount) {
        super(amount, false);
        setUnlocalizedName(Names.Items.MAMELOU_CHEESE);
        setRegistryName(Names.Items.MAMELOU_CHEESE);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add(ChatFormatting.DARK_GREEN + "A base de bon lait de mamelle !");
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, Names.Items.MAMELOU_CHEESE);
    }
}
