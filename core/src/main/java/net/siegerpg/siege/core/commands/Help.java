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

        player.sendMessage(Utils.parse("   <yellow>/buy <gray>Opens the in-game webstore"));
        player.sendMessage(Utils.parse("   <yellow>/discord <gray>Visit the discord server"));
        player.sendMessage(Utils.parse("   <yellow>/hub <gray>Visit the hub off Siege"));
        player.sendMessage(Utils.parse("   <yellow>/leaderboard <gray>See the leaderboard"));
        player.sendMessage(Utils.parse("   <yellow>/level <gray>See your level"));
        player.sendMessage(Utils.parse("   <yellow>/pay <gray>Pay a player"));
        player.sendMessage(Utils.parse("   <yellow>/spawn <gray>Visit the spawn off Siege"));
        player.sendMessage(Utils.parse("   <yellow>/stats <gray>See a player's stats"));
        player.sendMessage(Utils.parse("   <yellow>/tips enable/disable <gray>Disable/Enable tips"));
        player.sendMessage(Utils.parse("   <yellow>/webstore <gray>Sends link to the webstore"));
        player.sendMessage(Utils.parse("   <yellow>/rules <gray>See the rules"));
    }
}