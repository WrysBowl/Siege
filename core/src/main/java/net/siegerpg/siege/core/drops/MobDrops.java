package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum MobDrops {

    /**
    ExampleMob(new Object[][]{
        {new ExampleItem(qualityInt).getItem(), chanceInt},
        {new Pebble(0).getItem(), 10}
     }, new Integer[]{minGold, maxGold}, new Integer[]{minExp, maxExp}),
     **/

    //HOSTILE AREA 1
    RockRat(new Object[][]{
            {new Pebble(0).getItem(), 10},
    }, new Integer[]{0, 2}, new Integer[]{1, 3}),
    Blob(new Object[][]{
            {new Slime(0).getItem(), 50},
    }, new Integer[]{3, 6}, new Integer[]{4, 6}),
    ScorchingBlob(new Object[][]{
            {new Magma(0).getItem(), 50},
    }, new Integer[]{2, 5}, new Integer[]{5, 8}),
    ForestSpider(new Object[][]{
            {new Vine(0).getItem(), 50},
            {new Stick(0).getItem(), 30}
    }, new Integer[]{4, 7}, new Integer[]{7, 10}),
    BloodSucker(new Object[][]{
            {new Vine(0).getItem(), 60},
            {new Stick(0).getItem(), 20}
    }, new Integer[]{4, 7}, new Integer[]{6, 9}),
    AngryBull(new Object[][]{
            {new Leather(0).getItem(), 100},
            {new Drumstick(0).getItem(), 100}
    }, new Integer[]{8, 12}, new Integer[]{11, 15}),
    Bandit(new Object[][]{
            {new Shank(Utils.randRarity()).getItem(), 5},
            {new Dagger(Utils.randRarity()).getItem(), 2},
            {new MetalScrap(0).getItem(), 1},
            {new Leather(0).getItem(), 8},
            {new SplinteredBone(Utils.randRarity()).getItem(), 0.5}
    }, new Integer[]{21, 25}, new Integer[]{19, 24}),
    BanditArcher(new Object[][]{
            {new Crossbow(Utils.randRarity()).getItem(), 0.5},
            {new RecurveBow(Utils.randRarity()).getItem(), 0.25},
            {new Bone(0).getItem(), 3},
            {new Leather(0).getItem(), 8}
    }, new Integer[]{15, 19}, new Integer[]{27, 32}),
    //NEUTRAL AREA 1
    GiantHornet(new Object[][]{
            {new Magma(0).getItem(), 30},
            {new Seed(0).getItem(), 100},
    }, new Integer[]{1, 4}, new Integer[]{3, 5}),
    WildFox(new Object[][]{
            {new Dagger(Utils.randRarity()).getItem(), 1},
            {new Bone(0).getItem(), 2},
            {new WoodenSword(Utils.randRarity()).getItem(), 5},
            {new Drumstick(0).getItem(), 15}
    }, new Integer[]{2, 5}, new Integer[]{3, 6});
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
            if (Utils.randTest((Number) reward[1])) {
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
