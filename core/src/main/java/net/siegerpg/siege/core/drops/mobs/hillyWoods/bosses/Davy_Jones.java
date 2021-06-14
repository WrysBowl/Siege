package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;

public class Davy_Jones extends MobDropTable {
    public Davy_Jones() {
        super("Davy_Jones", 1000, 1100, 2000, 2200, new Reward[]{
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(new Trident(Utils.randRarity()).getUpdatedItem(false), 100.0),
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new Trident(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new SimpleHealthGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new SimpleToughGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new SimpleStrengthGem(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new SimpleLuckGem(Utils.randRarity()).getUpdatedItem(false), 20.0)
        });
    }
}