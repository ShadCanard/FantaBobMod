package fr.shadcanard.fbm.entity;

import fr.shadcanard.fbm.achievements.AchievementHandler;
import fr.shadcanard.fbm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJeanKevin extends EntityCreature {


    public EntityJeanKevin(World world)
    {
        super(world);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.magabondChop;
    }

    public ItemStack getHeldItem()
    {
        return (new ItemStack(Blocks.dirt));
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
    }

    protected String getHurtSound()
    {
        return "fbm:mob.kevin.hurt";
    }

    protected String getDeathSound()
    {
        return "fbm:mob.kevin.death";
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
        Entity assassin = par1DamageSource.getEntity();

        if (assassin != null && assassin instanceof EntityPlayer)
        {
           // ((EntityPlayer) assassin).triggerAchievement(getKillAch());
        }

        super.onDeath(par1DamageSource);
    }

    protected float getSoundPitch()
    {
        return 1.0F;
    }

    public void playLivingSound()
    {
        String s = getLivingSound();
        if (s != null) {
            worldObj.playSoundAtEntity(this, s, getSoundVolume(), 1.0F);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        super.attackEntityFrom(par1DamageSource, par2);
        entityToAttack = null;
        return false;
    }
}