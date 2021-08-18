package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.MagmaSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.utils.Utils;

public class MagmaSpirit extends MobDropTable {
    public MagmaSpirit() {
        super("MagmaSpirit", 1250, 1300, 750, 850, new Reward[]{
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false), 40.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Seed.Companion.tier(3).getUpdatedItem(false).asQuantity(16), 100.0),
                new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new MagmaSpiritKey(0).getUpdatedItem(false), 10.0)
        });
    }
}