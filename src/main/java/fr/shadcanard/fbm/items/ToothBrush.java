package fr.shadcanard.fbm.items;

import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToothBrush extends ItemFBM {
    public ToothBrush(){
        super();
        this.setUnlocalizedName(Names.Items.TOOTH_BRUSH);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.TOOTH_BRUSH;
    }


    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer entityPlayer) {
        world.playSoundAtEntity(entityPlayer,getBrushSound(), 1.0F ,1.0F);
        return null;
    }

    public String getBrushSound(){
        return "fbm:sounds.brushSound";
    }
}
