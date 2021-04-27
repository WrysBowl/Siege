package net.siegerpg.siege.core.dropTable;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum blockDrops {
    //WOOD
    SPRUCE_LOG(Material.SPRUCE_LOG, new Object[][]{
            {new Stick(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    SPRUCE_WOOD(Material.SPRUCE_WOOD, new Object[][]{
            {new Stick(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),

    //DIRT TERRAIN
    GRASS_BLOCK(Material.GRASS_BLOCK, new Object[][]{
            {new PlantMatter(0).getItem(), 10},
            {new Seed(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    GREEN_TERRACOTTA(Material.GREEN_TERRACOTTA, new Object[][]{
            {new PlantMatter(0).getItem(), 10},
            {new Seed(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    GREEN_CONCRETE(Material.GREEN_CONCRETE, new Object[][]{
            {new PlantMatter(0).getItem(), 10},
            {new Seed(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    LIME_TERRACOTTA(Material.LIME_TERRACOTTA, new Object[][]{
            {new PlantMatter(0).getItem(), 10},
            {new Seed(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    DIRT(Material.DIRT, new Object[][]{
            {new Pebble(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    COARSE_DIRT(Material.COARSE_DIRT, new Object[][]{
            {new Pebble(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),

    //STONE TERRAIN
    STONE(Material.STONE, new Object[][]{
            {new Pebble(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    LIGHT_GRAY_CONCRETE(Material.LIGHT_GRAY_CONCRETE, new Object[][]{
            {new Pebble(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    ANDESITE(Material.ANDESITE, new Object[][]{
            {new Pebble(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),

    //ORES
    COAL_ORE(Material.COAL_ORE, new Object[][]{
            {new Coal(0).getItem(), 10}
    }, new Integer[]{20, 30}, new Integer[]{30, 40}, 100),
    IRON_ORE(Material.IRON_ORE, new Object[][]{
            {new MetalScrap(0).getItem(), 10}
    }, new Integer[]{30, 40}, new Integer[]{40, 50}, 200),

    //DECOR TERRAIN
    VINE(Material.VINE, new Object[][]{
            {new Vine(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20),
    CHAIN(Material.CHAIN, new Object[][]{
            {new Chain(0).getItem(), 10}
    }, new Integer[]{0, 0}, new Integer[]{0, 0}, 20);

    private final Material block;
    private final Object[][] rewards;
    private final Integer[] numGold;
    private final Integer[] numExp;
    private final Integer regenTime;

    blockDrops(Material block, Object[][] rewards, Integer[] numGold, Integer[] numExp, Integer regenTime) {
        this.block = block;
        this.rewards = rewards;
        this.numGold = numGold;
        this.numExp = numExp;
        this.regenTime = regenTime;
    }

    public static boolean containsBlockDrops(String str) {
        for (blockDrops blocks : blockDrops.values()) {
            if (blocks.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static blockDrops matchCaseBlockDrops(String str) {
        for (blockDrops blocks : blockDrops.values()) {
            if (blocks.name().equalsIgnoreCase(str)) {
                return blocks;
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

    public Material getBlock() { return block; }
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
    public Integer getRegenTime() { return regenTime; }
}
