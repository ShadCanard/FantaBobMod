package com.shadcanard.fbm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;


@SuppressWarnings("UnusedDeclaration")
public class EntityBot extends EntityMob{
    public EntityBot(World world) {

        super(world);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, getAIMoveSpeed(), false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    protected float getSoundPitch() {
        return 1.0F;
    }

    @Override
    protected Item getDropItem() {
        return Items.IRON_INGOT;
    }

    @Nullable
    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        if(hand == EnumHand.MAIN_HAND)
            return new ItemStack(Items.STONE_SWORD);
        else{
            return super.getHeldItem(hand);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.bot.idle"));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
    }
    @Override
    public void onDeath(DamageSource source) {

      //  Entity assassin = p_70645_1_.getEntity();
        //if(assassin != null && assassin instanceof EntityPlayer)
       // {
            //((EntityPlayer)assassin).triggerAchievement(AchievementHandler.killBotlennonAch);
       // }

        super.onDeath(source);
    }
}
