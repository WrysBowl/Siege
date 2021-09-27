package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.utils.particleEffects.Helix;
import org.bukkit.Location;

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
        new Helix().createHelix(new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), -169, 70, 24));
    }
}