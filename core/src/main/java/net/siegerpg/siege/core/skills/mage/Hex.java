package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static net.siegerpg.siege.core.skills.SkillData.getSkillLevel;

public class Hex extends Skill {

	final int initCooldown = 10 * 1000;
	final int initManaCost = 40;
	final int initGoldCost = 5000;
	final double damageMulti = 1.75;

	public Hex() {
		this.identifier = "1_A_3";
		this.skillClass = SkillClass.MAGE;
		this.name = "Hex";
		this.description = List.of("Increase damage dealt",
		                           "by +75% for next hit");
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

		return List.of("Increase damage dealt",
		               "by +"+((getDamageMulti(level) - 1) * 100)+"% for next hit");
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
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.05)), 2);
	}


	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		// Handling of the skill goes here
		new BukkitRunnable() {
			@Override
			public void run() {
				triggerEnd(player, level);
			}
		}.runTaskLater(Core.plugin(), 200); //If it pasts 10 seconds, the skill timeouts.

		//triggerEnd(player, level) call for skill's end.
		return true;
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if (!(e.getDamager() instanceof Player p)) return;
		if(!ActiveSkillData.isActive(p, this)) return;
		if(getSkillLevel(p, this) == null) return;

		triggerEnd(p, requireNonNull(getSkillLevel(p, this))); //ends the skill

		e.setDamage(e.getDamage() * (1 + getDamageMulti(requireNonNull(getSkillLevel(p, this)))));

	}


	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
