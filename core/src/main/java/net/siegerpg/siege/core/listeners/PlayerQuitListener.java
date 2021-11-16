package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Tablist;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void quitEvent(PlayerQuitEvent e) {

        e.quitMessage(Utils.parse("<red><bold>LEAVE <reset><gray>[<red>-<gray>] " + e.getPlayer().getName()));

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {

            for (Player p : Bukkit.getOnlinePlayers()) {
                Scoreboard.updateScoreboard(p);
                Tablist.tablistUpdate(p);
            }
        }, 20L);
    }
}
