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

    public static ItemStack setLoreCost(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        Integer itemCost = CustomItemUtils.INSTANCE.getCustomItem(item).getQuality() * CustomItemUtils.INSTANCE.getCustomItem(item).getLevelRequirement();
        itemMeta.lore().add(Utils.parse(itemCost.toString()));
        item.setItemMeta(itemMeta);
        return item;
    }

    public static Integer getCost(ItemStack item) {
        String cost = item.getLore().get(item.getLore().size());
        return Integer.valueOf(cost);
    }

    public static ItemStack removeLastLore(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.lore().remove(itemMeta.getLore().size()-1);
        item.setItemMeta(itemMeta);
        return item;
    }

}
