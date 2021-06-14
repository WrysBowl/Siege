package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.utils.Utils;

public class Ogre extends MobDropTable {
    public Ogre() {
        super("Ogre", 800, 900, 1500, 1600, new Reward[]{
                new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 100.0),
                new Reward(Bone.Companion.tier(4).getUpdatedItem(false), 50.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(new GoldenCarrot(100).getUpdatedItem(false), 100.0),
                new Reward(new GoldenCarrot(100).getUpdatedItem(false), 100.0),
                new Reward(new SimpleHealthGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new SimpleRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new SimpleStrengthGem(Utils.randRarity()).getUpdatedItem(false), 20.0)
        });
    }
}