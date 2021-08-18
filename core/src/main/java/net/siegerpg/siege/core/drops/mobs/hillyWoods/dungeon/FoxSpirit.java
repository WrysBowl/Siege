package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.utils.Utils;

public class FoxSpirit extends MobDropTable {
    public FoxSpirit() {
        super("FoxSpirit", 2000, 2200, 1200, 1250, new Reward[]{
                new Reward(new Shank(Utils.randRarity()).getUpdatedItem(false), 80.0),
                new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 80.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 40.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 60.0),
                new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 40.0),
                new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 80.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 60.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 60.0),
                new Reward(new FoxSpiritKey(0).getUpdatedItem(false), 10.0)

        });
    }
}