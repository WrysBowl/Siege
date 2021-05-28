package net.siegerpg.siege.core.Webstore;

import net.bytebuddy.build.Plugin;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WebstoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) return false;

        OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);

        if (args[1].equals("5xBooster1.2")) {
            ItemStack item = WebstoreUtils.getExpBoosterItem(5, 1.2, 3600);
            final boolean fullInv = ((Player)argPlayer).getInventory().firstEmpty() == -1;
            final boolean fullEnderChest = ((Player)argPlayer).getEnderChest().firstEmpty() == -1;
            if (!fullInv) {
                ((Player)argPlayer).getInventory().addItem(item);
            } else if (!fullEnderChest) {
                ((Player)argPlayer).getEnderChest().addItem(item);
            } else {
                ((Player)argPlayer).getWorld().dropItemNaturally(((Player) argPlayer).getLocation(), item);
            }
            Bukkit.getServer().sendMessage(Utils.parse(""));
            Bukkit.getServer().sendMessage(Utils.parse("  <aqua>" + argPlayer.getName() + " has bought <yellow>5 <green>1.2x <light_purple>EXP Boosters!"));
            Bukkit.getServer().sendMessage(Utils.parse("  <aqua>https://store.siegerpg.net/"));
            Bukkit.getServer().sendMessage(Utils.parse(""));
        }



        return false;
    }
}