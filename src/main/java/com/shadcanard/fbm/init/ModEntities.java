package com.shadcanard.fbm.init;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.entity.*;
import com.shadcanard.fbm.entity.buddy.BuddyBob;
import com.shadcanard.fbm.entity.buddy.BuddyFanta;
import com.shadcanard.fbm.entity.buddy.BuddyTipeee;
import com.shadcanard.fbm.references.Names;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.awt.*;

public class ModEntities {

    public static void init() {



        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BOB), EntityBob.class, Names.Entities.BOB, 1, FantaBobMod.instance,40,1,true,new Color(180, 0, 0).getRGB(), new Color(255,182,90).getRGB());
        EntityRegistry.addSpawn(EntityBob.class,15,0,1, EnumCreatureType.CREATURE,Biomes.FOREST, Biomes.BIRCH_FOREST,Biomes.BEACH);

        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.FANTA), EntityFanta.class, Names.Entities.FANTA, 2, FantaBobMod.instance, 40, 1, true,new Color(0,0,230).getRGB(), new Color(0,0,0).getRGB());
        EntityRegistry.addSpawn(EntityFanta.class,15,0,1, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.BIRCH_FOREST,Biomes.BEACH);

        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.JEAN_KEVIN), EntityJeanKevin.class, Names.Entities.JEAN_KEVIN, 3, FantaBobMod.instance,40,1,true, new Color(50, 210, 150).getRGB(), new Color(50, 50, 255).getRGB());
        EntityRegistry.addSpawn(EntityJeanKevin.class,15,0,1, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.BIRCH_FOREST,Biomes.BEACH);

        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BOT), EntityBot.class, Names.Entities.BOT, 4, FantaBobMod.instance,40,1,true, new Color(255, 182, 90).getRGB(), new Color(180, 0, 0).getRGB());
        EntityRegistry.addSpawn(EntityBot.class, 15,0,1, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.BIRCH_FOREST,Biomes.BEACH);

        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.FEMME), EntityFemme.class, Names.Entities.FEMME, 5, FantaBobMod.instance, 40,1,true, new Color(255,150,150).getRGB(), new Color(255,100,100).getRGB());
        EntityRegistry.addSpawn(EntityFemme.class,15,0,1, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.BIRCH_FOREST,Biomes.BEACH);

        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BOSS_LENNON), EntityBossLennon.class, Names.Entities.BOSS_LENNON, 6, FantaBobMod.instance, 40,1,true, new Color(180, 0, 0).getRGB(), new Color(255, 182, 90).getRGB());

        //Adding Buddies
        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BUDDY_BOB), BuddyBob.class, Names.Entities.BUDDY_BOB,7,FantaBobMod.instance,40,1,true);
        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BUDDY_FANTA), BuddyFanta.class,Names.Entities.BUDDY_FANTA,8,FantaBobMod.instance,40,1,true);
        EntityRegistry.registerModEntity(new ResourceLocation("fbm",Names.Entities.BUDDY_TIPEEE), BuddyTipeee.class,Names.Entities.BUDDY_TIPEEE,9,FantaBobMod.instance,40,1,true);

    }
}
