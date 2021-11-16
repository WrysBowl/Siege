package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Pay implements CommandExecutor {

	@Override
	public boolean onCommand (@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player = (Player) sender;
		Levels.INSTANCE.getExpLevel(player, pair -> {
			if (pair == null || pair.getFirst() < 3) {
				player.sendMessage(Utils.lore("<red>You need to be level 3 to use this command!"));
				return null;
			}
			int gold = 0;
			OfflinePlayer targetPlayer;
			try {
				targetPlayer = Bukkit.getOfflinePlayerIfCached(args[0]);
				if (targetPlayer == null) {
					sender.sendMessage(Utils.parse("<red>That player could not be found."));
					return null;
				}
				gold = Integer.parseInt(args[1]);
			} catch (Exception ex) {
				player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay player gold"));
				return null;
			}

			if (!targetPlayer.hasPlayedBefore()) {
				player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay PLAYER gold"));
				return null;
			} else if (gold <= 0) {
				player.sendMessage(Utils.lore("<red>Incorrect arguments. Type /pay player GOLD"));
				return null;
			}
			double playerBal = VaultHook.econ.getBalance(player);
			if (playerBal >= gold) {
				player.sendMessage(Utils.lore("<yellow>You paid " + targetPlayer.getName() + " " + gold + " gold."));
				if (targetPlayer.isOnline())
					((Player) targetPlayer).sendMessage(Utils.lore("<yellow>You were paid " + gold + " gold by " + player.getName() + "."));
				VaultHook.econ.withdrawPlayer(player, gold);
				VaultHook.econ.depositPlayer(targetPlayer, gold);
			} else {
				player.sendMessage(Utils.lore("<red>You don't have enough money to pay this person " + gold + " gold."));
				return null;
			}
			new BukkitRunnable() {
				@Override
				public void run () {

					Scoreboard.updateScoreboard(player);
					if (targetPlayer.isOnline()) Scoreboard.updateScoreboard((Player) targetPlayer);
				}
			}.runTask(Core.plugin());
			return null;
		});

		return true;
	}

}