package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BullSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class DeathBull extends MobDropTable {
    public DeathBull() {
        super("DeathBull", 37, 40, 46, 49, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 80.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 8.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 5.0),

                new Reward(new LeatherHelmet(80).getUpdatedItem(false), 1.5),
                new Reward(new LeatherChestplate(80).getUpdatedItem(false), 1.5),
                new Reward(new LeatherLeggings(80).getUpdatedItem(false), 1.5),
                new Reward(new LeatherBoots(80).getUpdatedItem(false), 1.5),

                new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

                new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 1.5),

                new Reward(new Beef(100).getUpdatedItem(false), 40.0),
                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 0.25),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new BullSpiritKey(0).getUpdatedItem(false), 10.0),
        });
    }
}
