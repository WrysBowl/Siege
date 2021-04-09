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

    @SuppressWarnings("unused")
    public static ItemStack createItem(final Material material, final String name, final boolean glowing, Integer amount, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set glowing state of the item
        if (glowing) {
            meta.addEnchant(Enchantment.MENDING, 1, true); //Enchant with lure and will remove glowing effect
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        item.setAmount(amount);

        return item;
    }

    public static void sendMessage(Player player, Component message) {
        Core.INSTANCE.audiences.player(player).sendMessage(message);
    }


    @SuppressWarnings("unused")
    public static int randRarity() {
        //((random number between 1 and 100)*(1/random number between 1 and 5))
        double rand1 = ((Math.random() * 10) + 1);
        double rand2 = (((Math.random() * 10) + 1));
        return (int) (rand1*rand2);
    }



}
