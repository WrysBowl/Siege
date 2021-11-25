package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.listeners.BlockBreakListener;
import net.siegerpg.siege.core.listeners.DeathListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DropTable implements CommandExecutor {

	ItemStack grassBlock;
	ItemStack llama_egg;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		getStartMenu(player).show(player);
		return true;
	}


	private ChestGui getStartMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(3, "Select Drop Type");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));

		background.setRepeat(true);

		menu.addPane(background);

		OutlinePane row = new OutlinePane(3, 1, 3, 1);

		//icons

		//Creating Blocks Icon
		ItemStack blockDrops = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta blockDropsItemMeta = blockDrops.getItemMeta();
		blockDropsItemMeta.displayName(Utils.lore("<green><bold>Block Drops"));
		blockDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>View block drops here"));
			}
		});
		blockDrops.setItemMeta(blockDropsItemMeta);

		//Creating Mob Icon
		ItemStack mobDrops = new ItemStack(Material.LLAMA_SPAWN_EGG);
		ItemMeta mobDropsItemMeta = mobDrops.getItemMeta();
		mobDropsItemMeta.displayName(Utils.lore("<red><bold>Mob Drops"));
		mobDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>View mob drops here"));
			}
		});
		mobDrops.setItemMeta(mobDropsItemMeta);

		row.addItem(new GuiItem(blockDrops, inventoryClickEvent -> {
			getBlockDrops(0, player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(mobDrops, inventoryClickEvent -> {
			getMobDrops(0, player).show(player);
		}));


		this.grassBlock = blockDrops;
		this.llama_egg = mobDrops;

		menu.addPane(row);
		return menu;
	}

	private ChestGui getBlockDrops(int startPosition, Player player) {
		//Menu
		ChestGui menu = new ChestGui(6, "Block Drops");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 4);

		//icons
		LinkedHashMap< Material, BlockDropTable > dropTable = new LinkedHashMap<>(BlockBreakListener.blockDropTableHashMap);
		int endPosition = startPosition + 27;
		if (endPosition >= dropTable.size()) endPosition = dropTable.size()-1;
		for (int i = startPosition; i < endPosition; i++) {

			Material key = (Material) dropTable.keySet().toArray()[i];

			ItemStack item = new ItemStack((Material) dropTable.keySet().toArray()[i]);
			BlockDropTable blockDropTable = dropTable.get(key);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+item.getI18NDisplayName()));
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<yellow>Gold "+
					               String.format("%,d", blockDropTable.getGoldMin())+
					               " <gray>- <yellow>"+
					               String.format("%,d", blockDropTable.getGoldMax())));
					add(Utils.lore("<light_purple>EXP "+
					               String.format("%,d", blockDropTable.getExpMin())+
					               " <gray>- <light_purple>"+
					               String.format("%,d", blockDropTable.getExpMax())));
					for(Reward reward : blockDropTable.getRewards()) {
						add(Utils.lore("<gray>" + reward.getItem().getItemMeta().getDisplayName() + " <yellow>" + reward.getChance() + "%"));
					}
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		final int newPosition = endPosition*2;
		nextButton.addItem(new GuiItem(this.grassBlock, inventoryClickEvent -> {
			if (newPosition < dropTable.size()) getBlockDrops(newPosition, player).show(player);
			else getBlockDrops(0, player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}

	private ChestGui getMobDrops(int startPosition, Player player) {
		//Menu
		ChestGui menu = new ChestGui(6, "Mob Drops");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 4);

		//icons
		LinkedHashMap< String, MobDropTable > dropTable = new LinkedHashMap<>(DeathListener.mobDropTableHashMap);
		int endPosition = startPosition + 27;
		if (endPosition >= dropTable.size()) endPosition = dropTable.size()-1;
		for (int i = startPosition; i < endPosition; i++) {

			String key = (String) dropTable.keySet().toArray()[i];

			ItemStack item = new ItemStack(Material.LLAMA_SPAWN_EGG);
			MobDropTable mobDropTable = dropTable.get(key);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+key));
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<yellow>Gold "+
					               String.format("%,d", mobDropTable.getGoldMin())+
					               " <gray>- <yellow>"+
					               String.format("%,d", mobDropTable.getGoldMax())));
					add(Utils.lore("<light_purple>EXP "+
					               String.format("%,d", mobDropTable.getExpMin())+
					               " <gray>- <light_purple>"+
					               String.format("%,d", mobDropTable.getExpMax())));
					for(Reward reward : mobDropTable.getRewards()) {
						add(Utils.lore("<gray>" + reward.getItem().getItemMeta().getDisplayName() + " <yellow>" + reward.getChance() + "%"));
					}
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		final int newPosition = endPosition*2;
		nextButton.addItem(new GuiItem(this.llama_egg, inventoryClickEvent -> {
			if (newPosition < dropTable.size()) getMobDrops(newPosition, player).show(player);
			else getMobDrops(0, player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}

}
