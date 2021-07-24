package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;


public class ZombifiedDigger extends MobDropTable {
    public ZombifiedDigger() {
        super("ZombifiedDigger", 20, 23, 17, 20, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 60.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 6.0),
                new Reward(new Beetroot(50).getUpdatedItem(false), 10.0),
                new Reward(new Beetroot(0).getUpdatedItem(false), 50.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 10.0),
                new Reward(new CrackedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new RawRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false), 1.0)
        });
    }
}
