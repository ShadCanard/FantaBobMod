package com.shadcanard.fbm.utils;

import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

public class SkinHelper {
    public static void init(){
        for (int i = 0; i < Reference.TIPEEE_LIST.length; i++) {
            LogHelper.info("Downloading " + Reference.TIPEEE_LIST[i] + "'s skin");
            AbstractClientPlayer.getDownloadImageSkin(new ResourceLocation("fbm", "textures/entity/" + Reference.TIPEEE_LIST[i] + ".png"),Reference.TIPEEE_LIST[i]);
            LogHelper.info("Downloaded !");
        }
        LogHelper.info("Skin download complete !");
    }
}
