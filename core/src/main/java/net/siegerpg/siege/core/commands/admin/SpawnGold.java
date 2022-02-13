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
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("SiegeCore.spawnGold")) {
                if(args.length > 0)
                {
                    if(args.length == 2)
                    {
                        try {
                            int num = Integer.parseInt(args[0]);
                            Player target = Bukkit.getPlayer(args[1]);
                            GoldEXPSpawning.spawnGold(num, target.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Succesfully spawned in " + args[0] + " gold at " + target.getName() + "'s location");
                            return true;
                        }
                        catch(Exception exception) {
                            player.sendMessage(ChatColor.RED + "invalid syntax, please use /spawnGold <integer> <player>");
                            return false;
                        }
                    }
                    else {
                        try {
                            int num = Integer.parseInt(args[0]);
                            GoldEXPSpawning.spawnGold(num, player.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Succesfully spawned in " + args[0] + " gold at your location");
                            return true;
                        } catch (Exception exception) {
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
