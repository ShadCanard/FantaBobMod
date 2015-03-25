package fr.shadcanard.fbm.renders;

import fr.shadcanard.fbm.entity.EntityFanta;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


@SuppressWarnings("UnusedDeclaration")
public class RenderFanta extends RenderBiped {

    public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/fanta.png");

    public RenderFanta(ModelBiped modelBiped, float shadow) {
        super(modelBiped, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving living) {
        return this.getFantaTexture((EntityFanta) living);
    }

    private ResourceLocation getFantaTexture(EntityFanta fanta){
        return texture;
    }
}
