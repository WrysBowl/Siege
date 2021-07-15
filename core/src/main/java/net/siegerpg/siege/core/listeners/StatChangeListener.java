package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillUtils;
import net.siegerpg.siege.core.skills.Skills;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;

import javax.annotation.Nullable;
import java.util.HashMap;

public class StatChangeListener implements Listener, Runnable {

    public static void statBarDisplayTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                HashMap<Player, Double> playerHealth = PlayerData.playerHealth;
                HashMap<Player, Double> playerMana = PlayerData.playerMana;
                if (playerHealth.get(p) == null) continue;
                if (PlayerData.hasActionBar.get(p)) continue;
                double health = Utils.round(playerHealth.get(p), 1);
                double mana = Utils.round(playerMana.get(p), 1);
                double customHealth = Utils.round(CustomItemUtils.INSTANCE.getCustomHealth(p), 1);
                PlayerData.hasActionBar.put(p, true);
                p.sendActionBar(Utils.parse("<red>"
                        + customHealth + "<dark_red>/" + health + " \u2764"));
            }
            for (Player p : Bukkit.getOnlinePlayers()) {
                PlayerData.hasActionBar.put(p, false);
            }
        }, 0, 40);
    }

    @Override
    public void run() {

    }
}
