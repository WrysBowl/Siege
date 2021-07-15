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
    public void portalEnter(EntityPortalEnterEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        World world = e.getEntity().getWorld();
        World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
        World hub = Core.plugin().getServer().getWorld("Hub");
        World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");
        Player player = (Player) e.getEntity();

        if (world == siegeHub || world == hub) {
            assert hillyWoods != null;
            player.teleport(hillyWoods.getSpawnLocation());
        }
    }


    public void moveToward(Entity entity, Location to, double speed){
        Location loc = entity.getLocation();
        double x = loc.getX() - to.getX();
        double y = loc.getY() - to.getY();
        double z = loc.getZ() - to.getZ();
        Vector velocity = new Vector(x, y, z).normalize().multiply(-speed);
        entity.setVelocity(velocity);
    }
}
