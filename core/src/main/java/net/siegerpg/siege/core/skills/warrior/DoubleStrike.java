package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class DoubleStrike extends Skill {

	final int initCooldown = 10 * 1000;
	final int initManaCost = 30;
	final int initGoldCost = 2500;

	public DoubleStrike() {
		this.identifier = "2_B_3";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Double Strike";
		this.description = List.of("Slash your opponent twice,",
		                           "or three times if",
		                           "target is weakened");
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

		return List.of("Slash your opponent twice,",
		               "or three times if",
		               "target is weakened");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost - Math.ceil(this.initManaCost * (level-1) * 0.03));
	}
	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 3.5);
	}

	// This is made because damage is repeated.
	public void damage(Player player, Location location, double damage, LivingEntity entity) {
		entity.damage(damage, player);

	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		//used to calculate slash damage radius
		Vector vector = player
				.getLocation()
				.getDirection();

		//location of particle effect
		Location location = player
				.getEyeLocation()
				.add(vector.multiply(2));

		//damage to deal
		double damage = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.STRENGTH);

		//actually damage entity

		//bukkit runnable to run when hit
		new BukkitRunnable() {
			int counter = 1;
			int max = 2; //max amount of slashes to do

			@Override
			public void run() {
				if(counter > max){
					triggerEnd(player, level);
					this.cancel();
				}

				player.getWorld().spawnParticle(Particle.SWEEP_ATTACK, location, 1);

				for (LivingEntity entity : location.getNearbyLivingEntities(2, 2, 2)) {
					if (entity.equals(player)) continue;

					damage(player, location, damage, entity);

					if (counter != 3) continue; //if the counter is on the third slash iteration

					if (entity.hasPotionEffect(PotionEffectType.WEAKNESS)) {
						max = 3; //increase the max amount by one, dealing one more slash
					}
				}
				counter++;
			}

		}.runTaskTimer(Core.plugin(), 20L, 10L);

		return true;

	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
