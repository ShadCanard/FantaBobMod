package com.shadcanard.fbm.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatHelper {
    public static void AddBuddyKill(String buddyName, String playerName) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(buddyName + new TextComponentTranslation("text.slaughter").getFormattedText() + " " + playerName));
    }
}
