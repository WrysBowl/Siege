package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.Torch;
import net.siegerpg.siege.core.utils.Utils;

public class MagmaSpirit extends MobDropTable {
    public MagmaSpirit() {
        super("MagmaSpirit", 1500, 1800, 1500, 1800, new Reward[]{
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 100.0),
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 30.0),
                new Reward(Magma.Companion.tier(4).getUpdatedItem(false).asQuantity(2), 10.0),

                new Reward(new MagmaHelmet(100).getUpdatedItem(false), 5.5),
                new Reward(new MagmaChestplate(100).getUpdatedItem(false), 5.5),
                new Reward(new MagmaLeggings(100).getUpdatedItem(false), 5.5),
                new Reward(new MagmaBoots(100).getUpdatedItem(false), 5.5),

                new Reward(new MagmaHelmet(80).getUpdatedItem(false), 10.5),
                new Reward(new MagmaChestplate(80).getUpdatedItem(false), 10.5),
                new Reward(new MagmaLeggings(80).getUpdatedItem(false), 10.5),
                new Reward(new MagmaBoots(80).getUpdatedItem(false), 10.5),

                new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
                new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),
                
                new Reward(new Torch(100).getUpdatedItem(false), 20.0),
                new Reward(new Torch(Utils.randRarity()).getUpdatedItem(false), 25.0),

                new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 10.0),
                new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 10.0),
                new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 10.0),
                new Reward(new CrackedToughGem(0).getUpdatedItem(false), 10.0),
                new Reward(new CrackedHealthGem(0).getUpdatedItem(false), 10.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 5.0),
                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 5.0),
                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 5.0),
                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 5.0),
                new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 5.0),
        });
    }
}