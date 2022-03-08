package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Taunt extends Skill {

	final int initCooldown = 45 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 3000;
	final int duration = 10;
	final int range = 5;

	public Taunt() {
		this.identifier = "2_A_2";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Taunt";
		this.description = List.of("Force all mobs within",
		                           "5 blocks to attack you.",
		                           "Weaken your attacks by 20%",
		                           "for 10 seconds");
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

		return List.of("Force all mobs within",
		               getRange(level)+" blocks to attack you.",
		               "Weaken your attacks by 20%",
		               "for "+getDuration(level)+" seconds");
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
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDuration(int level) {
		return (this.duration) + (level-1);
	}
	public double getRange(int level) {
		return (this.range) + (level-1);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;
    
    	// Handling of the skill goes here
		Location location = player.getLocation();
		player.playSound(location, Sound.ENTITY_PHANTOM_AMBIENT, 1.0f, 0.8f);

		//taunt mobs for this duration
		new BukkitRunnable() {

			int counter = 0;
			@Override
			public void run() {
				//stop checking for enemies
				if (counter >= 10) {
					triggerEnd(player, level);
					this.cancel();
				}

				for (LivingEntity mob : location.getNearbyLivingEntities(getRange(level))) {
					if (!(mob instanceof Mob)) continue;
					mob.getWorld().spawnParticle(Particle.HEART, mob.getLocation(), 2);
					((Mob)mob).setTarget(player);

				}

				counter +=1;
			}
		}.runTaskTimer(Core.plugin(), 20, 20);

		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
