package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
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

public class ExplodingArrow extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 60;
	final int initGoldCost = 3500;
	final double damageMulti = 1.25; //percentage to remove health by (1-0.1)*health = newHealth
	final double radius = 2.0; //percentage to remove health by (1-0.1)*health = newHealth

	public ExplodingArrow() {
		this.identifier = "3_B_2";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Exploding Arrow";
		this.description = List.of(
				"Shoots an explosive arrow.",
				"Deals +25% of strength, or +50%",
				"if affected targets are burning.",
				"Explosive radius reaches 2 blocks"
		                          );
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

		return List.of(
				"Shoots an explosive arrow.",
				"Deals +25% of strength, or +"+((getDamageMulti(level, true)-1) * 100)+"%",
				"if affected targets are burning.",
				"Explosive radius reaches "+getRadius(level)+" blocks"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.05));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getDamageMulti(int level, boolean burning) {

		if (burning) return (this.damageMulti) + ((level-1) * 0.05);
		return this.damageMulti;
	}

	public double getRadius(int level) {

		return (this.radius) + ((level-1) * 0.5);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		Skill skill = this;

		//call triggerEnd when player's arrow lands
		new BukkitRunnable() {

			@Override
			public void run() {
				if (!ActiveSkillData.isActive(player, skill)) {
					//when skill ends, end the runnable
					this.cancel();

				} else {
					//display flames around the player
					player.getLocation().getWorld().spawnParticle(
							Particle.SMALL_FLAME,
							player.getLocation().add(0,1,0), 10, 0.75, 0.25, 0.75);

				}
			}
		}.runTaskTimer(Core.plugin(), 40, 40);

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

		//create explosion effect
		loc.getWorld().spawnParticle(
				Particle.EXPLOSION_NORMAL,
				loc.add(0,1,0), 10, 0.75, 0.25, 0.75);

		//create flame particles effect
		loc.getWorld().spawnParticle(
				Particle.SMALL_FLAME,
				loc.add(0,1,0), 30, 0.75, 0.25, 0.75);

		//shoot fireballs at mobs within 10 blocks
		int level = SkillData.getSkillLevel((Player) shooter, this);

		//spawn tnt
		TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
		tnt.setFuseTicks(20);
		tnt.setSource((Player) shooter);

		//check if entities are burning
		loc.getNearbyLivingEntities(2.0).forEach(new Consumer< LivingEntity >() {

			double damage = CustomItemUtils.INSTANCE.getPlayerStat((Player) shooter, StatTypes.STRENGTH);

			@Override
			public void accept(LivingEntity livingEntity) {

				if (livingEntity.getFireTicks() > 0) {
					//if entity is burning
					damage *= getDamageMulti(level, true);
				} else {
					damage *= getDamageMulti(level, false);
				}

				livingEntity.damage(damage, (Player) shooter);
			}
		});

		this.triggerEnd((Player) shooter, level);

	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
