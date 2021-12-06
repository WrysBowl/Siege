package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.listeners.BlockBreakListener;
import net.siegerpg.siege.core.listeners.DeathListener;
import net.siegerpg.siege.core.miscellaneous.BossLeaderboard;
import net.siegerpg.siege.core.miscellaneous.BossLeaderboardListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DropTable implements CommandExecutor {

	ItemStack grassBlock;
	ItemStack llama_egg;
	ItemStack endermite_egg;
	ItemStack next;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		getStartMenu(player).show(player);
		return true;
	}


	public ChestGui getStartMenu(Player player) {
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

		OutlinePane row = new OutlinePane(2, 1, 5, 1);

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

		//Creating Boss Icon
		ItemStack bossDrops = new ItemStack(Material.ENDERMITE_SPAWN_EGG);
		ItemMeta bossDropsItemMeta = bossDrops.getItemMeta();
		bossDropsItemMeta.displayName(Utils.lore("<dark_red><bold>Boss Drops"));
		bossDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>View boss drops here"));
			}
		});
		bossDrops.setItemMeta(bossDropsItemMeta);

		//Creating Next Icon
		ItemStack next = new ItemStack(Material.SPECTRAL_ARROW);
		ItemMeta nextItemMeta = next.getItemMeta();
		nextItemMeta.displayName(Utils.lore("<red><bold>NEXT >"));
		nextItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Next page"));
			}
		});
		next.setItemMeta(nextItemMeta);
		this.next = next;

		row.addItem(new GuiItem(blockDrops, inventoryClickEvent -> {
			getBlockDrops(0, player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(mobDrops, inventoryClickEvent -> {
			getMobDrops(0, player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(bossDrops, inventoryClickEvent -> {
			getBossDrops(player).show(player);
		}));

		this.grassBlock = blockDrops;
		this.llama_egg = mobDrops;
		this.endermite_egg = bossDrops;

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
		HashMap< Material, BlockDropTable > dropTable = BlockBreakListener.blockDropTableHashMap;
		int endPosition = startPosition + 27;
		if (endPosition >= dropTable.size()) endPosition = dropTable.size()-1;
		for (int i = startPosition; i < endPosition; i++) {

			Material key = (Material) dropTable.keySet().toArray()[i];

			ItemStack item = new ItemStack(key);
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
					add(Utils.lore(""));
					add(Utils.lore("<yellow>Click to View Drops"));
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(blockDropTable.getRewards()).show(player);
			}));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.size()-1) getBlockDrops(0, player).show(player);
			else getBlockDrops(newPosition, player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}
	private ChestGui createDropsGUI(Reward[] rewards) {
		//Menu
		int size = (int) Math.ceil(rewards.length / 9.0);
		if (size > 6) size = 6;
		ChestGui menu = new ChestGui(size, "Drops");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, size, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(0, 0, 9, size);

		//icons

		for(Reward reward : rewards) {
			ItemStack item = reward.getItem();
			List< Component > lore = item.lore();
			if (lore == null) lore = new ArrayList<>();
			lore.add(Utils.lore("<gray>Chance <yellow>"+reward.getChance()+"%"));
			item.lore(lore);

			row.addItem(new GuiItem(item));
		}

		menu.addPane(row);

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
		HashMap< String, MobDropTable > dropTable = DeathListener.mobDropTableHashMap;
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
					add(Utils.lore(""));
					add(Utils.lore("<yellow>Click to View Drops"));
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(mobDropTable.getRewards()).show(player);
			}));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.size()-1) getMobDrops(0, player).show(player);
			else getMobDrops(newPosition, player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}

	private ChestGui getBossDrops(Player player) {
		//Menu
		ChestGui menu = new ChestGui(4, "Boss Drops");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 4, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 2);

		//icons
		HashMap< String, MobDropTable > dropTable = new BossLeaderboardListener().getDungeonBossDropTableHashMap();
		for (int i = 0; i < dropTable.size(); i++) {

			String key = (String) dropTable.keySet().toArray()[i];

			ItemStack item = new ItemStack(Material.ENDERMITE_SPAWN_EGG);
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
					add(Utils.lore(""));
					add(Utils.lore("<yellow>Click to View Drops"));
				}
			});
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(mobDropTable.getRewards()).show(player);
			}));
		}

		menu.addPane(row);
		return menu;
	}
}
