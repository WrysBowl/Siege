package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.RockSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PristineHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PristineLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PristineStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ScrapShard;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.SplinteredBone;
import net.siegerpg.siege.core.utils.Utils;

public class FoxSpirit extends MobDropTable {
    public FoxSpirit() {
        super("FoxSpirit", 9000, 10000, 10000, 11000, new Reward[]{
                new Reward(Chain.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 60.0),
                new Reward(Chain.Companion.tier(3).getUpdatedItem(false), 12.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 60.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 12.0),

                new Reward(new ChainHelmet(100).getUpdatedItem(false), 5.5),
                new Reward(new ChainChestplate(100).getUpdatedItem(false), 5.5),
                new Reward(new ChainLeggings(100).getUpdatedItem(false), 5.5),
                new Reward(new ChainBoots(100).getUpdatedItem(false), 5.5),

                new Reward(new ChainHelmet(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainChestplate(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainLeggings(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainBoots(80).getUpdatedItem(false), 20.5),

                new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),

                new Reward(new SplinteredBone(100).getUpdatedItem(false), 5.5),
                new Reward(new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 20.5),

                new Reward(new ScrapShard(100).getUpdatedItem(false), 5.5),
                new Reward(new ScrapShard(Utils.randRarity()).getUpdatedItem(false), 20.5),

                new Reward(new PristineRegenerationGem(0).getUpdatedItem(false), 5.0),
                new Reward(new PristineStrengthGem(0).getUpdatedItem(false), 5.0),
                new Reward(new PristineLuckGem(0).getUpdatedItem(false), 5.0),
                new Reward(new PristineToughGem(0).getUpdatedItem(false), 5.0),
                new Reward(new PristineHealthGem(0).getUpdatedItem(false), 5.0),
                new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 10.0),
                new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 10.0),
                new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 10.0),
                new Reward(new PolishedToughGem(0).getUpdatedItem(false), 10.0),
                new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 10.0),
        });
    }
}