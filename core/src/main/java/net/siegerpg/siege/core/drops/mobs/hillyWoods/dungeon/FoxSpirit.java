package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.utils.Utils;

public class FoxSpirit extends MobDropTable {
    public FoxSpirit() {
        super("SlimeSpirit", 180, 200, 250, 270, new Reward[]{
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 100.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false), 100.0),
                new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new RockWand(Utils.randRarity()).getUpdatedItem(false), 60.0)
        });
    }
}