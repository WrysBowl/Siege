package net.siegerpg.siege.core.miscellaneous.cache;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomTool;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PlayerData implements Listener {

	public static HashMap< Player, Boolean > hasActionBar = new HashMap<>();
	public static HashMap< Player, Boolean > broadcastTips = new HashMap<>();
	public static HashMap< Player, Double > playerHealth = new HashMap<>();
	public static HashMap< Player, Double > playerCurrentMana = new HashMap<>();
	public static HashMap< Player, Double > playerMana = new HashMap<>();
	public static HashMap< Player, Location > playerDeathLocations = new HashMap<>();

	public static HashMap< Player, ArrayList< Action > > playerTriggers = new HashMap<>();

	public static void setStats(Player player) {

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
				double health = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.HEALTH) + 20;
				int regen = (int) CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.REGENERATION);

				Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(health);
				player.setHealthScale(health/(health/20));
				player.setSaturatedRegenRate((int)Math.ceil((regen/-50.0)+10));

				playerHealth.put(player, player.getMaxHealth());
				playerMana.put(player, CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.MANA));

			}, 2);
	}

	@EventHandler
	public void onEnable(PluginEnableEvent e) {

		for (Player player : Bukkit.getOnlinePlayers()) {
			setStats(player);
			hasActionBar.put(player, false);
			PlayerData.broadcastTips.put(player, true);
			//playerSkills.put(player, SkillUtils.decode(Skills.INSTANCE.getSkills(player)));
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player player = e.getPlayer();
		hasActionBar.put(player, false);
		setStats(player);
		//playerSkills.put(player, SkillUtils.decode(Skills.INSTANCE.getSkills(player)));
		if (!PlayerData.broadcastTips.containsKey(player)) {
			PlayerData.broadcastTips.put(player, true);
		}
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {

		Player player = e.getPlayer();
		playerHealth.remove(player);
		playerMana.remove(player);
		playerCurrentMana.remove(player);
	}

	@EventHandler( priority = EventPriority.LOWEST )
	public void onEquip(ArmorEquipEvent e) {

		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getNewArmorPiece());
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
			e.setCancelled(true);
			return;
		}
		setStats(e.getPlayer());
	}

	@EventHandler
	public void toolSwitch(PlayerItemHeldEvent e) {

		CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e
				                                                         .getPlayer()
				                                                         .getInventory()
				                                                         .getItem(e.getNewSlot()));
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
