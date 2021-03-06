package com.shadcanard.fbm.blocks;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.entity.EntityFanta;
import com.shadcanard.fbm.entity.EntityFemme;
import com.shadcanard.fbm.entity.buddy.BuddyBob;
import com.shadcanard.fbm.entity.buddy.BuddyFanta;
import com.shadcanard.fbm.items.ItemArgent;
import com.shadcanard.fbm.items.ItemMamelouCheese;
import com.shadcanard.fbm.references.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by kurt_ on 04/10/2016.
 */
public class BlockStatueFanta extends BlockStatue {
    public BlockStatueFanta() {
        super(Names.Blocks.BLOCK_STATUE_FANTA);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        AxisAlignedBB AABB = new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.12F, 0.75F);
        return AABB;
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add(ChatFormatting.DARK_RED + new TextComponentTranslation("tooltip.blockStatueMain").getFormattedText());
        tooltip.add(ChatFormatting.DARK_RED + new TextComponentTranslation("tooltip.blockStatueSecond").getFormattedText());
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            if (heldItem.getItem() != null && heldItem.getItem() instanceof ItemArgent) {
                worldIn.setBlockToAir(pos);
                worldIn.createExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0, true);
                BuddyFanta bud = new BuddyFanta(worldIn);
                bud.setPosition(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ);
                bud.setOwnerId(playerIn.getPersistentID());
                worldIn.spawnEntityInWorld(bud);
                        }else if(heldItem.getItem() == null && playerIn.isSneaking()){
                worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(),new SoundEvent(new ResourceLocation("fbm","mob.fanta.idle")),null, 1.0F,1.0F,true);
            }else if(heldItem.getItem() != null && heldItem.getItem() instanceof ItemMamelouCheese){
                worldIn.setBlockToAir(pos);
                worldIn.createExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0, true);
                EntityFanta bud = new EntityFanta(worldIn);
                bud.setPosition(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ);
                worldIn.spawnEntityInWorld(bud);
            }
    }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
}
