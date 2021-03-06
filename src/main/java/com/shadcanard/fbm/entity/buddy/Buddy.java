package com.shadcanard.fbm.entity.buddy;

import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;

/**
 * Created by kurt_ on 05/10/2016.
 */
public class Buddy extends EntityTameable {

    SoundEvent ambientSound, hurtSound, deathSound, livingSound;
    public String name;

    public Buddy(World worldIn) {
        super(worldIn);
        setTamed(true);
        this.setSize(0.5F,1F);
        if(worldIn.isRemote){
            setEntityBoundingBox(getRenderBoundingBox());
        }
    }

    protected void setSounds(String creatureName){
        if(creatureName != "null" || creatureName != null){
            ambientSound = new SoundEvent(new ResourceLocation(Reference.MOD_ID,"mob." + creatureName + ".idle"));
            hurtSound = new SoundEvent(new ResourceLocation(Reference.MOD_ID,"mob." + creatureName + ".hurt"));
            deathSound = new SoundEvent(new ResourceLocation(Reference.MOD_ID,"mob." + creatureName + ".death"));
            livingSound = new SoundEvent(new ResourceLocation(Reference.MOD_ID,"mob." + creatureName + ".idle"));
        }else{
            ambientSound = super.getAmbientSound();
            hurtSound = super.getHurtSound();
            deathSound = super.getDeathSound();
            livingSound = super.getAmbientSound();
        }
    }

    public void setPosition(BlockPos pos) {
        super.setPosition(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    protected float getSoundPitch() {
        return 1.5F;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ambientSound;
    }

    public SoundEvent getLivingSound() {
        return livingSound;
    }

    @Nullable
    @Override
    public SoundEvent getHurtSound() {
        return hurtSound;
    }

    @Nullable
    @Override
    public SoundEvent getDeathSound() {
        return deathSound;
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
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }


    public float getEyeHeight()
    {
        return this.height * 0.89F;
    }

    public boolean shouldAttackEntity(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if (p_142018_1_ instanceof EntityWolf)
            {
                EntityWolf entitywolf = (EntityWolf)p_142018_1_;

                if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)
                {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
        }
        else
        {
            return false;
        }
    }
}
