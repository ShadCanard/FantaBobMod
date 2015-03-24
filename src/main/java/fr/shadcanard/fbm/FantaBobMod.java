//TODO: Terminer les items (donner nom, vérifier textures)
//TODO : Terminer Entités (Register, Render, Proxy)
//TODO : S'occuper des sons.


package fr.shadcanard.fbm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.blocks.BlockFBM;
import fr.shadcanard.fbm.creativeTab.FBMTabs;
import fr.shadcanard.fbm.handler.CraftingHandler;
import fr.shadcanard.fbm.init.ModArmor;
import fr.shadcanard.fbm.init.ModBlocks;
import fr.shadcanard.fbm.init.ModItems;
import fr.shadcanard.fbm.proxy.ClientProxy;
import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
import fr.shadcanard.fbm.utils.LogHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.awt.*;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FantaBobMod {

    @Mod.Instance(Reference.MOD_ID)

    public static FantaBobMod instance;
    public static CreativeTabs fbmCreativeTabs = new FBMTabs(Reference.MOD_ID.toLowerCase());
    public BlockFBM blockBouze;
    public static ItemArmor.ArmorMaterial FBMArmor = EnumHelper.addArmorMaterial("FBMArmor",5,new int[]{1,3,2,1},15);

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static ClientProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
        ModItems.init();
        ModArmor.init();
        proxy.registerRender();
        CraftingHandler.init();

        LogHelper.info("Pre Initialization Complete !");
    }

    public void init(FMLInitializationEvent event){


        LogHelper.info("Initialization Complete !");
    }
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("Post Initialization Complete !");
    }

}
