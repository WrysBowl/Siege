package net.siegerpg.siege.core.commands;

import kotlin.Triple;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Leaderboard implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //get a list of all the players with levels
        //create a new sorted list
        //loop through the list and display it in a readable way for the player
        ArrayList<Triple<UUID, Short, Integer>> topTen = Levels.INSTANCE.getAllExpLevel(10);
        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("     <gold><bold>Siege Level Leaderboard     "));
        for (int i = 0; i < topTen.size(); i++) {
            UUID uuid = topTen.get(i).component1();
            Short level = topTen.get(i).component2();
            Integer experience = topTen.get(i).component3();
            float reqExp = Levels.INSTANCE.calculateRequiredExperience(level);
            double division = experience/reqExp;
            OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
            String name = player.getName();
            String levelPercent = " <reset><light_purple>(" + Utils.round(Utils.round(division, 3)*100,2) + "%)";
            String levelRaw = " <light_purple>" + String.format("%,d", experience);
            sender.sendMessage(Utils.lore("<gold>" + (i+1) + ". <white>" + name + " <dark_purple><bold>" + level + levelPercent + levelRaw));
        }
        sender.sendMessage(Utils.lore(" "));
        return true;
    }
}