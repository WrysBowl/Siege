package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class MobDrops {

    private Object[][] rewards;
    private Integer[] numGold;
    private Integer[] numExp;
    public boolean mob_exists = true;



    /*
    HashMap<String, Object[][]> dropTable = new HashMap<>(){
        {
            put("RockRat", new Object[][]{ new Object[][]{
                            {Pebble.Companion.tier(1).getUpdatedItem(false), 10.0},
                    },
                    { new Integer[]{2, 6}, new Integer[]{3, 6} }
            });
        }
    };
    HASHMAP EXAMPLE
    */

    public void setMobTable(String mobName) {
        switch (mobName) {
            case "RockRat":
                rewards = new Object[][]{{Pebble.Companion.tier(1).getUpdatedItem(false), 10.0}};
                numGold = new Integer[]{2, 6};
                numExp = new Integer[]{3, 6};
                break;
            case "Blob":
                rewards = new Object[][]{{Slime.Companion.tier(1).getUpdatedItem(false), 50.0}};
                numGold = new Integer[]{13, 16};
                numExp = new Integer[]{14, 16};
                break;
            case "ScorchingBlob":
                rewards = new Object[][]{{Magma.Companion.tier(1).getUpdatedItem(false), 50.0}};
                numGold = new Integer[]{12, 15};
                numExp = new Integer[]{15, 18};
                break;
            case "ForestSpider":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 50.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 30.0}};
                numGold = new Integer[]{14, 17};
                numExp = new Integer[]{17, 20};
                break;
            case "BloodSucker":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{14, 17};
                numExp = new Integer[]{16, 19};
                break;
            case "AngryBull":
                rewards = new Object[][]{
                        {Leather.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {new Drumstick(0).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{10, 20};
                numExp = new Integer[]{15, 20};
                break;
            case "Bandit":
                rewards = new Object[][]{
                        {new Shank(Utils.randRarity()).getUpdatedItem(false), 5.0},
                        {new Dagger(Utils.randRarity()).getUpdatedItem(false), 2.0},
                        {MetalScrap.Companion.tier(1).getUpdatedItem(false), 1.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0},
                        {new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5}};
                numGold = new Integer[]{40, 50};
                numExp = new Integer[]{30, 40};
                break;
            case "BanditArcher":
                rewards = new Object[][]{
                        {new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5},
                        {new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.25},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{30, 40};
                numExp = new Integer[]{40, 50};
                break;
            case "Orc":
                rewards = new Object[][]{
                        {new GiantClub(Utils.randRarity()).getUpdatedItem(false), 0.5},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{50, 60};
                numExp = new Integer[]{40, 60};
                break;
            case "Ogre":
                rewards = new Object[][]{
                        {new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 100.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{200, 300};
                numExp = new Integer[]{250, 300};
                break;
            //NEUTRAL
            case "GiantHornet":
                rewards = new Object[][]{
                        {Magma.Companion.tier(1).getUpdatedItem(false), 30.0},
                        {Seed.Companion.tier(1).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{11, 14};
                numExp = new Integer[]{13, 15};
                break;
            case "WildFix":
                rewards = new Object[][]{
                        {new Dagger(Utils.randRarity()).getUpdatedItem(false), 1.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 2.0},
                        {new WoodenSword(Utils.randRarity()).getUpdatedItem(false), 5.0},
                        {new Drumstick(0).getUpdatedItem(false), 15.0}};
                numGold = new Integer[]{5, 7};
                numExp = new Integer[]{8, 10};
                break;
            case "FeatheredMeat":
                rewards = new Object[][]{
                        {Feather.Companion.tier(1).getUpdatedItem(false), 1.0},
                        {new Drumstick(0).getUpdatedItem(false), 35.0}};
                numGold = new Integer[]{5, 8};
                numExp = new Integer[]{4, 7};
                break;
            case "Porky":
                rewards = new Object[][]{{new Drumstick(0).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{15, 18};
                numExp = new Integer[]{15, 17};
                break;
            case "Wooly":
                rewards = new Object[][]{
                        {new Drumstick(0).getUpdatedItem(false), 30.0},
                        {Wool.Companion.tier(1).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{18, 20};
                numExp = new Integer[]{16, 18};
                break;
            case "MooMoo":
                rewards = new Object[][]{
                        {new Drumstick(0).getUpdatedItem(false), 100.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{18, 22};
                numExp = new Integer[]{16, 20};
                break;
            case "Pigeon":
                rewards = new Object[][]{
                        {new Drumstick(0).getUpdatedItem(false), 25.0},
                        {Feather.Companion.tier(1).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{4, 7};
                numExp = new Integer[]{10, 15};
                break;
            case "Sushi":
                rewards = new Object[][]{{new Drumstick(0).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{0, 2};
                numExp = new Integer[]{0, 2};
                break;
            //MINIBOSSES
            case "Davy_Jones":
                rewards = new Object[][]{{new Drumstick(0).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{1000, 1200};
                numExp = new Integer[]{1800, 2000};
            default:
                mob_exists = false;
        }
    }

    public boolean isMob_exists() {
        return mob_exists;
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
