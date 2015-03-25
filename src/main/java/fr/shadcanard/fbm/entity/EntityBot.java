package fr.shadcanard.fbm.entity;

import fr.shadcanard.fbm.achievements.AchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBot extends EntityMob{
    public EntityBot(World world) {

        super(world);

    }

    @Override
    protected Item getDropItem() {
        return Items.iron_ingot;
    }

    @Override
    public ItemStack getHeldItem() {
        return new ItemStack(Items.stone_sword);
    }

    @Override
    protected String getLivingSound() {
        return "fbm:mob.bot.idle";
    }

    @Override
    public void playLivingSound() {
        if(getLivingSound() != null){
            worldObj.playSoundAtEntity(this,getLivingSound(),getSoundVolume(),1.0F);
        }
    }
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
    }
    @Override
    public void onDeath(DamageSource p_70645_1_) {
        Entity assassin = p_70645_1_.getEntity();
        if(assassin != null && assassin instanceof EntityPlayer)
        {
            //((EntityPlayer)assassin).triggerAchievement(AchievementHandler.killBotlennonAch);
        }
    }

    @Override
    public void onLivingUpdate() {
        if(this.worldObj.isDaytime() && !this.worldObj.isRemote){
            float var1 = this.getBrightness(1.0F);
            if((var1 > 0.5F) && (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX),MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))){
                this.setFire(8);
            }
        }
        super.onLivingUpdate();
    }
}
