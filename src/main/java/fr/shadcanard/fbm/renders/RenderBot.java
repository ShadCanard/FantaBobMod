package fr.shadcanard.fbm.renders;

import fr.shadcanard.fbm.entity.EntityBob;
import fr.shadcanard.fbm.entity.EntityBot;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBot extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/bot.png");

    public RenderBot(ModelBiped modelBiped, float shadow) {
        super(modelBiped, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getBobTexture((EntityBot) living);
    }

    private ResourceLocation getBobTexture(EntityBot bot){
        return texture;
    }
}
