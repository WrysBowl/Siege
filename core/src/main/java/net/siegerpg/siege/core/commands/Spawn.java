package net.siegerpg.siege.core.commands;

import com.destroystokyo.paper.ParticleBuilder;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Spawn implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getWorld().getName().equals("Dungeons")) return false;
            player.teleport(player.getWorld().getSpawnLocation());
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, (float) 0.5, (float) 0.8);
            player.setBedSpawnLocation(player.getWorld().getSpawnLocation(), true);
            return true;
        }
        Bukkit.getLogger().info(Utils.tacc("&cAn entity other than the player ran the /hub command"));
        return false;
    }
}