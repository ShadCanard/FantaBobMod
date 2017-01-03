package com.shadcanard.fbm.proxy;

import com.shadcanard.fbm.entity.*;
import com.shadcanard.fbm.entity.buddy.BuddyBob;
import com.shadcanard.fbm.entity.buddy.BuddyFanta;
import com.shadcanard.fbm.entity.buddy.BuddyTipeee;
import com.shadcanard.fbm.models.ModelFemme;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.renders.*;
import com.shadcanard.fbm.renders.buddy.RenderBuddyBob;
import com.shadcanard.fbm.renders.buddy.RenderBuddyFanta;
import com.shadcanard.fbm.renders.buddy.RenderBuddyTipeee;
import com.shadcanard.fbm.utils.SkinHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
    }

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
        RenderingRegistry.registerEntityRenderingHandler(BuddyBob.class, new RenderBuddyBob(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(BuddyFanta.class, new RenderBuddyFanta(new ModelBiped(),0.5F));
        RenderingRegistry.registerEntityRenderingHandler(BuddyTipeee.class, new RenderBuddyTipeee(new ModelBiped(0,0,64,64),0.5F));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        SkinHelper.init();
    }
}