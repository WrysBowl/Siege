package net.siegerpg.siege.core.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class EntityTeleportListener implements Listener {

    @EventHandler
    public void onTeleport(EntityTeleportEvent e) {
        if (e.getEntity() instanceof Player) return;
        Location loc = e.getEntity().getLocation();
        loc.getWorld().playEffect(loc, Effect.SMOKE, 0.1, 5);
        for (Entity entity : loc.getNearbyLivingEntities(10)) {
            if (entity instanceof Player) {
                ((Player)entity).playSound(entity.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0f, 1.0f);
            }
        }
    }
}
