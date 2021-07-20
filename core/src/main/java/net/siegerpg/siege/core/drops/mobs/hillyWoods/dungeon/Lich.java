package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.utils.Utils;

public class Lich extends MobDropTable {
    public Lich() {
        super("Lich", 1400, 1600, 2400, 2600, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(32), 40.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 20.0),
                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 40.0),
                new Reward(RefinedMetal.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 50.0),
                new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false).asQuantity(10), 20.0),

                new Reward(new CrackedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 80.0),
                new Reward(new FlawedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleStrengthGem(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new FlawedToughGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleToughGem(Utils.randRarity()).getUpdatedItem(false), 40.0)
        });
    }
}