package net.siegerpg.siege.core.commands;

import net.bytebuddy.build.Plugin;
import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GetBooster implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(Utils.lore("<red>Only console can use this command."));
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(Utils.lore("<red>You did not fill in the proper arguments /getBooster player amount multiplier seconds EXP/GOLD."));
            return false;
        }
        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(Utils.lore("<red>This player is null."));
            return false;
        }
        int amount;
        double multiplier;
        int seconds;
        String booster;
        try {
            amount = Integer.parseInt(args[1]);
            multiplier = Double.parseDouble(args[2]);
            seconds = Integer.parseInt(args[3]);
            booster = args[4];
        } catch (Exception e){
            sender.sendMessage(Utils.lore("<red>Exception parsing command."));
            return false;
        }
        if (!booster.equals("EXP") && !booster.equals("GOLD")) {
            sender.sendMessage(Utils.lore("<red>This player is null."));
            return false;
        }
        ItemStack item = WebstoreUtils.getBooster(amount, multiplier, seconds, booster);
        WebstoreUtils.giveItemToPlayer(targetPlayer, item);
        Bukkit.broadcastMessage(Utils.tacc(""));
        Bukkit.broadcastMessage(Utils.tacc("  &b" + targetPlayer.getName() + " has received &e" + amount + " &a" + ((multiplier*100)-100.0) + "x &e" + booster + " booster(s)!"));
        Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
        Bukkit.broadcastMessage(Utils.tacc(""));
        return true;
    }
}