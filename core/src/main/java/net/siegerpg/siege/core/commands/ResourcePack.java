package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
			player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);
			player.setResourcePack(
					"https://download.mc-packs.net/pack/552e26b7c45d46050d9c643818e1e43670bec27d.zip",
					"552e26b7c45d46050d9c643818e1e43670bec27d");
			player.sendMessage(Utils.lore("<green><bold>RESOURCE PACK"));
			player.sendMessage(Utils.lore("<green>https://download.mc-packs.net/pack/552e26b7c45d46050d9c643818e1e43670bec27d.zip"));
			return true;
		}
		return false;
	}

}