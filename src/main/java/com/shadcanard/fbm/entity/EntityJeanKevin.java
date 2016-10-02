package com.shadcanard.fbm.entity;

import com.shadcanard.fbm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityJeanKevin extends EntityCreature {

    protected int timeUntilNextEgg;
    public EntityJeanKevin(World world)
    {
        super(world);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.WHEAT_SEEDS, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }


    @Override
    public boolean isAIDisabled() {
        return false;
    }


    @Override
    protected Item getDropItem() {
        return ModItems.magabondChop;
    }

    public ItemStack getHeldItem()
    {
        return (new ItemStack(Blocks.DIRT));
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer var1 = this.worldObj.getClosestPlayerToEntity(this, 16.0D);
        if (var1 != null && this.canEntityBeSeen(var1))
        {
            //var1.triggerAchievement(AchievementHandler.floodAch);
            return var1;
        }

        return null;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    protected SoundEvent getHurtSound()
    {
        return getSoundEvent("hurt");
    }

    protected SoundEvent getDeathSound()
    {
        return getSoundEvent("death");
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return getSoundEvent("idle");
    }

    private SoundEvent getSoundEvent(String event){
        return new SoundEvent(new ResourceLocation("fbm:mob.kevin." + event));
    }

    protected String getLivingSound()
    {
        return "fbm:mob.kevin.idle";
    }

//    public Achievement getKillAch()
//    {
//        return AchievementHandler.killJeanKevinAch;
//    }

    public void onDeath(DamageSource par1DamageSource)
    {
       // Entity assassin = par1DamageSource.getEntity();

        //if (assassin != null && assassin instanceof EntityPlayer)
        //{
           // ((EntityPlayer) assassin).triggerAchievement(getKillAch());
        //}

        super.onDeath(par1DamageSource);
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(SoundEvents.BLOCK_LAVA_POP,  1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Item.getItemFromBlock(Blocks.COBBLESTONE), 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
        super.onLivingUpdate();
    }

    protected float getSoundPitch()
    {
        float pitch = super.getSoundPitch();
        if(pitch >= 1.0F) return pitch;
        return 1.0F;
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        super.attackEntityFrom(par1DamageSource, par2);
        return false;
    }
}