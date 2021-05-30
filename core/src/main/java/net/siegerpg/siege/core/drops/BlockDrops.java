package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.items.implemented.misc.food.Apple;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.LivingTwig;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public enum BlockDrops {


    //LOG
    SPRUCE_LOG(Material.SPRUCE_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    OAK_LOG(Material.OAK_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    BIRCH_LOG(Material.BIRCH_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    JUNGLE_LOG(Material.JUNGLE_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    ACACIA_LOG(Material.ACACIA_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    DARK_OAK_LOG(Material.DARK_OAK_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),

    //WOOD
    SPRUCE_WOOD(Material.SPRUCE_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    OAK_WOOD(Material.OAK_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    BIRCH_WOOD(Material.BIRCH_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    JUNGLE_WOOD(Material.JUNGLE_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    ACACIA_WOOD(Material.ACACIA_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    DARK_OAK_WOOD(Material.DARK_OAK_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),

    //STRIPPED LOG
    STRIPPED_SPRUCE_LOG(Material.STRIPPED_SPRUCE_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_OAK_LOG(Material.STRIPPED_OAK_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_BIRCH_LOG(Material.STRIPPED_BIRCH_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_JUNGLE_LOG(Material.STRIPPED_JUNGLE_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_ACACIA_LOG(Material.STRIPPED_ACACIA_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_DARK_OAK_LOG(Material.STRIPPED_DARK_OAK_LOG, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),

    //STRIPPED WOOD
    STRIPPED_SPRUCE_WOOD(Material.STRIPPED_SPRUCE_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_OAK_WOOD(Material.STRIPPED_OAK_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_BIRCH_WOOD(Material.STRIPPED_BIRCH_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_JUNGLE_WOOD(Material.STRIPPED_JUNGLE_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_ACACIA_WOOD(Material.STRIPPED_ACACIA_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),
    STRIPPED_DARK_OAK_WOOD(Material.STRIPPED_DARK_OAK_WOOD, new Object[][]{
            {Stick.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Stick.Companion.tier(2).getUpdatedItem(false), 10.0},
    }, new Integer[]{3, 3}, new Integer[]{3, 3}, 100),

    //DIRT TERRAIN
    GRASS_BLOCK(Material.GRASS_BLOCK, new Object[][]{
            {PlantMatter.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Seed.Companion.tier(1).getUpdatedItem(false), 50.0},
            {PlantMatter.Companion.tier(2).getUpdatedItem(false), 5.0},
            {Seed.Companion.tier(2).getUpdatedItem(false), 5.0},
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    GREEN_TERRACOTTA(Material.GREEN_TERRACOTTA, new Object[][]{
            {PlantMatter.Companion.tier(1).getUpdatedItem(false), 65.0},
            {Seed.Companion.tier(1).getUpdatedItem(false), 35.0},
            {PlantMatter.Companion.tier(2).getUpdatedItem(false), 6.5},
            {Seed.Companion.tier(2).getUpdatedItem(false), 3.5}
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    GREEN_CONCRETE(Material.GREEN_CONCRETE, new Object[][]{
            {PlantMatter.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Seed.Companion.tier(1).getUpdatedItem(false), 50.0},
            {PlantMatter.Companion.tier(2).getUpdatedItem(false), 5.0},
            {Seed.Companion.tier(2).getUpdatedItem(false), 5.0},
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    LIME_TERRACOTTA(Material.LIME_TERRACOTTA, new Object[][]{
            {PlantMatter.Companion.tier(1).getUpdatedItem(false), 60.0},
            {Seed.Companion.tier(1).getUpdatedItem(false), 60.0},
            {PlantMatter.Companion.tier(2).getUpdatedItem(false), 6.0},
            {Seed.Companion.tier(2).getUpdatedItem(false), 6.0}
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    DIRT(Material.DIRT, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 5.0},
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    COARSE_DIRT(Material.COARSE_DIRT, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 5.0},
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),

    //NATURE
    BAMBOO(Material.BAMBOO, new Object[][]{
            {new Sugar(100).getUpdatedItem(false), 0.1},
            {new Sugar(50).getUpdatedItem(false), 1.0},
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    SUGAR_CANE(Material.SUGAR_CANE, new Object[][]{
            {new Sugar(0).getUpdatedItem(false), 0.1}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    DARK_OAK_LEAVES(Material.DARK_OAK_LEAVES, new Object[][]{
            {new Apple(100).getUpdatedItem(false), 0.1},
            {new Apple(50).getUpdatedItem(false), 5.0},
            {new Apple(0).getUpdatedItem(false), 10.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 25.0}
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),
    BIRCH_LEAVES(Material.BIRCH_LEAVES, new Object[][]{
            {new Apple(100).getUpdatedItem(false), 0.1},
            {new Apple(50).getUpdatedItem(false), 5.0},
            {new Apple(0).getUpdatedItem(false), 10.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 25.0}
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),
    JUNGLE_LEAVES(Material.JUNGLE_LEAVES, new Object[][]{
            {new Apple(100).getUpdatedItem(false), 0.1},
            {new Apple(50).getUpdatedItem(false), 5.0},
            {new Apple(0).getUpdatedItem(false), 10.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 25.0}
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),
    OAK_LEAVES(Material.OAK_LEAVES, new Object[][]{
            {new Apple(100).getUpdatedItem(false), 0.1},
            {new Apple(50).getUpdatedItem(false), 5.0},
            {new Apple(0).getUpdatedItem(false), 10.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 25.0}
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),
    SPRUCE_LEAVES(Material.SPRUCE_LEAVES, new Object[][]{
            {new Apple(100).getUpdatedItem(false), 0.1},
            {new Apple(50).getUpdatedItem(false), 5.0},
            {new Apple(0).getUpdatedItem(false), 10.0},
            {Stick.Companion.tier(1).getUpdatedItem(false), 25.0}
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),

    //STONE TERRAIN
    STONE_BUTTON(Material.STONE_BUTTON, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 50.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 5.0},
    }, new Integer[]{0, 0}, new Integer[]{1, 1}, 200),
    STONE(Material.STONE, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Pebble.Companion.tier(3).getUpdatedItem(false), 0.1}
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    LIGHT_GRAY_CONCRETE(Material.LIGHT_GRAY_CONCRETE, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Pebble.Companion.tier(3).getUpdatedItem(false), 0.1}
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),
    ANDESITE(Material.ANDESITE, new Object[][]{
            {Pebble.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Pebble.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Pebble.Companion.tier(3).getUpdatedItem(false), 0.1}
    }, new Integer[]{1, 1}, new Integer[]{0, 0}, 100),

    //ORES
    COAL_ORE(Material.COAL_ORE, new Object[][]{
            {Coal.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Coal.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Coal.Companion.tier(3).getUpdatedItem(false), 0.1}
    }, new Integer[]{4, 4}, new Integer[]{9, 9}, 200),
    IRON_ORE(Material.IRON_ORE, new Object[][]{
            {MetalScrap.Companion.tier(1).getUpdatedItem(false), 100.0},
            {MetalScrap.Companion.tier(2).getUpdatedItem(false), 10.0},
            {MetalScrap.Companion.tier(1).getUpdatedItem(false), 0.1},
    }, new Integer[]{9, 9}, new Integer[]{4, 4}, 300),

    //DECOR TERRAIN
    VINE(Material.VINE, new Object[][]{
            {Vine.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Vine.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Vine.Companion.tier(3).getUpdatedItem(false), 0.1},
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 40),
    CHAIN(Material.CHAIN, new Object[][]{
            {Chain.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Chain.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Chain.Companion.tier(1).getUpdatedItem(false), 0.1}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    WHEAT(Material.WHEAT, new Object[][]{
            {Wheat.Companion.tier(1).getUpdatedItem(false), 100.0},
            {Wheat.Companion.tier(2).getUpdatedItem(false), 10.0},
            {Wheat.Companion.tier(3).getUpdatedItem(false), 0.1}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 400);

    private final Material block;
    private final Object[][] rewards;
    private final Integer[] numGold;
    private final Integer[] numExp;
    private final Integer regenTime;

    BlockDrops(Material block, Object[][] rewards, Integer[] numGold, Integer[] numExp, Integer regenTime) {
        this.block = block;
        this.rewards = rewards;
        this.numGold = numGold;
        this.numExp = numExp;
        this.regenTime = regenTime;
    }

    public static boolean containsBlockDrops(String str) {
        for (BlockDrops blocks : BlockDrops.values()) {
            if (blocks.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static BlockDrops matchCaseBlockDrops(String str) {
        for (BlockDrops blocks : BlockDrops.values()) {
            if (blocks.name().equalsIgnoreCase(str)) {
                return blocks;
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

    public Material getBlock() { return block; }
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
    public Integer getRegenTime() { return regenTime; }
}