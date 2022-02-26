package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
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

public class SelflessDefense extends Skill implements Listener {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 200;
	final int initGoldCost = 10000;
	final double damageMulti = 0.75; //multiply to new damage
	final double defenseMulti = 0.75; //multiply to new damage dealt to caster

	public SelflessDefense() {
		this.identifier = "2_A_4";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Selfless Defense";
		this.description = List.of("Absorb 25% of the damage",
		                           "that everyone within 10",
		                           "blocks takes. If weakened",
		                           "take 25% less damage.",
		                           "Lasts 10 seconds");
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

		return List.of("Absorb "+(1-(getDamageMulti(level)) * 100)+"% of the damage",
		               "that everyone within 10",
		               "blocks takes. If weakened",
		               "take "+(1-(getDefenseMulti(level, true)) * 100)+"% less damage.",
		               "Lasts 10 seconds.");
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
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) - ((level - 1) * 0.015)), 2);
	}
	public double getDefenseMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.defenseMulti) - ((level - 1) * 0.025)), 2);
		return 1.0;
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		//trigger end after 10 seconds
		new BukkitRunnable() {
			@Override
			public void run() {
				triggerEnd(player, level);
			}
		}.runTaskLater(Core.plugin(), 200);

		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageEvent e){

		if (!(e.getEntity() instanceof Player p)) return;

		Player temp = null;
		for(Entity entity: e.getEntity().getNearbyEntities(10, 10, 10)){
			if(entity instanceof Player){
				if(entity == p){
					continue;
				}
				if(ActiveSkillData.isActive((Player)entity, this)){
					temp = (Player) entity;
				}
			}
		}

		//If skill user exists
		if (temp != null) {
			e.setDamage(e.getDamage() * getDamageMulti(temp.getLevel()));

			if(temp.hasPotionEffect(PotionEffectType.WEAKNESS)){
				temp.damage(1-(getDamageMulti(temp.getLevel())) * 75);
			} else {
				temp.damage((1-(getDamageMulti(temp.getLevel())) * 100));
			}
		}
	}

}
