package com.shadcanard.fbm.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by Shad on 24/08/2016.
 */
public class DebugTool extends ItemFBM {

    public DebugTool(){
        super(Names.Items.DEBUG_TOOL);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!worldIn.isRemote){
            if(FantaBobMod.IS_DEBUG_MODE){
                playerIn.addChatMessage(new TextComponentString("DEBUG TOOL : " + getBlockLookingAt(worldIn,playerIn)));
                playerIn.addPotionEffect(new PotionEffect(MobEffects.HUNGER,600,2));


            }else{
                playerIn.addChatComponentMessage(new TextComponentString(ChatFormatting.BLUE + "Un objet qui ne vous sera d'aucune utilité."));
            }
        }

        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    private IBlockState getBlockLookingAt(World world, EntityPlayer player){
        RayTraceResult mop = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(200, 1.0F);
        if(mop != null)
        {
            IBlockState blockLookingAt = world.getBlockState(new BlockPos(mop.getBlockPos().getX(), mop.getBlockPos().getY(), mop.getBlockPos().getZ()));
            return blockLookingAt;
        }
        return null;
    }
}
