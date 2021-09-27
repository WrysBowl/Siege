package net.siegerpg.siege.core.dungeons.dungeon;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.utils.particleEffects.Helix;
import net.siegerpg.siege.core.utils.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;

public class SlimeSpirit extends Dungeon {

    public SlimeSpirit() {
        super("SlimeSpirit", 8,
                new SlimeSpiritKey(0),
                new Location(null, -169, 70, 24), "Hilly_Woods",
                100
        );
    }

    @Override
    public void spawning() {
        Location loc = new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), -169, 70, 24);
        new Helix().createHelix(loc);

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            new Waves().createWaves(loc);
            loc.getWorld().playSound(loc, Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
        }, 80);
    }
}