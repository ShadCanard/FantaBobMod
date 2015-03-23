package fr.shadcanard.fbm.entity;

import java.util.Random;

import fr.shadcanard.fbm.achievements.AchievementHandler;
import fr.shadcanard.fbm.handler.ConfigurationHandler;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBob extends EntityCreature
{


    public EntityBob(World world)
    {
        super(world);
        ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "/textures/entity/bob.png");
        attackStrength = 4;
        hasPlayedBurnSound = false;
        isImmuneToFire = ConfigurationHandler.isImmuneToFire;
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

    public ItemStack getHeldItem()
    {
        return (new ItemStack(Items.flint_and_steel));
    }

    protected Entity findPlayerToAttack()
    {
        EntityJeanKevin kevin = null;

        for (int i = 0; i < worldObj.loadedEntityList.size(); i++)
        {
            Entity target = (Entity) worldObj.loadedEntityList.get(i);

            if (target instanceof EntityJeanKevin) {
                double distance = target.getDistance(posX, posY, posZ);
                if (distance < 16
                        && ((EntityJeanKevin) target).canEntityBeSeen(this))
                {
                    kevin = (EntityJeanKevin) target;
                }
            }
        }
        return kevin;
    }

    protected void attackEntity(Entity entity, float f)
    {
        if (attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            Material material = worldObj.getBlock((int) entity.posX, (int) entity.posY, (int) entity.posZ).getMaterial();
            if (material == Material.air && ConfigurationHandler.isPyromaniac)
            {
                worldObj.setBlock((int) entity.posX, (int) entity.posY, (int) entity.posZ, Blocks.fire, 0, 2);
                worldObj.playSoundAtEntity(this, getBurnSound(), getSoundVolume(), 1.0F);
            }
            else
                attackEntityAsMob(entity);
        }
    }

    public boolean attackEntityAsMob(Entity entity)
    {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
    }

    protected String getHurtSound()
    {
        return "fantabob.bobhurt";
    }

    protected String getDeathSound()
    {
        return "fantabob.bobdeath";
    }

    protected String getLivingSound()
    {
        return "fantabob.bob";
    }

    private String getBurnSound()
    {
        return "fantabob.bobburn";
    }

    protected float getSoundVolume()
    {
        return 0.8F;
    }

    public boolean isFollowed()
    {
        return followed;
    }

    public void setFollowed(boolean followed)
    {
        this.followed = followed;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (ConfigurationHandler.isPyromaniac)
        {
            Random rand = new Random();
            int j = rand.nextInt(100);

            if (j <= ConfigurationHandler.pyroRate)
            {
                if (worldObj != null)
                {
                    Material material = worldObj.getBlock((int) this.posX + 1, (int) this.posY - 1, (int) this.posZ).getMaterial();
                    if ((ConfigurationHandler.canBurnWood && material == Material.wood)
                            || (ConfigurationHandler.canBurnWool && material == Material.cloth)
                            || (ConfigurationHandler.canBurnTNT && material == Material.tnt)
                            || (ConfigurationHandler.canBurnPlants && material == Material.plants)
                            || (ConfigurationHandler.canBurnLeaves && material == Material.leaves))
                    {
                        worldObj.setBlock((int) this.posX + 1, (int) this.posY, (int) this.posZ, Blocks.fire, 0, 2);
                        if (!hasPlayedBurnSound)
                        {
                            worldObj.playSoundAtEntity(this, getBurnSound(), getSoundVolume(), 1.0F);
                            hasPlayedBurnSound = true;
                        }
                    }
                }
            }
        }
    }

    public Achievement getKillAch()
    {
        return AchievementHandler.killBobAch;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        super.attackEntityFrom(par1DamageSource, par2);
        entityToAttack = null;
        return false;
    }

    public void onDeath(DamageSource par1DamageSource)
    {
        Entity assassin = par1DamageSource.getEntity();

        if (assassin != null && assassin instanceof EntityPlayer)
        {
            ((EntityPlayer) assassin).triggerAchievement(getKillAch());
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
        if (s != null)
        {
            worldObj.playSoundAtEntity(this, s, getSoundVolume(), 1.0F);
        }
    }

    private boolean followed;
    protected int attackStrength;
    private boolean hasPlayedBurnSound;
}