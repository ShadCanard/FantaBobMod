package com.shadcanard.fbm.items.guitar;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.items.ItemFBM;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockStateContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class Clementine extends ItemFBM {

    public Clementine() {
        super(Names.Items.CLEMENTINE);
        this.setMaxDamage(150);
    }

    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + Names.Items.CLEMENTINE;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(p_77624_1_, p_77624_2_, list, p_77624_4_);
        list.add(ChatFormatting.DARK_RED + "I am the Devil, I love Metal !");
    }

    private BlockPos getBlockPosLookingAt(World world, EntityPlayer player) {
        RayTraceResult mop = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(200, 1.0F);
        if (mop != null) {
            return mop.getBlockPos();
        }
        return null;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer, EnumHand hand) {

        RayTraceResult movingobjectposition = entityplayer.rayTrace(200, 1.0F);
        if (movingobjectposition == null)

        {
            return super.onItemRightClick(itemstack, world, entityplayer, hand);

        }

        if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK)

        {
            double i = movingobjectposition.getBlockPos().getX();

            double j = movingobjectposition.getBlockPos().getY();

            double k = movingobjectposition.getBlockPos().getZ();

            if (itemstack.getItemDamage() >= (itemstack.getMaxDamage() - 1)) --itemstack.stackSize;
            world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k, false));
            itemstack.setItemDamage(itemstack.getItemDamage() + 1);
            return super.onItemRightClick(itemstack, world, entityplayer, hand);
        }

        return super.onItemRightClick(itemstack, world, entityplayer, hand);
    }
}
