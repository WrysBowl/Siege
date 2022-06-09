package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class UndeadRevival extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final int healAmt = 10; //amount to multiply damage by

	public UndeadRevival() {
		this.identifier = "3_A_2";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Undead Revival";
		this.description = List.of(
				"Heals 10 HP/sec, but poison heals",
				"an additional 10 HP/sec for every",
				"level you are effected by for 30 seconds"
		                          );
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

		return List.of(
				"Heals "+getHealAmt(level, false)+" HP/sec, but poison heals",
				"an additional "+getHealAmt(level, true)+" HP/sec for every",
				"level you are effected by for 30 seconds"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.07));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 3.0);
	}

	public int getHealAmt(int level, boolean poisoned) {

		if (poisoned) return (this.healAmt) + (level-1);
		return this.healAmt;
	}



	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		return super.trigger(player, level);

		// Handling of the skill goes here
		new BukkitRunnable() {

			int counter = 0;
			@Override
			public void run() {
				//Run for 30 seconds
				if (counter >= 30) {
					triggerEnd(player, level);
					this.cancel();
				}

				PlayerData.addHealth(player, 10);

				Collection<PotionEffect> effects = player.getActivePotionEffects();
       
        		for(PotionEffect effect : effects) {
           
           			if(effect.getType() == PotionEffectType.POSION) {
               
                		Switch(effect.getAmplifier()) {
							case 1:
								PlayerData.addHealth(player, 10);
								break;
							case 2:
								PlayerData.addHealth(player, 20);
								break;
							case 3:
								PlayerData.addHealth(player, 30);
								break;
							case 4:
								PlayerData.addHealth(player, 40);
								break;
							case 5:
								PlayerData.addHealth(player, 50);
								break;
							case 6:
								PlayerData.addHealth(player, 60);
								break;
							case 7:
								PlayerData.addHealth(player, 70);
								break;
							case 8:
								PlayerData.addHealth(player, 80);
								break;
							case 9:
								PlayerData.addHealth(player, 90);
								break;
							case 10:
								PlayerData.addHealth(player, 100);
								break;
						}
           	 		}
        		}
			}

		}.runTaskTimer(Core.plugin(), 0, 20);

		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
