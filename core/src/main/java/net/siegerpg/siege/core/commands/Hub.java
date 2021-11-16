package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Hub implements CommandExecutor {

	@Override
	public boolean onCommand (@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(Core.plugin().getServer().getWorld("Hub").getSpawnLocation());
			return true;
		}
		Bukkit.getLogger().info(Utils.tacc("<red>An entity other than the player ran the /hub command"));
		return false;
	}

}