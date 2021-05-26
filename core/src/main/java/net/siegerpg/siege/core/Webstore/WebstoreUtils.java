package net.siegerpg.siege.core.Webstore;

import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WebstoreUtils {
    public static double expMultiplier = 1.0;
    public static ItemStack getExpBoosterItem(int amount, double multiplier, int seconds) {
        ItemStack item = new ItemStack(Material.PAPER, amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Utils.lore("<light_purple>EXP Booster"));
        itemMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("  <gray>Duration: <white>" + Utils.convertSecondsToTime(seconds)));
                add(Utils.lore("  <yellow>Multiplier: |" + multiplier + "x| EXP"));
                add(Utils.lore("<green><bold>CLICK TO REDEEM"));
            }
        });
        item.setItemMeta(itemMeta);
        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setInteger("seconds", seconds);
        nbtItem.setDouble("multiplier", multiplier);
        return nbtItem.getItem();
    }

}
