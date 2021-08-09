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

public class BroodMother extends MobDropTable {
    public BroodMother() {
        super("BroodMother", 1500, 1700, 2200, 2400, new Reward[]{
                new Reward(Vine.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 40.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 30.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false).asQuantity(16), 30.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(new EarthernHammer(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 10.0),

                new Reward(new FlawedToughGem(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new SimpleToughGem(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new PolishedToughGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new FlawedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new SimpleRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new FlawedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new SimpleLuckGem(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new BroodmotherKey(0).getUpdatedItem(false), 10.0)

        });
    }
}