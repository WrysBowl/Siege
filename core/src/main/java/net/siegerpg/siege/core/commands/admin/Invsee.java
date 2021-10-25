package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if(player.hasPermission("SiegeCore.invsee")){
                if (args.length == 1) {
                    final Player targetPlayer = Bukkit.getPlayer(args[0]);
                    if (targetPlayer != null && targetPlayer.isOnline()) {
                        player.openInventory(targetPlayer.getInventory());
                        return true;
                    }
                    player.sendMessage(Utils.parse("<red>That player is not online"));
                    return false;
                }
                player.sendMessage(Utils.parse("<red>Type in the player you want to invsee"));
                return false;
            }
            Bukkit.getLogger().info(Utils.tacc("<red>You do not have the permission to use this command"));
            return false;
        }
        Bukkit.getLogger().info(Utils.tacc("<red>An entity other than the player ran the /hub command"));
        return false;
    }
}