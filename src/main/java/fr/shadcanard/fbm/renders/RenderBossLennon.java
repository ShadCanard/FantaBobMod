package fr.shadcanard.fbm.renders;

import fr.shadcanard.fbm.entity.EntityBob;
import fr.shadcanard.fbm.entity.EntityBossLennon;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SuppressWarnings("UnusedDeclaration")
public class RenderBossLennon extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/bob.png");
    private float scale;
    public RenderBossLennon(ModelBiped modelBiped, float shadow) {
        super(modelBiped, shadow);
        this.scale = 6.0F;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        GL11.glScalef(scale,scale,scale);
    }

    @Override
    public void doRender(EntityLiving entityLiving, double x, double y, double z, float par1, float par2) {
        this.renderHealthBar((EntityBossLennon) entityLiving,x,y,z,par1,par2);
    }

    private void renderHealthBar(EntityBossLennon entityLiving, double x, double y, double z, float par1, float par2) {
        BossStatus.setBossStatus(entityLiving, true);
        super.doRender(entityLiving,x,y,z,par1,par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getBossTexture((EntityBossLennon) living);
    }

    private ResourceLocation getBossTexture(EntityBossLennon bob){
        return texture;
    }
}
