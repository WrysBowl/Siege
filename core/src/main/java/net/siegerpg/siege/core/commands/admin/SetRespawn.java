package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetRespawn implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player = Bukkit.getPlayer(args[0]);
		if (player == null) {
			sender.sendMessage(Utils.parse("<red>1st argument is not a player."));
			return false;
		}
		if (sender instanceof Player) {
			player.sendMessage(Utils.parse("<red>You can't use this command"));
			return false;
		}

		player.setBedSpawnLocation(player.getLocation(), true);
		player.sendMessage("");
		player.sendMessage(Utils.parse("<green>Respawn point has been set!"));
		player.sendMessage("");
		player.playSound(
				player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, (float) 0.5, (float) 0.8);

		return true;
	}

}