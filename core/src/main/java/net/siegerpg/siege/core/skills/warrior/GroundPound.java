package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.*;

import java.time.*;
import java.util.*;

public class GroundPound extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 75;
	final int initGoldCost = 3500;
	final double damageMulti = 2.0;

	public GroundPound() {
		this.identifier = "3_B_3";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Ground Pound";
		this.description = List.of("Leap upwards, delivering a shockwave,",
		                           "and fall back down, delivering another.",
		                           "Shockwave pushes enemies backwards,",
		                           "weakens them for 3 seconds, and",
		                           "deals +100% damage within 4 meters.");
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

		return List.of("Leap upwards, delivering a shockwave,",
		               "and fall back down, delivering another.",
		               "Shockwave pushes enemies backwards,",
		               "weakens them for 3 seconds, and",
		               "deals +"+((getDamageMulti(level) - 1) * 100)+"% damage within 4 meters.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost - Math.ceil(this.initManaCost * (level-1) * 0.02));
	}
	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 3.5);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level-1) * 0.025)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false

		Vector vector = new Vector(0,0.9,0);
		Vector fallVector = new Vector(0,-2,0);
		Location location = player.getLocation();



		double damage = (100 + (getDamageMulti(level) - 1) * 100);

		PotionEffect potion = new PotionEffect(PotionEffectType.WEAKNESS, 3, 0);

		//launch player up!
		player.setVelocity(vector);


		//shockwave
		for (LivingEntity entity : location.getNearbyLivingEntities(4, 4, 4)) {
			if (entity.equals(player)) continue;
			if (entity instanceof Player && !Utils.isOnlinePlayer(entity)) continue;

			//push
			entity.setVelocity(new Vector(entity.getLocation().getX()-location.getX(), entity.getLocation().getY()-location.getY(), entity.getLocation().getZ()-location.getZ()).normalize().multiply(1.5));

			//damage
			entity.damage(damage, player);
			entity.addPotionEffect(potion);

		}

		new BukkitRunnable() {
			@Override
			public void run() {

				//make players fall fast
				player.setVelocity(fallVector);
			}
		}.runTaskLater(Core.plugin(), 15L);


		//check if player is on ground
		new BukkitRunnable() {

			@Override
			public void run() {
				if(player.isOnGround()){

					//shockwave
					for (LivingEntity entity : location.getNearbyLivingEntities(4, 4, 4)) {
						if (entity.equals(player)) continue;
						if(!entity.isOnGround()) continue;
						if (entity instanceof Player && !Utils.isOnlinePlayer(entity)) continue;

						//push
						entity.setVelocity(new Vector(entity.getLocation().getX()-location.getX(), entity.getLocation().getY()-location.getY(), entity.getLocation().getZ()-location.getZ()).normalize().multiply(1.5));

						//damage
						entity.damage(damage, player);
						entity.addPotionEffect(potion);

					}

					//cancelation of repeation
					this.cancel();
				}
			}
		}.runTaskTimer(Core.plugin(), 7L, 2L);







		return super.trigger(player, level);

		// Handling of the skill goes here
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
