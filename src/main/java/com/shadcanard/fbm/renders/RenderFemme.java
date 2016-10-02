package com.shadcanard.fbm.renders;

import com.shadcanard.fbm.entity.EntityFemme;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Shad on 13/09/2016.
 */
public class RenderFemme extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/alex.png");

    public RenderFemme(ModelBiped modelBiped, float shadow) {
        super(Minecraft.getMinecraft().getRenderManager(), modelBiped, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getFemmeTexture((EntityFemme) living);
    }

    private ResourceLocation getFemmeTexture(EntityFemme femme){
        return texture;
    }


}
