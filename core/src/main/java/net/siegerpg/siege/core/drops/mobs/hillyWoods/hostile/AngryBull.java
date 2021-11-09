package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.utils.Utils;

public class AngryBull extends MobDropTable {
    public AngryBull() {
        super("AngryBull", 17, 20, 26, 29, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 80.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 8.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 5.0),

                new Reward(new LeatherHelmet(50).getUpdatedItem(false), 2.5),
                new Reward(new LeatherChestplate(50).getUpdatedItem(false), 2.5),
                new Reward(new LeatherLeggings(50).getUpdatedItem(false), 2.5),
                new Reward(new LeatherBoots(50).getUpdatedItem(false), 2.5),

                new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

                new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new Beef(50).getUpdatedItem(false), 20.0),

                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 0.25),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 0.25),
        });
    }
}
