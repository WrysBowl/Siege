package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.GoldEXPSpawning;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class CookieClicker implements CommandExecutor {

	private ChestGui menu;
	private int cookieLevel = 1;
	private int clicks = 0;
	public static ArrayList< Player > clickCalculating = new ArrayList<>();
	public static ArrayList< Player > awaitingRemoval = new ArrayList<>();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;

		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
		CookieClicker instance = new CookieClicker();
		this.menu = instance.getMenu(player);
		this.menu.show(player);
		return true;
	}

	private ChestGui getMenu(Player player) {

		HashMap<Integer, GuiItem> cookieTypes = new HashMap<>(){{
			put(1, get20Cookie(player));
			put(2, get50Cookie(player));
			put(3, get100Cookie(player));
			put(4, get250Cookie(player));
			put(5, get500Cookie(player));
			put(6, get1000Cookie(player));
			put(7, get2000Cookie(player));
			put(8, get5000Cookie(player));
			put(9, get10000Cookie(player));
			put(10, get20000Cookie(player));
			put(11, get50000Cookie(player));
			put(12, get100000Cookie(player));
			put(13, get200000Cookie(player));
			put(14, get500000Cookie(player));
			put(15, get1000000Cookie(player));
			put(16, get2000000Cookie(player));
			put(17, get5000000Cookie(player));
			put(18, get10000000Cookie(player));
			put(19, get20000000Cookie(player));
			put(20, get50000000Cookie(player));

		}};

		//Menu
		ChestGui menu = new ChestGui(5, "Cookie Clicker");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		double calculations = this.clicks / Math.pow(50.0, (1+(this.cookieLevel/4.0)));
		int newLevel = (int) Math.floor(calculations) + 1;
		if (newLevel > this.cookieLevel) {
			this.cookieLevel = newLevel;
		}

		if(Utils.randTest(15.0)) {
			int randomX = (int) Math.floor(Math.random() * 9);
			int randomY = (int) Math.floor(Math.random() * 5);

			OutlinePane randoCookie = new OutlinePane(randomX, randomY, 1, 1);
			int randomType = (int) Math.floor(Math.random() * this.cookieLevel);
			if (randomType > cookieTypes.size()) randomType = cookieTypes.size()-1;
			randoCookie.addItem(cookieTypes.get(randomType));
			menu.addPane(randoCookie);
			player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1.0f, 1.5f);
		}

		OutlinePane cookie = new OutlinePane(4, 2, 1, 1);
		cookie.addItem(getUpdatedCookie(player));

		menu.addPane(cookie);

		this.menu = menu;
		return menu;
	}
	private GuiItem getUpdatedCookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookies"));
		final int clicks = this.clicks;
		final int cookieLevel = this.cookieLevel;

		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Clicks "+String.format("%,d", clicks)));
				add(Utils.lore("<gray>Level "+String.format("%,d", cookieLevel)));

			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			this.clicks++;
			if (clickCalculating.contains(player)) {

				//if calculation has been processed, add to rate limiter arraylist
				if (!awaitingRemoval.contains(player)) {
					awaitingRemoval.add(player);

					//allow to be shown 4 ticks later
					new BukkitRunnable() {
						@Override
						public void run() {
							clickCalculating.remove(player);
							awaitingRemoval.remove(player);
							getMenu(player).show(player);
						}
					}.runTaskLater(Core.plugin(), 20);
				}

			} else {
				clickCalculating.add(player);
			}
		});
	}
	public GuiItem get20Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +20"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +20!"));
				add(Utils.lore("<yellow>+10 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 10);
			this.clicks += 20;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get50Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +50"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +50!"));
				add(Utils.lore("<yellow>+25 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 25);
			this.clicks += 50;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get100Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +100"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +100!"));
				add(Utils.lore("<yellow>+50 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 50);
			this.clicks += 100;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get250Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +250"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +250!"));
				add(Utils.lore("<yellow>+125 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 125);
			this.clicks += 250;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get500Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +500"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +500!"));
				add(Utils.lore("<yellow>+250 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 250);
			this.clicks += 500;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get1000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +1,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +1,000!"));
				add(Utils.lore("<yellow>+500 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 500);
			this.clicks += 1000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get2000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +2,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +2,000!"));
				add(Utils.lore("<yellow>+750 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 750);
			this.clicks += 2000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get5000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +5,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +5,000!"));
				add(Utils.lore("<yellow>+1,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 1000);
			this.clicks += 5000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get10000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +10,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +10,000!"));
				add(Utils.lore("<yellow>+1,500 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 1500);
			this.clicks += 10000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get20000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +20,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +20,000!"));
				add(Utils.lore("<yellow>+2,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 2000);
			this.clicks += 20000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get50000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +50,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +50,000!"));
				add(Utils.lore("<yellow>+3,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 3000);
			this.clicks += 50000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get100000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +100,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +100,000!"));
				add(Utils.lore("<yellow>+5,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 5000);
			this.clicks += 100000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get200000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +200,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +200,000!"));
				add(Utils.lore("<yellow>+7,500 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 7500);
			this.clicks += 200000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get500000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +500,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +500,000!"));
				add(Utils.lore("<yellow>+10,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 10000);
			this.clicks += 500000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get1000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +1,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +1,000,000!"));
				add(Utils.lore("<yellow>+20,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 20000);
			this.clicks += 1000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get2000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +2,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +2,000,000!"));
				add(Utils.lore("<yellow>+30,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 30000);
			this.clicks += 2000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get5000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +5,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +5,000,000!"));
				add(Utils.lore("<yellow>+40,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 40000);
			this.clicks += 5000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get10000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +10,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +10,000,000!"));
				add(Utils.lore("<yellow>+50,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 50000);
			this.clicks += 10000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get20000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +20,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +20,000,000!"));
				add(Utils.lore("<yellow>+75,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 75000);
			this.clicks += 20000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}
	public GuiItem get50000000Cookie(Player player) {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie +50,000,000"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click for +50,000,000!"));
				add(Utils.lore("<yellow>+100,000 gold"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return new GuiItem(cookieClickerIcon, e -> {
			GoldExpListener.giveGold(player, 100000);
			this.clicks += 50000000;
			this.menu = getMenu(player);
			this.menu.show(player);
		});
	}


}
