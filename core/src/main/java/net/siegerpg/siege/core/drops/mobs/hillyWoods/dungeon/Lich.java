package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword;
import net.siegerpg.siege.core.utils.Utils;

public class Lich extends MobDropTable {
    public Lich() {
        super("Lich", 1340, 1400, 1320, 1380, new Reward[]{
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 100.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 10.0),
                new Reward(Seed.Companion.tier(4).getUpdatedItem(false).asQuantity(4), 1.0),

                new Reward(Coal.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 100.0),
                new Reward(Coal.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 10.0),
                new Reward(Coal.Companion.tier(4).getUpdatedItem(false).asQuantity(4), 1.0),

                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 100.0),
                new Reward(Vine.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 10.0),
                new Reward(Vine.Companion.tier(4).getUpdatedItem(false).asQuantity(4), 1.0),

                new Reward(new GreatSword(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new GreatSword(100).getUpdatedItem(false), 20.0),
                new Reward(new GreatSword(80).getUpdatedItem(false), 30.0),

                new Reward(new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new FlamingHotTorch(100).getUpdatedItem(false), 20.0),
                new Reward(new FlamingHotTorch(80).getUpdatedItem(false), 30.0),

                new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new EarthernWand(100).getUpdatedItem(false), 20.0),
                new Reward(new EarthernWand(80).getUpdatedItem(false), 30.0),

                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 45.0),
                new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 45.0),
        });
    }
}