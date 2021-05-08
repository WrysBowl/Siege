package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.utils.Players;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.HashMap;

public class StatChangeListener implements Listener, Runnable {

    public static HashMap<Player, Double> playerHealth = new HashMap<>();
    public static HashMap<Player, Double> playerToughness = new HashMap<>();

    @EventHandler
    public void onEquip(ArmorEquipEvent e){
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
            playerHealth.put(
                    e.getPlayer(),
                    CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.HEALTH));

            playerToughness.put(
                    e.getPlayer(),
                    CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.TOUGHNESS));
        }, 2);
    }

    @EventHandler
    public void toolSwitch(PlayerItemHeldEvent e) {
        if (CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItemInMainHand()) != null) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
                playerHealth.put(
                        e.getPlayer(),
                        CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.HEALTH));

                playerToughness.put(
                        e.getPlayer(),
                        CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.TOUGHNESS));
            }, 2);
        }
    }

    public static void statBarDisplayTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Double health = playerHealth.get(p);
                Double toughness = playerToughness.get(p);
                p.sendActionBar(Utils.parse("<red>"
                        + CustomItemUtils.INSTANCE.getCustomHealth(p) + "<dark_red>/<red>" + health
                        + "       <blue>" + toughness));
            }
        }, 0, 40);
    }

    @Override
    public void run() {

    }
}
