package net.siegerpg.siege.core.fishing;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class FishingEvent implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player player = e.getPlayer();

    }
}
