package com.shadcanard.fbm.utils;

import com.shadcanard.fbm.references.Reference;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommandTipeee implements ICommand {

    private final List aliases;

    public CommandTipeee(){
        aliases = new ArrayList();
        aliases.add("fbm");
        aliases.add("fantabobmod");
    }

    @Override
    public String getCommandName() {
        return "fantabobmod";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "fantabobmod";
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        String tipList = "";
        for (int i = 1; i < Reference.TIPEEE_LIST.length; i++) {
            tipList += Reference.TIPEEE_LIST[i] + " ";
        }
        tipList += ".";
        sender.addChatMessage(new TextComponentString("[FantaBobMod] " + new TextComponentTranslation("text.tipeeThanks").getFormattedText() + " : " + tipList));
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
