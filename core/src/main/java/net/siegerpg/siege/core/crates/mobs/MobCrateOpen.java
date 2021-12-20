package net.siegerpg.siege.core.crates.mobs;


import kotlin.Pair;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.crates.cosmetics.CosmeticAnimation;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.DropUtils;
import net.siegerpg.siege.core.miscellaneous.GoldEXPSpawning;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobCrateOpen implements Listener {


	@EventHandler
	public void onCrateOpen(PlayerInteractEvent e) {

		//Make sure clicked block is trapped chest in the Hub
		Block targetedBlock = e.getClickedBlock();
		if (targetedBlock == null) return;
		if (!locationCheck(targetedBlock.getLocation())) return;
		Player player = e.getPlayer();
		e.setCancelled(true);
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

		//Make sure item is a cosmetic key
		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
		if (item == null) return;
		if (!(item instanceof CustomKey)) return;
		if (!keyCheck(item)) return;

		//Pick item reward to give to player
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);
		short level = expLevel.getFirst();
		ArrayList<MobDropTable> dropTablesList = new ArrayList<>();

		//get the drop tables of all mobs below level+3
		for (MobStats mob : MobStats.values()) {
			if (mob.getLevel() > level+3) continue;
			dropTablesList.add(mob.getDropTable());
		}

		int randNumber = (int) Math.floor(Math.random() * dropTablesList.size());
		MobDropTable dropTable = dropTablesList.get(randNumber);
		if (dropTable == null) return;

		ArrayList< ItemStack > rewardItems = new ArrayList<>();
		int rewardGold = 0;
		int rewardEXP = 0;

		//adding items to rewards
		try {
			//create a copy of the class
			for (int i = 0; i<5;i++) {
				rewardGold += dropTable.getGold(true);
				rewardEXP += dropTable.getExp(true);

				rewardItems.addAll(dropTable.calculateRewards(0));
				dropTable = dropTable.getClass().getDeclaredConstructor().newInstance();
			}

		} catch (Exception ignored) {}

		GoldExpListener.giveGold(player, rewardGold);
		Levels.INSTANCE.addExpShared(player, rewardEXP);
		ArrayList< ItemStack > rewardItemsCOPY = rewardItems;



		new BukkitRunnable() {
			@Override
			public void run() {

				if (rewardItemsCOPY.isEmpty()) this.cancel();

				//create vector to shoot items at player
				Vector vector = Utils.getDifferentialVector(
						targetedBlock.getLocation(), player.getLocation().subtract(0, 2, 0));
				vector.normalize();

				Item displayedItem = DropUtils.Companion.dropItemNaturallyForPlayers(
						targetedBlock.getLocation().add(0,2,0), rewardItemsCOPY.get(0), List.of(player.getUniqueId()));
				rewardItemsCOPY.remove(0);
				displayedItem.setVelocity(vector);
				player.playSound(player.getLocation(), Sound.ENTITY_FOX_TELEPORT, 1.0f, 1.0f);


			}
		}.runTaskTimer(Core.plugin(), 5, 5);

		player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0f, 1.0f);

		//add duplicte items together
		HashMap<ItemStack, Integer> itemCount = new HashMap<>();
		for (ItemStack reward : rewardItems) {
			if (!itemCount.containsKey(reward)) itemCount.put(reward.asOne(), reward.getAmount());
			else itemCount.put(reward.asOne(), reward.getAmount()+itemCount.get(reward.asOne()));
		}

		//player rewards message
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#91CB56><bold><underlined>   REWARDS   <reset>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#91CB56><bold>"+dropTable.getMobName() + " <gray>x3"));
		player.sendMessage(Utils.parse("  <yellow><bold>Gold <r><gray>+"+String.format("%,d",rewardGold)));
		player.sendMessage(Utils.parse("  <light_purple><bold>EXP <r><gray>+"+String.format("%,d",rewardEXP)));
		player.sendMessage("");
		for (Map.Entry<ItemStack, Integer> reward : itemCount.entrySet()) {
			Component miniMessage = Utils.lore("<green>+ "+reward.getKey().getItemMeta().getDisplayName()+" <gray>x"+reward.getValue()).hoverEvent(reward.getKey());
			player.sendMessage(miniMessage);
		}
		player.sendMessage("");

		player.getInventory().removeItem(item.getItem().asOne());

	}

	private boolean locationCheck(Location location) {
		double x = -26.0;
		double y = 92.0;
		double z = 9.0;
		Location strippedLocation = location.toBlockLocation();
		if (strippedLocation.getZ() != z) return false;
		if (strippedLocation.getY() != y) return false;
		if (strippedLocation.getX() != x) return false;
		return true;
	}

	private boolean keyCheck(CustomItem item) {
		return item instanceof MobKey;
	}
}
