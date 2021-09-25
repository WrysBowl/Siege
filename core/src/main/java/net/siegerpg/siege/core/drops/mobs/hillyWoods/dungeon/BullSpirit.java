package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BullSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.utils.Utils;

public class BullSpirit extends MobDropTable {
    public BullSpirit() {
        super("BullSpirit", 740, 800, 920, 980, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 80.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false).asQuantity(2), 8.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false).asQuantity(2), 25.0),

                new Reward(new LeatherHelmet(100).getUpdatedItem(false), 20.5),
                new Reward(new LeatherChestplate(100).getUpdatedItem(false), 20.5),
                new Reward(new LeatherLeggings(100).getUpdatedItem(false), 20.5),
                new Reward(new LeatherBoots(100).getUpdatedItem(false), 20.5),

                new Reward(new LeatherHelmet(80).getUpdatedItem(false), 25.5),
                new Reward(new LeatherChestplate(80).getUpdatedItem(false), 25.5),
                new Reward(new LeatherLeggings(80).getUpdatedItem(false), 25.5),
                new Reward(new LeatherBoots(80).getUpdatedItem(false), 25.5),

                new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),

                new Reward(new DoubleBladedAxe(100).getUpdatedItem(false), 20.5),
                new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 25.5),

                new Reward(new Beef(100).getUpdatedItem(false), 20.0),
                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 0.25),
                new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new BullSpiritKey(0).getUpdatedItem(false), 10.0),

        });
    }
}