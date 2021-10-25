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
    public String bossName;
    public int maxKeyCount;
    public CustomKey reqKey;
    public Location spawnLoc;
    public String world;
    public int bossSpawnDelay;

    //variable
    public Entity boss;
    public int currentKeyCount;

    public Dungeon(final String bossName, final int maxKeyCount, final CustomKey reqKey, final Location spawnLoc, final String world, final int bossSpawnDelay) {
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
