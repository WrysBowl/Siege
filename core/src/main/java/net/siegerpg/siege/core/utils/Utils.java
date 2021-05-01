package net.siegerpg.siege.core.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

    static public Component lore(String str) {
        return MiniMessage.get().parse(str).decoration(TextDecoration.ITALIC, false);
    }

    @SuppressWarnings("unused")
    static public NamespacedKey namespacedKey(String str) {
        return new NamespacedKey(Core.plugin(), str);
    }

    public static boolean randTest(Double num) {
        double randNumber = Math.random() *100;
        return randNumber <= num;
    }

    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
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

    public static ItemStack setLoreCost(CustomItem item) {
        ItemStack updatedItem = item.getUpdatedItem(false);
        int itemCost = item.getQuality() * item.getLevelRequirement();

        List<String> lore = new ArrayList<>(updatedItem.getLore().size()+1);
        lore.addAll(updatedItem.getLore());
        lore.add(Utils.tacc("&eCost " + itemCost));

        ItemMeta meta = updatedItem.getItemMeta();
        meta.setLore(lore);
        updatedItem.setItemMeta(meta);
        return updatedItem;
    }

    public static Integer getCost(ItemStack item) {
        String cost = item.getLore().get(item.getLore().size()-1);
        cost = cost.replace(Utils.tacc("&eCost "), "");
        return Integer.valueOf(cost);
    }

    public static ItemStack removeLastLore(ItemStack item) {
        List<String> lore = new ArrayList<>(item.getLore().size()-1);
        lore.addAll(item.getLore());
        lore.remove(item.getLore().size()-1);

        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
