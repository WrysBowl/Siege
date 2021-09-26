package net.siegerpg.siege.core.dungeons;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class Dungeon {
    final String bossName;
    final int maxKeyCount;
    final CustomKey reqKey;
    final Location spawnLoc;
    Entity boss = null;
    int currentKeyCount = 0;

    public Dungeon(String bossName, int maxKeyCount, CustomKey reqKey, Location spawnLoc) {
        this.bossName = bossName;
        this.maxKeyCount = maxKeyCount;
        this.reqKey = reqKey;
        this.spawnLoc = spawnLoc;
    }
}
