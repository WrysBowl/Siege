package net.siegerpg.siege.core.miscellaneous;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	@SuppressWarnings( "unused" )
	static public String tacc(String str) {
		return ChatColor.translateAlternateColorCodes('&', str);
	}

	static public String[] tacc(String[] strs) {

		String[] translatedStrings = new String[strs.length];
		for (int i = 0; i < strs.length; i++) {
			translatedStrings[i] = tacc(strs[i]);
		}
		return translatedStrings;
	}

	@SuppressWarnings( "unused" )
	static public String strip(String str) {

		return ChatColor.stripColor(str);
	}

	@SuppressWarnings( "unused" )
	static public Component parse(String[] str) {

		return parse(String.join("\n", str));
	}

	static public Component parse(String str) {

		return MiniMessage
				.get()
				.parse(str);
	}

	static public Component lore(String[] str) {

		return parse(str).decoration(TextDecoration.ITALIC, false);
	}

	@SuppressWarnings( "unused" )
	static public Component lore(String str) {

		return parse(str).decoration(TextDecoration.ITALIC, false);
	}

	@SuppressWarnings( "unused" )
	static public NamespacedKey namespacedKey(String str) {

		return new NamespacedKey(Core.plugin(), str);
	}

	public static boolean randTest(Double num) {

		double randNumber = Math.random() * 100;
		return randNumber <= num;
	}

	public static org.bukkit.util.Vector getDifferentialVector(Location from, Location to) {

		return new Vector(
				(to.getX() - from.getX()), to.getY() - from.getY(), (to.getZ() - from.getZ()));
	}

	public static double round(double value, int precision) {

		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

	public static String secondsToHHMMSS(long seconds) {

		Duration duration = Duration.ofSeconds(seconds);
		var HH = duration.toHours();
		int MM = duration.toMinutesPart();
		int SS = duration.toSecondsPart();
		return String.format("%02d:%02d:%02d", HH, MM, SS);
	}

	public static Integer getHighestPV(Player player) {

		int highestPV = 54;
		while (!player.hasPermission("cosmicvaults.amount." + highestPV)) {
			highestPV -= 1;
			if (highestPV < 1) return 0;
		}
		return highestPV;
	}

	public static int randRarity() {
		//((random number between 1 and 100)*(1/random number between 1 and 5))
		double rand1 = ((Math.random() * 75) + 1);
		double rand2 = (((Math.random() * 75) + 1));
		return (int) ((Math.sqrt(rand1 * rand2)) + 24);
	}

	public static ItemStack setLoreCost(CustomItem item) {

		Integer levelReq = item.getLevelRequirement();
		if (levelReq == null) levelReq = 0;

		ItemStack updatedItem = item.getUpdatedItem(false);
		int itemCost = item.getQuality() * levelReq * 2;


		List< Component > lore = updatedItem.lore();
		if (lore == null) lore = new ArrayList<>();
		lore.add(Utils.parse("<yellow>Cost " + itemCost));

		ItemMeta meta = updatedItem.getItemMeta();
		meta.lore(lore);
		updatedItem.setItemMeta(meta);
		return updatedItem;
	}

	public static Integer getCost(ItemStack item) {

		String cost = item
				.getLore()
				.get(item
						     .getLore()
						     .size() - 1);
		cost = cost.replace(Utils.tacc("&eCost "), "");
		return Integer.valueOf(cost);
	}

	public static ItemStack removeLastLore(ItemStack item) {

		List< String > lore = new ArrayList<>(item
				                                      .getLore()
				                                      .size() - 1);
		lore.addAll(item.getLore());
		lore.remove(item
				            .getLore()
				            .size() - 1);

		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack addLore(ItemStack item, Component... lore) {

		List< Component > newLore = item.lore();
		if (newLore == null) {
			newLore = new ArrayList<>(lore.length);
		}
		newLore.add(lore(" "));
		newLore.addAll(Arrays.asList(lore));
		item.lore(newLore);
		return item;
	}

	public static ItemStack setCost(ItemStack item, Integer cost) {

		List< String > lore;
		if (item.getLore() == null) {
			lore = new ArrayList<>(1);
		} else {
			lore = new ArrayList<>(item
					                       .getLore()
					                       .size() + 1);
			lore.addAll(item.getLore());
		}
		lore.add(Utils.tacc("&eCost " + cost));

		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static boolean giveItem(Player player, ItemStack item) {

		final boolean fullInv = ((Player) player)
				                        .getInventory()
				                        .firstEmpty() == -1;
		final boolean fullEnderChest = ((Player) player)
				                               .getEnderChest()
				                               .firstEmpty() == -1;
		if (!fullInv) {
			((Player) player)
					.getInventory()
					.addItem(item);
		} else if (!fullEnderChest) {
			((Player) player)
					.getEnderChest()
					.addItem(item);
			player.sendMessage(Utils.lore("<red>Your inventory was full so the item has been placed in your Ender Chest!"));
		} else {
			player.sendMessage(Utils.lore("<red>Your Ender Chest is full so the item was dropped on the ground!"));
			player.getWorld().dropItemNaturally(player.getLocation(), item);
			return false;
		}
		return true;
	}

	public static boolean isValidHexCode(String str) {
		// Regex to check valid hexadecimal color code.
		String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the string is empty
		// return false
		if (str == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given string
		// and regular expression.
		Matcher m = p.matcher(str);

		// Return if the string
		// matched the ReGex
		return m.matches();
	}

	public static org.bukkit.Color hex2Rgb(String colorStr) {

		return org.bukkit.Color.fromRGB(
				Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16),
				Integer.valueOf(colorStr.substring(5, 7), 16)
		                               );
	}

	/**
	 * Divides the string into an array by a max character count
	 * @param str
	 * @param max
	 * @return
	 */
	public static String[] getTextArray(List<String> str, int max) {
		String[] splitString = String.join(" ", str).split(" ");

		int characterCounter = 0;
		ArrayList<String> newArray = new ArrayList<>(){{add("");}};
		int currentRow = 0;

		for (String string : splitString) {
			String currentString = newArray.get(currentRow);
			String newString = currentString + string + " ";
			characterCounter = newString.length();

			if (characterCounter >= max) {
				newArray.add(string + " ");
				characterCounter = 0;
				currentRow += 1;
			} else {
				newArray.set(currentRow, newString);
			}
		}
		return newArray.toArray(new String[0]);
	}

}
