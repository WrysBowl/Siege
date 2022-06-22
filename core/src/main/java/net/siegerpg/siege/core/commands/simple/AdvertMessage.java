package net.siegerpg.siege.core.commands.simple;

import net.kyori.adventure.text.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class AdvertMessage implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player = (Player) sender;

		player.sendMessage("");
		player.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		player.sendMessage("");
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#E69F61><bold><underlined>   ADVERT MESSAGES   <reset>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<yellow><bold>\u27B2<reset> <click:suggest_command:/ad SiegeRPG &6&lNEW RPG &8| &d+600 ITEMS &8| &e+40 MOBS &8| &bOPEN WORLD><color:#D5B73F>" +
		                               "<gold><bold>CLICK <reset><green>VIP+</click>"));
		player.sendMessage(Utils.parse("<yellow><bold>\u27B2<reset> <click:suggest_command:/ad SiegeRPG RPG | +600 ITEMS | +40 MOBS | OPEN WORLD><color:#D5B73F>" +
		                               "<gold><bold>CLICK <reset><green>DEFAULT</click>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		player.sendMessage("");
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);
		return false;
	}

}