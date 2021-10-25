package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Discord implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        final Player player = (Player) sender;
        player.sendMessage(Utils.parse(""));
        player.sendMessage(Utils.parse("  <aqua><bold>Join our discord here!<reset>"));
        player.sendMessage(Utils.tacc("  https://discord.siegerpg.net"));
        player.sendMessage(Utils.parse(""));
        return false;
    }
}