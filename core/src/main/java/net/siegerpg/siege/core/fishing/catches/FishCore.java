package net.siegerpg.siege.core.fishing.catches;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.droptables.FishDropTable;
import net.siegerpg.siege.core.fishing.droptables.OldFishTable;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomRod;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Map;

public class FishCore {


	public static ArrayList<Fish> registeredFish = new ArrayList<>() {
		{
			add(new Bearacuda());
			add(new BigBlueTuna());
			add(new Catastrophe());
			add(new Codzilla());
			add(new FlashyShark());
			add(new MrKrabs());
			add(new MrsPuff());
			add(new PistolWhipper());
			add(new RedSnacker());
			add(new StingWhip());
		}
	};

	public static Fish chooseRandomFish (Player player) {

		ItemStack item = player.getInventory().getItemInMainHand();
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
		FishDropTable table = new OldFishTable();
		if (customItem instanceof CustomRod) table = ((CustomRod) customItem).getFishDropTable();
		double totalWeight = 0;
		for (Map.Entry<Fish, Double> entry : table.fishDropTable.entrySet()) {
			totalWeight += entry.getValue();
		}

		int weight = 0;
		double random = Math.random() * totalWeight;
		for (Map.Entry<Fish, Double> entry : table.fishDropTable.entrySet()) {
			Fish fish = entry.getKey();
			weight += entry.getValue();
			if (random > weight) continue; //if the random number is above the totalWeight
			try {
				fish = fish.getClass().getDeclaredConstructor().newInstance();
				return fish;
			} catch (Exception ignored) {
				return fish;
			}
		}
		return registeredFish.get(0);
	}

	public static Fish getFish (String name) {

		for (Fish fish : registeredFish) {
			if (!fish.name.equals(name)) continue;
			return fish;
		}
		return null;
	}

}
