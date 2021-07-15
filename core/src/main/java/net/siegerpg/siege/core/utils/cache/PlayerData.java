package net.siegerpg.siege.core.utils.cache;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.utils.Levels;
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

public class PlayerData implements Listener {
    public static HashMap<Player, Boolean> hasActionBar = new HashMap<>();
    public static HashMap<Player, Boolean> broadcastTips = new HashMap<>();
    public static HashMap<Player, Double> playerHealth = new HashMap<>();
    public static HashMap<Player, Double> playerCurrentMana = new HashMap<>();
    public static HashMap<Player, Double> playerMana = new HashMap<>();
    public static HashMap<Player, String> playerSkillString = new HashMap<>();
    @EventHandler
    public void onEnable(PluginEnableEvent e) {
        for (Player player : Bukkit.getOnlinePlayers()){
            setStats(player);
            hasActionBar.put(player, false);
            PlayerData.broadcastTips.put(player, true);
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        hasActionBar.put(e.getPlayer(), false);
        setStats(e.getPlayer());
        if (!PlayerData.broadcastTips.containsKey(e.getPlayer())) {
            PlayerData.broadcastTips.put(e.getPlayer(), true);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        playerHealth.remove(e.getPlayer());
        playerMana.remove(e.getPlayer());
        playerCurrentMana.remove(e.getPlayer());
    }

    public static void setStats(Player player) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
            playerHealth.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.HEALTH) + player.getMaxHealth() + player.getLevel() * 2);

            playerMana.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.MANA));

        }, 2);
    }



    @EventHandler
    public void onEquip(ArmorEquipEvent e){
        @Nullable CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getNewArmorPiece());
        if (item == null) {
            setStats(e.getPlayer());
            return;
        }
        if (item.getLevelRequirement() == null) {return;}
        if (item.getLevelRequirement() > Levels.INSTANCE.getExpLevel(e.getPlayer()).getFirst()) {
            e.getPlayer().sendTitle("", ChatColor.RED + "Too weak to use this armor's stats", 1, 80, 1);
            return;
        }
        setStats(e.getPlayer());
    }

    @EventHandler
    public void toolSwitch(PlayerItemHeldEvent e) {
        CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItemInMainHand());
        if (item != null) {
            if (!(item instanceof CustomMaterial)) {
                setStats(e.getPlayer());
            }
        }
    }
}
