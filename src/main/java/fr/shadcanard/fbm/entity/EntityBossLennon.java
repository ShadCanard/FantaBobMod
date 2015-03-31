package fr.shadcanard.fbm.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBossLennon extends EntityMob implements IBossDisplayData {
    public EntityBossLennon(World world) {
        super(world);
        this.yOffset *= 6.0F;
        this.setSize(this.width * 6.0F, this.height * 6.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);
    }

    @Override
    protected Entity findPlayerToAttack() {

        for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
            Entity target = (Entity) worldObj.loadedEntityList.get(i);

            if (target instanceof EntityPlayer) {
                double distance = target.getDistance(posX, posY, posZ);
                if (distance < 32 && ((EntityPlayer) target).canEntityBeSeen(this)) {
                    return target;
                }
            }
        }
        return null;
    }

    protected void attackEntity(Entity entity, float f) {
        if (attackTime <= 0 && f < 2.0F && entity instanceof EntityPlayer) {
            attackTime = 20;
            attackBySpawning(entity);
        }
    }

    private void attackBySpawning(Entity entity) {
        EntityBot mob = new EntityBot(worldObj);
        mob.setTarget(entity);
        worldObj.spawnEntityInWorld(mob);
    }

}
