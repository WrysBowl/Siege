package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.CrystalCane;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class Moss_Lurker extends MobDropTable {
    public Moss_Lurker() {
        super("Moss_Lurker", 200, 300, 250, 350, new Reward[]{
                new Reward(Ectoplasm.Companion.tier(1).getUpdatedItem(false).asQuantity(4), 25.0),
                new Reward(Ectoplasm.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false).asQuantity(16), 25.0),
                new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 5.0),

                new Reward(new PolishedToughGem(0).getUpdatedItem(false), 2.0),
                new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new CrystalCane(Utils.randRarity()).getUpdatedItem(false), 2.5),
        });
    }
}
