package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Level implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("     <gold><bold>Your Level     "));
        short level = Levels.INSTANCE.getExpLevel((Player)sender).getFirst();
        float reqExp = Levels.INSTANCE.calculateRequiredExperience(level);
        Integer experience = Levels.INSTANCE.getExpLevel((Player)sender).getSecond();
        double division = experience/reqExp;
        String name = sender.getName();
        String levelPercent = " <reset><light_blue>(" + Utils.round(Utils.round(division, 3)*100,2) + "%)";
        Integer total = 0;

        for (int i = 2; i < level; i++) {

            Levels.INSTANCE.calculateRequiredExperience(level);

        }
        String levelRaw = " <light_blue>" + String.format("%,d", experience);
        sender.sendMessage(Utils.lore("<gold>" + ". <white>" + name + " <dark_blue><bold>" + level + levelPercent + levelRaw));

        return true;
    }

}

