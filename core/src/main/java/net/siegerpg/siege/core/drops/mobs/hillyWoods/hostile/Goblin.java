package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.utils.Utils;


public class Goblin extends MobDropTable {
    public Goblin() {
        super("Goblin", 20, 23, 10, 13, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 5.0),
                new Reward(new Twig(Utils.randRarity()).getUpdatedItem(false), 25.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 5.0),
                new Reward(new CrackedLuckGem(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new RawLuckGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false), 2.0)
        });
    }
}
