package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum MobDrops {

    /**
    ExampleMob(new Object[][]{
        {new ExampleItem(qualityInt).getUpdatedItem(false), chanceInt},
        {new Pebble(0).getUpdatedItem(false), 10}
     }, new Integer[]{minGold, maxGold}, new Integer[]{minExp, maxExp}),
     **/

    //HOSTILE AREA 1
    RockRat(new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 10.0},
    }, new Integer[]{2, 6}, new Integer[]{3, 6}),
    Blob(new Object[][]{
            {Slime.Companion.tier(1).getUpdatedItem(false), 50.0},
    }, new Integer[]{13, 16}, new Integer[]{14, 16}),
    ScorchingBlob(new Object[][]{
            {Magma.Companion.tier(1).getUpdatedItem(false), 50.0},
    }, new Integer[]{12, 15}, new Integer[]{15, 18}),
    ForestSpider(new Object[][]{
            {Vine.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 30.0}
    }, new Integer[]{14, 17}, new Integer[]{17, 20}),
    BloodSucker(new Object[][]{
            {Vine.Companion.tier(1).getUpdatedItem(false), 60.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 20.0}
    }, new Integer[]{14, 17}, new Integer[]{16, 19}),
    AngryBull(new Object[][]{
            {Leather.Companion.tier(1).getUpdatedItem(false), 100.0},
            {new Drumstick(0).getUpdatedItem(false), 100.0}
    }, new Integer[]{10, 20}, new Integer[]{15, 20}),
    Bandit(new Object[][]{
            {new Shank(Utils.randRarity()).getUpdatedItem(false), 5.0},
            {new Dagger(Utils.randRarity()).getUpdatedItem(false), 2.0},
            {MetalScrap.Companion.tier(1).getUpdatedItem(false), 1.0},
            {Leather.Companion.tier(1).getUpdatedItem(false), 8.0},
            {new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5}
    }, new Integer[]{40, 50}, new Integer[]{30, 40}),
    BanditArcher(new Object[][]{
            {new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5},
            {new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.25},
            {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
            {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}
    }, new Integer[]{30, 40}, new Integer[]{40, 50}),
    Orc(new Object[][]{
            {new GiantClub(Utils.randRarity()).getUpdatedItem(false), 0.5},
            {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25},
            {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
            {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}
    }, new Integer[]{50, 60}, new Integer[]{40, 60}),
    Ogre(new Object[][]{
            {new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0},
            {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 100.0},
            {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
            {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}
    }, new Integer[]{200, 300}, new Integer[]{250, 300}),

    //NEUTRAL AREA 1
    GiantHornet(new Object[][]{
            {Magma.Companion.tier(1).getUpdatedItem(false), 30.0},
            {Seed.Companion.tier(1).getUpdatedItem(false), 100.0},
    }, new Integer[]{11, 14}, new Integer[]{13, 15}),
    WildFox(new Object[][]{
            {new Dagger(Utils.randRarity()).getUpdatedItem(false), 1.0},
            {Bone.Companion.tier(1).getUpdatedItem(false), 2.0},
            {new WoodenSword(Utils.randRarity()).getUpdatedItem(false), 5.0},
            {new Drumstick(0).getUpdatedItem(false), 15.0}
    }, new Integer[]{5, 7}, new Integer[]{8, 10}),
    FeatheredMeat(new Object[][]{
        {Feather.Companion.tier(1).getUpdatedItem(false), 1.0},
        {new Drumstick(0).getUpdatedItem(false), 35.0}
    }, new Integer[]{5, 8}, new Integer[]{4, 7}),
    Porky(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 100.0}
    }, new Integer[]{15, 18}, new Integer[]{15, 17}),
    Wooly(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 30.0},
            {Wool.Companion.tier(1).getUpdatedItem(false), 60.0}
    }, new Integer[]{18, 20}, new Integer[]{16, 18}),
    MooMoo(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 100.0},
            {Leather.Companion.tier(1).getUpdatedItem(false), 60.0}
    }, new Integer[]{18, 22}, new Integer[]{16, 20}),
    Pigeon(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 25.0},
            {Feather.Companion.tier(1).getUpdatedItem(false), 60.0}
    }, new Integer[]{4, 7}, new Integer[]{10, 15}),
    Sushi(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 20.0},
    }, new Integer[]{0, 2}, new Integer[]{0, 2}),

    //Minibosses
    Davy_Jones(new Object[][]{
            {new Drumstick(0).getUpdatedItem(false), 20.0},
    }, new Integer[]{1000, 1200}, new Integer[]{1800, 2000})
    ;
    private final Object[][] rewards;
    private final Integer[] numGold;
    private final Integer[] numExp;

    MobDrops(Object[][] rewards, Integer[] numGold, Integer[] numExp) {
        this.rewards = rewards;
        this.numGold = numGold;
        this.numExp = numExp;
    }

    public static MobDrops matchCaseMobDrops(String str) {
        for (MobDrops mobs : MobDrops.values()) {
            if (mobs.name().equalsIgnoreCase(str)) {
                return mobs;
            }
        }
        return null;
    }

    public ArrayList<ItemStack> getRewards(Double luckChance) {
        ArrayList<ItemStack> itemList = new ArrayList<>();
        for (Object[] reward : rewards) {
            if (Utils.randTest((Double) reward[1])) {
                if ((Math.random() * 100) <= luckChance) {
                    itemList.add((ItemStack) reward[0]);
                }
                itemList.add((ItemStack) reward[0]);
            }
        }
        return itemList;
    }

    public Integer getGold(boolean rand) {
        if (rand) {
            double randomGold = (Math.random() * numGold[1]) + numGold[0];
            return (int) Math.round(randomGold);
        }
        return numGold[1];
    }
    public Integer getExp(boolean rand) {
        if (rand) {
            double randomExp = (Math.random() * numExp[1]) + numExp[0];
            return (int) Math.round(randomExp);
        }
        return numExp[1];
    }
}
