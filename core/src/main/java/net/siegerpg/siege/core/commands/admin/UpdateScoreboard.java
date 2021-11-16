package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UpdateScoreboard implements CommandExecutor {

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
            return false;
        }
        Scoreboard.updateScoreboard(targetPlayer);
        return true;
    }
}