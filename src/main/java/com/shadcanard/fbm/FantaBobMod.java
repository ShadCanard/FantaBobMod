
//TODO: ADD Squelettes de creeper en plastique


package com.shadcanard.fbm;

import com.shadcanard.fbm.blocks.BlockFBM;
import com.shadcanard.fbm.creativeTab.FBMTabs;
import com.shadcanard.fbm.handler.ConfigurationHandler;
import com.shadcanard.fbm.handler.CraftingHandler;
import com.shadcanard.fbm.init.ModArmor;
import com.shadcanard.fbm.init.ModBlocks;
import com.shadcanard.fbm.init.ModEntities;
import com.shadcanard.fbm.init.ModItems;
import com.shadcanard.fbm.proxy.CommonProxy;
import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.CommandHelper;
import com.shadcanard.fbm.utils.LogHelper;
import com.shadcanard.fbm.utils.SkinHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("ALL")
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FantaBobMod {

    public static final boolean IS_DEBUG_MODE = true;

    @Mod.Instance(Reference.MOD_ID)

    public static FantaBobMod instance;
    public static CreativeTabs fbmCreativeTabs = new FBMTabs(Reference.MOD_ID.toLowerCase());
    public BlockFBM blockBouze;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        LogHelper.info("Loading Config Files");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        LogHelper.info("Loading Blocks");
        ModBlocks.init();
        LogHelper.info("Loading Items");
        ModItems.init();
        LogHelper.info("Loading Armor");
        ModArmor.init();
        LogHelper.info("Loading Entities");
        ModEntities.init();


        //LogHelper.info("Loading Achievements");
        //AchievementHandler.init();

        LogHelper.info("Pre Initialization Complete !");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.registerRender();
        LogHelper.info("Loading Crafts");
        CraftingHandler.init();

        LogHelper.info("Initialization Complete !");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        SkinHelper.init();
        LogHelper.info("Finished Downloading skins");
        LogHelper.info("Post Initialization Complete !");
    }

    @Mod.EventHandler
    public void serverIint(FMLServerStartingEvent event){
        CommandHelper.init(event);
    }
}
