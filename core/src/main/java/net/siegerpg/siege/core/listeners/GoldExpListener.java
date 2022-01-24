package net.siegerpg.siege.core.listeners;

import com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent;
import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GoldExpListener implements Listener {

	public static ArrayList< Player > expCalculating = new ArrayList<>();
	public static ArrayList< Player > awaitingRemoval = new ArrayList<>();

	public static void giveGold(Player player, int goldAmount) {
		net.siegerpg.siege.core.miscellaneous.VaultHook.econ.depositPlayer(player, goldAmount);
		player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3f, 1.0f);
		player.sendActionBar(Utils.parse("<yellow>+ " + goldAmount + " <yellow>\u26C1"));
		Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
					public void run() {

						Scoreboard.updateScoreboard(player);
					}
				}, 20);
	}

	@EventHandler
	public void goldPickUp(PlayerAttemptPickupItemEvent e) {

		ItemStack item = e.getItem().getItemStack();
		if (e.isCancelled()) return;
		if (!item.getType().equals(Material.SUNFLOWER)) return;
		if (!item.getItemMeta().getDisplayName().contains("\u26C1")) return;
		Player player = e.getPlayer();
		e.setCancelled(true);
		e.getItem().remove();
		int goldAmount = e.getItem().getItemStack().getAmount();
		giveGold(player, goldAmount);
	}

	@EventHandler
	public void expPickUp(PlayerPickupExperienceEvent e) {

		int exp = e.getExperienceOrb().getExperience();
		Player player = e.getPlayer();

		//check if exp calculation for player is currently being processed
		if (expCalculating.contains(player)) {
			e.setCancelled(true);
			e.getExperienceOrb().setVelocity(player.getLocation().getDirection().multiply(0.5));
			//if exp calculation has been processed, add to rate limiter arraylist
			if (awaitingRemoval.contains(player)) return;
			awaitingRemoval.add(player);

			//allow EXP to be gained 5 ticks later
			new BukkitRunnable() {
				@Override
				public void run() {
					expCalculating.remove(player);
					awaitingRemoval.remove(player);
				}
			}.runTaskLater(Core.plugin(), 1);

			return; //if player is processing exp calculation
		} else {
			expCalculating.add(player);
		}
		Levels.INSTANCE.addExpShared(player, exp);
		player.sendActionBar(Utils.parse("<dark_purple>+ " + exp + " <dark_purple>EXP"));

		Bukkit
				.getServer()
				.getScheduler()
				.runTaskLater(Core.plugin(), new Runnable() {
					public void run() {

						Scoreboard.updateScoreboard(player);
					}
				}, 20);
		e.getExperienceOrb().setExperience(0);
	}

	@EventHandler
	public void expMerge(ExperienceOrbMergeEvent e) {

		e.setCancelled(true);

	}

	@EventHandler
	public void goldMerge(ItemMergeEvent e) {

		ItemStack item = e
				.getEntity()
				.getItemStack();
		Item source = e.getEntity();
		Item target = e.getTarget();
		int total = source
				            .getItemStack()
				            .getAmount() + target
				            .getItemStack()
				            .getAmount();
		if (e.isCancelled()) return;
		if (item
				    .getType()
				    .equals(Material.SUNFLOWER) && item
				    .getItemMeta()
				    .getDisplayName()
				    .contains("\u26C1")) {
			e.getTarget().customName(Utils.lore("<yellow>+" + total + " \u26C1"));
		} else if (CustomItemUtils.INSTANCE.getCustomItem(item) != null) {
			e.getTarget().customName(Utils.lore("<yellow>" + total + "x <r>" + item.getItemMeta().getDisplayName()));
		}
		e
				.getTarget()
				.setCustomNameVisible(true);
	}

	@EventHandler
	public void setDroppedItemName(ItemSpawnEvent e) {

		ItemStack item = e
				.getEntity()
				.getItemStack();
		CustomItem CusItem = CustomItemUtils.INSTANCE.getCustomItem(item);
		if (CusItem == null) return;
		if (item.getAmount() <= 1)
			e
					.getEntity()
					.setCustomName(Utils.tacc(item
							                          .getItemMeta()
							                          .getDisplayName()));
		else
			e
					.getEntity()
					.setCustomName(Utils.tacc("&e" + item.getAmount() + "x &r" + item
							.getItemMeta()
							.getDisplayName()));
		e
				.getEntity()
				.setCustomNameVisible(true);
	}

}
