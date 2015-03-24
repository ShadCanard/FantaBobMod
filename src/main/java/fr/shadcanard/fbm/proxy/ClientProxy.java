package fr.shadcanard.fbm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.shadcanard.fbm.entity.EntityBob;
import fr.shadcanard.fbm.entity.EntityBot;
import fr.shadcanard.fbm.entity.EntityFanta;
import fr.shadcanard.fbm.entity.EntityJeanKevin;
import fr.shadcanard.fbm.renders.RenderBob;
import fr.shadcanard.fbm.renders.RenderBot;
import fr.shadcanard.fbm.renders.RenderFanta;
import fr.shadcanard.fbm.renders.RenderJeanKevin;
import net.minecraft.client.model.ModelBiped;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRender()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityBob.class,new RenderBob(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFanta.class,new RenderFanta(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityJeanKevin.class,new RenderJeanKevin(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBot.class, new RenderBot(new ModelBiped(), 0.5F));
    }
}