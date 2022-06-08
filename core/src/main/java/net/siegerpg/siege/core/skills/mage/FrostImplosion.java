package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class FrostImplosion extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 120;
	final int initGoldCost = 5000;
	final double damageMulti = 0.1;

	public FrostImplosion() {
		this.identifier = "2_A_1";
		this.skillClass = SkillClass.MAGE;
		this.name = "Frost Implosion";
		this.description = List.of("All enemies within 5 meters",
		                           "are slowed by 20% and take 10%",
		                           "damage/sec for 5 seconds.");
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

		return List.of("All enemies within 5 meters",
		               "are slowed and take "+((getDamageMulti(level)-1) * 100)+"%",
		               "damage/sec for 5 seconds.");
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
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.015)), 2);
	}


	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		Location location = player.getLocation();

		double damage = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.STRENGTH);

		double increase = Math.PI / 18;

		new BukkitRunnable(){
			int counter = 1;

			@Override
			public void run() {
				if(counter > 5){
					for(int k = 1; k < 4; k++){
						for(int j = 0; j < 36; j++){

							double angle = j * increase;

							Vector v = new Vector(Math.cos(angle) * k, 0, Math.sin(angle) * k);

							player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation().add(v), 4 - k);
						}
					}

					triggerEnd(player, level);
					this.cancel();
				}


				//particles

				for(int j = 0; j < 36; j++){

					double angle = j * increase;

					Vector v = new Vector(Math.cos(angle) * 5, 0, Math.sin(angle) * 5);

					player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation().add(v), 4);
				}

				//Damage TODO: removed method
				for (LivingEntity entity : location.getNearbyLivingEntities(5, 5, 5)) {
					if (entity.equals(player)) continue;

					entity.damage(damage / 10, player);

					entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 1));

				}


				counter++;
			}
		}.runTaskTimer(Core.plugin(), 20L, 20L);

		// Handling of the skill goes here
		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
