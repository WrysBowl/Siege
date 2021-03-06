package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Webstore implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player = (Player) sender;

		player.sendMessage("");
		player.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		player.sendMessage("");
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#E69F61><bold><underlined>   WEBSTORE   <reset>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<yellow><bold>\u27B2<reset> <click:open_url:https://store.siegerpg.net/><color:#D5B73F>https://store.siegerpg.net/</click>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<dark_gray><underlined>                                        "));
		player.sendMessage("");
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);
		return false;
	}

}