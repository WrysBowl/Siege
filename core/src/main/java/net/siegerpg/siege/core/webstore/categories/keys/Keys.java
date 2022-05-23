package net.siegerpg.siege.core.webstore.categories.keys;

import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.types.misc.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.webstore.categories.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import java.util.*;

public class Keys extends WebstorePackage {

	public static HashMap< String, CustomKey > keys = new HashMap< String, CustomKey >() {
		{
			this.put("mob", new MobKey());
		}
	};
	String arg2 = "key";
	String arg3 = "mob"; //key type
	Integer arg4 = 1; //amount
	CustomKey key = new MobKey();

	public Keys(String arg2, String arg3, Integer arg4, CustomKey key) {

		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
		this.key = key;
	}

	public Keys(String[] args) {

		super(args);
		try {
			this.arg2 = args[0];
			this.arg3 = args[1];
			this.arg4 = Integer.parseInt(args[2]);
			this.key = keys.get(args[1]);
		} catch (Exception ignored) {
		}
	}

	@Override
	public void setArgs(String[] args) {

		try {
			this.arg2 = args[0];
			this.arg3 = args[1];
			this.arg4 = Integer.parseInt(args[2]);
		} catch (Exception ignored) {
			ignored.printStackTrace();
		}
	}

	@Override
	public void completePurchase(UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
		final Player player = Bukkit.getPlayer(uuid);
		if (null == player) return;
		final ItemStack item = this.key
				.getUpdatedItem(false)
				.asQuantity(this.arg4);
		if (!Utils.giveItem(player, item)) {
			//when giveItem is run it will give the player the booster if the condition is not met
			player.sendMessage(Utils.lore(
					"<red>An item has been purchased for this account, but your inventory and ender chest was too full. Please rejoin the server with space for the item(s) in your inventory."));

		}

		//send a message that they purchased a booster
		Bukkit.broadcast(Utils.lore(""));
		Bukkit.broadcast(Utils.lore(
				"  <aqua>" + player.getName() + " has bought a <yellow>" + arg4 + " " +
				key.getName() + "!"));
		Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
		Bukkit.broadcast(Utils.lore(""));
	}

}
