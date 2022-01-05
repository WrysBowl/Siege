package net.siegerpg.siege.core.crates.mobs;


import kotlin.Pair;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.crates.cosmetics.CosmeticCrateOpen;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class MobCrateOpen implements Listener {

	public static boolean crateDelay = false;
	public static boolean awaitingRemoval = false;

	@EventHandler
	public void onCrateOpen(PlayerInteractEvent e) {

		//Make sure clicked block is trapped chest in the Hub
		Block targetedBlock = e.getClickedBlock();
		if (targetedBlock == null) return;
		if (!targetedBlock.getLocation().getWorld().getName().equals("Hilly_Woods")) return;
		if (!locationCheck(targetedBlock.getLocation())) return;
		Player player = e.getPlayer();
		e.setCancelled(true);
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

		//Make sure item is a cosmetic key
		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
		if (item == null) {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.lore("<red>Please use a mob key!"));
			return;
		}
		if (!(item instanceof CustomKey)) {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.lore("<red>Please use a mob key!"));
			return;
		}
		if (!keyCheck(item)) {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.lore("<red>Please use a mob key!"));
			return;
		}
		if (CosmeticCrateOpen.currentlyUsedChests.contains(targetedBlock.getLocation())) {
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			player.sendMessage(Utils.lore("<red>This crate is currently being used!"));
			return;
		}
		CosmeticCrateOpen.currentlyUsedChests.add(targetedBlock.getLocation());


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

		player.getInventory().removeItem(item.getItem().asOne());

		ArmorStand stand = getArmorStand(targetedBlock.getLocation().toCenterLocation());
		stand.setHelmet(new ItemStack(Material.BARREL));
		new BukkitRunnable() {

			int counter = 0;
			final World world = stand.getWorld();
			int soundCounter = 0;

			@Override
			public void run() {
				if (counter >= 64) {
					giveReward(player, dropTable, targetedBlock, stand);
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0f, 1.0f);
					CosmeticCrateOpen.currentlyUsedChests.remove(targetedBlock.getLocation());
					this.cancel();
				} else {
					if (counter % 6 == 0) {
						if (soundCounter == 0) player.getWorld().playSound(stand.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
						else if (soundCounter == 1) player.getWorld().playSound(stand.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.2f);
						else if (soundCounter == 2) player.getWorld().playSound(stand.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.4f);
						else if (soundCounter == 3) {
							soundCounter = -1;
							player.getWorld().playSound(stand.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.6f);
						}
						soundCounter++;
					}

					double x = stand.getLocation().getX();
					double y = stand.getLocation().getY()+0.025;
					double z = stand.getLocation().getZ();
					float yaw = stand.getLocation().getYaw()+15;
					float pitch = stand.getLocation().getPitch();
					Location loc = new Location(world ,x, y, z, yaw, pitch);
					stand.teleport(loc);
				}
				if (counter >= 45 && counter <= 55) {
					final int r = 203;
					final int g = 225;
					final int b = 145;
					Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(r, g, b), 2);
					stand.getWorld().spawnParticle(Particle.REDSTONE, stand.getLocation(), 5, 3, 1, 3, dust);
				}
				counter++;
			}

		}.runTaskTimer(Core.plugin(), 1, 1);

	}

	private ArmorStand getArmorStand(Location loc) {
		final ArmorStand stand = loc.getWorld().spawn(loc, ArmorStand.class);
		stand.setGravity(false);
		stand.setBasePlate(false);
		stand.setSmall(true);
		stand.setArms(false);
		stand.setVisible(false);
		stand.customName(Utils.parse("<color:#91CB56><bold>MOB CRATE"));
		stand.setCustomNameVisible(true);
		return stand;
	}

	public static void giveReward(Player player, MobDropTable dropTable, Block targetedBlock, ArmorStand stand) {
		ArrayList< ItemStack > rewardItems = new ArrayList<>();
		int rewardGold = 0;
		int rewardEXP = 0;

		//adding items to rewards
		try {
			//create a copy of the class
			for (int i = 0; i<3;i++) {
				rewardGold += dropTable.getGold(true);
				rewardEXP += dropTable.getExp(true);

				final ArrayList<ItemStack> items = dropTable.calculateRewards(0);
				ArrayList<ItemStack> copiedItems = items;
				for (ItemStack item: items) {
					if (item.getType().equals(Material.TRIPWIRE_HOOK)) copiedItems.remove(item);
				}

				rewardItems.addAll(copiedItems);
				dropTable = dropTable.getClass().getDeclaredConstructor().newInstance();
			}

		} catch (Exception ignored) {}

		GoldExpListener.giveGold(player, rewardGold);
		Levels.INSTANCE.addExpShared(player, rewardEXP);
		ArrayList< ItemStack > rewardItemsCOPY = rewardItems;



		new BukkitRunnable() {
			@Override
			public void run() {

				if (rewardItems.size() < 1) {
					stand.remove();
					this.cancel();
				} else {
					//create vector to shoot items at player
					Vector vector = Utils.getDifferentialVector(
							targetedBlock.getLocation(), player.getLocation().subtract(0, 2, 0));
					vector.normalize();

					ItemStack reward = rewardItemsCOPY.get(0);
					Item displayedItem =
							targetedBlock.getWorld().dropItemNaturally(
									stand.getLocation(),
									reward);
					displayedItem.setPickupDelay(99999);
					rewardItemsCOPY.remove(0);
					displayedItem.setVelocity(vector);
					player.playSound(player.getLocation(), Sound.ENTITY_FOX_TELEPORT, 0.25f, 1.0f);
					new BukkitRunnable() {

						@Override
						public void run() {
							displayedItem.remove();
							Utils.giveItem(player, reward);
							player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.25f, 1.0f);

						}
					}.runTaskLater(Core.plugin(), 20);
				}
			}
		}.runTaskTimer(Core.plugin(), 3, 3);

		//add duplicate items together
		HashMap<ItemStack, Integer> itemCount = new HashMap<>();
		for (ItemStack reward : rewardItems) {
			if (!itemCount.containsKey(reward)) itemCount.put(reward.asOne(), reward.getAmount());
			else itemCount.put(reward.asOne(), reward.getAmount()+itemCount.get(reward.asOne()));
		}

		//player rewards message
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#91CB56><bold><underlined>   REWARDS   <reset>"));
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#91CB56><bold>"+dropTable.getMobName() + " <r><gray>x3"));
		player.sendMessage(Utils.parse("  <yellow><bold>Gold <r><gray>+"+String.format("%,d",rewardGold)));
		player.sendMessage(Utils.parse("  <light_purple><bold>EXP <r><gray>+"+String.format("%,d",rewardEXP)));
		player.sendMessage("");
		for (Map.Entry<ItemStack, Integer> reward : itemCount.entrySet()) {
			Component miniMessage = Utils.lore("<green>+ "+reward.getKey().getItemMeta().getDisplayName()+" <gray>x"+reward.getValue()).hoverEvent(reward.getKey());
			player.sendMessage(miniMessage);
		}
		player.sendMessage("");
	}

	private boolean locationCheck(Location location) {
		double x = -206.0;
		double y = 56.0;
		double z = -157.0;
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
