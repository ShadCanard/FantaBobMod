package com.shadcanard.fbm.entity;

import com.shadcanard.fbm.init.ModItems;
import com.shadcanard.fbm.utils.LogHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Shad on 13/09/2016.
 */
public class EntityFemme extends EntityAnimal {

    public EntityFemme(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.itemArgent, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }


    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityFemme(this.worldObj);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return getSoundEvent("death");
    }

    @Override
    protected float getSoundPitch() {
        return 1.0F;
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return getSoundEvent("idle");
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound() {
        return getSoundEvent("hurt");
    }

    private SoundEvent getSoundEvent(String soundEvent){
        return new SoundEvent(new ResourceLocation("fbm:mob.femme." + soundEvent));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack == null ? false : stack.getItem() == ModItems.itemArgent;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        LogHelper.info("Starting Milk");
        if (stack != null && stack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode && !this.isChild())
        {
            LogHelper.info("Milking");
            player.playSound(getSoundEvent("milk"), 1.0F, 1.0F);
            stack.func_190918_g(1);

            if (stack.func_190926_b())
            {
                player.setHeldItem(hand, new ItemStack(ModItems.mamelouBucket));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.mamelouBucket)))
            {
                player.dropItem(new ItemStack(ModItems.mamelouBucket), false);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }

    public float getEyeHeight()
    {
        return this.height - 0.28F;
    }
}
