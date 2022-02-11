package net.siegerpg.siege.core.miscellaneous.cache;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
import org.bukkit.attribute.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class ActiveMobs implements Listener {

	public static HashMap< Entity, String > mobNames = new HashMap<>();
	public static HashMap< Entity, Integer > luckStacked = new HashMap<>();

	@EventHandler
	public void onSpawn(MythicMobSpawnEvent e) {

		if (!(e.getEntity() instanceof Mob)) return;
		String displayName = e
				.getMob()
				.getDisplayName();
		if (displayName != null) {
			mobNames.put(e.getEntity(), displayName);
		}
	}

	public static void addLuck(LivingEntity mob, double damage, double luck) {
		AttributeInstance genericMaxHealth = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		if (genericMaxHealth == null) return;

		double maxHealth = genericMaxHealth.getValue();
		double percentDamage = damage/maxHealth;
		int addedLuck = (int)Math.floor(percentDamage * luck);

		luckStacked.put(mob, addedLuck);
	}

}
