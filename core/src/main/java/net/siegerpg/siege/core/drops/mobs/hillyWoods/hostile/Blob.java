package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.*;

public class Blob extends MobDropTable {
    public Blob() {
        super("Blob", 7, 10, 7, 10, new Reward[]{
                new Reward(Slime.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Slime.Companion.tier(2).getUpdatedItem(false), 10.0),

                new Reward(new StickyStick(0).getUpdatedItem(false), 5.0),
                new Reward(new LuckyStickyStick(0).getUpdatedItem(false), 2.0),
                new Reward(new StrongStickyStick(0).getUpdatedItem(false), 2.0),
                new Reward(new HealthyStickyStick(0).getUpdatedItem(false), 2.0),
                new Reward(new HealingStickyStick(0).getUpdatedItem(false), 2.0),
                new Reward(new ToughStickyStick(0).getUpdatedItem(false), 2.0),

                new Reward(new SlimyHelmet(0).getUpdatedItem(false), 5.0),
                new Reward(new SlimyChestplate(0).getUpdatedItem(false), 5.0),
                new Reward(new SlimyLeggings(0).getUpdatedItem(false), 5.0),
                new Reward(new SlimyBoots(0).getUpdatedItem(false), 5.0),


                new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 1.0),
                new Reward(new RawLuckGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
