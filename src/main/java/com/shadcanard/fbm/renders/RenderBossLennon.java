package com.shadcanard.fbm.renders;

import com.shadcanard.fbm.entity.EntityBossLennon;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SuppressWarnings("UnusedDeclaration")
public class RenderBossLennon extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/bob.png");
    private float scale;

    public RenderBossLennon(ModelBiped modelBiped, float shadow, float scale) {
        super(Minecraft.getMinecraft().getRenderManager(), modelBiped, shadow);
        this.scale = scale;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getBobTexture((EntityBossLennon) living);
    }

    private ResourceLocation getBobTexture(EntityBossLennon bossLennon){
        return texture;
    }

}
