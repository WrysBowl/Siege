package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor {


	@Override
	public boolean onCommand (@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(player.getWorld().getSpawnLocation());
			player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, (float) 0.5, (float) 0.8);
			player.setBedSpawnLocation(null, true);
			return true;
		}
		Bukkit.getLogger().info(Utils.tacc("&cAn entity other than the player ran the /hub command"));
		return false;
	}

}