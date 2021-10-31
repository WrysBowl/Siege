package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Help implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.sendMessage(Utils.parse(""));
        player.sendMessage(Utils.parse("  <aqua><bold>Join our discord here!<reset>"));
        player.sendMessage(Utils.tacc("  https://discord.siegerpg.net"));
        player.sendMessage(Utils.parse(""));
        return false;
    }

    //-----[HELP SIEGE]-----
    public void firstLine(Player player) {
        player.sendMessage(Utils.parse("    <gold><bold>HELP    "));
    }

    public void lastLine(Player player) {
        player.sendMessage(Utils.parse(""));
    }

    public void firstPage(Player player) {

        //COMMAND LIST

        //  <yellow>/buy <gray>Opens the webstore
    }
}