package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.DavyJonesKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.LichKey;
import net.siegerpg.siege.core.utils.particleEffects.Helix;
import net.siegerpg.siege.core.utils.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Davy_Jones extends Dungeon {

    public Davy_Jones() {
        super("Davy_Jones", 10,
                new DavyJonesKey(0),
                new Location(null, 242, 91, 87), "Hilly_Woods",
                100
        );
    }

    @Override
    public void spawning() {
        Location loc = new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), 242, 91, 87);
        new Helix().createHelix(loc, Particle.WATER_BUBBLE);

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            new Waves().createWaves(loc);
            loc.getWorld().playSound(loc, Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
        }, 80);
    }
}