package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.projectiles.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;
import java.util.function.*;
import java.util.function.Consumer;

public class CriticalShot extends Skill {

	final int initCooldown = 10 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 2500;
	final double damageMulti = 1.5;

	public CriticalShot() {
		this.identifier = "1_A_1";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Critical Shot";
		this.description = List.of("+50% STR next shot");
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

		return List.of("+" + ((getDamageMulti(level) - 1) * 100) + "% STR next shot");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.03));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDamageMulti(int level) {

		return (this.damageMulti) + ((level-1) * 0.01);
	}



	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		Skill skill = this;
		CustomItemKotlinListener.Companion.addDamageMulti(this.getDamageMulti(level), player);

		//call triggerEnd when player's arrow lands
		new BukkitRunnable() {

			@Override
			public void run() {
				if (!ActiveSkillData.isActive(player, skill)) {

					//when skill ends, end the runnable
					triggerEnd(player, level);
					this.cancel();
				} else {
					//display flames around the player
					player.getLocation().getWorld().spawnParticle(
							Particle.CRIT,
							player.getLocation().add(0,1,0), 10, 0.75, 0.25, 0.75);

				}
			}
		}.runTaskTimer(Core.plugin(), 40, 40);

		// Handling of the skill goes here
		return true;
	}

	@EventHandler
	public void onArrowLand(ProjectileHitEvent e) {
		Projectile arrow = e.getEntity();
		if (!(arrow instanceof Arrow)) return;

		//gets the player instance
		ProjectileSource shooter = arrow.getShooter();
		if (!(shooter instanceof Player)) return;

		//check if player has this skill active
		if (!ActiveSkillData.isActive(((OfflinePlayer) shooter), this)) return;

		//get location of arrow
		Location loc = arrow.getLocation();

		//create crit effect
		loc.getWorld().spawnParticle(
				Particle.CRIT,
				loc.add(0,1,0), 10, 0.75, 0.25, 0.75);

		//sets damage multi back
		int level = SkillData.getSkillLevel((Player) shooter, this);

		CustomItemKotlinListener.Companion.removeDamageMulti(this.getDamageMulti(level), (Player) shooter);

		this.triggerEnd((Player) shooter, level);

	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
