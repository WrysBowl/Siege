package net.siegerpg.siege.core.cache;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.HashMap;

public class playerData implements Listener {
    public static HashMap<Player, Boolean> hasActionBar = new HashMap<>();

    @EventHandler
    public void onEnable(PluginEnableEvent e) {
        for (Player player : Bukkit.getOnlinePlayers()){
            hasActionBar.put(player, false);
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        hasActionBar.put(e.getPlayer(), false);
    }
}
