package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.LichKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.utils.Utils;

public class Lich extends MobDropTable {
    public Lich() {
        super("Lich", 1150, 3000, 2800, 3000, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 20.0),
                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 40.0),
                new Reward(RefinedMetal.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 50.0),
                new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false).asQuantity(10), 20.0),

                new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 80.0),
                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 40.0),
                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 40.0),
                new Reward(new LichKey(0).getUpdatedItem(false), 10.0)

        });
    }
}