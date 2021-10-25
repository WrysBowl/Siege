package net.siegerpg.siege.core.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import net.siegerpg.siege.core.skills.Skill;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Utils {
    @SuppressWarnings("unused")
    public static String tacc(final String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    @SuppressWarnings("unused")
    public static String strip(final String str) {
        return ChatColor.stripColor(str);
    }

    public static Component parse(final String str) {
        return MiniMessage.get().parse(str);
    }

    public static Component lore(final String str) {
        return MiniMessage.get().parse(str).decoration(TextDecoration.ITALIC, false);
    }

    public static NamespacedKey namespacedKey(final String str) {
        return new NamespacedKey(Core.plugin(), str);
    }

    public static boolean randTest(final Double num) {
        final double randNumber = Math.random() * 100;
        return randNumber <= num;
    }

    public static org.bukkit.util.Vector getDifferentialVector(final Location from, final Location to) {
        return new Vector((to.getX() - from.getX()), to.getY() - from.getY(), (to.getZ() - from.getZ()));
    }

    public static double round (final double value, final int precision) {
        final int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public static String convertSecondsToTime(final int seconds) {
        final double minutes = seconds/60.0;
        final double hours = minutes/60;
        String time = "";

        if (hours >= 1) {
            time += (int) Math.floor(hours)+"h ";
        }
        if (minutes >= 1) {
            if ((minutes % 60) > 0.0) {
                time += (int) Math.floor(minutes % 60) + "m ";
            }
        }
        if (seconds >= 1) {
            if ((seconds % 60) > 0.0) {
                time += (int) Math.floor(seconds % 60)+"s";
            }
        }
        return time;
    }

    public static Integer getHighestPV(final Player player) {
        final Set<PermissionAttachmentInfo> perms = player.getEffectivePermissions();
        int highestPV = 54;
        while(!player.hasPermission("cosmicvaults.amount."+highestPV)) {
            highestPV-=1;
            if (highestPV < 1) return 0;
        }
        return highestPV;
    }

    public static int randRarity() {
        //((random number between 1 and 100)*(1/random number between 1 and 5))
        final double rand1 = ((Math.random() * 70) + 1);
        final double rand2 = (((Math.random() * 70) + 1));
        return (int) ((Math.sqrt(rand1*rand2)) + 29);
    }

    public static ItemStack setLoreCost(final CustomItem item) {
        final ItemStack updatedItem = item.getUpdatedItem(false);
        final int itemCost = item.getQuality() * item.getLevelRequirement() * 2;

        final List<String> lore = new ArrayList<>(updatedItem.getLore().size()+1);
        lore.addAll(updatedItem.getLore());
        lore.add(tacc("&eCost " + itemCost));

        final ItemMeta meta = updatedItem.getItemMeta();
        meta.setLore(lore);
        updatedItem.setItemMeta(meta);
        return updatedItem;
    }

    public static Integer getCost(final ItemStack item) {
        String cost = item.getLore().get(item.getLore().size()-1);
        cost = cost.replace(tacc("&eCost "), "");
        return Integer.valueOf(cost);
    }

    public static ItemStack removeLastLore(final ItemStack item) {
        final List<String> lore = new ArrayList<>(item.getLore().size()-1);
        lore.addAll(item.getLore());
        lore.remove(item.getLore().size()-1);

        final ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addLore(final ItemStack item, final Component... lore) {
        List<Component> newLore = item.lore();
        if (newLore == null) {
            newLore = new ArrayList<>(lore.length);
        }
        newLore.add(Utils.lore(" "));
        newLore.addAll(Arrays.asList(lore));
        item.lore(newLore);
        return item;
    }

    public static ItemStack setCost(final ItemStack item, final Integer cost) {
        final List<String> lore;
        if (item.getLore() == null) {
            lore = new ArrayList<>(1);
        } else {
            lore = new ArrayList<>(item.getLore().size() + 1);
            lore.addAll(item.getLore());
        }
        lore.add(tacc("&eCost " + cost));

        final ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static boolean giveItem(final Player player, final ItemStack item) {
        boolean fullInv = player.getInventory().firstEmpty() == -1;
        boolean fullEnderChest = player.getEnderChest().firstEmpty() == -1;
        if (!fullInv) {
            player.getInventory().addItem(item);
        } else if (!fullEnderChest) {
            player.getEnderChest().addItem(item);
        } else {
            return false;
        }
        return true;
    }
}
