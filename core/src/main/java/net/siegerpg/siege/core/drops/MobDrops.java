package net.siegerpg.siege.core.drops;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig;
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class MobDrops implements Listener {

    private Object[][] rewards;
    private Integer[] numGold;
    private Integer[] numExp;
    public boolean mob_exists = true;

    @EventHandler
    public void damageDrops(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            ActiveMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getDamager());
            if (mm != null) {
                ItemStack reward = null;
                double chance = 0.0;
                if (mm.getType().getInternalName().equals("Goblin")) {
                    reward = new GoldenCarrot(100).getUpdatedItem(false);
                    chance = 5.0;
                } else if (mm.getType().getInternalName().equals("WildFox")) {
                    reward = new GoldenCarrot(50).getUpdatedItem(false);
                    chance = 10.0;
                }
                if (reward != null) {
                    if (Utils.randTest(chance)) {
                        if (e.getEntity().getLocation().distance(e.getEntity().getWorld().getSpawnLocation()) > 3) {
                            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), reward);
                        }
                    }
                }
            }
        }
    }

    public void setMobTable(ActiveMob mob) {
        String mobName = mob.getType().getInternalName();
        switch (mobName) {
            case "RockRat":
                rewards = new Object[][]{
                        {Pebble.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {Pebble.Companion.tier(2).getUpdatedItem(false), 5.0},
                        {new RockWand(Utils.randRarity()).getUpdatedItem(false), 0.01}};
                numGold = new Integer[]{2, 6};
                numExp = new Integer[]{2, 4};
                break;
            case "Blob":
                rewards = new Object[][]{
                        {Slime.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {Slime.Companion.tier(2).getUpdatedItem(false), 10.0},
                };
                numGold = new Integer[]{6, 11};
                numExp = new Integer[]{7, 10};
                break;
            case "ScorchingBlob":
                rewards = new Object[][]{
                        {Magma.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {Magma.Companion.tier(2).getUpdatedItem(false), 10.0},
                };
                numGold = new Integer[]{5, 10};
                numExp = new Integer[]{10, 14};
                break;
            case "ForestSpider":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 50.0},
                        {Vine.Companion.tier(2).getUpdatedItem(false), 5.0},
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 1.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 30.0}};
                numGold = new Integer[]{9, 12};
                numExp = new Integer[]{14, 18};
                break;
            case "BloodSucker":
                rewards = new Object[][]{
                        {Vine.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Vine.Companion.tier(2).getUpdatedItem(false), 6.0},
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 1.0},
                        {Stick.Companion.tier(1).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{9, 12};
                numExp = new Integer[]{14, 18};
                break;
            case "AngryBull":
                rewards = new Object[][]{
                        {Leather.Companion.tier(1).getUpdatedItem(false), 80.0},
                        {Leather.Companion.tier(2).getUpdatedItem(false), 8.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 5.0},
                        {new Beef(50).getUpdatedItem(false), 25.0}};
                numGold = new Integer[]{10, 13};
                numExp = new Integer[]{18, 23};
                break;
            case "Bandit":
                rewards = new Object[][]{
                        {new Dagger(Utils.randRarity()).getUpdatedItem(false), 4.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 10.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 1.0},
                        {MetalScrap.Companion.tier(1).getUpdatedItem(false), 6.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 25.0},
                        {Leather.Companion.tier(2).getUpdatedItem(false), 1.0},
                };
                numGold = new Integer[]{18, 22};
                numExp = new Integer[]{28, 33};
                break;
            case "BanditArcher":
                rewards = new Object[][]{
                        {new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.5},
                        {new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.25},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 10.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 1.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 25.0}};
                numGold = new Integer[]{20, 23};
                numExp = new Integer[]{33, 38};
                break;
            case "Orc":
                rewards = new Object[][]{
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 35.0},
                        {new GiantClub(Utils.randRarity()).getUpdatedItem(false), 7.0},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 2.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 10.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 25.0}};
                numGold = new Integer[]{14, 17};
                numExp = new Integer[]{16, 20};
                break;
            case "Goblin":
                rewards = new Object[][]{
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 4.0},
                        {new Twig(Utils.randRarity()).getUpdatedItem(false), 5.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 2.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 12.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 1.0},
                };
                numGold = new Integer[]{2, 6};
                LivingEntity wildGob = (LivingEntity) mob.getEntity().getBukkitEntity();
                Material gobItem = Objects.requireNonNull(wildGob.getEquipment()).getItemInMainHand().getType();
                if (gobItem.equals(Material.SUNFLOWER)) {
                    numGold = new Integer[]{55, 60};
                }
                numExp = new Integer[]{7, 12};
                break;
            case "InfectedDigger":
                rewards = new Object[][]{
                        {Bone.Companion.tier(1).getUpdatedItem(false), 80.0},
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 10.0},
                        {new Beetroot(0).getUpdatedItem(false), 40.0},
                        {new Beetroot(50).getUpdatedItem(false), 10.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 8.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 15.0}};
                numGold = new Integer[]{6, 8};
                numExp = new Integer[]{16, 20};
                break;
            case "ZombifiedDigger":
                rewards = new Object[][]{
                        {new Beetroot(0).getUpdatedItem(false), 20.0},
                        {new SusStew(Utils.randRarity()).getUpdatedItem(false), 8.0},
                        {new Beetroot(50).getUpdatedItem(false), 5.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 40.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 4.0}
                };
                numGold = new Integer[]{4, 9};
                numExp = new Integer[]{16, 18};
                break;
            //NEUTRAL
            case "GiantHornet":
                rewards = new Object[][]{
                        {Magma.Companion.tier(1).getUpdatedItem(false), 30.0},
                        {Magma.Companion.tier(2).getUpdatedItem(false), 3.0},
                        {Seed.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Seed.Companion.tier(2).getUpdatedItem(false), 6.0},
                };
                numGold = new Integer[]{3, 5};
                numExp = new Integer[]{5, 9};
                break;
            case "WildFox":
                rewards = new Object[][]{
                        {Bone.Companion.tier(1).getUpdatedItem(false), 8.0},
                        {new Drumstick(0).getUpdatedItem(false), 50.0},
                        {new Drumstick(50).getUpdatedItem(false), 10.0},
                        {new Drumstick(100).getUpdatedItem(false), 5.0}
                };
                numGold = new Integer[]{5, 7};
                LivingEntity wildFox = (LivingEntity) mob.getEntity().getBukkitEntity();
                Material foxItem = Objects.requireNonNull(wildFox.getEquipment()).getItemInMainHand().getType();
                if (foxItem.equals(Material.SUNFLOWER)) {
                    numGold = new Integer[]{55, 65};
                }
                numExp = new Integer[]{14, 18};
                break;
            case "FeatheredMeat":
                rewards = new Object[][]{
                        {Feather.Companion.tier(1).getUpdatedItem(false), 30.0},
                        {Feather.Companion.tier(2).getUpdatedItem(false), 3.0},
                        {new Drumstick(0).getUpdatedItem(false), 100.0}};
                numGold = new Integer[]{0, 2};
                numExp = new Integer[]{1, 3};
                break;
            case "Porky":
                rewards = new Object[][]{{new Porkchop(50).getUpdatedItem(false), 60.0}};
                numGold = new Integer[]{3, 5};
                numExp = new Integer[]{6, 9};
                break;
            case "Wooly":
                rewards = new Object[][]{
                        {new Drumstick(50).getUpdatedItem(false), 60.0},
                        {Wool.Companion.tier(1).getUpdatedItem(false), 60.0},
                        {Wool.Companion.tier(2).getUpdatedItem(false), 6.0},
                        {Wool.Companion.tier(3).getUpdatedItem(false), 0.6}
                };
                numGold = new Integer[]{5, 7};
                numExp = new Integer[]{8, 12};
                break;
            case "MooMoo":
                rewards = new Object[][]{
                        {new Beef(50).getUpdatedItem(false), 100.0},
                        {Bone.Companion.tier(1).getUpdatedItem(false), 20.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 80.0}};
                numGold = new Integer[]{5, 8};
                numExp = new Integer[]{10, 15};
                break;
            case "Pigeon":
                rewards = new Object[][]{
                        {new Drumstick(0).getUpdatedItem(false), 50.0},
                        {Feather.Companion.tier(1).getUpdatedItem(false), 40.0},
                        {Feather.Companion.tier(2).getUpdatedItem(false), 4.0},
                };
                numGold = new Integer[]{0, 0};
                numExp = new Integer[]{2, 3};
                break;
            case "Sushi":
                rewards = new Object[][]{{new Drumstick(0).getUpdatedItem(false), 20.0}};
                numGold = new Integer[]{0, 0};
                numExp = new Integer[]{0, 1};
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
                    {new Trident(Utils.randRarity()).getUpdatedItem(false), 5.0}
                };
                numGold = new Integer[]{12, 15};
                numExp = new Integer[]{13, 17};
                break;
            case "Ogre":
                rewards = new Object[][]{
                        {new IronAxe(Utils.randRarity()).getUpdatedItem(false), 50.0},
                        {new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 100.0},
                        {Bone.Companion.tier(2).getUpdatedItem(false), 100.0},
                        {Bone.Companion.tier(3).getUpdatedItem(false), 50.0},
                        {Bone.Companion.tier(4).getUpdatedItem(false), 25.0},
                        {Bone.Companion.tier(5).getUpdatedItem(false), 5.0},
                        {Leather.Companion.tier(1).getUpdatedItem(false), 100.0},
                        {Leather.Companion.tier(2).getUpdatedItem(false), 50.0},
                        {Leather.Companion.tier(3).getUpdatedItem(false), 25.0},
                };
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
