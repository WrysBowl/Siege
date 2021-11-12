package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.*;
import net.siegerpg.siege.core.utils.Utils;

public class SlimeSpirit extends MobDropTable {
    public SlimeSpirit() {
        super("SlimeSpirit", 340, 400, 340, 500, new Reward[]{
                new Reward(Slime.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 100.0),
                new Reward(Slime.Companion.tier(3).getUpdatedItem(false).asQuantity(3), 30.0),
                new Reward(Slime.Companion.tier(4).getUpdatedItem(false).asQuantity(2), 10.0),

                new Reward(new SlimeSpoofer(100).getUpdatedItem(false), 5.0),
                new Reward(new SlimeSpoofer(80).getUpdatedItem(false), 30.0),
                new Reward(new SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 5.0),

                new Reward(new SlimyHelmet(100).getUpdatedItem(false), 5.0),
                new Reward(new SlimyChestplate(100).getUpdatedItem(false), 5.0),
                new Reward(new SlimyLeggings(100).getUpdatedItem(false), 5.0),
                new Reward(new SlimyBoots(100).getUpdatedItem(false), 5.0),

                new Reward(new SlimyHelmet(80).getUpdatedItem(false), 3.0),
                new Reward(new SlimyChestplate(80).getUpdatedItem(false), 3.0),
                new Reward(new SlimyLeggings(80).getUpdatedItem(false), 3.0),
                new Reward(new SlimyBoots(80).getUpdatedItem(false), 3.0),

                new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
                new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
                new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
                new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),

                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 10.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 10.0),
        });
    }
}