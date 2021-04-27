package net.siegerpg.siege.core.dropTable;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum mobDrops {

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
            {new Slime(0).getItem(), 10},
    }, new Integer[]{3, 6}, new Integer[]{4, 6}),
    ScorchingBlob(new Object[][]{
            {new Magma(0).getItem(), 10},
    }, new Integer[]{2, 5}, new Integer[]{5, 8}),
    ForestSpider(new Object[][]{
            {new Vine(0).getItem(), 10},
            {new Stick(0).getItem(), 10}
    }, new Integer[]{4, 7}, new Integer[]{7, 10}),
    BloodSucker(new Object[][]{
            {new Vine(0).getItem(), 10},
            {new Stick(0).getItem(), 10}
    }, new Integer[]{4, 7}, new Integer[]{6, 9}),
    AngryBull(new Object[][]{
            {new Leather(0).getItem(), 10},
            {new Drumstick(0).getItem(), 10}
    }, new Integer[]{8, 12}, new Integer[]{11, 15}),
    Bandit(new Object[][]{
            {new Shank(0).getItem(), 10},
            {new Dagger(0).getItem(), 10},
            {new MetalScrap(0).getItem(), 10},
            {new Leather(0).getItem(), 10},
            {new SplinteredBone(Utils.randRarity()).getItem(), 10}
    }, new Integer[]{21, 25}, new Integer[]{19, 24}),
    BanditArcher(new Object[][]{
            {new Crossbow(Utils.randRarity()).getItem(), 10},
            {new RecurveBow(Utils.randRarity()).getItem(), 10},
            {new Bone(0).getItem(), 10},
            {new Leather(0).getItem(), 10}
    }, new Integer[]{15, 19}, new Integer[]{27, 32}),
    //NEUTRAL AREA 1
    GiantHornet(new Object[][]{
            {new Magma(0).getItem(), 10},
            {new Seed(0).getItem(), 10},
    }, new Integer[]{1, 4}, new Integer[]{3, 5}),
    WildFox(new Object[][]{
            {new Dagger(Utils.randRarity()).getItem(), 10},
            {new Bone(0).getItem(), 10},
            {new WoodenSword(Utils.randRarity()).getItem(), 10},
            {new Drumstick(0).getItem(), 10}
    }, new Integer[]{2, 5}, new Integer[]{3, 6});
    private final Object[][] rewards;
    private final Integer[] numGold;
    private final Integer[] numExp;

    mobDrops(Object[][] rewards, Integer[] numGold, Integer[] numExp) {
        this.rewards = rewards;
        this.numGold = numGold;
        this.numExp = numExp;
    }

    public static mobDrops matchCaseMobDrops(String str) {
        for (mobDrops mobs : mobDrops.values()) {
            if (mobs.name().equalsIgnoreCase(str)) {
                return mobs;
            }
        }
        return null;
    }

    public ArrayList<ItemStack> getRewards(Double luckChance) {
        ArrayList<ItemStack> itemList = new ArrayList<>();
        for(int i = 0;i<rewards.length;i++) {
            if (Utils.randTest((Number) rewards[i][1])) {
                if ((Math.random()*100) <= luckChance) {
                    itemList.add((ItemStack) rewards[i][0]);
                }
                itemList.add((ItemStack) rewards[i][0]);
            }
        }
        return itemList;
    }

    public Integer getGold(boolean rand) {
        if (rand) {
            Double randomGold = (Math.random() * numGold[1]) + numGold[0];
            return (int) Math.round(randomGold);
        }
        return numGold[1];
    }
    public Integer getExp(boolean rand) {
        if (rand) {
            Double randomExp = (Math.random() * numExp[1]) + numExp[0];
            return (int) Math.round(randomExp);
        }
        return numExp[1];
    }
}
