package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class Tutorial implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(Core.plugin().getNewSpawnLocation());
			player.playSound(
					player.getLocation(), Sound.ENTITY_WITHER_SHOOT, (float) 0.5, (float) 0.8);
			return true;
		}
		Bukkit
				.getLogger()
				.info(Utils.tacc("&cAn entity other than the player ran the /hub command"));
		return false;
	}

}