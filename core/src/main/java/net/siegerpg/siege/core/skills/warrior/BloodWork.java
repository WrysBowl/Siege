package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static net.siegerpg.siege.core.skills.SkillData.getSkillLevel;

public class BloodWork extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 75;
	final int initGoldCost = 3500;
	final double bleedPercent = 0.75;

	public BloodWork() {
		this.identifier = "2_B_2";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Blood Work";
		this.description = List.of("Damage a target",
								   "on next hit.",
		                           "Target loses 25% health,",
		                           "or 40% if weakened,",
		                           "over 10 seconds.");
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

		return List.of("Damage a target",
					   "on next hit.",
		               "Target loses "+(1-(getDamageMulti(level, false)) * 100)+"% health,",
		               "or 40% if weakened,",
		               "over 10 seconds.");
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

	public double getDamageMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.bleedPercent - 0.15) - ((level - 1) * 0.025)), 2);
		return Utils.round(((this.bleedPercent) - ((level - 1) * 0.025)), 2);
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

	private BloodWork getThis(){
		return this;
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if (!(e.getDamager() instanceof Player p)) return;
		if(!ActiveSkillData.isActive(p, this)) return;

		triggerEnd(p, requireNonNull(getSkillLevel(p, this))); //ends the skill

		new BukkitRunnable() {
			int counter = 1;

			@Override
			public void run() {
				if(counter > 10){
					triggerEnd(p, requireNonNull(getSkillLevel(p, getThis())));
					this.cancel();
				}

				((LivingEntity)e.getEntity()).damage(CustomItemUtils.INSTANCE.getPlayerStat(p, StatTypes.STRENGTH) * (((LivingEntity) e.getEntity()).hasPotionEffect(PotionEffectType.WEAKNESS) ? 0.025 : 0.04), p);

				counter++;
			}
		}.runTaskTimer(Core.plugin(), 0L, 20L);
	}
	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
