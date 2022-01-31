package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.statgems.StatGem;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GemRemover implements Listener {

	private int cost = 0;
	private double chance = 0;
	private ItemStack item = null;

	public GemRemover() {
		cost = 0;
		chance = 0;
		item = null;
	}

	@EventHandler
	public void onRightClickOnEntity(PlayerInteractEvent e) {

		if (e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.CHIPPED_ANVIL)) {
			e.setCancelled(true);
			openInventory(e.getPlayer());
		}
	}

	public void openInventory(Player player) {
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
		if (customItem instanceof CustomEquipment) {
			if (((CustomEquipment) customItem).hasGem()) {
				getMenu(player).show(player);
				return;
			}
		}
		player.sendMessage(Utils.lore("<red>You must be holding an item with a gem!"));
	}

	private double calcChance() {

		if (this.item == null) return 0;
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(this.item);
		if (customItem == null) return 0;
		if (customItem.getLevelRequirement() == null) return 0;
		int levelReq = customItem.getLevelRequirement();
		double calculatedChance = Utils.round(30.0 + (this.cost / ((double) (levelReq * 5))), 2);
		if (calculatedChance > 100) return 100;
		else return calculatedChance;
	}

	private int calcCost(double chance) {

		if (this.item == null) return 0;
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(this.item);
		if (customItem == null) return 0;
		if (customItem.getLevelRequirement() == null) return 0;
		int levelReq = customItem.getLevelRequirement();
		return (int) ((chance*(levelReq * 5)) - 30.0);
	}


	private ChestGui getMenu(Player player) {

		//Menu
		ChestGui menu = new ChestGui(5, "Gem Remover");
		menu.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});
		menu.setOnClose(e -> {
			if (this.item != null) {
				e.getPlayer().getInventory().addItem(this.item);
				this.item = null;
			}
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		ItemStack item = player.getInventory().getItemInMainHand();
		this.item = item;
		this.chance = calcChance();

		OutlinePane iconDisplays = new OutlinePane(4, 2, 1, 2);
		OutlinePane removeAdd = new OutlinePane(2, 1, 5, 1);

		//Creating rows
		if (this.chance < 100) {
			removeAdd.addItem(new GuiItem(getIconRemove1000(), e -> {
				if (this.cost < 1000) return;
				this.cost -= 1000;
				getMenu(player).show(player);
				player.updateInventory();
			}));
			removeAdd.addItem(new GuiItem(getIconRemove100(), e -> {
				if (this.cost < 100) return;
				this.cost -= 100;
				getMenu(player).show(player);
				player.updateInventory();
			}));
			removeAdd.addItem(new GuiItem(getIcon()));
			removeAdd.addItem(new GuiItem(getIconAdd100(), e -> {
				double bal = VaultHook.econ.getBalance(player);
				if (bal < 100) {
					player.sendMessage(
							Utils.tacc("&cYou do not have enough money to increase the chance!"));
				} else {
					this.cost += 100;
					getMenu(player).show(player);
					player.updateInventory();
				}
			}));
			removeAdd.addItem(new GuiItem(getIconAdd1000(), e -> {
				double bal = VaultHook.econ.getBalance(player);
				if (bal < 1000) {
					player.sendMessage(
							Utils.tacc("&cYou do not have enough money to increase the chance!"));
				} else {
					this.cost += 1000;
					getMenu(player).show(player);
					player.updateInventory();
				}
			}));

			iconDisplays.addItem(new GuiItem(getIconSpeedUp(), e -> {
				double bal = VaultHook.econ.getBalance(player);
				if (bal < calcCost(100)) {
					player.sendMessage(
							Utils.tacc("&cYou do not have enough money to increase the chance!"));
				} else {
					this.cost += calcCost(100);
					getMenu(player).show(player);
					player.updateInventory();
				}
			}));
			iconDisplays.addItem(new GuiItem(item, e -> {
				getGem(player);
			}));
		}
		menu.addPane(removeAdd);
		menu.addPane(iconDisplays);

		return menu;
	}
	private ItemStack getIconRemove100() {
		ItemStack icon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<red>-100 <yellow>\u26C1"));

		icon.setItemMeta(iconMeta);
		return icon;
	}
	private ItemStack getIconRemove1000() {
		ItemStack icon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<red>-1,000 <yellow>\u26C1"));

		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getIconAdd100() {
		ItemStack icon = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<green>+100 <yellow>\u26C1"));

		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getIconAdd1000() {
		ItemStack icon = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<green>+1,000 <yellow>\u26C1"));

		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getIconSpeedUp() {
		ItemStack icon = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<green>+"+calcCost(100-chance)+" <yellow>\u26C1"));
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getIcon() {
		ItemStack icon = new ItemStack(Material.SUNFLOWER);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<yellow>Cost: " + this.cost));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<aqua>Chance of Recovery: " + chance));
				add(Utils.lore("<gold><bold>CLICK TO GET <reset><yellow>(maybe)"));

			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private void getGem(Player player) {
		if (this.item == null || this.item.getType().isAir()) return;
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(this.item);
		if (customItem == null) return;
		if (!(customItem instanceof CustomEquipment)) return;
		if (!((CustomEquipment) customItem).hasGem()) return;
		if (Utils.randTest((double) this.chance)) {
			//How to get the stat gem from the item? Check in the stat gem listener class
			//StatGem(itemOnCursor.statType, itemOnCursor.statAmount
			StatGem gem = new StatGem(
					((CustomEquipment) customItem)
							.getStatGem()
							.getType(), ((CustomEquipment) customItem)
							.getStatGem()
							.getAmount());
			ItemStack item = new ItemStack(Material.AIR);
			switch (gem.getType()) {
				case HEALTH:
					if (gem.getAmount() == 10.0) {
						item = new RawHealthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 14.0) {
						item = new CrackedHealthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 18.0) {
						item = new FlawedHealthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 22.0) {
						item = new SimpleHealthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 26.0) {
						item = new PolishedHealthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 30.0) {
						item = new PristineHealthGem(0).getUpdatedItem(false);
					}
					break;
				case STRENGTH:
					if (gem.getAmount() == 2.0) {
						item = new RawStrengthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 3.0) {
						item = new CrackedStrengthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 4.0) {
						item = new FlawedStrengthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 6.0) {
						item = new SimpleStrengthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 8.0) {
						item = new PolishedStrengthGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 10.0) {
						item = new PristineStrengthGem(0).getUpdatedItem(false);
					}
					break;
				case LUCK:
					if (gem.getAmount() == 4.0) {
						item = new RawLuckGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 6.0) {
						item = new CrackedLuckGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 8.0) {
						item = new FlawedLuckGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 11.0) {
						item = new SimpleLuckGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 14.0) {
						item = new PolishedLuckGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 18.0) {
						item = new PristineLuckGem(0).getUpdatedItem(false);
					}
					break;
				case DEFENSE:
					if (gem.getAmount() == 10.0) {
						item = new RawToughGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 15.0) {
						item = new CrackedToughGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 20.0) {
						item = new FlawedToughGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 30.0) {
						item = new SimpleToughGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 40.0) {
						item = new PolishedToughGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 50.0) {
						item = new PristineToughGem(0).getUpdatedItem(false);
					}
					break;
				case REGENERATION:
					if (gem.getAmount() == 5.0) {
						item = new RawRegenerationGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 7.0) {
						item = new CrackedRegenerationGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 9.0) {
						item = new FlawedRegenerationGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 11.0) {
						item = new SimpleRegenerationGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 13.0) {
						item = new PolishedRegenerationGem(0).getUpdatedItem(false);
					} else if (gem.getAmount() == 15.0) {
						item = new PristineRegenerationGem(0).getUpdatedItem(false);
					}
			}

			player
					.getInventory()
					.addItem(item);
			player.sendMessage(Utils.tacc("&aSuccessfully removed gem!"));
			player.playSound(
					player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

		} else {
			player.sendMessage(Utils.tacc("&cThe gem broke upon trying to remove it!"));
			player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1.0f, 1.0f);
		}
		player.closeInventory();
		VaultHook.econ.withdrawPlayer(
				player, this.cost); //takes the cost they put in from the player
		Scoreboard.updateScoreboard(player);
		CustomEquipment equipmentItem = (CustomEquipment) customItem;
		equipmentItem.removeStatGem(); //removes stat gem
		equipmentItem.updateMeta(false);
		Utils.giveItem(player, equipmentItem.getItem());
		player
				.getInventory()
				.remove(this.item.asOne());
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
		this.cost = 0;
		this.item = null;
	}

}