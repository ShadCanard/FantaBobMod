package com.shadcanard.fbm.entity;


import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBossLennon extends EntityMob {


public EntityBossLennon(World worldIn)
        {
            super(worldIn);
            this.setSize(this.width * 6.0F, this.height * 6.0F);
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