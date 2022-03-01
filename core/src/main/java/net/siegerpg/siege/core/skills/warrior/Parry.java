package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.*;

import java.time.*;
import java.util.*;

public class Parry extends Skill {

	final int initCooldown = 15 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 5000;
	final int duration = 3;

	public Parry() {
		this.identifier = "2_B_4";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Parry";
		this.description = List.of("If hit within 3 seconds,",
		                           "block attack and weaken",
		                           "attacker for 3 seconds.");
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

		return List.of("If hit within 3 seconds,",
		               "block attack and weaken",
		               "attacker for "+getDuration(level)+" seconds.");
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
		return (this.duration) + ((level-1)*0.5);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		//add skill to active skills and remove 5 seconds later
		new BukkitRunnable() {
			@Override
			public void run() {
				triggerEnd(player, level);
			}
		}.runTaskLater(Core.plugin(), (long) getDuration(level));

		// Handling of the skill goes here
		return true;
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if (!(e.getEntity() instanceof Player player)) return;
		if(!ActiveSkillData.isActive(player, this)) return;
		e.setCancelled(true);

		((LivingEntity) e.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3, 1));

		Integer skillLevel = SkillData.getSkillLevel(player, this);

		//this will never be null because the skill is currently active, which has gone through these same checks already
		if (skillLevel == null || skillLevel < 1) return;

		triggerEnd(player, skillLevel);
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
