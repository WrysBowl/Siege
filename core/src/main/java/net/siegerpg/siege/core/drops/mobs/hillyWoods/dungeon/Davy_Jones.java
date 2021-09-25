package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.DavyJonesKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Tridents.*;
import net.siegerpg.siege.core.utils.Utils;

public class Davy_Jones extends MobDropTable {
    public Davy_Jones() {
        super("Davy_Jones", 1400, 1480, 1500, 1580, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(6), 50.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(6), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 25.0),

                new Reward(new Trident(100).getUpdatedItem(false), 10.0),
                new Reward(new LuckyTrident(100).getUpdatedItem(false), 10.0),
                new Reward(new StrongTrident(100).getUpdatedItem(false), 10.0),
                new Reward(new HealingTrident(100).getUpdatedItem(false), 10.0),
                new Reward(new ToughTrident(100).getUpdatedItem(false), 10.0),
                new Reward(new HealthyTrident(100).getUpdatedItem(false), 10.0),

                new Reward(new Trident(80).getUpdatedItem(false), 30.0),
                new Reward(new LuckyTrident(80).getUpdatedItem(false), 30.0),
                new Reward(new StrongTrident(80).getUpdatedItem(false), 30.0),
                new Reward(new HealingTrident(80).getUpdatedItem(false), 30.0),
                new Reward(new ToughTrident(80).getUpdatedItem(false), 30.0),
                new Reward(new HealthyTrident(80).getUpdatedItem(false), 30.0),

                new Reward(new WarHammer(100).getUpdatedItem(false), 10.0),
                new Reward(new LuckyWarHammer(100).getUpdatedItem(false), 10.0),
                new Reward(new StrongWarHammer(100).getUpdatedItem(false), 10.0),
                new Reward(new HealingWarHammer(100).getUpdatedItem(false), 10.0),
                new Reward(new ToughWarHammer(100).getUpdatedItem(false), 10.0),
                new Reward(new HealthyWarHammer(100).getUpdatedItem(false), 10.0),

                new Reward(new WarHammer(80).getUpdatedItem(false), 30.0),
                new Reward(new LuckyWarHammer(80).getUpdatedItem(false), 30.0),
                new Reward(new StrongWarHammer(80).getUpdatedItem(false), 30.0),
                new Reward(new HealingWarHammer(80).getUpdatedItem(false), 30.0),
                new Reward(new ToughWarHammer(80).getUpdatedItem(false), 30.0),
                new Reward(new HealthyWarHammer(80).getUpdatedItem(false), 30.0),
                
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.25),
                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 1.0),
                new Reward(new GoldenCarrot(50).getUpdatedItem(false), 20.0),
        });
    }
}