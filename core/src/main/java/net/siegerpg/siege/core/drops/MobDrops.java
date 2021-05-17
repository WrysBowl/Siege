package net.siegerpg.siege.core.drops;

import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig;
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fox;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MobDrops {

    private Object[][] rewards;
    private Integer[] numGold;
    private Integer[] numExp;
    public boolean mob_exists = true;


    public void setMobTable(ActiveMob mob) {
        String mobName = mob.getType().getInternalName();
        switch (mobName) {
            case "RockRat":
                rewards = new Object[][]{
                        {Pebble.Companion.tier(1).getUpdatedItem(false), 10.0},
                        {new RockWand(Utils.randRarity()).getUpdatedItem(false), 0.5}};
                numGold = new Integer[]{2, 6};
                numExp = new Integer[]{2, 4};
                break;
            case "Blob":
                rewards = new Object[][]{{Slime.Companion.tier(1).getUpdatedItem(false), 50.0}};
                numGold = new Integer[]{6, 11};
                numExp = new Integer[]{7, 10};
                break;
            case "ScorchingBlob":
                rewards = new Object[][]{{Magma.Companion.tier(1).getUpdatedItem(false), 50.0}};
                numGold = new Integer[]{5, 10};
                numExp = new Integer[]{8, 11};
                break;
            case "ForestSpider":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 50.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 30.0}};
                numGold = new Integer[]{12, 16};
                numExp = new Integer[]{10, 12};
                break;
            case "BloodSucker":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{10, 14};
                numExp = new Integer[]{13, 15};
                break;
            case "AngryBull":
                rewards = new Object[][]{
                        {Leather.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {new Drumstick(50).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{15, 20};
                numExp = new Integer[]{14, 18};
                break;
            case "Bandit":
                rewards = new Object[][]{
                        {new Shank(Utils.randRarity()).getUpdatedItem(false), 5.0},
                        {new Dagger(Utils.randRarity()).getUpdatedItem(false), 2.0},
                        {MetalScrap.Companion.tier(1).getUpdatedItem(false), 1.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0},
                        {new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5}};
                numGold = new Integer[]{13, 18};
                numExp = new Integer[]{15, 20};
                break;
            case "BanditArcher":
                rewards = new Object[][]{
                        {new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5},
                        {new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.25},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{15, 20};
                numExp = new Integer[]{15, 20};
                break;
            case "Orc":
                rewards = new Object[][]{
                        {new GiantClub(Utils.randRarity()).getUpdatedItem(false), 0.5},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{16, 20};
                numExp = new Integer[]{12, 18};
                break;
            case "Goblin":
                rewards = new Object[][]{
                        {new Shank(Utils.randRarity()).getUpdatedItem(false), 8.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{2, 6};
                LivingEntity wildGob = (LivingEntity) mob.getEntity().getBukkitEntity();
                Material gobItem = Objects.requireNonNull(wildGob.getEquipment()).getItemInMainHand().getType();
                if (gobItem.equals(Material.SUNFLOWER)) {
                    numGold = new Integer[]{50, 60};
                }
                numExp = new Integer[]{3, 5};
                break;
            case "InfectedDigger":
                rewards = new Object[][]{
                        {new GlowingTwig(Utils.randRarity()).getUpdatedItem(false), 6.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{8, 12};
                numExp = new Integer[]{10, 14};
                break;
            case "ZombifiedDigger":
                rewards = new Object[][]{
                        {new GlowingTwig(Utils.randRarity()).getUpdatedItem(false), 15.0}};
                numGold = new Integer[]{4, 9};
                numExp = new Integer[]{8, 12};
                break;
            //NEUTRAL
            case "GiantHornet":
                rewards = new Object[][]{
                        {Magma.Companion.tier(1).getUpdatedItem(false), 30.0},
                        {Seed.Companion.tier(1).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{8, 11};
                numExp = new Integer[]{5, 9};
                break;
            case "WildFox":
                rewards = new Object[][]{
                        {new Dagger(Utils.randRarity()).getUpdatedItem(false), 1.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 2.0},
                        {new WoodenSword(Utils.randRarity()).getUpdatedItem(false), 5.0},
                        {new Drumstick(0).getUpdatedItem(false), 35.0}};
                numGold = new Integer[]{5, 7};
                LivingEntity wildFox = (LivingEntity) mob.getEntity().getBukkitEntity();
                Material foxItem = Objects.requireNonNull(wildFox.getEquipment()).getItemInMainHand().getType();
                if (foxItem.equals(Material.SUNFLOWER)) {
                    numGold = new Integer[]{50, 60};
                }
                numExp = new Integer[]{8, 10};
                break;
            case "FeatheredMeat":
                rewards = new Object[][]{
                        {Feather.Companion.tier(1).getUpdatedItem(false), 1.0},
                        {new Drumstick(0).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{2, 4};
                numExp = new Integer[]{3, 6};
                break;
            case "Porky":
                rewards = new Object[][]{{new Drumstick(50).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{5, 8};
                numExp = new Integer[]{6, 9};
                break;
            case "Wooly":
                rewards = new Object[][]{
                        {new Drumstick(50).getUpdatedItem(false), 60.0},
                        {Wool.Companion.tier(1).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{8, 14};
                numExp = new Integer[]{8, 12};
                break;
            case "MooMoo":
                rewards = new Object[][]{
                        {new Drumstick(50).getUpdatedItem(false), 100.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{12, 14};
                numExp = new Integer[]{10, 15};
                break;
            case "Pigeon":
                rewards = new Object[][]{
                        {new Drumstick(0).getUpdatedItem(false), 50.0},
                        {Feather.Companion.tier(1).getUpdatedItem(false), 40.0}};
                numGold = new Integer[]{1, 2};
                numExp = new Integer[]{2, 3};
                break;
            case "Sushi":
                rewards = new Object[][]{{new Drumstick(0).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{0, 2};
                numExp = new Integer[]{0, 2};
                break;
            //MINIBOSSES
            case "Davy_Jones":
                rewards = new Object[][]{
                        {new IronAxe(Utils.randRarity()).getUpdatedItem(false), 100.0},
                        {new Trident(Utils.randRarity()).getUpdatedItem(false), 100.0},
                };
                numGold = new Integer[]{500, 550};
                numExp = new Integer[]{700, 800};
                break;
            case "Sea_Warrior":
                rewards = new Object[][]{
                    {new Trident(Utils.randRarity()).getUpdatedItem(false), 25.0}
                };
                numGold = new Integer[]{12, 15};
                numExp = new Integer[]{13, 17};
                break;
            case "Ogre":
                rewards = new Object[][]{
                        {new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 100.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 3.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 8.0}};
                numGold = new Integer[]{650, 700};
                numExp = new Integer[]{600, 700};
                break;
            case "RockSpirit":
                rewards = new Object[][]{
                        {new RockWand(Utils.randRarity()).getUpdatedItem(false), 60.0},
                        {new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 50.0},
                        {new StoneAxe(Utils.randRarity()).getUpdatedItem(false), 15.0},
                        {Seed.Companion.tier(3).getUpdatedItem(false), 30.0}};
                numGold = new Integer[]{180, 200};
                numExp = new Integer[]{100, 150};
                break;
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
