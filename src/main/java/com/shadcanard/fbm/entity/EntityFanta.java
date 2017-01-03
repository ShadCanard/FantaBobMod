package com.shadcanard.fbm.entity;

import com.shadcanard.fbm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityFanta extends EntityCreature{

    private static final double proximityRadius = 3;
    private static boolean mounting = false;
    public static EntitySheep mount;
    private static final double detectionRadius = 3;
    private static final double rejoinRadius = 3;


    @Override
    public boolean isAIDisabled() {
        return false;
    }


    public EntityFanta(World world) {

        super(world);

        PathNavigateGround ground = ((PathNavigateGround)this.getNavigator());
        ground.setCanSwim(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this,0.6D));
        this.tasks.addTask(2, new EntityAIWander(this,0.5D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.itemArgent, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this,EntityBob.class,(float)detectionRadius));

    }

    @Override
    protected float getSoundPitch() {
        return 1.0F;
    }

    @Override
    protected Item getDropItem() {
        Random rand = new Random();
        int j = rand.nextInt(100);
        if(j > 75){
            return Items.WOODEN_SWORD;
        }else{
            return null;
        }
    }

    @Nullable
    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        if(hand == EnumHand.MAIN_HAND) return new ItemStack(Items.WOODEN_SWORD);
        return new ItemStack(Items.WHEAT);
    }

    protected Entity findPlayerToAttack() {
        if(!mounting){
            for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
                if(worldObj.loadedEntityList.get(i) instanceof EntitySheep) {
                    EntitySheep target = (EntitySheep) worldObj.loadedEntityList.get(i);
                    double distance = target.getDistance(posX, posY, posZ);
                    if (distance > 1 && distance < 3 && target.canEntityBeSeen(this) && !isRiding()) {
                        startRiding(target);
                        return target;
                    }
                    else if (distance < 16 && distance > 1 && target.canEntityBeSeen(this)) {
                        return target;
                    }
                }
            }
        }else{
            for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
                if(worldObj.loadedEntityList.get(i) instanceof EntityBob){
                    EntityBob target = (EntityBob) worldObj.loadedEntityList.get(i);
                    double distance = target.getDistance(posX, posY, posZ);
                    if (distance < 16 && distance > 3 && target.canEntityBeSeen(this) && !target.followed){
                        target.followed = true;
                        mount.attackEntityAsMob(target);
                        return target;
                    }
                }
            }
        }
        return null;
    }

    @Override
    protected SoundEvent getHurtSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.fanta.hurt"));
    }

    @Override
    protected SoundEvent getDeathSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.fanta.death"));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.fanta.idle"));
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    //public Achievement getKillAch(){
     //   return AchievementHandler.killFantaAch;
   // }

    public SoundEvent getLivingSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.fanta.idle"));
    }

    @Override
    public void playLivingSound() {
        worldObj.playSound(posX,posY,posZ,getLivingSound(), SoundCategory.NEUTRAL, getSoundVolume(),getSoundPitch(),true);
    }

    @Override
    protected void playHurtSound(DamageSource source) {
        worldObj.playSound(posX,posY,posZ,getHurtSound(), SoundCategory.NEUTRAL, getSoundVolume(),getSoundPitch(),true);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        worldObj.playSound(posX,posY,posZ,getDeathSound(), SoundCategory.NEUTRAL, getSoundVolume(),getSoundPitch(),true);
        super.onDeath(damageSource);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        super.attackEntityFrom(damageSource, par2);
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
    }
}
