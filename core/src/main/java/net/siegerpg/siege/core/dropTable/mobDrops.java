package net.siegerpg.siege.core.dropTable;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.Slime;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum mobDrops {
    RockRat("RockRat", new Object[][]{
            {new Pebble(0).getItem(), 10},
            {new Drumstick(0).getItem(), 10}
    }, 0, 0),
    Blob("Blob", new Object[][]{
            {new Slime(0).getItem(), 10}
    }, 0, 0);
    private final String mobName;
    private final Object[][] rewards;
    private final Integer numGold;
    private final Integer numExp;

    mobDrops(String mobName, Object[][] rewards, Integer numGold, Integer numExp) {
        this.mobName = mobName;
        this.rewards = rewards;
        this.numGold = numGold;
        this.numExp = numExp;
    }

    public static boolean containsBlockDrops(String str) {
        for (mobDrops mobs : mobDrops.values()) {
            if (mobs.name().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
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

    public String getMobName() { return mobName; }
    public Integer getGold() { return numGold; }
    public Integer getExp() { return numExp; }
}
