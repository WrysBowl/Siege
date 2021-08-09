package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.RockSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class RockSpirit extends MobDropTable {
    public RockSpirit() {
        super("RockSpirit", 200, 300, 150, 200, new Reward[]{
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new RockWand(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new RockSpiritKey(0).getUpdatedItem(false), 10.0)
        });
    }
}