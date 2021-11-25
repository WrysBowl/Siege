package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResourcePack implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.setResourcePack(
					"https://download.mc-packs.net/pack/552e26b7c45d46050d9c643818e1e43670bec27d.zip",
					"552e26b7c45d46050d9c643818e1e43670bec27d");
			return true;
		}
		Bukkit.getLogger().info(Utils.tacc("<green><bold>RESOURCE PACK"));
		Bukkit.getLogger().info(Utils.tacc("<green>https://download.mc-packs.net/pack/552e26b7c45d46050d9c643818e1e43670bec27d.zip"));
		return false;
	}

}