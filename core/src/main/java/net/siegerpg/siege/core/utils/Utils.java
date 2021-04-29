package net.siegerpg.siege.core.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.siegerpg.siege.core.Core;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Arrays;

public class Utils {
    @SuppressWarnings("unused")
    static public String tacc(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    @SuppressWarnings("unused")
    static public String strip(String str) {
        return ChatColor.stripColor(str);
    }

    static public Component parse(String str) {
        return MiniMessage.get().parse(str);
    }

    @SuppressWarnings("unused")
    static public NamespacedKey namespacedKey(String str) {
        return new NamespacedKey(Core.INSTANCE, str);
    }

    public static boolean randTest(Double num) {
        double randNumber = Math.random() *100;
        if (randNumber <= num) { return true; }
        return false;
    }

    public static ItemStack getGoldCoin() {
        ItemStack gold = new ItemStack(Material.SUNFLOWER);
        ItemMeta meta = gold.getItemMeta();
        meta.setDisplayName("Gold Coin");
        gold.setItemMeta(meta);
        return gold;
    }

    @SuppressWarnings("unused")
    public static int randRarity() {
        //((random number between 1 and 100)*(1/random number between 1 and 5))
        double rand1 = ((Math.random() * 100) + 1);
        double rand2 = (((Math.random() * 100) + 1));
        return (int) ((-1 * Math.sqrt(rand1*rand2)) + 100);
    }
}
