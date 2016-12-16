package com.shadcanard.fbm.entity;

import com.shadcanard.fbm.entity.ai.EntityAIBurn;
import com.shadcanard.fbm.handler.ConfigurationHandler;
import com.shadcanard.fbm.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityBob extends EntityCreature {

    protected boolean followed;
    private boolean BurnSoundPlayed;

    public EntityBob(World world) {
        super(world);
        BurnSoundPlayed = false;
        PathNavigateGround ground = ((PathNavigateGround)this.getNavigator());
        ground.setCanSwim(true);
        this.tasks.addTask(0, new EntityAIBurn(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2,new EntityAITempt(this,1.25D, ModItems.itemArgent,false));
        this.tasks.addTask(3, new EntityAIWander(this,0.5D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this,EntityPlayer.class,6.0F));
        this.tasks.addTask(5, new EntityAIPanic(this,0.6D));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityJeanKevin.class,false));

    }


    public boolean hasBurnSoundPlayed(){
        return BurnSoundPlayed;
    }

    public void setBurnSoundPlayed(boolean played){
        BurnSoundPlayed = played;
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }



    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
    }


    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public boolean isFollowed() {
        return followed;
    }

    @Override
    protected float getSoundPitch() {
        return 1.0F;
    }

    public SoundEvent getHurtSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.bob.hurt")) ;
    }

    public SoundEvent getDeathSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.bob.death"));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()  {
        return new SoundEvent(new ResourceLocation("fbm:mob.bob.idle"));
    }

    public SoundEvent getLivingSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.bob.idle"));
    }

    public SoundEvent getBurnSound() {
        return new SoundEvent(new ResourceLocation("fbm:mob.bob.burn"));
    }

    public float getSoundVolume() {
        return 0.8F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (ConfigurationHandler.isPyromaniac) {
            Random rand = new Random();
            int j = rand.nextInt(100);
            if (j <= ConfigurationHandler.pyroRate) {
                if (worldObj != null) {
                    Material material = worldObj.getBlockState(new BlockPos((int) this.posX + 1, (int) this.posY - 1, (int) this.posZ)).getMaterial();
                    if ((ConfigurationHandler.canBurnWood && material == Material.WOOD)
                            || (ConfigurationHandler.canBurnWool && material == Material.CLOTH)
                            || (ConfigurationHandler.canBurnTNT && material == Material.TNT)
                            || (ConfigurationHandler.canBurnPlants && material == Material.PLANTS)
                            || (ConfigurationHandler.canBurnLeaves && material == Material.LEAVES)) {
                        worldObj.setBlockState(new BlockPos((int) this.posX + 1, (int) this.posY, (int) this.posZ), Blocks.FIRE.getDefaultState());
                        if (!BurnSoundPlayed) {
                            worldObj.playSound(getPosition().getX(), getPosition().getY(), getPosition().getZ(),getBurnSound(), SoundCategory.NEUTRAL,getSoundVolume(),getSoundPitch(),true);
                            BurnSoundPlayed = true;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt lightningBolt) {
        EntityBossLennon boss = new EntityBossLennon(this.worldObj);
        boss.setLocationAndAngles(this.posX,this.posY,this.posZ,this.rotationYaw,this.rotationPitch);
        this.worldObj.spawnEntityInWorld(boss);
        this.setDead();
    }


    /*
    public Achievement getKillAch() {
        return AchievementHandler.killBobAch;
    }*/

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        super.attackEntityFrom(source, par2);
        return false;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        //Entity assassin = damageSource.getEntity();

        //if( assassin != null && assassin instanceof EntityPlayer){
           // ((EntityPlayer)assassin).triggerAchievement(getKillAch());
        //}
    }

    @Override
    public void playLivingSound() {
        if (getLivingSound() != null) {
            worldObj.playSound(posX,posY,posZ,getLivingSound(), SoundCategory.NEUTRAL, getSoundVolume(),getSoundPitch(),true);   //this,getLivingSound(),getSoundVolume(),1.0F);
        }
    }

    @Nullable
    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        if(hand == EnumHand.MAIN_HAND) return new ItemStack(Items.GOLDEN_SWORD);
        return new ItemStack(Items.FLINT_AND_STEEL);
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.COBBLESTONE);
    }
}