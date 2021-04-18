package net.siegerpg.siege.core.dropTable;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public final class dropTable {

    public enum blockDrops {

        Spruce_Log(Material.SPRUCE_LOG, new Object[][]{
                {new Stick(0).getItem(), 10}
        }, 0, 0, 20),
        Grass_Block(Material.GRASS_BLOCK, new Object[][]{
                {new Seed(0).getItem(), 10},
                {new PlantMatter(0).getItem(), 10}
        }, 0, 0, 20);
        private final Material block;
        private final Object[][] rewards;
        private final Integer numGold;
        private final Integer numExp;
        private final Integer regenTime;

        blockDrops(Material block, Object[][] rewards, Integer numGold, Integer numExp, Integer regenTime) {
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
                if (blocks.name().equals(str)) {
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
        public Integer getGold() { return numGold; }
        public Integer getExp() { return numExp; }
        public Integer getRegenTime() { return regenTime; }
    }
}
