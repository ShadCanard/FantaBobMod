package fr.shadcanard.fbm.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.entity.EntityBob;
import fr.shadcanard.fbm.entity.EntityBot;
import fr.shadcanard.fbm.entity.EntityFanta;
import fr.shadcanard.fbm.entity.EntityJeanKevin;
import fr.shadcanard.fbm.handler.ConfigurationHandler;
import fr.shadcanard.fbm.references.Names;

import java.awt.*;

public class ModEntities {

    public static void init() {

        EntityRegistry.registerGlobalEntityID(EntityBob.class, Names.Entities.BOB, EntityRegistry.findGlobalUniqueEntityId(), new Color(180, 0, 0).getRGB(), new Color(255,182,90).getRGB());
        EntityRegistry.registerModEntity(EntityBob.class, Names.Entities.BOB, EntityRegistry.findGlobalUniqueEntityId(), FantaBobMod.instance,40,1,true);

        EntityRegistry.registerGlobalEntityID(EntityFanta.class,Names.Entities.FANTA, EntityRegistry.findGlobalUniqueEntityId(), new Color(0,0,230).getRGB(), new Color(0,0,0).getRGB());
        EntityRegistry.registerModEntity(EntityFanta.class, Names.Entities.FANTA, EntityRegistry.findGlobalUniqueEntityId(), FantaBobMod.instance, 40, 1, true);

        if(!ConfigurationHandler.onlyFantaBob) EntityRegistry.registerGlobalEntityID(EntityJeanKevin.class, Names.Entities.JEAN_KEVIN, EntityRegistry.findGlobalUniqueEntityId(), new Color(50, 210, 150).getRGB(), new Color(50, 50, 255).getRGB());
        if(!ConfigurationHandler.onlyFantaBob) EntityRegistry.registerModEntity(EntityJeanKevin.class, Names.Entities.JEAN_KEVIN, EntityRegistry.findGlobalUniqueEntityId(), FantaBobMod.instance,40,1,true);

        if(!ConfigurationHandler.onlyFantaBob) EntityRegistry.registerGlobalEntityID(EntityBot.class, Names.Entities.BOT, EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 182, 90).getRGB(), new Color(180, 0, 0).getRGB());
        if(!ConfigurationHandler.onlyFantaBob) EntityRegistry.registerModEntity(EntityBot.class, Names.Entities.BOT, EntityRegistry.findGlobalUniqueEntityId(), FantaBobMod.instance,40,1,true);

    }
}
