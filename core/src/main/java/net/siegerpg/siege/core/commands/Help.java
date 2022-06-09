package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Help implements CommandExecutor {

	private ChestGui menu;
	private Player player;

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
		ChestGui help = new ChestGui(6, "Help");
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
		OutlinePane tutorial = new OutlinePane(0, 0, 1, 1);
		tutorial.addItem(new GuiItem(getTutorialIcon(), e -> player.performCommand("menu")));

		//Commands
		OutlinePane command = new OutlinePane(0, 0, 1, 1);
		command.addItem(new GuiItem(getCommandsIcon(), e -> player.performCommand("menu")));

		//Menu
		OutlinePane navigator = new OutlinePane(0, 0, 1, 1);
		navigator.addItem(new GuiItem(getMenuIcon(), e -> player.performCommand("menu")));

		help.addPane(navigator);

		return help;
	}

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

	private static ItemStack getCommandsIcon() {
		//Creating Icon
		ItemStack icon = new ItemStack(Material.COMMAND_BLOCK);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#de6a3c>Commands"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to Access"));
			}
		});
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

}