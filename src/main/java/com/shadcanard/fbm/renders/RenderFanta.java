package com.shadcanard.fbm.renders;

import com.shadcanard.fbm.entity.EntityFanta;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


@SuppressWarnings("UnusedDeclaration")
public class RenderFanta extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/fanta.png");

    public RenderFanta(ModelBiped modelBiped, float shadow) {
        super(Minecraft.getMinecraft().getRenderManager(), modelBiped, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getFantaTexture((EntityFanta) living);
    }

    private ResourceLocation getFantaTexture(EntityFanta fanta){
        return texture;
    }
}
