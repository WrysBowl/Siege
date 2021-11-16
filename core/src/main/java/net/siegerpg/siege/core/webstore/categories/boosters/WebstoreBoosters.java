package net.siegerpg.siege.core.webstore.categories.boosters;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class WebstoreBoosters extends WebstorePackage {

	String arg2 = "booster"; //booster
	String arg3 = "GOLD"; //booster type
	Double arg4 = 1.2; //multiplier
	Integer arg5 = 3600; //duration
	Integer arg6 = 1; //amount


	public WebstoreBoosters (String arg2, String arg3, Double arg4, Integer arg5, Integer arg6) {
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
		this.arg5 = arg5;
		this.arg6 = arg6;
	}

	public WebstoreBoosters (String[] args) {
		super(args);
		try {
			this.arg2 = args[0];
			this.arg3 = args[1];
			this.arg4 = Double.parseDouble(args[2]);
			this.arg5 = Integer.parseInt(args[3]);
			this.arg6 = Integer.parseInt(args[4]);
		} catch (Exception ignored) {
		}
	}

	public void setMultiplier (double multi) {
		this.arg4 = multi;
	}

	public void setDuration (int duration) {
		this.arg5 = duration;
	}

	public void setAmount (int amount) {
		this.arg6 = amount;
	}

	@Override
	public void setArgs (String[] args) {
		try {
			this.arg2 = args[0];
			this.arg3 = args[1];
			this.arg4 = Double.parseDouble(args[2]);
			this.arg5 = Integer.parseInt(args[3]);
			this.arg6 = Integer.parseInt(args[4]);
		} catch (Exception ignored) {
			ignored.printStackTrace();
		}
	}

	@Override
	public void completePurchase (UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
		//give player the booster item
		Player player = Bukkit.getPlayer(uuid);
		if (player == null) return;
		if (!Utils.giveItem(player, getBoosterItem())) {
			//when giveItem is run it will give the player the booster if the condition is not met
			player.sendMessage(Utils.lore(
					"<red>An item has been purchased for this account, but your inventory and ender chest was too full. Please rejoin the server with space for the item(s) in your inventory."));

		}

		//send a message that they purchased a booster
		Bukkit.broadcast(Utils.lore(""));
		Bukkit.broadcast(Utils.lore("  <aqua>" + player.getName() + " has bought <yellow>" + arg6 + " " + arg3 + " <green>booster(s)!"));
		Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
		Bukkit.broadcast(Utils.lore(""));
	}

	public ItemStack getBoosterItem () {
		ItemStack item = new ItemStack(Material.PAPER, arg6);
		ItemMeta itemMeta = item.getItemMeta();
		if (this.arg3.equals("EXP")) itemMeta.displayName(Utils.lore("<light_purple>EXP Booster"));
		else if (this.arg3.equals("GOLD")) itemMeta.displayName(Utils.lore("<yellow>Gold Booster"));
		else return null;
		itemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("  <gray>Duration: <white>" + Utils.convertSecondsToTime(arg5)));
				add(Utils.lore("  <yellow>Multiplier: +" + ((arg4 * 100) - 100.0) + "% " + arg3));
				add(Utils.lore(""));
				add(Utils.lore("<green><bold>CLICK TO REDEEM"));
			}
		});

		item.setItemMeta(itemMeta);
		NBTItem nbtItem = new NBTItem(item);
		nbtItem.setInteger("seconds", arg5);
		nbtItem.setDouble("multiplier", arg4);
		return nbtItem.getItem();
	}
}
