package fr.shadcanard.fbm.entity;

import fr.shadcanard.fbm.achievements.AchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class EntityFanta extends EntityCreature{

    private static final double proximityRadius = 3;
    private static final double detectionRadius = 3;
    private static final double rejoinRadius = 3;

    public EntityFanta(World world) {

        super(world);

    }

    @Override
    protected Item getDropItem() {
        Random rand = new Random();
        int j = rand.nextInt(100);
        if(j > 75){
            return Items.wooden_sword;
        }else{
            return null;
        }
    }

    @Override
    public ItemStack getHeldItem() {
        return new ItemStack(Items.wooden_sword,1,(Items.wooden_sword.getMaxDamage() + 30));
    }

    @Override
    protected Entity findPlayerToAttack() {
        for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
            if(worldObj.loadedEntityList.get(i) instanceof EntityBob){
                EntityBob target = (EntityBob) worldObj.loadedEntityList.get(i);
                double distance = target.getDistance(posX,posY,posZ);
                if (distance <= detectionRadius && distance >= rejoinRadius && ((EntityBob) target).canEntityBeSeen(this)){
                    if(!target.isFollowed()) target.setFollowed(true);
                    return target;
                }
            }
        }
        return null;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(entityToAttack != null){
            double distance = entityToAttack.getDistance(posX,posY,posZ);
            if(distance < proximityRadius){
                ((EntityBob) entityToAttack).setFollowed(false);
                entityToAttack = null;
            }
        }
    }

    @Override
    protected String getHurtSound() {
        return "fbm:mob.fanta.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "fbm:mob.fanta.death";
    }

    @Override
    protected String getLivingSound() {
        return "fbm:mob.fanta.idle";
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    public Achievement getKillAch(){
        return AchievementHandler.killFantaAch;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        if(entityToAttack != null){
            ((EntityBob) entityToAttack).setFollowed(false);
        }

        Entity assassin = damageSource.getEntity();

        if(assassin != null && assassin instanceof EntityPlayer){
            ((EntityPlayer)assassin).triggerAchievement(getKillAch());
        }
        super.onDeath(damageSource);
    }

    @Override
    public void playLivingSound() {
        if (getLivingSound() != null){
            worldObj.playSoundAtEntity(this,getLivingSound(),getSoundVolume(),1.0F);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        super.attackEntityFrom(damageSource, par2);
        entityToAttack = null;
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
    }
}
