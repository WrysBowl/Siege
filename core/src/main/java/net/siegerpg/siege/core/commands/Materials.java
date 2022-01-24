package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Materials implements CommandExecutor {


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		getMenu(player).show(player);
		return true;
	}

	public ChestGui getMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(5, "Materials Crafting");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 5);

		//icons
		row.addItem(getBoneIcon(player));
		row.addItem(getFeatherIcon(player));
		row.addItem(getLeatherIcon(player));
		row.addItem(getMagmaIcon(player));
		row.addItem(getPebbleIcon(player));
		row.addItem(getPlantMatterIcon(player));
		row.addItem(getSeedIcon(player));
		row.addItem(getSlimeIcon(player));
		row.addItem(getStickIcon(player));
		row.addItem(getVineIcon(player));
		row.addItem(getWheatIcon(player));
		row.addItem(getWoolIcon(player));
		row.addItem(getChainIcon(player));
		row.addItem(getCoalIcon(player));
		row.addItem(getMetalScrapIcon(player));
		row.addItem(getRefinedMetalIcon(player));
		row.addItem(getTitaniumIcon(player));

		menu.addPane(row);

		return menu;
	}

	private static GuiItem getBoneIcon(Player player) {
		ItemStack icon = Bone.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Bone"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops bone " + player.getName());
		});
	}

	private static GuiItem getFeatherIcon(Player player) {
		ItemStack icon = Feather.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Feather"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops feather " + player.getName());
		});
	}

	private static GuiItem getLeatherIcon(Player player) {
		ItemStack icon = Leather.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Leather"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops leather " + player.getName());
		});
	}

	private static GuiItem getMagmaIcon(Player player) {
		ItemStack icon = Magma.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Magma"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops magma " + player.getName());
		});
	}

	private static GuiItem getPebbleIcon(Player player) {
		ItemStack icon = Pebble.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Pebble"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops pebble " + player.getName());
		});
	}

	private static GuiItem getPlantMatterIcon(Player player) {
		ItemStack icon = PlantMatter.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Plant Matter"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops plantMatter " + player.getName());
		});
	}

	private static GuiItem getSeedIcon(Player player) {
		ItemStack icon = Seed.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Seed"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops seed " + player.getName());
		});
	}

	private static GuiItem getSlimeIcon(Player player) {
		ItemStack icon = Slime.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Slime"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops slime " + player.getName());
		});
	}

	private static GuiItem getStickIcon(Player player) {
		ItemStack icon = Stick.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Stick"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops stick " + player.getName());
		});
	}

	private static GuiItem getVineIcon(Player player) {
		ItemStack icon = Vine.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Vine"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops vine " + player.getName());
		});
	}

	private static GuiItem getWheatIcon(Player player) {
		ItemStack icon = Wheat.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Wheat"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops wheat " + player.getName());
		});
	}

	private static GuiItem getWoolIcon(Player player) {
		ItemStack icon = Wool.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Wool"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops wool " + player.getName());
		});
	}
	private static GuiItem getChainIcon(Player player) {
		ItemStack icon = Chain.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Chain"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops chain " + player.getName());
		});
	}

	private static GuiItem getCoalIcon(Player player) {
		ItemStack icon = Coal.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Coal"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops coal " + player.getName());
		});
	}

	private static GuiItem getMetalScrapIcon(Player player) {
		ItemStack icon = MetalScrap.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Metal Scrap"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops metalScrap " + player.getName());
		});
	}

	private static GuiItem getRefinedMetalIcon(Player player) {
		ItemStack icon = RefinedMetal.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Refined Metal"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops refinedMetal " + player.getName());
		});
	}
	private static GuiItem getTitaniumIcon(Player player) {
		ItemStack icon = Titanium.Companion.tier(0).getItem();
		ItemMeta iconItemMeta = icon.getItemMeta();
		iconItemMeta.displayName(Utils.lore("<color:#D4DC7F>Titanium"));
		iconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<dark_gray><underlined>              "));
				add(Utils.lore(""));
				add(Utils.lore("<gray>View recipe"));
				add(Utils.lore("<dark_gray><underlined>              "));
			}
		});

		icon.setItemMeta(iconItemMeta);
		return new GuiItem(icon, e -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "shops titanium " + player.getName());
		});
	}
}
