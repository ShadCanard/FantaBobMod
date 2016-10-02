package com.shadcanard.fbm.entity.ai;

import com.shadcanard.fbm.entity.EntityBob;
import com.shadcanard.fbm.handler.ConfigurationHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

/**
 * Created by Shad on 21/07/2016.
 */
public class EntityAIBurn extends EntityAIBase {
    EntityCreature inCreature;

    @Override
    public boolean shouldExecute() {
        EntityBob creature = (EntityBob)inCreature;
        if (ConfigurationHandler.isPyromaniac) {
            Random rand = new Random();
            int j = rand.nextInt(100);
            if (j <= ConfigurationHandler.pyroRate) {
                if (creature.worldObj != null) {
                    Material material = creature.worldObj.getBlockState(new BlockPos((int) creature.posX + 1, (int) creature.posY - 1, (int) creature.posZ)).getMaterial();
                    if ((ConfigurationHandler.canBurnWood && material == Material.WOOD)
                            || (ConfigurationHandler.canBurnWool && material == Material.CLOTH)
                            || (ConfigurationHandler.canBurnTNT && material == Material.TNT)
                            || (ConfigurationHandler.canBurnPlants && material == Material.PLANTS)
                            || (ConfigurationHandler.canBurnLeaves && material == Material.LEAVES)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        EntityBob creature = (EntityBob)inCreature;
        creature.worldObj.setBlockState(new BlockPos((int) creature.posX + 1, (int) creature.posY, (int) creature.posZ), Blocks.FIRE.getDefaultState());
        if (!creature.hasBurnSoundPlayed()) {
            creature.worldObj.playSound(creature.posX, creature.posY, creature.posZ, creature.getBurnSound(), SoundCategory.NEUTRAL, creature.getSoundVolume(), 1.0F, true);
            creature.setBurnSoundPlayed(true);
        }
    }

    public EntityAIBurn(EntityCreature creature){
        inCreature = creature;
    }


}
