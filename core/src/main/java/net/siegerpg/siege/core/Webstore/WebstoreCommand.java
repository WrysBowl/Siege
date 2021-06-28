package net.siegerpg.siege.core.Webstore;

import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WebstoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) return false;

        OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);

        if (args[1].equals("5xBoosterEXP1.2")) {
            ItemStack item = WebstoreUtils.getBooster(5, 1.2, 3600, "EXP");
            WebstoreUtils.giveItemToPlayer((Player)argPlayer, item);
            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &e5 &a1.2x &dEXP Boosters!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }
        if (args[1].equals("5xBoosterGOLD1.2")) {
            ItemStack item = WebstoreUtils.getBooster(5, 1.2, 3600, "GOLD");
            WebstoreUtils.giveItemToPlayer((Player)argPlayer, item);
            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &e5 &a1.2x &eGold Boosters!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }
        if (args[1].equals("WarriorRank")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String cmd = "lp user " + argPlayer.getName() + " parent add Warrior";
            Bukkit.dispatchCommand(console, cmd);
            int highestPV = Utils.getHighestPV((Player)argPlayer);
            int diff = 54 - highestPV;
            int addPV = highestPV+2;
            if (diff < 2) addPV = diff;
            VaultHook.perms.playerAdd((Player)argPlayer, "cosmicvaults.amount."+addPV+" true global");
            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &2Warrior &erank!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }


        return false;
    }
}