package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.DullLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.DullStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class BanditArcher extends MobDropTable {
    public BanditArcher() {
        super("BanditArcher", 20, 24, 52, 56, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 2.5),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 15.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 1.5),
                new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false), 7.5),
                new Reward(new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new FlawedLuckGem(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new DullLuckGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new DullStrengthGem(Utils.randRarity()).getUpdatedItem(false), 2.0)
        });
    }
}
