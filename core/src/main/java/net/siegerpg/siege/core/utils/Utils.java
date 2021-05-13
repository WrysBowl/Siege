package net.siegerpg.siege.core.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        return (int) ((-1 * Math.sqrt(rand1*rand2)) + 101);
    }

    public static ItemStack setLoreCost(CustomItem item) {
        ItemStack updatedItem = item.getUpdatedItem(false);
        int itemCost = item.getQuality() * item.getLevelRequirement() * 2;

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

    public static ItemStack addLore(ItemStack item, Component... lore) {
        List<Component> newLore = item.lore();
        if (newLore == null) {
            newLore = new ArrayList<>(lore.length);
        }
        newLore.add(lore(" "));
        newLore.addAll(Arrays.asList(lore));
        item.lore(newLore);
        return item;
    }


    @SuppressWarnings("unchecked")
    public static void changeName(String name, Player player) {
        try {
            Method getHandle = player.getClass().getMethod("getHandle");
            Object entityPlayer = getHandle.invoke(player);
            /*
             * These methods are no longer needed, as we can just access the
             * profile using handle.getProfile. Also, because we can just use
             * the method, which will not change, we don't have to do any
             * field-name look-ups.
             */
            boolean gameProfileExists = false;
            // Some 1.7 versions had the GameProfile class in a different package
            try {
                Class.forName("net.minecraft.util.com.mojang.authlib.GameProfile");
                gameProfileExists = true;
            } catch (ClassNotFoundException ignored) {

            }
            try {
                Class.forName("com.mojang.authlib.GameProfile");
                gameProfileExists = true;
            } catch (ClassNotFoundException ignored) {

            }
            if (!gameProfileExists) {
                /*
                 * Only 1.6 and lower servers will run this code.
                 *
                 * In these versions, the name wasn't stored in a GameProfile object,
                 * but as a String in the (final) name field of the EntityHuman class.
                 * Final (non-static) fields can actually be modified by using
                 * {@link java.lang.reflect.Field#setAccessible(boolean)}
                 */
                Field nameField = entityPlayer.getClass().getSuperclass().getDeclaredField("name");
                nameField.setAccessible(true);
                nameField.set(entityPlayer, name);
            } else {
                // Only 1.7+ servers will run this code
                Object profile = entityPlayer.getClass().getMethod("getProfile").invoke(entityPlayer);
                Field ff = profile.getClass().getDeclaredField("name");
                ff.setAccessible(true);
                ff.set(profile, name);
            }
            // In older versions, Bukkit.getOnlinePlayers() returned an Array instead of a Collection.
            if (Bukkit.class.getMethod("getOnlinePlayers", new Class<?>[0]).getReturnType() == Collection.class) {
                Collection<? extends Player> players = (Collection<? extends Player>) Bukkit.class.getMethod("getOnlinePlayers").invoke(null);
                for (Player p : players) {
                    p.hidePlayer(player);
                    p.showPlayer(player);
                }
            } else {
                Player[] players = ((Player[]) Bukkit.class.getMethod("getOnlinePlayers").invoke(null));
                for (Player p : players) {
                    p.hidePlayer(player);
                    p.showPlayer(player);
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
            /*
             * Merged all the exceptions. Less lines
             */
            e.printStackTrace();
        }
    }

}
