package fr.shadcanard.fbm.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import fr.shadcanard.fbm.handler.ConfigurationHandler;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;


public class ModGuiConfig extends GuiConfig{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        //noinspection unchecked
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}