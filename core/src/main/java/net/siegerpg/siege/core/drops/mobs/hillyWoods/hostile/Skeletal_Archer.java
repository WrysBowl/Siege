package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.FlamingHotTorch;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.SplinteredBone;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ReinforcedBow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.reinforcedBows.*;
import net.siegerpg.siege.core.utils.Utils;


public class Skeletal_Archer extends MobDropTable {
    public Skeletal_Archer() {
        super("Skeletal_Archer", 40, 50, 50, 60, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 1.0),

                new Reward(new BoneHelmet(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneChestplate(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneLeggings(50).getUpdatedItem(false), 2.5),
                new Reward(new BoneBoots(50).getUpdatedItem(false), 2.5),

                new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),
                
                new Reward(new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new HealingCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new ToughCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new StrongCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.5),
                
                new Reward(new ReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new HealingReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new HealthyReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new ToughReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new StrongReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new LuckyReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 2.5),
                
                new Reward(new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 1.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 0.5),
        });
    }
}
