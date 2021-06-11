package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

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

public class Sea_Warrior extends MobDropTable {
    public Sea_Warrior() {
        super("Sea_Warrior", 12, 15, 20, 23, new Reward[]{
                new Reward(new Trident(Utils.randRarity()).getUpdatedItem(false), 5.0),
                new Reward(new GoldenCarrot(50).getUpdatedItem(false), 5.0)
        });
    }
}