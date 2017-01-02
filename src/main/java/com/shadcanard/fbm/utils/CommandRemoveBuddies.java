package com.shadcanard.fbm.utils;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.shadcanard.fbm.entity.buddy.Buddy;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandRemoveBuddies implements ICommand {

    private final List aliases;

    public CommandRemoveBuddies() {
        aliases = new ArrayList();
        aliases.add("fbm_killbuddies");
    }

    @Override
    public String getCommandName() {
        return "fbm_killbuddies";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "fbm_killbuddies";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = server.getEntityWorld();
        List entityList = new ArrayList();
        entityList = world.getEntities(Buddy.class,null);
        for (int i = 0; i < entityList.size(); i++) {
            world.removeEntity((Buddy)entityList.get(i));
        }
        sender.addChatMessage(new TextComponentString("[FantaBobMod]" + new TextComponentTranslation("text.buddyRemoved").getFormattedText() + " " + ChatFormatting.DARK_RED + ChatFormatting.BOLD + entityList.size() + ChatFormatting.RESET + " Buddies"));
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
