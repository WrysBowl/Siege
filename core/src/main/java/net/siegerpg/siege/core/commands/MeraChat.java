package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MeraChat implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player)) return false;

		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.5f);

		final Location deathLocation = PlayerData.playerDeathLocations.get(player);
		if (deathLocation == null) return false;
		int locationCostComputation = (int) player.getLocation().distance(deathLocation)*2;
		int bal = (int) VaultHook.econ.getBalance(player);
		if (player.hasPermission("siege.donor")) bal = 0;

		if (bal < locationCostComputation) {
			player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
			player.playSound(player.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1.0f, 1.0f);
			return false;
		}
		VaultHook.econ.withdrawPlayer(player, locationCostComputation);
		Scoreboard.updateScoreboard(player);
		player.closeInventory();
		player.sendTitle(
				Utils.tacc("&aTeleporting to..."), Utils.tacc("&eLast Death Point"), 10, 30,
				10
		                );
		player.getWorld().spawnParticle(
						Particle.DRAGON_BREATH
								.builder()
								.count(50)
								.offset(1, 1, 1)
								.particle(),
						player.getLocation(), 10
				              );
		deathLocation.getWorld().spawnParticle(
						Particle.DRAGON_BREATH
								.builder()
								.count(50)
								.offset(1, 1, 1)
								.particle(),
						deathLocation, 10
				              );
		Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
					player.teleport(deathLocation);
					player.playSound(
							player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0f, 0.8f);
				}, 40L);
		return true;
	}

}