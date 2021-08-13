package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BroodmotherKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.EarthernHammer;
import net.siegerpg.siege.core.utils.Utils;

public class Broodmother extends MobDropTable {
    public Broodmother() {
        super("Broodmother", 1300, 1500, 1300, 1500, new Reward[]{
                new Reward(Vine.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 40.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 30.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false).asQuantity(16), 30.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(new EarthernHammer(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 10.0),

                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 50.0),
                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 40.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 50.0),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 30.0),
                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 50.0),
                new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 30.0),
                new Reward(new BroodmotherKey(0).getUpdatedItem(false), 10.0)

        });
    }
}