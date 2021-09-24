package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.utils.Utils;


public class ZombifiedDigger extends MobDropTable {
    public ZombifiedDigger() {
        super("ZombifiedDigger", 50, 53, 57, 60, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 60.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 6.0),

                new Reward(new BoneHelmet(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneChestplate(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneLeggings(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneBoots(50).getUpdatedItem(false), 2.5),

                new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

                new Reward(new Beetroot(50).getUpdatedItem(false), 10.0),
                new Reward(new Beetroot(0).getUpdatedItem(false), 50.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 10.0),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 1.0),
                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 2.0),
        });
    }
}
