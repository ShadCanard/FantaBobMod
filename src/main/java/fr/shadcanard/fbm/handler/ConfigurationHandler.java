package fr.shadcanard.fbm.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.shadcanard.fbm.references.Reference;
import net.minecraftforge.common.config.Configuration;

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

    public static void init(File configFile){
        if(configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        isPyromaniac = configuration.getBoolean("isPyromaniac",Configuration.CATEGORY_GENERAL,true,"Is Bob Pyromaniac ?");
        pyroRate = configuration.getInt("pyroRate", Configuration.CATEGORY_GENERAL, 30, 0, 100, "Rate of Bob's pyro");
        isImmuneToFire = configuration.getBoolean("isImmuneToFire", Configuration.CATEGORY_GENERAL, true, "Is Bob immune to fire ?");
        canBurnWool = configuration.getBoolean("canBurnWool",Configuration.CATEGORY_GENERAL,true,"Can Bob burn Wool ?");
        canBurnTNT = configuration.getBoolean("canBurnTNT",Configuration.CATEGORY_GENERAL,true,"Can Bob burn TNT ?");
        canBurnPlants = configuration.getBoolean("canBurnPlants",Configuration.CATEGORY_GENERAL,true,"Can Bob burn Plants ?");
        canBurnLeaves = configuration.getBoolean("canBurnLeaves",Configuration.CATEGORY_GENERAL,true,"Can Bob burn Leaves ?");
        canBurnWood = configuration.getBoolean("canBurnWood",Configuration.CATEGORY_GENERAL,true,"Can Bob burn Leaves ?");

        if(configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }
    }
}