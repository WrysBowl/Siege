package net.siegerpg.siege.core.commands.admin;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.CustomItemUtilsKt;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.listeners.NPC.GamblingGames.TreasureHunter;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatUpgrade implements CommandExecutor {

	private ItemStack customItem;
	private ChestGui menu;
	private Integer goldCost = 0;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			return false;
		}
		if (args.length == 0) return false;
		Player player = Bukkit.getPlayer(args[0]);
		if (player == null) return false;

		ItemStack mainItem = player.getInventory().getItemInMainHand();
		CustomItem customMainItem = CustomItemUtils.INSTANCE.getCustomItem(mainItem);
		if (customMainItem == null) {
			player.sendMessage(Utils.lore("<red>You need to hold a weapon or armor to reforge."));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			return false;
		}
		if (!(customMainItem instanceof CustomEquipment)) {
			player.sendMessage(Utils.lore("<red>You need to hold a weapon or armor to reforge."));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			return false;
		}
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
		ChestGui menu = new StatUpgrade().getMenu(player, (CustomEquipment) customMainItem);
		menu.show(player);
		this.menu = menu;
		return true;
	}

	private ChestGui getMenu(Player player, CustomEquipment customEquipment) {
		//Menu
		ChestGui menu = new ChestGui(3, "Reforge");

		menu.setOnTopClick(event -> event.setCancelled(true));
		menu.setOnBottomDrag(event -> event.setCancelled(false));
		menu.setOnClose(event -> {
			if (this.goldCost > 0) getMenu(player, customEquipment).show(player);
			else {
				this.goldCost = 0;
				player.getInventory().addItem(this.customItem);
				player.closeInventory();
			}
		});


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
		startIconMeta.displayName(Utils.lore("<red><bold>REFORGE"));
		startIconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Drag materials onto the"));
				add(Utils.lore("<gray>item in the inventory!"));
				add(Utils.lore(""));
				add(Utils.lore("<yellow>Purchases Done Immediately"));
				add(Utils.lore("<yellow><bold>Gold Spent "+String.format("%,d", goldCost)));
			}
		});
		startIcon.setItemMeta(startIconMeta);

		navigator.addItem(new GuiItem(startIcon, this::completePurchase));
		navigator.addItem(new GuiItem(customEquipment.getItem(), event -> {
			upgradeStat(event, customEquipment);
		}));

		menu.addPane(navigator);
		this.menu = menu;
		this.customItem = customEquipment.getItem();
		player.getInventory().removeItem(customEquipment.getItem().asOne());
		return menu;
	}

	private void completePurchase(InventoryClickEvent e) {
		this.goldCost = 0;
		e.getWhoClicked().closeInventory();
	}

	private void upgradeStat(InventoryClickEvent e, CustomEquipment customEquipment) {
		//get item on the player's cursor (the material)
		Player player = (Player) e.getWhoClicked();
		ItemStack cursorItem = e.getCursor();
		if (cursorItem == null) return;

		//make sure cursor item is a custom material
		CustomItem customMaterialItem = CustomItemUtils.INSTANCE.getCustomItem(cursorItem);
		if (customMaterialItem == null) return;
		if (!(customMaterialItem instanceof CustomMaterial)) return;

		//get entire hashmap of all tier upgrades for the material
		HashMap<Integer, HashMap< StatTypes, Double>> tierStatMap = ((CustomMaterial) customMaterialItem).getUpgradeStats();
		if (tierStatMap == null) return;

		//get singular hashmap for the material's tier
		HashMap< StatTypes, Double> materialStatMap = tierStatMap.get(((CustomMaterial) customMaterialItem).getTier());

		//calculate gold cost
		int sum = 0;
		HashMap< StatTypes, Double> customEquipmentMap = customEquipment.getUpgradeStats();
		if (customEquipmentMap == null) customEquipmentMap = CustomItemUtils.INSTANCE.statMap(0.0,0.0,0.0,0.0,0.0,0.0,0.0);
		for (Map.Entry<StatTypes, Double> entry : materialStatMap.entrySet()) {
			if (entry.getValue() != 0.0 && customEquipmentMap.containsKey(entry.getKey())) {
				Double upgradeValue = materialStatMap.get(entry.getKey());
				Double originalValue = customEquipmentMap.get(entry.getKey());
				sum += (int)Math.floor(50*originalValue*upgradeValue);
			}
		}
		this.goldCost = sum;

		//completing purchase
		if (VaultHook.econ.getBalance(player) >= this.goldCost) {
			VaultHook.econ.withdrawPlayer(player, this.goldCost);
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 1.0f, 1.0f);

			Scoreboard.updateScoreboard((Player) e.getWhoClicked());
			customEquipment.addUpgradeStats(materialStatMap);
			customEquipment.updateMeta(false);
			cursorItem.setAmount(cursorItem.getAmount()-1);
			this.customItem = customEquipment.getItem();
			player.closeInventory();
		} else {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
		}
	}

}
