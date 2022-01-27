package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor;
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RarityRoll implements Listener {

	private CustomItem item;

	public RarityRoll() {
		item = null;
	}

	public void openInventory(Player player) {
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
		if (customItem instanceof CustomArmor || customItem instanceof CustomWeapon) {
			RarityRoll instance = new RarityRoll();
			instance.getMenu(player).show(player);
			instance.item = customItem;
			return;
		}
		player.sendMessage(Utils.lore("<red>You must be holding a weapon!"));
	}


	private ChestGui getMenu(Player player) {

		//Menu
		ChestGui menu = new ChestGui(3, "Rarity Roll");
		menu.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane exitIcon = new OutlinePane(6, 1, 1, 1);
		OutlinePane reRollIcon = new OutlinePane(2, 1, 1, 1);
		OutlinePane itemIcon = new OutlinePane(4, 1, 1, 1);

		//Creating rows
		exitIcon.addItem(new GuiItem(getIconExit(), e -> {
			player.getInventory().close();
		}));
		reRollIcon.addItem(new GuiItem(getIconReRoll(), e -> {
			reRoll(player);
		}));
		itemIcon.addItem(new GuiItem(this.item.getUpdatedItem(false)));

		menu.addPane(exitIcon);
		menu.addPane(itemIcon);
		menu.addPane(reRollIcon);

		return menu;
	}
	private ItemStack getIconExit() {
		ItemStack icon = new ItemStack(Material.BARRIER);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<red><bold>EXIT"));
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private ItemStack getIconReRoll() {
		ItemStack icon = new ItemStack(Material.RESPAWN_ANCHOR);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#B5EB5A><bold>RE-ROLL"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to roll a"));
				add(Utils.lore("<gray>new rarity for"));
				add(Utils.lore("<yellow>"+getCost()+" \u26C1"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private int getCost() {
		try {
			int levelReq = this.item.getLevelRequirement();
			return (levelReq^2)*10;
		} catch (Exception ignored) {}
		return 0;
	}

	private void reRoll(Player player) {

		//save a copy of current item
		CustomItem copiedItem = this.item;

		//check if player has balance to pay for re-roll
		double bal = VaultHook.econ.getBalance(player);
		if (bal < getCost()) {
			player.sendMessage(Utils.tacc("&cYou are too poor to re-roll your item!"));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			return;
		}

		//removes cost of re-roll from player's balance
		player.sendMessage(Utils.tacc("&eYou re-rolled your item's quality!"));
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
		VaultHook.econ.withdrawPlayer(player, getCost());
		Scoreboard.updateScoreboard(player);

		//remove item from player's inventory
		player.getInventory().remove(this.item.getItem().asOne());

		//change quality of copied item
		int rarity = Utils.randRarity();
		while (rarity > 80) {
			rarity = Utils.randRarity();
		}
		copiedItem.setQuality(rarity);
		copiedItem.serialize();

		//remove old item from player
		player.getInventory().remove(this.item.getItem().asOne());

		//set this.item to copied item
		this.item = copiedItem;

		//give player copied item
		Utils.giveItem(player, copiedItem.getUpdatedItem(false));
	}

}