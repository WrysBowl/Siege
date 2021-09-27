package net.siegerpg.siege.core.dungeons;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class Dungeon {
    String bossName;
    int maxKeyCount;
    CustomKey reqKey;
    Location spawnLoc;
    String world;
    int bossSpawnDelay = 0;

    //variable
    Entity boss = null;
    int currentKeyCount = 0;

    public Dungeon(String bossName, int maxKeyCount, CustomKey reqKey, Location spawnLoc, String world, int bossSpawnDelay) {
        this.bossName = bossName;
        this.maxKeyCount = maxKeyCount;
        this.reqKey = reqKey;
        this.spawnLoc = spawnLoc;
        this.world = world;
        this.bossSpawnDelay = bossSpawnDelay;
    }

    public void spawning() {
        //placeholder
    }

    //Add new wait variable to use for bukkit scheduler in spawning method
    //Create new method to be called before scheduler
}
