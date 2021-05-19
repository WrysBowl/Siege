package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.utils.Players;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.HashMap;

public class StatChangeListener implements Listener, Runnable {

    public static HashMap<Player, Double> playerHealth = new HashMap<>();
    public static HashMap<Player, Double> playerToughness = new HashMap<>();

    private void addHealthTough(Player player) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
            playerHealth.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.HEALTH) + player.getMaxHealth() + player.getLevel() * 2);

            playerToughness.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.TOUGHNESS));
        }, 2);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        addHealthTough(e.getPlayer());
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        playerHealth.remove(e.getPlayer());
        playerToughness.remove(e.getPlayer());
    }

    @EventHandler
    public void onEquip(ArmorEquipEvent e){
        @Nullable CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getNewArmorPiece());
        if (item == null) {
            addHealthTough(e.getPlayer());
            return;
        }
        if (item.getLevelRequirement() == null) {return;}
        if (item.getLevelRequirement() > Levels.INSTANCE.getExpLevel(e.getPlayer()).getFirst()) {
            e.getPlayer().sendTitle("", ChatColor.RED + "Too weak to use this armor's stats", 1, 80, 1);
            return;
        }
        addHealthTough(e.getPlayer());
    }

    @EventHandler
    public void toolSwitch(PlayerItemHeldEvent e) {
        if (CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItemInMainHand()) != null) {
            addHealthTough(e.getPlayer());
        }
    }

    public static void statBarDisplayTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (playerHealth.get(p) == null) {
                    p.sendActionBar(Utils.parse("<red>REJOIN or RE-EQUIP your armor"));
                } else {
                    double health = Utils.round(playerHealth.get(p), 1);
                    double toughness = Utils.round(playerToughness.get(p), 1);
                    double customHealth = Utils.round(CustomItemUtils.INSTANCE.getCustomHealth(p), 1);
                    p.sendActionBar(Utils.parse("<red>"
                            + customHealth + "<dark_red>/" + health + " \u2764"
                            + "          <dark_aqua>" + Utils.round(toughness, 1) + " \uD83D\uDEE1       "));
                }
            }
        }, 0, 40);
    }

    @Override
    public void run() {

    }
}
