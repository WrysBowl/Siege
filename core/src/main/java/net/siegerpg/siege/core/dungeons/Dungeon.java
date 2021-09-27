package net.siegerpg.siege.core.dungeons;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class Dungeon {
    String bossName;
    int maxKeyCount;
    CustomKey reqKey;
    Location spawnLoc;
    Entity boss = null;
    int currentKeyCount = 0;

    public Dungeon(String bossName, int maxKeyCount, CustomKey reqKey, Location spawnLoc) {
        this.bossName = bossName;
        this.maxKeyCount = maxKeyCount;
        this.reqKey = reqKey;
        this.spawnLoc = spawnLoc;
    }
    public void spawning() throws InvalidMobTypeException {
        bossSpawn();
    }
    public void bossSpawn() throws InvalidMobTypeException {
        this.boss = MythicMobs.inst().getAPIHelper().spawnMythicMob(bossName, spawnLoc);
    }

}
