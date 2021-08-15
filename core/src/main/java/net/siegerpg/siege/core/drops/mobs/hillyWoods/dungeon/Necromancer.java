package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.utils.Utils;

public class Necromancer extends MobDropTable {
    public Necromancer() {
        super("Necromancer", 4800, 5000, 2500, 2600, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 20.0),
                new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 20.0),

                new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 80.0),
                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 40.0),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 40.0),
                new Reward(new NecromancerKey(0).getUpdatedItem(false), 10.0)

        });
    }
}