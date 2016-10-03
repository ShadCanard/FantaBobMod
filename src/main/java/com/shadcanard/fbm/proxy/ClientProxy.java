package com.shadcanard.fbm.proxy;

import com.shadcanard.fbm.entity.*;
import com.shadcanard.fbm.models.ModelFemme;
import com.shadcanard.fbm.references.Names;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.renders.*;
import com.shadcanard.fbm.tileentities.TESRCreeperSkeleton;
import com.shadcanard.fbm.tileentities.TileEntityCreeperSkeleton;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

        GameRegistry.registerTileEntity(TileEntityCreeperSkeleton.class,"te_creeperSkeleton");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCreeperSkeleton.class, new TESRCreeperSkeleton());
    }
}