package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Tridents.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters.*;
import net.siegerpg.siege.core.utils.Utils;

public class Sea_Warrior extends MobDropTable {
    public Sea_Warrior() {
        super("Sea_Warrior", 47, 50, 56, 59, new Reward[]{
                new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false).asQuantity(2), 100.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false).asQuantity(1), 10.0),
                new Reward(Chain.Companion.tier(1).getUpdatedItem(false).asQuantity(2), 100.0),
                new Reward(Chain.Companion.tier(2).getUpdatedItem(false).asQuantity(1), 10.0),

                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 1.0),
        });
    }
}