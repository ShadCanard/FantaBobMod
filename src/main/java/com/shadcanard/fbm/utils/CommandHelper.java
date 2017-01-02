package com.shadcanard.fbm.utils;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandHelper {

    public static void init(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandTipeee());
        event.registerServerCommand(new CommandRemoveBuddies());
    }
}
