package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.DropTable;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.listeners.BlockBreakListener;
import net.siegerpg.siege.core.listeners.DeathListener;
import net.siegerpg.siege.core.miscellaneous.BossLeaderboardListener;
import net.siegerpg.siege.core.miscellaneous.MobHeadType;
import net.siegerpg.siege.core.miscellaneous.MobStats;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.*;

public class Drops implements CommandExecutor {

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
		blockDropsItemMeta.displayName(Utils.lore("<color:#A4CE51><bold><underlined>Block Drops"));
		blockDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#A4CE51><underlined>                  "));
			}
		});
		blockDrops.setItemMeta(blockDropsItemMeta);

		//Creating Mob Icon
		ItemStack mobDrops = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta mobDropsItemMeta = mobDrops.getItemMeta();
		mobDropsItemMeta.displayName(Utils.lore("<color:#E7234A><bold><underlined>Mob Drops"));
		mobDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#E7234A><underlined>               "));
			}
		});
		mobDrops.setItemMeta(mobDropsItemMeta);

		//Creating Boss Icon
		ItemStack bossDrops = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta bossDropsItemMeta = bossDrops.getItemMeta();
		bossDropsItemMeta.displayName(Utils.lore("<color:#A22525><bold><underlined>Boss Drops"));
		bossDropsItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#A22525><underlined>                 "));
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
	private ChestGui createDropsGUI(DropTable dropTable, int startPosition, Player player) {

		Reward[] rewards = dropTable.getRewards();
		int goldMin = dropTable.getGoldMin();
		int goldMax = dropTable.getGoldMax();
		int expMin = dropTable.getExpMin();
		int expMax = dropTable.getExpMax();

		ChestGui menu = new ChestGui(6, "Drops");

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

		if (startPosition == 0) {
			//Gold Display
			ItemStack goldDisplay = new ItemStack(Material.SUNFLOWER);
			ItemMeta goldDisplayMeta = goldDisplay.getItemMeta();
			goldDisplayMeta.displayName(Utils.lore("<yellow><bold>GOLD   "));
			goldDisplayMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<dark_gray><underlined>           "));
					add(Utils.lore(""));
					add(Utils.lore("<yellow>"+String.format("%,d", goldMin)+
					               " <gray>- <yellow>"+
					               String.format("%,d", goldMax)+
					               " \u26C1"));
					add(Utils.lore("<dark_gray><underlined>           "));
				}
			});
			goldDisplay.setItemMeta(goldDisplayMeta);
			row.addItem(new GuiItem(goldDisplay));

			ItemStack expDisplay = new ItemStack(Material.EXPERIENCE_BOTTLE);
			ItemMeta expDisplayMeta = expDisplay.getItemMeta();
			expDisplayMeta.displayName(Utils.lore("<light_purple><bold>EXP    "));
			expDisplayMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<dark_gray><underlined>           "));
					add(Utils.lore(""));
					add(Utils.lore("<light_purple>"+String.format("%,d", expMin)+
					               " <gray>- <light_purple>"+
					               String.format("%,d", expMax)+
					               " \u2742"));
					add(Utils.lore("<dark_gray><underlined>           "));
				}
			});
			expDisplay.setItemMeta(expDisplayMeta);
			row.addItem(new GuiItem(expDisplay));
		}

		int endPosition = startPosition + 27;
		if (startPosition == 0) endPosition -= 2;
		if (endPosition >= rewards.length) endPosition = rewards.length-1;
		for (int i = startPosition; i < endPosition; i++) {

			ItemStack item = rewards[i].getItem().clone();
			List< Component > lore = item.lore();

			lore.add(Utils.lore("<dark_gray><underlined>            "));
			lore.add(Utils.lore(""));
			lore.add(Utils.lore("<color:#BFD57C><bold>\u2618 <reset><color:#BFD57C>"+rewards[i].getChance()+" %"));
			lore.add(Utils.lore("<dark_gray><underlined>            "));
			item.lore(lore);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(dropTable, 0, player).show(player);
			}));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.getRewards().length-1) createDropsGUI(dropTable, 0, player).show(player);
			else createDropsGUI(dropTable, newPosition, player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);

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
		Object[] array = dropTable.keySet().toArray();

		for (int i = startPosition; i < endPosition; i++) {

			Material key = (Material) array[i];

			ItemStack item = new ItemStack(key);
			BlockDropTable blockDropTable = dropTable.get(key);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+item.getI18NDisplayName()));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(blockDropTable, 0, player).show(player);
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
		Object[] array = dropTable.keySet().toArray();
		for (int i = startPosition; i < endPosition; i++) {

			String key = (String) array[i];
			MythicMob mob = MythicMobs.inst().getAPIHelper().getMythicMob(key);

			ItemStack item = new ItemStack(Material.LLAMA_SPAWN_EGG);
			try {
				EntityType type = EntityType.valueOf(mob.getEntityType().toUpperCase());

				for (MobHeadType mobType : MobHeadType.values()) {
					if (!mobType.getType().equals(type)) continue;
					item = Utils.getMobHead(mobType);
					break;
				}

			} catch (Exception ignored) {}
			MobDropTable mobDropTable = dropTable.get(key);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+key));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(mobDropTable, 0, player).show(player);
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
		Object[] array = dropTable.keySet().toArray();

		for (int i = 0; i < dropTable.size(); i++) {

			String key = (String) array[i];
			MythicMob mob = MythicMobs.inst().getAPIHelper().getMythicMob(key);

			ItemStack item = new ItemStack(Material.ENDERMITE_SPAWN_EGG);
			try {
				EntityType type = EntityType.valueOf(mob.getEntityType().toUpperCase());

				for (MobHeadType mobType : MobHeadType.values()) {
					if (!mobType.getType().equals(type)) continue;
					item = Utils.getMobHead(mobType);
					break;
				}

			} catch (Exception ignored) {}
			MobDropTable mobDropTable = dropTable.get(key);

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+key));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				createDropsGUI(mobDropTable, 0, player).show(player);
			}));
		}

		menu.addPane(row);
		return menu;
	}
}
