package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.*;
import org.bukkit.attribute.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.*;

import java.time.*;
import java.util.*;

public class DivinePresence extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 2500;
	final double healthMulti = 1.25;

	public DivinePresence() {
		this.identifier = "3_A_3";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Divine Presence";
		this.description = List.of("Summon lightning to heal",
		                           "allies by +25% and weaken",
		                           "enemies by 20% for 10 seconds",
		                           "within 8 meters.");
	}

	@Override
	public List< String > getDescription() {
		return this.description;
	}
	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Summon lightning to regenerate",
		               "ally health by +" + ((getHealthMulti(level) - 1) * 100) + "% and weaken",
		               "enemies by 20% for 10 seconds",
		               "within 8 meters.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.025));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getHealthMulti(int level) {
		return Utils.round(((this.healthMulti) + ((level - 1) * 0.01)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		Location location = player.getLocation();

		location.getWorld().strikeLightningEffect(location);

		new BukkitRunnable() {
			int counter = 1;

			@Override
			public void run() {
				if(counter > 11){
					triggerEnd(player, level);
					this.cancel();
				}


				for (LivingEntity entity : location.getNearbyLivingEntities(8, 8, 8)) {

					if (entity.equals(player)) continue;

					//heal
					if(entity instanceof Player ally){

						if (!Utils.isOnlinePlayer(entity)) continue;

						double playerMaxHealth = Objects
								.requireNonNull(ally.getAttribute(Attribute.GENERIC_MAX_HEALTH))
								.getValue();
						Double playerHealth = PlayerData.playerHealth.get(ally);

						if (playerHealth != null) {

							PlayerData.playerHealth.put(ally, Math.min(playerMaxHealth, (playerHealth * getHealthMulti(level))));

						}
					}

				}

				counter++;
			}

		}.runTaskTimer(Core.plugin(), 0L, 20L);

		return true;

		// Handling of the skill goes here
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if(!(e.getDamager() instanceof Player)){ //Check if enemy
			for (LivingEntity entity : e.getDamager().getLocation().getNearbyLivingEntities(8, 8, 8)) {
				if(entity instanceof Player player && ActiveSkillData.isActive(player, this)){ //check if any skill user exists

					e.setDamage(e.getFinalDamage() * 0.8);

					return;
				}
			}
		}
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
