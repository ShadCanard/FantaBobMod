package com.shadcanard.fbm.items;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Shad on 13/09/2016.
 */
public class MamelouBucket extends ItemFood implements IItemModelProvider {

    public MamelouBucket(int healAmount) {
        super(healAmount, false);
        setMaxStackSize(1);
        setUnlocalizedName(Names.Items.MAMELOU_BUCKET);
        setRegistryName(Names.Items.MAMELOU_BUCKET);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Nullable
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BUCKET);
    }


    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, Names.Items.MAMELOU_BUCKET);
    }
}
