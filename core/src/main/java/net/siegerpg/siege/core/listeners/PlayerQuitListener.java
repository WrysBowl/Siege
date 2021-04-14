package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void quitEvent(PlayerQuitEvent e) {
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            new Tablist().tablistUpdate();

            Scoreboard s = new Scoreboard();
            for (Player p : Bukkit.getOnlinePlayers()) {
                s.updateScoreboard(p);
            }
        }, 20L);

        new Tablist().tablistUpdate();

        Scoreboard s = new Scoreboard();
        for (Player p : Bukkit.getOnlinePlayers()) {
            s.updateScoreboard(p);
        }
    }
}
