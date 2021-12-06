package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Level implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}
		if (args.length > 0) {
			OfflinePlayer argPlayer = Bukkit.getOfflinePlayerIfCached(args[0]);
			if (argPlayer == null) {
				sender.sendMessage(Utils.parse("<red>That player could not be found."));
				return true;
			}
			showLevelInfo(sender, argPlayer);
			return true;
		}
		Player player = (Player) sender;
		showLevelInfo(sender, player);

		return true;

	}

	public void showLevelInfo(CommandSender executor, OfflinePlayer player) {

		Levels.INSTANCE.getExpLevel(player, pair -> {
			if (pair == null) {
				executor.sendMessage(Utils.lore("<red>That player could not be found."));
				return null;
			}
			float reqExp = Levels.INSTANCE.calculateRequiredExperience(pair.getFirst());
			double division = pair.getSecond() / reqExp;
			String name = player.getName();
			String levelPercent = Utils.round(Utils.round(division, 3) * 100, 2) + "%";

			int total = 0;
			for (int i = 2; i < pair.getFirst(); i++) {
				total = total + Levels.INSTANCE.calculateRequiredExperience((short) i);

			}
			total = total + pair.getSecond();
			String totalFormat = String.format("%,d", total);
			String expLeft = String.format("%,d", (int) (reqExp - pair.getSecond()));
			executor.sendMessage(Utils.lore("<dark_purple><bold>Level Statistics"));
			executor.sendMessage("");
			executor.sendMessage("");
			executor.sendMessage(Utils.lore("<gold>" + name));
			executor.sendMessage(
					Utils.lore("<gray>Level         <reset><dark_purple>" + pair.getFirst()));
			executor.sendMessage(
					Utils.lore("<gray>Exp %         <reset><light_purple>" + levelPercent));
			executor.sendMessage(
					Utils.lore("<gray>Exp            <reset><light_purple>" + pair.getSecond()));
			executor.sendMessage(Utils.lore("<gray>Exp to Next  <reset><light_purple>" + expLeft));
			executor.sendMessage(
					Utils.lore("<gray>Total Exp     <reset><light_purple>" + totalFormat));
			executor.sendMessage(Utils.lore(" "));
			return null;
		});
	}

}

