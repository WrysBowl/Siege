package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Tablist;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void quitEvent(PlayerQuitEvent e) {

        e.quitMessage(Utils.parse("<red><bold>LEAVE <gray>[<red>-<gray>] " + e.getPlayer().getName()));

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {

            for (Player p : Bukkit.getOnlinePlayers()) {
                Scoreboard.updateScoreboard(p);
                Tablist.tablistUpdate(p);
            }
        }, 20L);
    }
}
