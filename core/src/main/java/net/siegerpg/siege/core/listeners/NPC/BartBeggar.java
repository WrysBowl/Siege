package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.listeners.NPC.GamblingGames.TreasureHunter;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BartBeggar implements Listener {

	@EventHandler
	public void onRightClickOnEntity(PlayerInteractEntityEvent e) {

		if (e
				    .getRightClicked()
				    .getName()
				    .contains("Bart") && e
				    .getRightClicked()
				    .getName()
				    .contains("6")) {
			getMenu().show(e.getPlayer());
		}
	}

	private ChestGui getMenu() {
		//Menu
		ChestGui menu = new ChestGui(3, "Bart's Treasure Hunt");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));

		background.setRepeat(true);

		menu.addPane(background);

		OutlinePane navigator = new OutlinePane(4, 0, 1, 2);

		//Creating Start Icon
		ItemStack startIcon = new ItemStack(Material.ENDER_EYE);
		ItemMeta startIconMeta = startIcon.getItemMeta();
		startIconMeta.displayName(Utils.lore("<gold><bold>TREASURE HUNTER"));
		startIconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Uncover as many"));
				add(Utils.lore("<gray>rewards as you can"));
				add(Utils.lore("<gray>without blowing up!"));
				add(Utils.lore(""));
				add(Utils.lore("<yellow>COST 500 gold"));
				add(Utils.lore("<green><BOLD>CLICK TO PLAY"));
			}
		});
		startIcon.setItemMeta(startIconMeta);

		//Creating JackPot Icon
		ItemStack jackPotIcon = new ItemStack(Material.SUNFLOWER);
		ItemMeta jackPotIconMeta = jackPotIcon.getItemMeta();
		jackPotIconMeta.displayName(Utils.lore("<yellow><bold>WIN THE JACKPOTS"));
		jackPotIconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>1x <yellow>2,000 <gray>Gold"));
				add(Utils.lore("<gray>2x <yellow>1,000 <gray>Gold"));
				add(Utils.lore("<gray>3x <yellow>500 <gray>Gold"));
			}
		});
		jackPotIcon.setItemMeta(jackPotIconMeta);

		navigator.addItem(new GuiItem(jackPotIcon));
		navigator.addItem(new GuiItem(startIcon, this::clickStart));

		menu.addPane(navigator);
		return menu;
	}

	private void clickStart(InventoryClickEvent e) {

		if (e.getSlot() == 13) {
			Player player = (Player) e.getWhoClicked();
			int cost = 500;
			if (VaultHook.econ.getBalance(player) >= cost) {
				VaultHook.econ.withdrawPlayer(player, cost);
				Scoreboard.updateScoreboard((Player) e.getWhoClicked());
				TreasureHunter game = new TreasureHunter(player);
				return;
			}
			player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
		}
	}

}
