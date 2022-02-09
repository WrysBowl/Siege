package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.statgems.StatGem;
import net.siegerpg.siege.core.items.types.armor.*;
import net.siegerpg.siege.core.items.types.misc.*;
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

	private CustomItem item;
	private StatGemType gem;

	public GemRemover() {
		this.item = null;
		this.gem = null;
	}
	public GemRemover(CustomItem item, StatGemType gem) {
		this.item = item;
		this.gem = gem;
	}

	public void openInventory(Player player) {
		ItemStack item = player.getInventory().getItemInMainHand();
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);

		if (customItem instanceof CustomEquipment) {
			if (((CustomEquipment) customItem).hasGem()) {

				StatGem gem = new StatGem(((CustomEquipment) customItem).getStatGem().getType(), ((CustomEquipment) customItem).getStatGem().getAmount());
				GemRemover instance = new GemRemover(customItem, getStatGem(gem));
				instance.getMenu(player).show(player);

				return;
			}
		}
		player.sendMessage(Utils.lore("<red>You must be holding an item with a gem!"));
	}


	private ChestGui getMenu(Player player) {

		//Menu
		ChestGui menu = new ChestGui(3, "Gem Remover");
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
		OutlinePane itemIcon = new OutlinePane(4, 1, 1, 1);
		OutlinePane gemRemoveIcon = new OutlinePane(2, 1, 1, 1);

		//Creating rows
		exitIcon.addItem(new GuiItem(getIconExit(), e -> {
			player.getInventory().close();
		}));
		gemRemoveIcon.addItem(new GuiItem(getIconSpeedUp(), e -> {
			getGem(player);
		}));
		itemIcon.addItem(new GuiItem(this.item.getUpdatedItem(false)));

		menu.addPane(exitIcon);
		menu.addPane(itemIcon);
		menu.addPane(gemRemoveIcon);

		return menu;
	}

	private ItemStack getIconSpeedUp() {
		ItemStack icon = new CrystalHammer().getUpdatedItem(false);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#C0ED8E><bold>REMOVE GEM"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to remove"));
				add(Utils.lore("<gray>your gem for"));
				add(Utils.lore("<yellow>"+String.format("%,d", getCost())+" \u26C1"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getIconExit() {
		ItemStack icon = new ItemStack(Material.BARRIER);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<red><bold>EXIT"));
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private int getCost() {
		return this.gem.getSellValue();
	}

	private void getGem(Player player) {

		CustomEquipment equipmentItem = ((CustomEquipment)this.item);
		try {
			ItemStack removedItem = equipmentItem.getItem().asOne();
			player.getInventory().remove(removedItem);
		} catch (Exception ignored) {
			player.closeInventory();
			player.sendMessage(Utils.lore("<red>Couldn't find the item in your inventory."));
			return;
		}


		VaultHook.econ.withdrawPlayer(player, getCost()); //takes the cost they put in from the player
		Scoreboard.updateScoreboard(player);

		equipmentItem.removeStatGem();
		equipmentItem.serialize();

		player.getInventory().addItem(this.gem.getUpdatedItem(false));
		Utils.giveItem(player, equipmentItem.getUpdatedItem(false));

		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
		player.closeInventory();

		this.item = null;
	}


	private StatGemType getStatGem(StatGem gem) {
		StatGemType item = null;
		switch (gem.getType()) {
			case HEALTH:
				if (gem.getAmount() == 10.0) {
					item = new RawHealthGem(0);
				} else if (gem.getAmount() == 14.0) {
					item = new CrackedHealthGem(0);
				} else if (gem.getAmount() == 18.0) {
					item = new FlawedHealthGem(0);
				} else if (gem.getAmount() == 22.0) {
					item = new SimpleHealthGem(0);
				} else if (gem.getAmount() == 26.0) {
					item = new PolishedHealthGem(0);
				} else if (gem.getAmount() == 30.0) {
					item = new PristineHealthGem(0);
				}
				break;
			case STRENGTH:
				if (gem.getAmount() == 2.0) {
					item = new RawStrengthGem(0);
				} else if (gem.getAmount() == 3.0) {
					item = new CrackedStrengthGem(0);
				} else if (gem.getAmount() == 4.0) {
					item = new FlawedStrengthGem(0);
				} else if (gem.getAmount() == 6.0) {
					item = new SimpleStrengthGem(0);
				} else if (gem.getAmount() == 8.0) {
					item = new PolishedStrengthGem(0);
				} else if (gem.getAmount() == 10.0) {
					item = new PristineStrengthGem(0);
				}
				break;
			case LUCK:
				if (gem.getAmount() == 4.0) {
					item = new RawLuckGem(0);
				} else if (gem.getAmount() == 6.0) {
					item = new CrackedLuckGem(0);
				} else if (gem.getAmount() == 8.0) {
					item = new FlawedLuckGem(0);
				} else if (gem.getAmount() == 11.0) {
					item = new SimpleLuckGem(0);
				} else if (gem.getAmount() == 14.0) {
					item = new PolishedLuckGem(0);
				} else if (gem.getAmount() == 18.0) {
					item = new PristineLuckGem(0);
				}
				break;
			case DEFENSE:
				if (gem.getAmount() == 10.0) {
					item = new RawToughGem(0);
				} else if (gem.getAmount() == 15.0) {
					item = new CrackedToughGem(0);
				} else if (gem.getAmount() == 20.0) {
					item = new FlawedToughGem(0);
				} else if (gem.getAmount() == 30.0) {
					item = new SimpleToughGem(0);
				} else if (gem.getAmount() == 40.0) {
					item = new PolishedToughGem(0);
				} else if (gem.getAmount() == 50.0) {
					item = new PristineToughGem(0);
				}
				break;
			case REGENERATION:
				if (gem.getAmount() == 5.0) {
					item = new RawRegenerationGem(0);
				} else if (gem.getAmount() == 7.0) {
					item = new CrackedRegenerationGem(0);
				} else if (gem.getAmount() == 9.0) {
					item = new FlawedRegenerationGem(0);
				} else if (gem.getAmount() == 11.0) {
					item = new SimpleRegenerationGem(0);
				} else if (gem.getAmount() == 13.0) {
					item = new PolishedRegenerationGem(0);
				} else if (gem.getAmount() == 15.0) {
					item = new PristineRegenerationGem(0);
				}
		}
		return item;
	}

}