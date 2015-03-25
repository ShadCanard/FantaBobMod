package fr.shadcanard.fbm.entity;

import fr.shadcanard.fbm.handler.ConfigurationHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class EntityBob extends EntityCreature {

    protected boolean followed;
    private boolean hasPlayedBurnSound;
    private boolean isImmuneToFire;

    public EntityBob(World world) {
        super(world);
        hasPlayedBurnSound = false;
        isImmuneToFire = ConfigurationHandler.isImmuneToFire;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
    }

    @Override
    protected Entity findPlayerToAttack() {

        for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
            Entity target = (Entity) worldObj.loadedEntityList.get(i);

            if (target instanceof EntityJeanKevin) {
                double distance = target.getDistance(posX, posY, posZ);
                if (distance < 16 && ((EntityJeanKevin) target).canEntityBeSeen(this)) {
                    return target;
                }
            }
        }
        return null;
    }

    protected void attackEntity(Entity entity, float f) {
        if (attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY) {
            attackTime = 20;
            Material material = worldObj.getBlock((int) entity.posX, (int) entity.posY, (int) entity.posZ).getMaterial();
            if (material == Material.air && ConfigurationHandler.isPyromaniac) {
                worldObj.setBlock((int) entity.posX, (int) entity.posY, (int) entity.posZ, Blocks.fire, 0, 2);
                worldObj.playSoundAtEntity(this, getBurnSound(), getSoundVolume(), 1.0F);
            } else
                attackEntityAsMob(entity);
        }
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

    protected String getHurtSound() {
        return "fbm:mob.bob.hurt";
    }

    protected String getDeathSound() {
        return "fbm:mob.bob.death";
    }

    protected String getLivingSound() {
        return "fbm:mob.bob.idle";
    }

    private String getBurnSound() {
        return "fbm:mob.bob.burn";
    }

    protected float getSoundVolume() {
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
                    Material material = worldObj.getBlock((int) this.posX + 1, (int) this.posY - 1, (int) this.posZ).getMaterial();
                    if ((ConfigurationHandler.canBurnWood && material == Material.wood)
                            || (ConfigurationHandler.canBurnWool && material == Material.cloth)
                            || (ConfigurationHandler.canBurnTNT && material == Material.tnt)
                            || (ConfigurationHandler.canBurnPlants && material == Material.plants)
                            || (ConfigurationHandler.canBurnLeaves && material == Material.leaves)) {
                        worldObj.setBlock((int) this.posX + 1, (int) this.posY, (int) this.posZ, Blocks.fire, 0, 2);
                        if (!hasPlayedBurnSound) {
                            worldObj.playSoundAtEntity(this, getBurnSound(), getSoundVolume(), 1.0F);
                            hasPlayedBurnSound = true;
                        }
                    }

                }
            }
        }
    }

/*
    public Achievement getKillAch() {
        return AchievementHandler.killBobAch;
    }*/

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        super.attackEntityFrom(source, par2);
        entityToAttack = null;
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
            worldObj.playSoundAtEntity(this,getLivingSound(),getSoundVolume(),1.0F);
        }
    }

    @Override
    public ItemStack getHeldItem() {
        return new ItemStack(Items.golden_sword);
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.cobblestone);
    }
}