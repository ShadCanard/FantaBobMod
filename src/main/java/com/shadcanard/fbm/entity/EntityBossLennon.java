package com.shadcanard.fbm.entity;


import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityBossLennon extends EntityMob {


public EntityBossLennon(World worldIn)
        {
            super(worldIn);
            this.setSize(this.width * 6.0F, this.height * 6.0F);
            isImmuneToFire = true;
        }


    @Override
    public boolean isImmuneToExplosions() {
        return true;
    }

    @Override
    protected float getSoundPitch() {
        return 0.8F;
    }

    @Override
    protected float getSoundVolume() {
        return 1.5F;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return getSounds("death");
    }

    @Override
    protected SoundEvent getHurtSound() {
        return getSounds("hurt");
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return getSounds("idle");
    }

    public SoundEvent getSounds(String event){
        return new SoundEvent(new ResourceLocation(Reference.MOD_ID,"mob.bob." + event));
    }

    public float getEyeHeight() {
        return 10.440001F;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0D);
    }

    public float getBlockPathWeight(BlockPos pos) {
        return this.worldObj.getLightBrightness(pos) - 0.5F;
    }

}