package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.*;
import org.bukkit.block.data.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Iceberg extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 80;
	final int initGoldCost = 5000;
	final double damageMulti = 2.0;

	public Iceberg() {
		this.identifier = "2_A_2";
		this.skillClass = SkillClass.MAGE;
		this.name = "Iceberg";
		this.description = List.of("Throws a block of ice",
		                           "at a target for +200%",
		                           "of your strength. Deals",
		                           "+250% if enemy is slowed.");
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

		return List.of("Throws a block of ice",
		               "at a target for +"+((getDamageMulti(level, false)-1) * 100)+"%",
		               "of your strength. Deals",
		               "+"+((getDamageMulti(level, true)-1) * 100)+"% if enemy is slowed.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.025));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDamageMulti(int level, boolean slowed) {
		if (slowed) return (this.damageMulti + 0.5) + ((level-1) * 0.05);
		return this.damageMulti + ((level-1) * 0.05);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		Location loc = player.getEyeLocation();

		Vector v = loc.getDirection().normalize().multiply(2);

		double damage = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.STRENGTH);

		//todo: work with falling blocks
		FallingBlock fb = loc.getWorld().spawnFallingBlock(loc, Material.BLUE_ICE, (byte) 0);
		fb.setHurtEntities(false);
		fb.setDropItem(false);
		fb.setVelocity(v);

		new BukkitRunnable() {

			int counter;

			@Override
			public void run() {
				if(counter > 5){

					triggerEnd(player, level);
					this.cancel();

				}

				java.util.List<Entity> entityList = fb.getNearbyEntities(1.0, 1.0, 1.0);
				entityList.remove(fb);
				entityList.remove(player);

				if(entityList.size() > 0){

					LivingEntity le = ((LivingEntity)entityList.get(0));

					le.damage(le.hasPotionEffect(PotionEffectType.SLOW)?(damage * 2.5):(damage * 2));

					triggerEnd(player, level);
					this.cancel();

				}

				counter++;

			}
		}.runTaskTimer(Core.plugin(), 1L, 1L);

		// Handling of the skill goes here
		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
