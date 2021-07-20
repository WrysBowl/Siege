package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class BullSpirit extends MobDropTable {
    public BullSpirit() {
        super("SlimeSpirit", 700, 800, 800, 900, new Reward[]{
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 40.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(16), 50.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(16), 50.0),
                new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),
        });
    }
}