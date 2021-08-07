package net.siegerpg.siege.core.fishing.commands;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class getBait implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("Siege.getBait")){
                if(args.length==1) {
                    try{
                        BaitCore bait = BaitCore.getBait(args[0]);
                        player.sendMessage(bait.getName());
                        ItemStack item = bait.getBaitItemStack();
                        player.getInventory().addItem(item);
                        return true;
                    }
                    catch(Exception exception) {
                        exception.printStackTrace();
                        player.sendMessage(ChatColor.RED + "Invalid syntax, please use /getBait <baitName>, this bait does not exist");
                        return false;
                    }
                }
                player.sendMessage(ChatColor.RED + "Invalid syntax, please use /getBait <baitName>, use only 1 argument");
                return false;
            }
            player.sendMessage(ChatColor.RED + "no perm");
            return false;
        }
        return false;
    }
}
