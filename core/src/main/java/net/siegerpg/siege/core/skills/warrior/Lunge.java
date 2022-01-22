package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Lunge extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 3000;
	final double damageMulti = 1.5;

	public Lunge() {
		this.identifier = "1_A_2";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Lunge";
		this.description = List.of("Leap forwards dealing +50%",
		                           "damage to enemies in the way.",
		                           "If enemy is weakened deal +75%");
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

		return List.of("Leap forwards dealing +"+((getDamageMulti(level, false) - 1) * 100)+"%",
		               "damage to enemies in the way.",
		               "If enemy is weakened deal +"+((getDamageMulti(level, true) - 1) * 100)+"%");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.02));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getDamageMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.damageMulti + 0.25) + ((level-1) * 0.025)), 2);
		return Utils.round(((this.damageMulti) + ((level-1) * 0.025)), 2);
	}


	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;


		//used to calculate where and how far the player will lunge
		Vector vector = player.getLocation().getDirection();

		for (LivingEntity entity : player.getLocation().getNearbyLivingEntities(10, 4, 10)) {
			final Vector entityVector = entity.getLocation().toVector().clone();
			final Vector playerVector = player.getLocation().toVector().clone();
			vector = entityVector.subtract(playerVector);

			//make player look at entity
			Utils.faceDirection(player, entity.getLocation());
			break;
		}
		//normalize the vector
		vector.normalize();

		//pushes the player in the direction of the vector
		player.setVelocity(vector.multiply(6));

		//damage to deal UNMODIFIED
		final double damage = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.STRENGTH);

		//spawn slash particle effect

		//bukkit timer to check nearby entities goes until velocity is less than running speed or 3 seconds
		new BukkitRunnable() {

			int counter = 0;
			@Override
			public void run() {
				//stop checking for enemies
				if (counter >= 12) {
					triggerEnd(player, level);
					this.cancel();
				}

				Location location = player.getLocation();
				player.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, location, 2);
				player.getWorld().playSound(location, Sound.ENTITY_PLAYER_BIG_FALL, 1.0f, 1.0f);

				for (LivingEntity entity : location.getNearbyLivingEntities(1.5, 1.5, 1.5)) {
					if (entity.equals(player)) continue;

					if (entity.hasPotionEffect(PotionEffectType.WEAKNESS)) {
						entity.damage(damage*getDamageMulti(level, true), entity);
					} else {
						entity.damage(damage*getDamageMulti(level, false), entity);
					}
				}

				counter +=1;
			}
		}.runTaskTimer(Core.plugin(), 5, 5);

		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
