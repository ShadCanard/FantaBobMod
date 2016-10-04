package com.shadcanard.fbm.items.guitar;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.items.ItemFBM;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.LogHelper;
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
    public Clementine(){
    super(Names.Items.CLEMENTINE);
        this.setMaxDamage(100);
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



    @SideOnly(Side.CLIENT)
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer, EnumHand hand) {


        float f = 1.0F;

        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;

        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;

        double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;

        double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.renderOffsetY;

        double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;

        Vec3d vec3d = new Vec3d(d, d1, d2);

        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);

        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);

        float f5 = -MathHelper.cos(-f1 * 0.01745329F);

        float f6 = MathHelper.sin(-f1 * 0.01745329F);

        float f7 = f4 * f5;

        float f8 = f6;

        float f9 = f3 * f5;

        double d3 = 5000D;

        Vec3d vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);

        RayTraceResult movingobjectposition = world.rayTraceBlocks(vec3d, vec3d1, false);

        if (movingobjectposition == null)

        {
            return super.onItemRightClick(itemstack, world, entityplayer, hand);

        }

        if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK)

        {

            double i = movingobjectposition.getBlockPos().getX();

            double j = movingobjectposition.getBlockPos().getY();

            double k = movingobjectposition.getBlockPos().getZ();

            world.spawnEntityInWorld(new EntityLightningBolt(world,i,j,k,false));
            world.setBlockState(new BlockPos(i,j,k), Blocks.FIRE.getDefaultState());
            itemstack.setItemDamage(itemstack.getItemDamage() + 1);
            return super.onItemRightClick(itemstack, world, entityplayer, hand);
        }
        if(itemstack.getItemDamage() == itemstack.getMaxDamage()){
            itemstack = null;
            return super.onItemRightClick(itemstack, world, entityplayer, hand);
        }

        return super.onItemRightClick(itemstack, world, entityplayer, hand);
    }
}
