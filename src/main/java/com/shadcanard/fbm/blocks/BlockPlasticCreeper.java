package com.shadcanard.fbm.blocks;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.entity.EntityFemme;
import com.shadcanard.fbm.entity.EntityJeanKevin;
import com.shadcanard.fbm.entity.buddy.BuddyTipeee;
import com.shadcanard.fbm.init.ModBlocks;
import com.shadcanard.fbm.init.ModItems;
import com.shadcanard.fbm.items.MamelouBucket;
import com.shadcanard.fbm.references.Names;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by kurt_ on 03/10/2016.
 */
public class BlockPlasticCreeper extends BlockStatue {
    public BlockPlasticCreeper() {
        super(Names.Blocks.BLOCK_CREEPER);
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add(ChatFormatting.DARK_RED + new TextComponentTranslation("tooltip.plasticCreeper").getFormattedText());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            if(playerIn.getHeldItem(hand).getItem() == ModItems.itemArgent){
                BuddyTipeee tip = new BuddyTipeee(worldIn);
                tip.setPosition(pos);
                tip.setOwnerId(playerIn.getUniqueID());
                spawnBuddy(tip);
            }else if(playerIn.getHeldItem(hand).getItem() instanceof MamelouBucket){
                playerIn.setHeldItem(hand,new ItemStack(Items.BUCKET));
                EntityFemme femme = new EntityFemme(worldIn);
                BlockPos pos2 = pos.offset(side);
                femme.setPosition(pos2.getX(),pos2.getY(),pos2.getZ());
                worldIn.spawnEntityInWorld(femme);
            }else if(playerIn.getHeldItem(hand).getItem() == ModItems.magabondChop){
                playerIn.setHeldItem(hand,new ItemStack(Items.BUCKET));
                EntityJeanKevin femme = new EntityJeanKevin(worldIn);
                BlockPos pos2 = pos.offset(side);
                femme.setPosition(pos2.getX(),pos2.getY(),pos2.getZ());
                worldIn.spawnEntityInWorld(femme);
            }
        }
        return true;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        AxisAlignedBB AABB = new AxisAlignedBB(0.25F, 0.0F, 0.15F, 0.75F, 1.65F, 0.86F);
        return AABB;
    }
}