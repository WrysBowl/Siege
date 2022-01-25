package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Herbert implements Listener {

	private final ItemStack cashInSymbol = new ItemStack(Material.SUNFLOWER);
	private final ItemMeta cashMeta = cashInSymbol.getItemMeta();
	private final ItemStack scanSymbol = new ItemStack(Material.ARROW);
	private final ItemMeta scanMeta = scanSymbol.getItemMeta();
	private final OutlinePane infoPane = new OutlinePane(1, 1, 1, 2);
	private ChestGui menu;
	private int total = 0; // Total scrap cash

	public Herbert() {

	}

	// Initialize menu
	public Herbert(Player player) {

		ChestGui menu = new ChestGui(5, "Scrapper");

		menu.setOnClose(this::onInvClose);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

		// Setup background pane
		OutlinePane background = new OutlinePane(0, 0, 3, 5, Pane.Priority.LOWEST);
		background.addItem(new GuiItem(filler, event -> event.setCancelled(true)));
		background.setRepeat(true);
		menu.addPane(background);

		// Setup cash in sunflower
		cashMeta.displayName(Utils.lore("<gold><bold>CASH IN"));
		cashMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Total: <gold>0"));
				add(Utils.lore("<red><bold>THIS ACTION CANNOT BE UNDONE!"));
				add(Utils.lore("<gray>Click \"Calculate\" to update total!"));
			}
		});
		cashInSymbol.setItemMeta(cashMeta);

		// Setup scan arrow
		scanMeta.displayName(Utils.lore("<green>Calculate"));
		scanMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<grey>Compute your gains!"));
			}
		});
		scanSymbol.setItemMeta(scanMeta);
		infoPane.addItem(new GuiItem(scanSymbol, this::scanner));
		infoPane.addItem(new GuiItem(cashInSymbol, this::clickCash));
		menu.addPane(infoPane);
		this.menu = menu;
		menu.show(player);
	}

	@EventHandler
	public void onRightClickEntity(PlayerInteractEntityEvent e) {

		if (e
				    .getRightClicked()
				    .getName()
				    .contains("Herbert") && e
				    .getRightClicked()
				    .getName()
				    .contains("6")) {
			new Herbert(e.getPlayer());
		}
	}

	// Cash in all items in the scrapper
	private void clickCash(InventoryClickEvent e) {

		scanner(e); // Update values
		clearItems(); // Trash items
		refresh(); // Update Gui
		e
				.getWhoClicked()
				.sendMessage(Utils.parse(
						"<color:#E4EC5E>You earned " + String.format("%,d", total) + " \u26C1!"));
		((Player) e.getWhoClicked()).playSound(
				((Player) e.getWhoClicked()).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
				1.0f, 1.0f
		                                      );
		GoldExpListener.giveGold(((Player) e.getWhoClicked()).getPlayer(), total);
		Scoreboard.updateScoreboard((Player) e.getWhoClicked()); // Update scoreboard
	}


	// Calculate item values in the scrapper
	private void scanner(InventoryClickEvent e) {

		ArrayList< ItemStack > scraps = new ArrayList< ItemStack >(
				pullItems()); // Get scrapper items
		total = 0;
		for (ItemStack scrap : scraps) {
			total += getSellValue(scrap) * scrap.getAmount();
		}

		// Refresh cash in sunflower
		infoPane.clear();
		final int cash = total;
		cashMeta.displayName(Utils.lore("<gold><bold>CASH IN"));
		cashMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Total: <gold>" + String.format("%,d", cash)));
				add(Utils.lore("<red><bold>THIS ACTION CANNOT BE UNDONE!"));
				add(Utils.lore("<gray>Click \"Calculate\" to update total!"));
			}
		});
		cashInSymbol.setItemMeta(cashMeta);

		infoPane.addItem(new GuiItem(scanSymbol, this::scanner));
		infoPane.addItem(new GuiItem(cashInSymbol, this::clickCash));
		refresh(); // Update Gui
	}

	public static int getSellValue(ItemStack item) {
		int total = 1;
		CustomItem cItem = CustomItemUtils.INSTANCE.getCustomItem(item);
		if (cItem == null) return total;
		return cItem.getSellCost();
	}

	// Return player items still in the scrapper on close
	public void onInvClose(InventoryCloseEvent e) {

		ArrayList< ItemStack > Items = new ArrayList< ItemStack >(pullItems());
		for (ItemStack item : Items) {
			if (e
					    .getPlayer()
					    .getInventory()
					    .firstEmpty() == -1) {
				e
						.getPlayer()
						.getWorld()
						.dropItemNaturally(e
								                   .getPlayer()
								                   .getLocation(), item);
			} else {
				e
						.getPlayer()
						.getInventory()
						.addItem(item);
			}
		}
		clearItems();
	}

	// Get the coordinates of all items in the scrapper from top left to bottom right
	private ArrayList< Integer > pullItemCoords() {

		Inventory inv = menu.getInventory();
		ArrayList< Integer > scraps = new ArrayList< Integer >();
		int y = 0;
		while (y < 5) {
			int x = 3;
			while (x < 9) {
				if (inv.getItem(x + (y * 9)) != null) {
					scraps.add(x + (y * 9));
				}
				x++;
			}
			y++;
		}
		return scraps;
	}

	// Get an ArrayList of all ItemStacks in the scrapper from top left to bottom right
	private ArrayList< ItemStack > pullItems() {

		Inventory inv = menu.getInventory();
		ArrayList< ItemStack > scraps = new ArrayList< ItemStack >();
		int y = 0;
		while (y < 5) {
			int x = 3;
			while (x < 9) {
				if (inv.getItem(x + (y * 9)) != null) {
					scraps.add(inv.getItem(x + (y * 9)));
				}
				x++;
			}
			y++;
		}
		return scraps;
	}

	// Clear items in the scrapper
	private void clearItems() {

		Inventory inv = menu.getInventory();
		ArrayList< Integer > coords = new ArrayList< Integer >(pullItemCoords());
		for (Integer coord : coords) {
			inv.setItem(coord, null);
		}
	}

	// Updates the gui and reseats items
	private void refresh() {

		ArrayList< ItemStack > raws = new ArrayList< ItemStack >(pullItems());
		ArrayList< Integer > coords = new ArrayList< Integer >(pullItemCoords());

		menu.update();

		Inventory inv = menu.getInventory();
		for (int i = 0; i < coords.size(); i++) {
			inv.setItem(coords.get(i), raws.get(i));
		}
	}

}
