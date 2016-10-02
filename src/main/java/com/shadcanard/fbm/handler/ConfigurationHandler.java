package com.shadcanard.fbm.handler;

import com.shadcanard.fbm.references.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;
    public static int pyroRate = 30;
    public static boolean isPyromaniac = false;
    public static boolean isImmuneToFire = true;
    public static boolean canBurnWool = true;
    public static boolean canBurnTNT = true;
    public static boolean canBurnPlants = true;
    public static boolean canBurnLeaves = true;
    public static boolean canBurnWood = true;
    public static boolean onlyFantaBob = false;

    public static void init(File configFile){
        if(configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        isPyromaniac = configuration.getBoolean("isPyromaniac","Boblennon",true,"Is Bob Pyromaniac ?");
        pyroRate = configuration.getInt("pyroRate", "Boblennon", 30, 0, 100, "Rate of Bob's pyro");
        isImmuneToFire = configuration.getBoolean("isImmuneToFire", "Boblennon", true, "Is Bob immune to fire ?");
        canBurnWool = configuration.getBoolean("canBurnWool","Boblennon",true,"Can Bob burn Wool ?");
        canBurnTNT = configuration.getBoolean("canBurnTNT","Boblennon",true,"Can Bob burn TNT ?");
        canBurnPlants = configuration.getBoolean("canBurnPlants","Boblennon",true,"Can Bob burn Plants ?");
        canBurnLeaves = configuration.getBoolean("canBurnLeaves","Boblennon",true,"Can Bob burn Leaves ?");
        canBurnWood = configuration.getBoolean("canBurnWood","Boblennon",true,"Can Bob burn Leaves ?");
        onlyFantaBob = configuration.getBoolean("onlyFantaBob","General",false,"Is there only Fanta and Bob ?");

        if(configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }
    }
}