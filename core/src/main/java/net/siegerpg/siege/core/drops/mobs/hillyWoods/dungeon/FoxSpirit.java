package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.utils.Utils;

public class FoxSpirit extends MobDropTable {
    public FoxSpirit() {
        super("FoxSpirit", 800, 900, 800, 900, new Reward[]{
                new Reward(new Shank(Utils.randRarity()).getUpdatedItem(false), 80.0),
                new Reward(new CrackedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 80.0),
                new Reward(new FlawedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new FlawedLuckGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleLuckGem(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new CrackedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 80.0),
                new Reward(new FlawedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 40.0),
                new Reward(new FlawedLuckGem(Utils.randRarity()).getUpdatedItem(false), 60.0),
                new Reward(new SimpleLuckGem(Utils.randRarity()).getUpdatedItem(false), 40.0)
        });
    }
}