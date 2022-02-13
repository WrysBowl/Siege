package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.commands.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import net.siegerpg.siege.core.parties.*;
import net.siegerpg.siege.core.skills.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.*;

public class DivinePresence extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 2500;
	final double healthMulti = 1.25;
	final int _radius = 8;
	final int _time = 10;

	public DivinePresence() {
		this.identifier = "3_A_3";
		this.skillClass = SkillClass.WARRIOR;
		this.name = "Divine Presence";
		this.description = List.of("Summon lightning to heal",
		                           "allies by +25% and weaken",
		                           "enemies by 20% for 10 seconds",
		                           "within 8 meters.");
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

		return List.of("Summon lightning to regenerate",
		               "ally health by +" + ((getHealthMulti(level) - 1) * 100) + "% and weaken",
		               "enemies by 20% for 10 seconds",
		               "within 8 meters.");
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
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getHealthMulti(int level) {
		return Utils.round(((this.healthMulti) + ((level - 1) * 0.01)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;


		Location loc = player.getLocation();
		List<Location> locsAffected = Utils.getCircle(loc, _radius, 30);


		//Particle and sound effect when clicked
		player.getLocation().getWorld().strikeLightningEffect(loc);
		player.playSound(loc, Sound.BLOCK_BELL_USE, 10f, 0.5f);


		ActiveSkillData.addToActiveSkills(player, this);

		//This is the loop that check if a player is in the radius and give them the effect
		new BukkitRunnable(){
			int time=0;
			@Override
			public void run() {

				if(time<=_time)
					this.cancel();


				for(Location toParticle: locsAffected) {
					toParticle.getWorld().spawnParticle(Particle.HEART, toParticle.add(new Vector(0, 0.3, 0)), 1);
				}


				Party party = Party.Companion.getPlayerParty(player);
				for(Player p : loc.getNearbyPlayers(_radius, 2)) {
					//code to execute every second that the player is in the radius
					p.playSound(loc, Sound.BLOCK_BELL_USE, 10f, 0.5f);
					if(player.getUniqueId().equals(p.getUniqueId()) || (party != null && party.isMember(p))) {
						player.setHealth(player.getHealth() * ((getHealthMulti(level) - 1) * 100));
						player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1, 2));
					}
					else
					{
						player.setHealth(player.getHealth()*0.80);
					}
				}
				time++;


			}
		}.runTaskTimer(Core.plugin(), 0, 20);


		// Handling of the skill goes here

		Skill skill = this;
		Bukkit.getScheduler().runTaskLater(Core.plugin(), new Runnable() {
			@Override
			public void run() {
				ActiveSkillData.removeFromActiveSkills(player, skill);
			}
		}, _time*20);
		return false;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

	public int getRadius() {
		return this._radius;
	}
	public int getTime() {
		return this._time;
	}

}
