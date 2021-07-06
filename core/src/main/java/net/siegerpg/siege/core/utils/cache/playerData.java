package net.siegerpg.siege.core.utils.cache;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.HashMap;

public class playerData implements Listener {
    public static HashMap<Player, Boolean> hasActionBar = new HashMap<>();
    public static HashMap<Player, Boolean> broadcastTips = new HashMap<>();

    @EventHandler
    public void onEnable(PluginEnableEvent e) {
        for (Player player : Bukkit.getOnlinePlayers()){
            hasActionBar.put(player, false);
            playerData.broadcastTips.put(player, true);
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        hasActionBar.put(e.getPlayer(), false);
        if (!playerData.broadcastTips.containsKey(e.getPlayer())) {
            playerData.broadcastTips.put(e.getPlayer(), true);
        }
    }
}
