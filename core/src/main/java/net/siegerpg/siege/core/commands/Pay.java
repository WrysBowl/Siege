package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.cache.LevelEXPStorage;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Pay implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        OfflinePlayer targetPlayer;
        if (LevelEXPStorage.playerLevel.get(player) < 3) {
            player.sendMessage(Utils.lore("<red>You need to be level 3 to use this command!"));
            return false;
        }
        int gold = 0;
        try {
            targetPlayer = Bukkit.getOfflinePlayer(args[0]);
            gold = Integer.parseInt(args[1]);
        } catch (Exception ex) {
            player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay player gold"));
            return false;
        }

        if (!targetPlayer.hasPlayedBefore()) {
            player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay PLAYER gold"));
            return false;
        } else if (gold<=0) {
            player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay player GOLD"));
            return false;
        }
        double playerBal = VaultHook.econ.getBalance(player);
        if (playerBal >= gold) {
            player.sendMessage(Utils.lore("<yellow>You paid " + targetPlayer.getName() + " " + gold + " gold."));
            if (targetPlayer.isOnline()) ((Player)targetPlayer).sendMessage(Utils.lore("<yellow>You were paid " + gold + " gold by " + player.getName() + "."));
            VaultHook.econ.withdrawPlayer(player, gold);
            VaultHook.econ.depositPlayer(targetPlayer, gold);
        } else {
            player.sendMessage(Utils.lore("<red>You don't have enough money to pay this person " + gold + " gold."));
            return false;
        }
        Scoreboard.updateScoreboard(player);
        if (targetPlayer.isOnline()) Scoreboard.updateScoreboard((Player)targetPlayer);
        return true;
    }
}