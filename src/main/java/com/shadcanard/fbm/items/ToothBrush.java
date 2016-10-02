package com.shadcanard.fbm.items;

import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ToothBrush extends ItemFBM {
    public ToothBrush(){
        super(Names.Items.TOOTH_BRUSH);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.TOOTH_BRUSH;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.playSound(getBrushSound(), 1.0F ,1.0F);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    public SoundEvent getBrushSound(){
        return new SoundEvent(new ResourceLocation("fbm:sounds.brushSound"));
    }
}
