package net.siegerpg.siege.core.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class EntityTeleportListener implements Listener {

    @EventHandler
    public void onTeleport(final EntityTeleportEvent e) {
        if (e.getEntity() instanceof Player) return;
        final Location loc = e.getEntity().getLocation();
        loc.getWorld().spawnParticle(Particle.CLOUD, loc, 3);
        for (final Entity entity : loc.getNearbyLivingEntities(10)) {
            if (entity instanceof Player) {
                ((Player)entity).playSound(entity.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0f, 1.0f);
            }
        }
    }
}
