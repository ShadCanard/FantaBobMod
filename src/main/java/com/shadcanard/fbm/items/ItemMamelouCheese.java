package com.shadcanard.fbm.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.entity.EntityFanta;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

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
        tooltip.add(ChatFormatting.DARK_GREEN + new TextComponentTranslation("tooltip.mamelou").getFormattedText());
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, Names.Items.MAMELOU_CHEESE);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        if(target instanceof EntityFanta){
            target.playSound(new SoundEvent(new ResourceLocation(Reference.MOD_ID,"records.chansonMamelou")),1.0F,1.0F);
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
