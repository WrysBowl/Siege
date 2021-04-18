package net.siegerpg.siege.core.dropTable;

import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Seed;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Object[][] test = new Object[][]{
                {new Seed(0).getItem(), 10},
                {new PlantMatter(0).getItem(), 10}
        };
        ArrayList<ItemStack> itemList = new ArrayList<>();
        for(int i = 0;i<test.length;i++) {
            itemList.add((ItemStack) test[i][0]);
        }
    }
}
