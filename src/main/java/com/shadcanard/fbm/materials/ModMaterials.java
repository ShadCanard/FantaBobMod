package com.shadcanard.fbm.materials;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
    public static Item.ToolMaterial BAMBOO;

    public static void init(){
       BAMBOO = EnumHelper.addToolMaterial("BAMBOO",1,120,3.0F,0.5F,10);
    }
}