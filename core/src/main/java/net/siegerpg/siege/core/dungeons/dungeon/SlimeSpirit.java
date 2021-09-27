package net.siegerpg.siege.core.dungeons.dungeon;

import lombok.SneakyThrows;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.particleEffects.Helix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SlimeSpirit extends Dungeon implements Runnable {

    public SlimeSpirit() {
        super("SlimeSpirit", 8,
                new SlimeSpiritKey(0),
                new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), -169, 70, 24)
        );
    }

    @Override
    public void spawning() {
        //Run a scheduler to spawn the boss after x seconds
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), this, 100);
        new Helix().createHelix(new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), -169, 70, 24));

    }

    @SneakyThrows
    @Override
    public void run() {
        bossSpawn();
    }
}
