package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Ogre extends MobDropTable {
    public Ogre() {
        super("Ogre", 250, 300, 300, 325, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 40.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 6.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 60.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 6.0),

                new Reward(new BoneHelmet(100).getUpdatedItem(false), 0.5),
                new Reward(new BoneChestplate(100).getUpdatedItem(false), 0.5),
                new Reward(new BoneLeggings(100).getUpdatedItem(false), 0.5),
                new Reward(new BoneBoots(100).getUpdatedItem(false), 0.5),

                new Reward(new BoneHelmet(80).getUpdatedItem(false), 2.5),
                new Reward(new BoneChestplate(80).getUpdatedItem(false), 2.5),
                new Reward(new BoneLeggings(80).getUpdatedItem(false), 2.5),
                new Reward(new BoneBoots(80).getUpdatedItem(false), 2.5),

                new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 3.0),

                new Reward(new GreatSword(100).getUpdatedItem(false), 0.5),
                new Reward(new GreatSword(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.5),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 2.0),
                new Reward(new NecromancerKey(0).getUpdatedItem(false), 10.0),
        });
    }
}