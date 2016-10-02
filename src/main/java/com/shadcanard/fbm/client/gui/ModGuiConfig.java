package com.shadcanard.fbm.client.gui;


import com.shadcanard.fbm.handler.ConfigurationHandler;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;


public class ModGuiConfig extends GuiConfig {
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