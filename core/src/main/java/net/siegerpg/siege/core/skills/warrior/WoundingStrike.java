package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.*;

import java.time.*;
import java.util.*;

import static java.util.Objects.requireNonNull;
import static net.siegerpg.siege.core.skills.SkillData.*;

public class WoundingStrike extends Skill {

	final int initCooldown = 25 * 1000;
	final int initManaCost = 75;
	final int initGoldCost = 5000;
	final int duration = 3;

	public WoundingStrike() {
		this.identifier = "3_B_1";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Wounding Strike";
		this.description = List.of("Deals +75% damage and",
		                           "reduces enemy healing by 50%",
		                           "for 3 seconds. If enemy is",
		                           "weakened reduce for 6 seconds");
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

		return List.of("Deals +75% damage and",
		               "reduces enemy healing by 50%",
		               "for "+((getDuration(level, false) - 1) * 100)+" seconds. If enemy is",
		               "weakened reduce for "+((getDuration(level, true) - 1) * 100)+" seconds");
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

	public double getDuration(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.duration + 3) + ((level - 1) * 0.3)), 2);
		return Utils.round(((this.duration) + ((level - 1) * 0.3)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		new BukkitRunnable() {
			@Override
			public void run() {
				triggerEnd(player, level);
			}
		}.runTaskLater(Core.plugin(), 200); //If it pasts 10 seconds, the skill timeouts.
		
		return true;
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if (!(e.getDamager() instanceof Player p)) return;
		if(!ActiveSkillData.isActive(p, this)) return;

		triggerEnd(p, requireNonNull(getSkillLevel(p, this))); //ends the skill

		((LivingEntity)e.getEntity()).damage(CustomItemUtils.INSTANCE.getPlayerStat(p, StatTypes.STRENGTH) * 0.75);

		//Reduce regen WIP!
		int regen = (int) CustomItemUtils.INSTANCE.getPlayerStat(p, StatTypes.REGENERATION);
		PlayerData.playerExtraRegeneration.put(p, (int)(regen * -0.5)); //adds negative of half the player's regen


	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}













