package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Webstore implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.sendMessage(Utils.parse(""));
        player.sendMessage(Utils.parse("  <aqua><bold>Visit our webstore here!<reset>"));
        player.sendMessage(Utils.tacc("  https://store.siegerpg.net/"));
        player.sendMessage(Utils.parse(""));
        return false;
    }
}