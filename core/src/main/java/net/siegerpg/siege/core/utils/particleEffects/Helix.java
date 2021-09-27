package net.siegerpg.siege.core.utils.particleEffects;

import net.siegerpg.siege.core.Core;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class Helix implements Runnable{

    public void createHelix(Location location) {
        new BukkitRunnable() {
            Location loc = location;
            double t = 0;
            double r = 2;

            public void run() {
                t = t + Math.PI / 16;
                double x = r * Math.cos(t);
                double y = 0.5*t;
                double z = r * Math.sin(t);
                loc.add(x, y, z);
                location.getWorld().spawnParticle(Particle.SLIME.builder().count(2).offset(0,0,0).particle(), loc, 5);
                loc.subtract(x, y, z);
                if (t > Math.PI * 8) {
                    this.cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 1);
    }

    @Override
    public void run() {

    }
}
