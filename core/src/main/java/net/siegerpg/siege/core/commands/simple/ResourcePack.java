package net.siegerpg.siege.core.commands.simple;

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
					"https://6112ca72f60402008d5e41f9.manager.minehut.com/v1/resource_packs/76b869c1-9bfa-476a-a01b-7246ba25da4c",
					"bb53ed8fb1ef89d4c1bd93536dabc8a55c8d55c3");
			player.sendMessage(Utils.lore("<green><bold>RESOURCE PACK"));
			player.sendMessage(Utils.lore("<green>https://6112ca72f60402008d5e41f9.manager.minehut.com/v1/resource_packs/76b869c1-9bfa-476a-a01b-7246ba25da4c"));
			return true;
		}
		return false;
	}

}