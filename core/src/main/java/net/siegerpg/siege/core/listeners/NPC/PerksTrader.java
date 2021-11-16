package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Objects;

public class PerksTrader implements Listener {


	@EventHandler
	public void onRightClickOnEntity (PlayerInteractEntityEvent e) {

		if (e.getRightClicked().getName().contains("Perks") && e.getRightClicked().getName().contains("6")) {
			Inventory shop = getShopMenu(e.getPlayer());
			e.getPlayer().openInventory(shop);
		}
	}

	@EventHandler
	public void guiClick (InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		if (e.getWhoClicked().getMetadata("PerkTrading").size() > 0 &&
		    Objects.equals(e.getWhoClicked().getMetadata("PerkTrading").get(0).value(), e.getInventory())) {
			clickShop(e);
			e.setCancelled(true);
		}
	}

	private void clickShop (InventoryClickEvent e) {

		if (e.getSlot() != 13) return;

		Player player = (Player) e.getWhoClicked();
		int highestPV = Utils.getHighestPV(player);
		if (highestPV == 54) {
			player.sendMessage(Utils.tacc("&cYou can not get more than 54 vaults!"));
			player.closeInventory();
			return;
		}
		int nextPV = highestPV + 1;
		int cost = nextPV * 10000;

		if (VaultHook.econ.getBalance(player) < cost) {
			player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
			player.closeInventory();
			return;
		}
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		String cmd = "lp user " + player.getName() + " permission set cosmicvaults.amount." + nextPV + " true global";
		Bukkit.dispatchCommand(console, cmd);
		VaultHook.econ.withdrawPlayer(player, cost);
		player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
		Scoreboard.updateScoreboard(player);
		player.sendMessage(Utils.tacc("&eYou have increased your player vault amount by 1."));
		player.closeInventory();
	}


	private Inventory getShopMenu (Player player) {

		Inventory gui = Bukkit.createInventory(null, 27, "Perk Trading");

		//Fill in the GUI
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		for (int i = 0; i < gui.getSize(); i++) {
			gui.setItem(i, filler);
		}
		int highestPV = Utils.getHighestPV(player);
		int nextPV = highestPV + 1;
		int cost = nextPV * 10000;
		ItemStack buyPerk = new ItemStack(Material.CHEST);
		ItemMeta buyPerkMeta = buyPerk.getItemMeta();
		buyPerkMeta.displayName(Utils.lore("<yellow>Buy +1 Vault"));
		buyPerkMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>" + highestPV + " -> " + nextPV));
				add(Utils.lore("<yellow>Cost " + String.format("%,d", cost)));
				add(Utils.lore("<yellow><bold>CLICK TO UPGRADE"));
			}
		});
		buyPerk.setItemMeta(buyPerkMeta);
		gui.setItem(13, buyPerk);

		player.setMetadata("PerkTrading", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

}