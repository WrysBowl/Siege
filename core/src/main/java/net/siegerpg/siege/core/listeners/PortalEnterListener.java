package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void portalEnter(PlayerPortalEvent e) {
        World world = e.getPlayer().getWorld();
        World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
        World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");
        Player player = e.getPlayer();

        if (world == siegeHub) {
            assert hillyWoods != null;
            player.teleport(hillyWoods.getSpawnLocation());
        }
    }

    /*
    public void moveToward(Entity entity, Location to, double speed){
        Location loc = entity.getLocation();
        double x = loc.getX() - to.getX();
        double y = loc.getY() - to.getY();
        double z = loc.getZ() - to.getZ();
        Vector velocity = new Vector(x, y, z).normalize().multiply(-speed);
        entity.setVelocity(velocity);
    }*/
}
