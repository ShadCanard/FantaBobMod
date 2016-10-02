package com.shadcanard.fbm.items;

import com.shadcanard.fbm.client.gui.GuiSoundBox;
import com.shadcanard.fbm.references.Names;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by ShadCanard on 26/05/2015.
 */
public class SoundBox extends ItemFBM implements IItemModelProvider {
    public SoundBox(){
        super(Names.Items.SOUNDBOX);
        this.setMaxStackSize(1);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!worldIn.isRemote) Minecraft.getMinecraft().displayGuiScreen(new GuiSoundBox(playerIn, worldIn));
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
