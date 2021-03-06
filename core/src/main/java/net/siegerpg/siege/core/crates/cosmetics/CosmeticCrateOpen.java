package net.siegerpg.siege.core.crates.cosmetics;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CosmeticCrateOpen implements Listener {

	public static ArrayList< Location > currentlyUsedChests = new ArrayList<>();

	@EventHandler
	public void onCrateOpen(PlayerInteractEvent e) {

		//Make sure clicked block is trapped chest in the Hub
		Block targetedBlock = e.getClickedBlock();
		if (targetedBlock == null) return;
		if (!targetedBlock.getLocation().getWorld().getName().equals("Hilly_Woods")) return;
		if (!locationCheck(targetedBlock.getLocation())) return;

		Player player = e.getPlayer();
		e.setCancelled(true);
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}
		if (currentlyUsedChests.contains(targetedBlock.getLocation())) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}

		//Make sure item is a cosmetic key
		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player
				                                                         .getInventory()
				                                                         .getItemInMainHand());
		if (item == null) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}
		if (!(item instanceof CustomKey)) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}
		if (!keyCheck(item)) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}

		//Add chest location to arraylist to prevent further use
		currentlyUsedChests.add(targetedBlock.getLocation());

		//Pick item reward to give to player
		CosmeticDropTable dropTable = getItem(item);
		if (dropTable == null) {
			new CosmeticCrateOpen().getStartMenu(player).show(player);
			return;
		}
		CustomCosmetic reward = dropTable.pickItem();

		//Play item getting animation
		//Plays item win effect
		//Gives item to player
		Bukkit.broadcast(Utils.parse("<green>" + player.getName() + " is opening a crate!"));

		new CosmeticAnimation().openCrate(
				targetedBlock
						.getLocation()
						.toCenterLocation(),
				dropTable.dropTable.keySet(),
				reward, player
		                                 );
		player
				.getInventory()
				.removeItem(item
						            .getItem()
						            .asOne());

	}

	private boolean locationCheck(Location location) {
		double x = -218.0;
		double y = 62.0;
		double z = -162.0;
		Location strippedLocation = location.toBlockLocation();
		if (strippedLocation.getZ() != z) return false;
		if (strippedLocation.getY() != y) return false;
		if (strippedLocation.getX() != x) return false;
		return true;
	}

	private boolean keyCheck(CustomItem item) {

		for (Map.Entry< CustomKey, CosmeticDropTable > entry : CosmeticCrate.crates.entrySet()) {
			CustomKey key = entry.getKey();
			if (item.getClass() == key.getClass()) return true;
		}
		return false;
	}

	private CosmeticDropTable getItem(CustomItem item) {

		for (Map.Entry< CustomKey, CosmeticDropTable > entry : CosmeticCrate.crates.entrySet()) {
			CustomKey key = entry.getKey();
			if (item.getClass() == key.getClass()) return entry.getValue();
		}
		return null;
	}

	private ChestGui getStartMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(4, "Cosmetic Keys");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 4, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));

		background.setRepeat(true);

		menu.addPane(background);

		OutlinePane topRow = new OutlinePane(3, 1, 3, 1);
		OutlinePane bottomRow = new OutlinePane(2, 2, 5, 1);

		//icons
		topRow.addItem(new GuiItem(new NormalKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new NormalKey(0)).show(player);
		}));
		topRow.addItem(new GuiItem(new SuperiorKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new SuperiorKey(0)).show(player);
		}));
		topRow.addItem(new GuiItem(new SpiritKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new SpiritKey(0)).show(player);
		}));
		menu.addPane(topRow);

		//icons
		bottomRow.addItem(new GuiItem(new CommonKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new CommonKey(0)).show(player);
		}));
		bottomRow.addItem(new GuiItem(new UncommonKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new UncommonKey(0)).show(player);
		}));
		bottomRow.addItem(new GuiItem(new RareKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new RareKey(0)).show(player);
		}));
		bottomRow.addItem(new GuiItem(new EpicKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new EpicKey(0)).show(player);
		}));
		bottomRow.addItem(new GuiItem(new LegendaryKey(0).getUpdatedItem(false), inventoryClickEvent -> {
			getGUI(new LegendaryKey(0)).show(player);
		}));
		menu.addPane(bottomRow);

		return menu;
	}

	private ChestGui getGUI(CustomItem customItem) {
		//Menu
		ChestGui menu = new ChestGui(6, "Cosmetic Crate Chance");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 0, 7, 6);

		//icons
		HashMap< CustomCosmetic, Integer > dropTable = getItem(customItem).dropTable;
		double totalWeight = dropTable.values().stream().mapToInt(Integer::intValue).sum();
		for (Map.Entry<CustomCosmetic, Integer> entry : dropTable.entrySet()) {
			ItemStack item = entry.getKey().getUpdatedItem(false);
			double chance = Utils.round(entry.getValue()*100/totalWeight, 2);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Chance <yellow>"+chance+"%"));
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item));
		}
		menu.addPane(row);
		return menu;
	}

}
