//TODO: Terminer les items (donner nom, vérifier textures)
//TODO : Terminer Entités (Register, Render, Proxy)
//TODO : S'occuper des sons.


package fr.shadcanard.fbm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import fr.shadcanard.fbm.blocks.BlockFBM;
import fr.shadcanard.fbm.creativeTab.FBMTabs;
import fr.shadcanard.fbm.init.ModArmor;
import fr.shadcanard.fbm.init.ModBlocks;
import fr.shadcanard.fbm.init.ModItems;
import fr.shadcanard.fbm.proxy.ClientProxy;
import fr.shadcanard.fbm.references.Reference;
import fr.shadcanard.fbm.utils.LogHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.awt.*;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FantaBobMod {

    @Mod.Instance(Reference.MOD_ID)

    public static FantaBobMod instance;
    public static CreativeTabs fbmCreativeTabs = new FBMTabs(Reference.MOD_NAME + "_creative_tab");
    public BlockFBM blockBouze;
    public static ItemArmor.ArmorMaterial FBMArmor = EnumHelper.addArmorMaterial("FBMArmor",5,new int[]{1,3,2,1},15);

    public static ClientProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
        ModItems.init();
        ModArmor.init();


        //proxy.registerRender();

        LogHelper.info("Pre Initialization Complete !");
    }

    public void init(FMLInitializationEvent event){

        LogHelper.info("Initialization Complete !");
    }
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("Post Initialization Complete !");
    }

}
