package com.shadcanard.fbm.proxy;

import com.shadcanard.fbm.entity.*;
import com.shadcanard.fbm.models.ModelFemme;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.renders.*;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
    }

    @Override
    public void registerRender()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityBob.class,new RenderBob(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFanta.class,new RenderFanta(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityJeanKevin.class,new RenderJeanKevin(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBot.class, new RenderBot(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossLennon.class, new RenderBossLennon(new ModelBiped(), 0.5F, 6));
        RenderingRegistry.registerEntityRenderingHandler(EntityFemme.class, new RenderFemme(new ModelFemme(),0.5F));
    }
}