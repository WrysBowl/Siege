package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ToggleTips implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.lore("<red>You can not toggle tips!"));
			return false;
		}
		Player player = (Player) sender;
		if (args.length < 1) {
			player.sendMessage(Utils.parse("\n" +
			                               "<gold><bold>TOGGLE TIPS<reset>" +
			                               "\n" +
			                               "\n" +
			                               "<green>/tips enable<reset> <gray>enables tip broadcasts." +
			                               "\n" +
			                               "<red>/tips disable<reset> <gray>disables tip broadcasts." +
			                               "\n"));
		} else if (args[0].equals("enable")) {
			player.sendMessage(Utils.lore(
					"\n<yellow>Tips have been enabled. To disable tips type /tips disable.\n"));
			PlayerData.broadcastTips.put(player, true);
		} else if (args[0].equals("disable")) {
			player.sendMessage(Utils.lore(
					"\n<yellow>Tips have been disabled. To re-enable tips type /tips enable.\n"));
			PlayerData.broadcastTips.put(player, false);
		}
		return false;
	}

}