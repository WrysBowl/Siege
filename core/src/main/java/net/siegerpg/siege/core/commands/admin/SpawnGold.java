package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.utils.GoldEXPSpawning;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnGold implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.hasPermission("SiegeCore.spawnGold")) {
                if(args.length < 0)
                {
                    if(args.length == 2)
                    {
                        try {
                            final int num = Integer.getInteger(args[0]);
                            final Player target = Bukkit.getPlayer(args[1]);
                            GoldEXPSpawning.spawnGold(num, target.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Succesfully spawned in " + args[0] + " gold at " + target.getName() + "'s location");
                            return true;
                        }
                        catch(final Exception exception) {
                            player.sendMessage(ChatColor.RED + "invalid syntax, please use /spawnGold <integer> <player>");
                            return false;
                        }
                    }
                    else {
                        try {
                            final int num = Integer.getInteger(args[0]);
                            GoldEXPSpawning.spawnGold(num, player.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Succesfully spawned in " + args[0] + " gold at your location");
                            return true;
                        } catch (final Exception exception) {
                            player.sendMessage(ChatColor.RED + "invalid syntax, please use /spawnGold <integer> <player>");
                            return false;
                        }
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "invalid syntax, please use /spawnGold <integer> <player>");
                    return false;
                }
            }
            else
            {
                player.sendMessage(ChatColor.RED + "No perms papa");
                return false;
            }
        }

        return false;
    }
}
