package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.ActiveSkillData;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import net.siegerpg.siege.core.skills.SkillData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Armory extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final double damageMulti = 0.75;

	public Armory() {
		this.identifier = "2_A_1";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Armory";
		this.description = List.of("You take 25% less",
		                           "damage for 5 seconds.",
		                           "If weakened your damage",
		                           "reduction is 50%.");
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

		return List.of("You take "+(1-(getDamageMulti(level, false)) * 100)+"% less",
		               "damage for 5 seconds.",
		               "If weakened your damage",
		               "reduction is "+(1-(getDamageMulti(level, true)) * 100)+"%.");
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

	public double getDamageMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.damageMulti - 0.25) - ((level - 1) * 0.025)), 2);
		return Utils.round(((this.damageMulti) - ((level - 1) * 0.025)), 2);
	}


	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		//add skill to active skills and remove 5 seconds later
		ActiveSkillData.addToActiveSkills(player, this);
		Skill skill = this;
		new BukkitRunnable() {
			@Override
			public void run() {
				ActiveSkillData.removeFromActiveSkills(player, skill);
			}
		}.runTaskLater(Core.plugin(), 100);

		// Handling of the skill goes here
		return true;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageEvent e) {

		if (!(e.getEntity() instanceof Player player)) return;
		if(!ActiveSkillData.isActive(player, this)) return;
		Integer skillLevel = SkillData.getSkillLevel(player, this);

		//this will never be null because the skill is currently active, which has gone through these same checks already
		if (skillLevel == null || skillLevel < 1) return;

		if (player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
			e.setDamage(e.getDamage() * getDamageMulti(skillLevel, true));
		} else {
			e.setDamage(e.getDamage() * getDamageMulti(skillLevel, false));
		}

	}



	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
