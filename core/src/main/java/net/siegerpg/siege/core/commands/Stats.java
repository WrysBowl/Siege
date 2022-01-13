package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.listeners.CustomItemKotlinListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Stats implements CommandExecutor {

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

		double health = Utils.round(
				CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.HEALTH), 2);
		double strength = Utils.round(
				CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.STRENGTH), 2);
		double toughness = Utils.round(
				CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.DEFENSE), 2);
		double luck = Utils.round(
				CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.LUCK), 2);
		double regeneration = Utils.round(
				CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.REGENERATION), 2);

		sender.sendMessage("");
		sender.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		sender.sendMessage("");

		sender.sendMessage("");
		sender.sendMessage(Utils.lore("<color:#EECB66>Player Statistics"));
		sender.sendMessage(Utils.lore(" "));
		sender.sendMessage(Utils.lore("<color:#DED153>" + player.getName()));
		sender.sendMessage(Utils.lore("  <gray>Strength        <reset><dark_red>" + strength));
		sender.sendMessage(Utils.lore("  <gray>Toughness     <reset><blue>" + toughness));
		sender.sendMessage(Utils.lore("  <gray>Health           <reset><red>" + health));
		sender.sendMessage(Utils.lore("  <gray>Regeneration  <reset><gold>" + regeneration));
		sender.sendMessage(Utils.lore("  <gray>Luck             <reset><green>" + luck));
		sender.sendMessage("");

		sender.sendMessage("");
		sender.sendMessage(Utils.lore("<color:#EECB66><bold>Specifics"));
		sender.sendMessage(Utils.lore(" "));
		sender.sendMessage(Utils.lore("  <dark_red>Strength <reset><gray>You deal "+strength+" to target's health points."));
		sender.sendMessage(Utils.lore("  <blue>Toughness <reset><gray>You prevent " +
		                              CustomItemKotlinListener.Companion.calcReducedToughness(toughness) +
		                              " damage from attackers."));
		sender.sendMessage(Utils.lore("  <red>Health <reset><gray>You have "+health+" health to be able to take more damage."));
		sender.sendMessage(Utils.lore("  <gold>Regeneration <reset><gray>You heal " + (int)(regeneration/5) + " health every " +
		                              Utils.round((PlayerData.getRegenRate((int) regeneration))/20.0,2) + "seconds on full hunger"));
		sender.sendMessage(Utils.lore("  <green>Luck <reset><gray>You have a "+luck+"% chance to get double the drops, EXP, and gold. For every 100 luck, you get a higher drops multiplier."));
		sender.sendMessage("");

		sender.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		sender.sendMessage("");

		return true;
	}

}

