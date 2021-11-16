package net.siegerpg.siege.core.listeners.NPC;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MeraTransit implements Listener {

	@EventHandler
	public void onRightClickOnEntity (PlayerInteractEntityEvent e) {

		if (e.getRightClicked().getName().contains("Mera") && e.getRightClicked().getName().contains("6")) {
			Inventory shop = getGUIWorldTransit(e.getPlayer());
			e.getPlayer().openInventory(shop);
		}
	}

	@EventHandler
	public void guiClick (InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		if (e.getView().getTitle().equals("World Transit")) {
			e.setCancelled(true);
			Player player = (Player) e.getWhoClicked();
			int slot = e.getSlot();
			int bal = (int) VaultHook.econ.getBalance(player);
			final Location deathLocation = PlayerData.playerDeathLocations.get(player);
			if (deathLocation == null) {
				player.playSound(player.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1.0f, 1.0f);
				return;
			}
			int locationCostComputation = (int) player.getLocation().distance(deathLocation);
			int deathTeleportCost = (player.hasPermission("siege.mera.0")) ? 0 : locationCostComputation;


			if (slot == 13) {
				if (bal < deathTeleportCost) {
					player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
					player.playSound(player.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1.0f, 1.0f);
					return;
				}
				VaultHook.econ.withdrawPlayer(player, deathTeleportCost);
				Scoreboard.updateScoreboard(player);
				player.closeInventory();
				player.sendTitle(Utils.tacc("&aTeleporting to..."), Utils.tacc("&eLast Death Point"), 10, 30, 10);
				player.getWorld().spawnParticle(
						Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
						player.getLocation(), 10);
				deathLocation.getWorld().spawnParticle(
						Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
						deathLocation, 10);
				Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
					player.teleport(deathLocation);
					player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0f, 0.8f);
				}, 40L);
			}
		}
	}

	private Inventory getGUIWorldTransit (Player player) {

		Inventory gui = Bukkit.createInventory(null, 27, "World Transit");

		//Fill in the GUI
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		for (int i = 0; i < gui.getSize(); i++) {
			gui.setItem(i, filler);
		}

		final Location deathLocation = PlayerData.playerDeathLocations.get(player);
		ItemStack deathLocationIcon = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta deathLocationIconItemMeta = deathLocationIcon.getItemMeta();
		deathLocationIconItemMeta.displayName(Utils.lore("<gray><bold>Last Death"));
		if (deathLocation == null) {

			List<Component> lore = new ArrayList<>() {
				{
					add(Utils.lore(""));
					add(Utils.lore("<red>Oh, you have"));
					add(Utils.lore("<red>not died yet."));
				}
			};
			deathLocationIconItemMeta.lore(lore);

		} else {
			int locationCostComputation = (int) player.getLocation().distance(deathLocation);
			final int deathTeleportCost = (player.hasPermission("siege.mera.0")) ? 0 : locationCostComputation;

			List<Component> lore = new ArrayList<>() {
				{
					add(Utils.lore(""));
					add(Utils.lore("<green>Location"));
					add(Utils.lore("<green>x: <gray>" + (int) deathLocation.getX()));
					add(Utils.lore("<green>y: <gray>" + (int) deathLocation.getY()));
					add(Utils.lore("<green>z: <gray>" + (int) deathLocation.getZ()));
					add(Utils.lore(""));
					add(Utils.lore("<yellow>Cost " + deathTeleportCost));
					add(Utils.lore("<gray>Click to Purchase"));
				}
			};
			deathLocationIconItemMeta.lore(lore);

		}
		deathLocationIcon.setItemMeta(deathLocationIconItemMeta);

		//This is where you decide what slot the item goes into
		gui.setItem(13, deathLocationIcon);

		return gui;
	}

}
