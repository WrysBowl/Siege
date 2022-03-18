package net.siegerpg.siege.core.miscellaneous.cache;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomTool;
import net.siegerpg.siege.core.items.sets.*;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class PlayerData implements Listener {

	public static HashMap< Player, Boolean > hasActionBar = new HashMap<>();
	public static HashMap< Player, Double > playerHealth = new HashMap<>();
	public static HashMap< Player, Double > playerRegeneration = new HashMap<>();
	public static HashMap< Player, Integer > playerExtraRegeneration = new HashMap<>();

	public static HashMap< Player, Integer > playerCurrentMana = new HashMap<>();
	public static HashMap< Player, Integer > playerMana = new HashMap<>();
	public static HashMap< Player, Location > playerDeathLocations = new HashMap<>();

	public static ArrayList< Player > commandCooldown = new ArrayList<>();
	public static HashMap< Player, Integer > playerCooldownStrikes = new HashMap<>();

	//runnable to regenerate mana
	public PlayerData() {

		new BukkitRunnable() {

			@Override
			public void run() {
				playerCooldownStrikes.clear();
			}
		}.runTaskTimer(Core.plugin(), 40, 40);

		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!playerMana.containsKey(player)) continue;
					int maxMana = playerMana.get(player);
					int currentMana = playerCurrentMana.get(player);
					double manaRegen = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.MANA_REGEN);
					int newCurrentMana = currentMana + (int)manaRegen + 1;

					if (newCurrentMana > maxMana) newCurrentMana = maxMana;
					playerCurrentMana.put(player, newCurrentMana);
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 20);
	}

	public static boolean onCooldown(Player player) {
		if (commandCooldown.contains(player)) {

			int currentStrikes = 0;
			if (playerCooldownStrikes.containsKey(player)) currentStrikes = playerCooldownStrikes.get(player);

			if (overStrikeLimit(currentStrikes)) player.kick(Utils.lore("<red>You were kicked for packet overload!"));
			playerCooldownStrikes.put(player, currentStrikes);
			return true;
		} else {
			return false;
		}
	}
	private static boolean overStrikeLimit(int strikes) {
		return strikes > 10;
	}

	public static void addCooldown(Player player) {
		commandCooldown.add(player);
		new BukkitRunnable() {

			@Override
			public void run() {
				commandCooldown.remove(player);
			}

		}.runTaskLater(Core.plugin(), 20L);
	}
	public static void addCooldown(Player player, int ticks) {
		commandCooldown.add(player);
		new BukkitRunnable() {

			@Override
			public void run() {
				commandCooldown.remove(player);
			}

		}.runTaskLater(Core.plugin(), ticks);
	}

	public static int getRegenRate(int regen) {
		int regenRate = (int)Math.ceil((regen/-10.0)+11);
		if (regenRate<1) regenRate = 1;
		return regenRate;
	}

	public static double getNewHealth(Double health, Double maxHealth, Double oldMaxHealth) {
		return (health/oldMaxHealth)*maxHealth;
	}
	public static double getHealthMultiplier(Player player) {
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

		return (expLevel.getFirst()-1)*5;
	}

	public static double getManaMultiplier(Player player) {
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

		return (expLevel.getFirst()-1)*10;
	}

	public static void addHealth(Player player, int health) {
		boolean critical = isCriticalHealth(player, health);
		DamageIndicator.INSTANCE.showDamageIndicator((health * -1), player.getLocation(), critical);
		player.setHealth(health);
	}
	private static boolean isCriticalHealth(Player player, int health) {
		return (health > player.getHealth());
	}


	public static void setStats(Player player) {

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
			AttributeInstance maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);

			if (maxHealth == null) return;

			double oldMaxHealth = maxHealth.getBaseValue();
			double health = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.HEALTH) + 20 + getHealthMultiplier(player);
			player.setHealthScale(health/(health/20));
			maxHealth.setBaseValue(health);
			player.setHealth(getNewHealth(player.getHealth(), health, oldMaxHealth));

			int regen = (int) CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.REGENERATION);
			regen += (playerExtraRegeneration.get(player) != null) ? playerExtraRegeneration.get(player) : 0;
			int regenRate = getRegenRate(regen);
			player.setSaturatedRegenRate(regenRate);
			player.setUnsaturatedRegenRate((int)(regenRate*1.25));

			int mana = (int) (CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.MANA) + 100 + getManaMultiplier(player));

			if (!playerCurrentMana.containsKey(player)) playerCurrentMana.put(player, mana);
			playerHealth.put(player, health);
			playerRegeneration.put(player, (double)regen);
			playerMana.put(player, mana);
		}, 2);
	}

	@EventHandler
	public void onEnable(PluginEnableEvent e) {

		for (Player player : Bukkit.getOnlinePlayers()) {
			setStats(player);
			for(GearSet set : GearSet.Companion.getSets()) {
				set.removeEffect(player);
				set.setEffect(player);
			}
			hasActionBar.put(player, false);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player player = e.getPlayer();
		player.setHealth(player.getMaxHealth());
		hasActionBar.put(player, false);
		setStats(player);
		for(GearSet set : GearSet.Companion.getSets()) {
			set.removeEffect(e.getPlayer());
			set.setEffect(e.getPlayer());
		}
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {

		Player player = e.getPlayer();
		playerRegeneration.remove(player);
		playerHealth.remove(player);
		playerMana.remove(player);
		playerCurrentMana.remove(player);
		playerExtraRegeneration.remove(player);
	}

	@EventHandler( priority = EventPriority.LOWEST )
	public void onEquip(ArmorEquipEvent e) {

		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getNewArmorPiece());
		new BukkitRunnable() {
			@Override
			public void run() {
				//gear set effects
				for(GearSet set : GearSet.Companion.getSets()) {
					set.removeEffect(e.getPlayer());
					set.setEffect(e.getPlayer());
				}
			}
		}.runTaskLater(Core.plugin(), 2);

		if (item == null) {
			setStats(e.getPlayer());
			return;
		}
		if (item.getLevelRequirement() == null) return;
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(e.getPlayer());
		if (item.getLevelRequirement() > (expLevel != null ? expLevel.getFirst() : 0)) {
			e
					.getPlayer()
					.sendTitle(
							Utils.tacc("&c&lSORRY!"),
							ChatColor.RED + "Too weak to use this armor's stats", 1, 80, 1
					          );
			e
					.getPlayer()
					.playSound(e
							           .getPlayer()
							           .getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			return;
		}
		setStats(e.getPlayer());
	}

	@EventHandler
	public void toolSwitch(PlayerItemHeldEvent e) {

		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItem(e.getNewSlot()));
		Player player = e.getPlayer();
		player.removePotionEffect(PotionEffectType.SLOW_DIGGING);

		if (item == null) return;
		if (!(item instanceof CustomEquipment)) return;

		setStats(e.getPlayer());
	}

	@EventHandler
	public void toolUse(PlayerInteractEvent e) {

		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {

			CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e
					                                                         .getPlayer()
					                                                         .getInventory()
					                                                         .getItemInMainHand());
			Player player = e.getPlayer();
			player.removePotionEffect(PotionEffectType.SLOW_DIGGING);

			if (item == null) return;
			if (!(item instanceof CustomEquipment)) return;

			effectUnderLeveled(item, player);

		}
	}

	private void effectUnderLeveled(CustomItem item, Player player) {

		if (item instanceof CustomWeapon || item instanceof CustomTool) {
			Integer level = item.getLevelRequirement();
			Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);

			if (expLevel == null) return;
			if (expLevel.getFirst() == null) return;
			if (level == null) return;
			if (expLevel.getFirst() >= level) return;

			PotionEffect potion = new PotionEffect(PotionEffectType.SLOW_DIGGING, 99999, 2);
			player.addPotionEffect(potion);
		}
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {

		Player player = e.getEntity();
		playerDeathLocations.put(player, player.getLocation());
	}

}
