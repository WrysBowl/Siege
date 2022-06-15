package net.siegerpg.siege.core.customEvents.events;

import io.lumine.xikage.mythicmobs.*;
import io.lumine.xikage.mythicmobs.mobs.*;
import kotlin.*;
import lombok.*;
import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.customEvents.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.*;

import java.util.*;

public class Nightmare extends CustomEvent {

	BukkitTask currentTask;

	public ArrayList<String> spawnableMobNames = new ArrayList<>(){
		{
			add("Zombified_Digger");
			add("Goblin");
			add("Golden_Goblin");
			add("Nightmare");
			add("Infected_Digger");
			add("Corrupted_Skeleton");
			add("Skeletal_Warrior");
			add("Skeletal_Archer");
			add("Dark_Fairy");

		}
	};

	public Nightmare() {
		this.duration = 600;
	}

	public Nightmare(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(20.0);
	}

	@Override
	public void action() {

		for (World world : Bukkit.getServer().getWorlds()) {
			world.setTime(18000);
			world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
		}

		this.currentTask = new BukkitRunnable() {
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) { //trigger all events
					Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);

					//if it's a new player return
					if (expLevel == null) return;

					//targets only people above level 7
					if (expLevel.getFirst() < 8) return;

					Location loc = player.getLocation();

					//determining the mobs
					ArrayList<String> mobsToSpawn = new ArrayList<>();

					int amtOfMobs = (int)(Math.random()*spawnableMobNames.size())-1;
					if (amtOfMobs < 1) amtOfMobs = 0;

					for (int i = 0; i < amtOfMobs; i++) {
						int randomIndex = (int)Math.floor(Math.random()*spawnableMobNames.size());
						mobsToSpawn.add(spawnableMobNames.get(randomIndex));
					}

					//announcing the mobs
					Bukkit.broadcast(Utils.parse(""));
					Bukkit.broadcast(Utils.parse("<color:#962929>Nightmare!"));
					Bukkit.broadcast(Utils.parse("<color:#e37571>Mobs will be spawning on "+player.getName()+" in 10 seconds!"));
					Bukkit.broadcast(Utils.parse(""));

					//spawning the mobs
					new BukkitRunnable() {
						@SneakyThrows
						@Override
						public void run() {

							for (String mobNames : mobsToSpawn) {
								MythicMobs.inst().getAPIHelper().spawnMythicMob(mobNames, loc);
							}
						}
					}.runTaskLater(Core.plugin(), 200L); //spawns mob 10 seconds later

				}
			}
		}.runTaskTimer(Core.plugin(), 0, 1200L); //checks for event every 120 seconds

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#962929>Nightmare!"));
		Bukkit.broadcast(Utils.parse("<gray>Duration (<aqua>"+Utils.secondsToHHMMSS(this.duration)+"<gray>)"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#e37571>Undead mobs will spawn around people who are alone"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

	@Override
	public void clearAction() {

		this.currentTask.cancel();
		for (World world : Bukkit.getServer().getWorlds()) {
			world.setTime(0);
			world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
		}
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>Your nightmare is over!"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
