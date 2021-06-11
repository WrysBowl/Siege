package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class Davy_Jones extends MobDropTable {
    public Davy_Jones() {
        super("Davy_Jones", 1000, 1100, 2000, 2200, new Reward[]{
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(new Trident(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new Trident(Utils.randRarity()).getUpdatedItem(false), 50.0)
        });
    }
}