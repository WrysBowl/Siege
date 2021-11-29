package net.siegerpg.siege.core.commands.admin;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
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

	private CustomEquipment oldItem;
	private ItemStack oldItemStack;
	private CustomEquipment newItem;

	private ChestGui menu;
	private Integer goldCost = 0;
	private ItemStack material;
	private ItemStack cursor;

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
		StatUpgrade instance = new StatUpgrade();
		instance.oldItem = (CustomEquipment) customMainItem;
		instance.oldItemStack = customMainItem.getItem();
		player.getInventory().removeItem(customMainItem.getItem().asOne());
		this.menu = instance.getMenu(player);
		this.menu.show(player);
		return true;
	}

	private ChestGui getMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(3, "Reforge");

		menu.setOnTopClick(event -> event.setCancelled(true));
		menu.setOnBottomClick(event -> {
			if (event.getCurrentItem() == null) return;
			if (this.material == null) cursor = event.getCurrentItem().clone();
		});
		menu.setOnBottomDrag(event -> event.setCancelled(false));
		menu.setOnClose(event -> {
			if (this.goldCost > 0) getMenu(player).show(player);
			else {
				this.goldCost = 0;
				if (this.newItem == null) {
					Utils.giveItem(player, this.oldItemStack);
				} else {
					Utils.giveItem(player, this.newItem.getItem());
				}
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

		OutlinePane reforgeIcon = new OutlinePane(4, 0, 1, 1);
		//Creating Reforging Purchase Icon
		ItemStack startIcon = new ItemStack(Material.ANVIL);
		ItemMeta startIconMeta = startIcon.getItemMeta();
		startIconMeta.displayName(Utils.lore("<red><bold>REFORGE"));
		startIconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Drag materials into the"));
				add(Utils.lore("<gray>the available slot!"));
				add(Utils.lore(""));
				add(Utils.lore("<yellow>Cost "+String.format("%,d", goldCost)));
			}
		});
		startIcon.setItemMeta(startIconMeta);
		//when clicked, process transaction
		reforgeIcon.addItem(new GuiItem(startIcon, this::completePurchase));


		OutlinePane navigator = new OutlinePane(2, 1, 5, 1);

		//sets the proper material
		ItemStack materialIcon = new ItemStack(Material.BARRIER);
		if (this.material == null) {
			//Creating Material Placing Icon
			ItemMeta materialIconMeta = startIcon.getItemMeta();
			materialIconMeta.displayName(Utils.lore("<red>Empty Slot"));
			materialIconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Material must have"));
					add(Utils.lore("<gray>stats that are on item"));
					add(Utils.lore(""));
					add(Utils.lore("<yellow>Drop Material"));
				}
			});
			materialIcon.setItemMeta(materialIconMeta);
		} else {
			materialIcon = this.material;
		}

		navigator.addItem(new GuiItem(materialIcon, this::setMaterialUsed));
		navigator.addItem(new GuiItem(filler));
		navigator.addItem(new GuiItem(this.oldItemStack));
		navigator.addItem(new GuiItem(filler));
		if (this.newItem != null) {
			navigator.addItem(new GuiItem(this.newItem.getItem()));
		} else {
			navigator.addItem(new GuiItem(this.oldItemStack));
		}

		menu.addPane(reforgeIcon);
		menu.addPane(navigator);
		this.menu = menu;
		return menu;
	}

	/**
	 * Adds material into GUI and displays newItem
	 */
	private void setMaterialUsed(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();

		if (this.material != null) {

			Utils.giveItem(player, cursor);
			this.material = null;
			this.newItem = null;
			this.goldCost = 0;
			this.cursor = null;
			player.closeInventory();
			return;
		}

		ItemStack cursorItem = e.getCursor();
		HashMap< StatTypes, Double> materialStatMap = getMaterialStatMap(cursorItem);
		if (!materialUsable(materialStatMap)) return;

		this.material = cursorItem;
		CustomEquipment item = this.oldItem;
		this.newItem = getUpgradedItem(materialStatMap, item);
		this.goldCost = getCost(materialStatMap);

		e.setCursor(null);
		player.closeInventory();
	}

	/**
	 * @return Checks if material can be used for upgrading
	 */
	private boolean materialUsable(HashMap< StatTypes, Double> materialStatMap) {
		if (materialStatMap == null) return false;
		CustomEquipment item = this.oldItem;
		return item.checkIfExistingStat(materialStatMap);
	}

	private HashMap< StatTypes, Double> getMaterialStatMap(ItemStack cursorItem) {
		//make sure cursor item is a custom material
		CustomItem customMaterialItem = CustomItemUtils.INSTANCE.getCustomItem(cursorItem);
		if (customMaterialItem == null) return null;
		if (!(customMaterialItem instanceof CustomMaterial)) return null;

		//get entire hashmap of all tier upgrades for the material
		HashMap<Integer, HashMap< StatTypes, Double>> tierStatMap = ((CustomMaterial) customMaterialItem).getUpgradeStats();
		if (tierStatMap == null) return null;

		//get singular hashmap for the material's tier
		return tierStatMap.get(((CustomMaterial) customMaterialItem).getTier());
	}

	private int getCost(HashMap< StatTypes, Double> addStats) {
		//calculate gold cost
		int sum = 0;
		HashMap< StatTypes, Double> customEquipmentMap = this.oldItem.getUpgradeStats();
		if (customEquipmentMap == null) customEquipmentMap = CustomItemUtils.INSTANCE.statMap(0.0,0.0,0.0,0.0,0.0,0.0,0.0);
		for (Map.Entry<StatTypes, Double> entry : addStats.entrySet()) {
			if (entry.getValue() != 0.0 && customEquipmentMap.containsKey(entry.getKey())) {
				Double upgradeValue = addStats.get(entry.getKey());
				Double originalValue = customEquipmentMap.get(entry.getKey());
				sum += 300+(((1+originalValue)*10)*((1+upgradeValue)*10)*0.75);
			}
		}
		return sum * this.material.getAmount();
	}

	private void completePurchase(InventoryClickEvent e) {
		//get item on the player's cursor (the material)
		Player player = (Player) e.getWhoClicked();

		//completing purchase
		if (VaultHook.econ.getBalance(player) >= this.goldCost) {
			VaultHook.econ.withdrawPlayer(player, this.goldCost);
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 1.0f, 1.0f);

			this.goldCost = 0;
			Scoreboard.updateScoreboard(player);
			player.closeInventory();
		} else {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
		}
	}

	//used when getting item for display in GUI
	private CustomEquipment getUpgradedItem(HashMap< StatTypes, Double> addStats, CustomEquipment customEquipment) {

		addStats.replaceAll((k, v) -> v * this.material.getAmount());
		customEquipment.addUpgradeStats(addStats);
		customEquipment.updateMeta(false);
		return customEquipment;

	}

}
