package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.fishing.catches.loot.webstore.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class TutorialReward implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (args.length != 1) return false;
		Player player = Bukkit.getPlayer(args[0]);
		if (player == null) {
			sender.sendMessage(Utils.parse("<red>1st argument is not a player."));
			return false;
		}
		if (player.hasPermission("siege.tutorial.complete")) {
			player.sendMessage(Utils.parse("<red>You've already claimed your tutorial reward!"));
			return false;
		}
		VaultHook.perms.playerAdd(null, player, "siege.tutorial.complete");

		Utils.giveItem(player, new MobKey().getUpdatedItem(false).asQuantity(3));
		Utils.giveItem(player, new CommonKey().getUpdatedItem(false));

		player.setBedSpawnLocation(player.getLocation().toBlockLocation(), true);
		player.sendMessage("");
		player.sendMessage(Utils.parse("<green>Reward claimed!"));
		player.sendMessage("");
		player.playSound(
				player.getLocation(), Sound.BLOCK_CHEST_OPEN, (float) 0.5, (float) 0.8);

		return true;
	}

}