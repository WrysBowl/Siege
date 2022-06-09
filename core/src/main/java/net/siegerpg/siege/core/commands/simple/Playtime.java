package net.siegerpg.siege.core.commands.simple;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Playtime implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}
		OfflinePlayer player = (Player) sender;
		if (args.length > 0) {
			OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
			if (!argPlayer.isOnline()) {
				((Player) player).sendMessage(Utils.lore("<red>That player can not be found."));
				return false;
			}
			player = argPlayer;
		}
		((Player)sender).playSound(((Player)sender).getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);

		String time = Utils.secondsToHHMMSS(player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20);
		sender.sendMessage("");
		sender.sendMessage(Utils.parse("<gray>    <aqua><bold>PLAYTIME<reset><gray>    "));
		sender.sendMessage(Utils.parse("     <yellow>"+time));
		sender.sendMessage("");
		return false;
	}

}