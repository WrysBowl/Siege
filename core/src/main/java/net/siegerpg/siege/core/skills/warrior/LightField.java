package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.*;

import java.time.*;
import java.util.*;

public class LightField extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final double manaMulti = 1.05;

	public LightField() {
		this.identifier = "3_A_2";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Light Field";
		this.description = List.of("Enemies standing in this",
		                           "circle take 10% of your",
		                           "damage every second.",
		                           "Allies gain +5% mana/second.",
		                           "Lasts 5 seconds.");
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

		return List.of("Enemies standing in this",
		               "circle take 10% of your",
		               "damage every second.",
		               "Allies gain +"+((getManaMulti(level) - 1) * 100)+"% mana/second.",
		               "Lasts 5 seconds.");
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

	public double getManaMulti(int level) {
		return Utils.round(((this.manaMulti) + ((level - 1) * 0.01)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		Location location = player.getLocation();

		double damage = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.STRENGTH);

		double increase = Math.PI / 18;

		new BukkitRunnable(){
			int counter = 1;

			@Override
			public void run() {
				if(counter > 5){
					triggerEnd(player, level);
					this.cancel();
				}


				//particles

				for(int j = 0; j < 36; j++){

					double angle = j * increase;

					Vector v = new Vector(Math.cos(angle) * 5, 0, Math.sin(angle) * 5);

					player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation().add(v), 1);
				}

				//Damage
				for (LivingEntity entity : location.getNearbyLivingEntities(5, 5, 5)) {
					if (entity.equals(player)) continue;

					if(entity instanceof Player){
						//Ally
						Player ally = (Player) entity;

						if (!Utils.isOnlinePlayer(entity)) continue;

						Integer playerMaxMana = PlayerData.playerMana.get(ally);
						Integer playerMana = PlayerData.playerCurrentMana.get(ally);

						if (playerMana != null && playerMaxMana != null) {

							PlayerData.playerCurrentMana.put(ally, Math.min(playerMaxMana, (int) (playerMana * getManaMulti(level))));

						}
					} else{
						//Enemy

						entity.damage(damage / 10, player);

					}
				}

				counter++;
			}
		}.runTaskTimer(Core.plugin(), 20L, 20L);

		return true;

		// Handling of the skill goes here
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
