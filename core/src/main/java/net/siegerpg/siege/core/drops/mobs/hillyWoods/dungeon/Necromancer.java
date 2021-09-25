package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.RecurveBow;
import net.siegerpg.siege.core.utils.Utils;

public class Necromancer extends MobDropTable {
    public Necromancer() {
        super("Necromancer", 1400, 1480, 1500, 1580, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 40.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 6.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 60.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 6.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 60.0),
                new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false), 6.0),

                new Reward(new ChainHelmet(100).getUpdatedItem(false), 10.5),
                new Reward(new ChainChestplate(100).getUpdatedItem(false), 10.5),
                new Reward(new ChainLeggings(100).getUpdatedItem(false), 10.5),
                new Reward(new ChainBoots(100).getUpdatedItem(false), 10.5),

                new Reward(new ChainHelmet(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainChestplate(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainLeggings(80).getUpdatedItem(false), 20.5),
                new Reward(new ChainBoots(80).getUpdatedItem(false), 20.5),

                new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
                new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),

                new Reward(new IronAxe(100).getUpdatedItem(false), 10.5),
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 25.5),

                new Reward(new EarthernWand(100).getUpdatedItem(false), 10.5),
                new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 25.5),

                new Reward(new RecurveBow(100).getUpdatedItem(false), 10.5),
                new Reward(new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 25.5),

                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 15.5),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 25.0),
        });
    }
}