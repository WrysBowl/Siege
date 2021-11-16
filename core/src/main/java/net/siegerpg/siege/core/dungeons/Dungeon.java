package net.siegerpg.siege.core.dungeons;

import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class Dungeon {

	public String bossName;
	public int maxKeyCount;
	public CustomKey reqKey;
	public Location spawnLoc;
	public String world;
	public int bossSpawnDelay = 0;

	//variable
	public Entity boss = null;
	public int currentKeyCount = 0;

	public Dungeon (String bossName, int maxKeyCount, CustomKey reqKey, Location spawnLoc, String world, int bossSpawnDelay) {

		this.bossName = bossName;
		this.maxKeyCount = maxKeyCount;
		this.reqKey = reqKey;
		this.spawnLoc = spawnLoc;
		this.world = world;
		this.bossSpawnDelay = bossSpawnDelay;
	}

	public void spawning () {
		//placeholder
	}

	//Add new wait variable to use for bukkit scheduler in spawning method
	//Create new method to be called before scheduler
}
