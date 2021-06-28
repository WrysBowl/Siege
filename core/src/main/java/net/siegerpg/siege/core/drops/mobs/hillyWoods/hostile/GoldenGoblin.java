package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import net.siegerpg.siege.core.utils.Utils;


public class GoldenGoblin extends MobDropTable {
    public GoldenGoblin() {
        super("Goblin", 100, 115, 30, 36, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 100.0),
                new Reward(new Twig(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(new CrackedLuckGem(Utils.randRarity()).getUpdatedItem(false), 10.0),
                new Reward(new RawLuckGem(Utils.randRarity()).getUpdatedItem(false), 20.0)
        });
    }
}
