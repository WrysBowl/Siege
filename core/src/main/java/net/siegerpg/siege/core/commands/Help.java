package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.kyori.adventure.text.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Help implements CommandExecutor {

	private ChestGui menu;
	private Player player;
	private int cmdPageNumber = 1;
	private static int maxCmdPageNumber = 2;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player player)) {
			return false;
		}

		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.75f, 1.0f);
		Help instance = new Help();
		this.player = player;
		this.menu = instance.getMenu();
		this.menu.show(player);

		return false;
	}

	private ChestGui getMenu() {
		//Menu
		ChestGui help = new ChestGui(5, "Help");
		help.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		help.addPane(background);

		//Tutorial
		OutlinePane tutorial = new OutlinePane(0, 0, 1, 2);
		tutorial.addItem(new GuiItem(getTutorialIcon(), e -> getObjectivesMenu().show(player)));

		//Commands - figure out how to change this icon on click
		OutlinePane command = new OutlinePane(0, 0, 3, 2);
		command.addItem(new GuiItem(getCommandsIcon(), e -> {
			this.cmdPageNumber += 1;
			this.menu.show(player);
		}));

		//Menu
		OutlinePane navigator = new OutlinePane(0, 0, 6, 2);
		navigator.addItem(new GuiItem(getMenuIcon(), e -> player.performCommand("menu")));

		help.addPane(navigator);

		return help;
	}

	//make a command icon that accepts a click action

	private static ItemStack getTutorialIcon() {
		//Creating Icon
		ItemStack icon = new ItemStack(Material.COMPASS);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#4bc471>Tutorial"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to Access"));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ItemStack getCommandsIcon() {
		//Creating Icon
		ItemStack icon = new ItemStack(Material.COMMAND_BLOCK);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#34cf9b>Commands"));
		if (this.cmdPageNumber > maxCmdPageNumber) {
			this.cmdPageNumber = 1;
		}
		/*
		/level
		/leaderboard
		/blb
		 */
		if (this.cmdPageNumber == 1) {
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore(""));
					add(Utils.lore("<color:#7da34e><bold>Teleportation"));
					add(Utils.lore("<color:#9bd15a>/warp crates"));
					add(Utils.lore("<gray> TP to crates"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#9bd15a>/spawn"));
					add(Utils.lore("<gray> TP to spawn"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#9bd15a>/tutorial"));
					add(Utils.lore("<gray> TP to tutorial"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#9bd15a>/traveler"));
					add(Utils.lore("<gray> TP to areas"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#7da34e>\u27a4 Next Page"));

				}
			});
		} else if (this.cmdPageNumber == 2) {
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore(""));
					add(Utils.lore("<color:#6fbfa4><bold>Utilities"));
					add(Utils.lore("<color:#5bd9af>/menu"));
					add(Utils.lore("<gray> Hub for utilities"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#5bd9af>/drops"));
					add(Utils.lore("<gray> See all drop tables"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#5bd9af>/scrapper"));
					add(Utils.lore("<gray> Ranked access only"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#5bd9af>/pay"));
					add(Utils.lore("<gray> Pay people gold"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#5bd9af>/resourcepack"));
					add(Utils.lore("<gray> Apply the resource pack"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#6fbfa4>\u27a4 Next Page"));

				}
			});
		} else {
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore(""));
					add(Utils.lore("<color:#4670a3><bold>Information"));
					add(Utils.lore("<color:#729fd6>/discord"));
					add(Utils.lore("<gray> Join the discord!"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#729fd6>/webstore"));
					add(Utils.lore("<gray> View store items"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#729fd6>/playtime"));
					add(Utils.lore("<gray> What's your time?"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#729fd6>/blb"));
					add(Utils.lore("<gray> Boss leaderboards"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#729fd6>/leaderboard"));
					add(Utils.lore("<gray> Level leaderboard"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#729fd6>/level"));
					add(Utils.lore("<gray> Level statistics"));
					add(Utils.lore(""));
					add(Utils.lore("<color:#4670a3>\u27a4 Start Page"));

				}
			});
		}

		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private static ItemStack getMenuIcon() {
		//Creating Icon
		ItemStack icon = new ItemStack(Material.NETHER_STAR);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#d1af4f>Menu"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to Access"));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	private ChestGui getObjectivesMenu() {
		//Menu
		ChestGui help = new ChestGui(6, "Objectives");
		help.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		help.addPane(background);

		//Kill mobs icon
		//get armor icons
		//kill boss icons
		//get weapons icon



		return help;
	}

}