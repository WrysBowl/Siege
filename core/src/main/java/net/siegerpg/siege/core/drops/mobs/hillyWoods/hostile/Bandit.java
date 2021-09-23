package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger;
import net.siegerpg.siege.core.utils.Utils;

public class Bandit extends MobDropTable {
    public Bandit() {
        super("Bandit", 35, 38, 55, 58, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false), 25.0),

                new Reward(new LeatherHelmet(50).getUpdatedItem(false), 4.5),
                new Reward(new LeatherChestplate(50).getUpdatedItem(false), 4.5),
                new Reward(new LeatherLeggings(50).getUpdatedItem(false), 4.5),
                new Reward(new LeatherBoots(50).getUpdatedItem(false), 4.5),

                new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new Dagger(50).getUpdatedItem(false), 3.0),
                new Reward(new Dagger(Utils.randRarity()).getUpdatedItem(false), 5.0),

                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 2.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
