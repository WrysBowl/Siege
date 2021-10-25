package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Leaderboard implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        //get a list of all the players with levels
        //create a new sorted list
        //loop through the list and display it in a readable way for the player
        Levels.INSTANCE.getAllExpLevel(10, topTen -> {
            sender.sendMessage(Utils.lore(" "));
            sender.sendMessage(Utils.lore("     <gold><bold>Siege Level Leaderboard     "));
            for (int i = 0; i < topTen.size(); i++) {
                final UUID uuid = topTen.get(i).component1();
                final Short level = topTen.get(i).component2();
                final Integer experience = topTen.get(i).component3();
                final float reqExp = Levels.INSTANCE.calculateRequiredExperience(level);
                final double division = experience / reqExp;
                final OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
                final String name = player.getName();
                final String levelPercent = " <reset><light_purple>(" + Utils.round(Utils.round(division, 3) * 100, 2) + "%)";
                sender.sendMessage(Utils.lore("<gold>" + (i + 1) + ". <white>" + name + " <dark_purple><bold>" + level + levelPercent));
            }
            sender.sendMessage(Utils.lore(" "));
            return null;
        });
        return true;
    }
}