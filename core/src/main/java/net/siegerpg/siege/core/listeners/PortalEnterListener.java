package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.util.Vector;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void portalEnter(final EntityPortalEnterEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        final World world = e.getEntity().getWorld();
        final World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
        final World hub = Core.plugin().getServer().getWorld("Hub");
        final World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");
        final Player player = (Player) e.getEntity();

        if (world == siegeHub || world == hub) {
            assert hillyWoods != null;
            player.teleport(hillyWoods.getSpawnLocation());
        }
    }


    public void moveToward(final Entity entity, final Location to, final double speed){
        final Location loc = entity.getLocation();
        final double x = loc.getX() - to.getX();
        final double y = loc.getY() - to.getY();
        final double z = loc.getZ() - to.getZ();
        final Vector velocity = new Vector(x, y, z).normalize().multiply(-speed);
        entity.setVelocity(velocity);
    }
}
