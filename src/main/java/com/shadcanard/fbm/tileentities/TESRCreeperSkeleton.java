package com.shadcanard.fbm.tileentities;

import com.shadcanard.fbm.models.ModelTESRCreeperSkeleton;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by kurt_ on 03/10/2016.
 */
public class TESRCreeperSkeleton extends TileEntitySpecialRenderer {
    ModelTESRCreeperSkeleton model = new ModelTESRCreeperSkeleton();
    ResourceLocation texture = new ResourceLocation(Reference.MOD_ID,"textures/blocks/creeperSkeleton.png");


    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
        this.renderTileEntityCreeperSkeletonAt((TileEntityCreeperSkeleton) te, x,y,z,partialTicks,destroyStage);
    }


    private void renderTileEntityCreeperSkeletonAt(TileEntityCreeperSkeleton te, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        model.renderAll();
        GlStateManager.popMatrix();
    }

}
