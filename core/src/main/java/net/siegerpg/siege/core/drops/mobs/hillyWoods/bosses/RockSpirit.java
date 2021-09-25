package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.GrieferChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.LichKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.RockSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class RockSpirit extends MobDropTable {
    public RockSpirit() {
        super("RockSpirit", 67, 70, 66, 69, new Reward[]{
                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 100.0),
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 10.0),
                new Reward(Pebble.Companion.tier(4).getUpdatedItem(false).asQuantity(4), 1.0),

                new Reward(new GrieferChestplate(Utils.randRarity()).getUpdatedItem(false), 4.0),
                new Reward(new GrieferChestplate(100).getUpdatedItem(false), 1.0),
                new Reward(new GrieferChestplate(80).getUpdatedItem(false), 3.0),

                new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 4.0),
                new Reward(new JaggedTunic(100).getUpdatedItem(false), 1.0),
                new Reward(new JaggedTunic(80).getUpdatedItem(false), 3.0),

                new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 4.0),
                new Reward(new PebbleShooter(100).getUpdatedItem(false), 1.0),
                new Reward(new PebbleShooter(80).getUpdatedItem(false), 2.0),

                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 5.0),
                new Reward(new LichKey(0).getUpdatedItem(false), 10.0),
        });
    }
}