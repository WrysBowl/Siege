package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Hub implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            player.teleport(Core.plugin().getServer().getWorld("Hub").getSpawnLocation());
            return true;
        }
        Bukkit.getLogger().info(Utils.tacc("<red>An entity other than the player ran the /hub command"));
        return false;
    }
}