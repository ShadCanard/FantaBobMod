package fr.shadcanard.fbm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.shadcanard.fbm.entity.*;
import fr.shadcanard.fbm.handler.ConfigurationHandler;
import fr.shadcanard.fbm.renders.*;
import net.minecraft.client.model.ModelBiped;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRender()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityBob.class,new RenderBob(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFanta.class,new RenderFanta(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossLennon.class,new RenderBossLennon(new ModelBiped(),0.5F));
        if(!ConfigurationHandler.onlyFantaBob) RenderingRegistry.registerEntityRenderingHandler(EntityJeanKevin.class,new RenderJeanKevin(new ModelBiped(),0.5F));
        if(!ConfigurationHandler.onlyFantaBob) RenderingRegistry.registerEntityRenderingHandler(EntityBot.class, new RenderBot(new ModelBiped(), 0.5F));
    }
}