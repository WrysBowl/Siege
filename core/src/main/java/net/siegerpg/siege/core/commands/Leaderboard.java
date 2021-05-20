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
        sender.sendMessage(Utils.lore("<light_purple>_____<dark_purple>Siege Level Leaderboard<light_purple>_____"));
        for (int i = 0; i < topTen.size(); i++) {
            Player player = Bukkit.getPlayer(topTen.get(i).component1());
            Short level = topTen.get(i).component2();
            Integer experience = topTen.get(i).component3();
            String name = "NULL";
            if (player != null) {
                name = player.getName();
            }
            sender.sendMessage(Utils.lore("<yellow>" + (i+1) + ". " + name + " <light_purple>" + level.toString() + " <white>" + experience.toString()));
        }
        sender.sendMessage(Utils.lore(" "));
        return true;
    }
}