package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.SewerShooter;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class ForestSpider extends MobDropTable {
    public ForestSpider() {
        super("ForestSpider", 27, 30, 36, 39, new Reward[]{
                new Reward(Vine.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 100.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(2), 10.0),
                new Reward(Vine.Companion.tier(3).getUpdatedItem(false), 1.0),

                new Reward(new SewerShooter(50).getUpdatedItem(false), 1.0),
                new Reward(new LuckySewerShooter(50).getUpdatedItem(false), 1.0),
                new Reward(new StrongSewerShooter(50).getUpdatedItem(false), 1.0),
                new Reward(new HealingSewerShooter(50).getUpdatedItem(false), 1.0),

                new Reward(new SewerShooter(30).getUpdatedItem(false), 3.0),
                new Reward(new LuckySewerShooter(30).getUpdatedItem(false), 3.0),
                new Reward(new StrongSewerShooter(30).getUpdatedItem(false), 3.0),
                new Reward(new HealingSewerShooter(30).getUpdatedItem(false), 3.0),

                new Reward(new Crossbow(50).getUpdatedItem(false), 1.0),
                new Reward(new HealthyCrossbow(50).getUpdatedItem(false), 1.0),
                new Reward(new ToughCrossbow(50).getUpdatedItem(false), 1.0),
                new Reward(new HealingCrossbow(50).getUpdatedItem(false), 1.0),

                new Reward(new Crossbow(30).getUpdatedItem(false), 3.0),
                new Reward(new HealthyCrossbow(30).getUpdatedItem(false), 3.0),
                new Reward(new HealingCrossbow(30).getUpdatedItem(false), 3.0),
                new Reward(new ToughCrossbow(30).getUpdatedItem(false), 3.0),

                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
