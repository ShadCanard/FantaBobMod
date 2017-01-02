package com.shadcanard.fbm.entity.buddy;

import com.shadcanard.fbm.helpers.ChatHelper;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.LogHelper;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BuddyTipeee extends Buddy {

    private String name;


    @Override
    public String getName() {
        return name;
    }

    public BuddyTipeee(World worldIn) {
        super(worldIn);
        setTippeur();
        setSounds("null");
    }

    public ResourceLocation getTippeurSkin(){
        if(name == "null" || name == null){
            name = "ShadCanard";
        }
        ResourceLocation rlSkin = new ResourceLocation("fbm","textures/entity/" + name + ".png");
        return rlSkin;
    }

    public void setTippeur(){
        int ref = 0 + (int)(Math.random() * ((Reference.TIPEEE_LIST.length) - 0));
        name = Reference.TIPEEE_LIST[ref];
        setCustomNameTag(name);
        LogHelper.info(name);
    }


    @Override
    public void onDeath(DamageSource cause) {
        ChatHelper.AddBuddyKill("Mini-" + name, cause.getEntity().getName());
    }
}
