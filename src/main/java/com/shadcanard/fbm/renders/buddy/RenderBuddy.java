package com.shadcanard.fbm.renders.buddy;

import com.shadcanard.fbm.entity.EntityBob;
import com.shadcanard.fbm.entity.buddy.Buddy;
import com.shadcanard.fbm.entity.buddy.BuddyBob;
import com.shadcanard.fbm.entity.buddy.BuddyFanta;
import com.shadcanard.fbm.entity.buddy.BuddyTipeee;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBuddy extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation("textures/entity/steve.png");
    private float scale;

    public RenderBuddy(ModelBiped modelBiped, float shadow, float scale) {
        super(Minecraft.getMinecraft().getRenderManager(), modelBiped, shadow);
        this.scale = scale;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getBuddyTexture((Buddy) living);
    }

    protected ResourceLocation getBuddyTexture(Buddy buddy){
        if(buddy instanceof BuddyBob){
            return new ResourceLocation(Reference.MOD_ID, "textures/entity/bob.png");
        }else if(buddy instanceof BuddyFanta){
            return new ResourceLocation(Reference.MOD_ID, "textures/entity/fanta.png");
        }else if(buddy instanceof BuddyTipeee){
            return AbstractClientPlayer.getLocationSkin(((BuddyTipeee)buddy).getName());
        }else{
            return texture;
        }
    }
}
