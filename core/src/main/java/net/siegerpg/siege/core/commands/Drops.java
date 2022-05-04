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
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.listeners.BlockBreakListener;
import net.siegerpg.siege.core.listeners.DeathListener;
import net.siegerpg.siege.core.miscellaneous.BossLeaderboardListener;
import net.siegerpg.siege.core.miscellaneous.MobHeadType;
import net.siegerpg.siege.core.miscellaneous.MobStats;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
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
			Player player = Bukkit.getPlayer(args[1]);
			if (player == null) return false;
			if (!findMenu(player, args[0])) {
				player.sendMessage(Utils.lore("<red>Invalid drop!"));
				return false;
			}
			return true;
		}
		if (args.length < 1) {
			Player player = (Player) sender;
			getStartMenu(player).show(player);
		}
		return true;
	}

	private boolean findMenu(Player player, String name) {
		try {
			HashMap< Material, BlockDropTable > dropTable = BlockBreakListener.blockDropTableHashMap;
			Material key = Material.getMaterial(name);
			createDropsGUI(dropTable.get(key), 0, player).show(player);
			return true;
		} catch (Exception ignored) {}

		try {
			HashMap< String, MobDropTable > dropTable = DeathListener.mobDropTableHashMap;
			createDropsGUI(dropTable.get(name), 0, player).show(player);
			return true;
		} catch (Exception ignored) {}

		try {
			HashMap< String, MobDropTable > dropTable = BossLeaderboardListener.Companion.getDungeonBossDropTableHashMap();
			createDropsGUI(dropTable.get(name), 0, player).show(player);
			return true;
		} catch (Exception ignored) {}
		return false;
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

		this.next = getIconNext();
		this.grassBlock = getIconBlockDrops();
		this.llama_egg = getIconMobDrops();
		this.endermite_egg = getIconBossDrops();

		row.addItem(new GuiItem(this.grassBlock, inventoryClickEvent -> {
			getBlockDrops(0, player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(this.llama_egg, inventoryClickEvent -> {
			getMobDrops(0, player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(this.endermite_egg, inventoryClickEvent -> {
			getBossDrops(player).show(player);
		}));



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
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);
		OutlinePane menuButton = new OutlinePane(0, 5, 1, 1);

		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.getRewards().length-1) createDropsGUI(dropTable, 0, player).show(player);
			else createDropsGUI(dropTable, newPosition, player).show(player);
		}));

		menuButton.addItem(new GuiItem(getIconBack(), inventoryClickEvent -> {
			getStartMenu(player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);
		menu.addPane(menuButton);

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
			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+item.getI18NDisplayName()));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				String cmd = "drops "+key.name()+" "+player.getName();
				Bukkit.dispatchCommand(console, cmd);
			}));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);
		OutlinePane menuButton = new OutlinePane(0, 5, 1, 1);

		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.size()-1) getBlockDrops(0, player).show(player);
			else getBlockDrops(newPosition, player).show(player);
		}));
		menuButton.addItem(new GuiItem(getIconBack(), inventoryClickEvent -> {
			getStartMenu(player).show(player);
		}));

		menu.addPane(row);
		menu.addPane(nextButton);
		menu.addPane(menuButton);

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
			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+key));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				String cmd = "drops "+key+" "+player.getName();
				Bukkit.dispatchCommand(console, cmd);
			}));
		}

		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);
		OutlinePane menuButton = new OutlinePane(0, 5, 1, 1);

		menuButton.addItem(new GuiItem(getIconBack(), inventoryClickEvent -> {
			getStartMenu(player).show(player);
		}));
		final int newPosition = endPosition;
		nextButton.addItem(new GuiItem(this.next, inventoryClickEvent -> {
			if (newPosition >= dropTable.size()-1) getMobDrops(0, player).show(player);
			else getMobDrops(newPosition, player).show(player);
		}));

		menu.addPane(menuButton);
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
		HashMap< String, MobDropTable > dropTable = BossLeaderboardListener.Companion.getDungeonBossDropTableHashMap();
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

			ItemMeta iconMeta = item.getItemMeta();
			iconMeta.displayName(Utils.lore("<green>"+key));
			item.setItemMeta(iconMeta);

			row.addItem(new GuiItem(item, e -> {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				String cmd = "drops "+key+" "+player.getName();
				Bukkit.dispatchCommand(console, cmd);
			}));
		}

		OutlinePane menuButton = new OutlinePane(0, 3, 1, 1);

		menuButton.addItem(new GuiItem(getIconBack(), inventoryClickEvent -> {
			getStartMenu(player).show(player);
		}));

		menu.addPane(menuButton);
		menu.addPane(row);
		return menu;
	}











	/*
	ICONS
	 */
	private static ItemStack getIconBlockDrops() {
		ItemStack icon = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#A4CE51><bold><underlined>Block Drops"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#A4CE51><underlined>                  "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconMobDrops() {
		ItemStack icon = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#E7234A><bold><underlined>Mob Drops"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#E7234A><underlined>               "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconBossDrops() {
		ItemStack icon = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#A22525><bold><underlined>Boss Drops"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View drops"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#A22525><underlined>                 "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconNext() {
		//Creating Next Icon
		ItemStack icon = new ItemStack(Material.SKELETON_SKULL);
		SkullMeta iconMeta = (SkullMeta) icon.getItemMeta();
		iconMeta.setOwner("MHF_ArrowRight");
		iconMeta.displayName(Utils.lore("<green>Next"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Next page"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconBack() {
		//Creating Next Icon
		ItemStack icon = new ItemStack(Material.NETHER_STAR);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<gold>Menu"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Back to menu"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
}
