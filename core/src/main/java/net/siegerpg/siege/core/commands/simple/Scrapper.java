package net.siegerpg.siege.core.commands.simple;

import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class Scrapper implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player player)) return false;
		if (player.hasPermission("siege.donor")) {
			new Herbert(player);
		} else {
			player.sendMessage(Utils.lore("<red>Purchase a rank using the /webstore command to unlock this feature!"));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 0.5f, 0.75f);
			return false;
		}
		return true;
	}

}