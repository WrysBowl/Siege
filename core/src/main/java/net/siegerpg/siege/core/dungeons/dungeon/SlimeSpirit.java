package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SlimeSpirit extends Dungeon {

    public SlimeSpirit() {
        super("SlimeSpirit", 8,
                new SlimeSpiritKey(0),
                new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), -169, 70, 24)
        );
    }
}
