package net.siegerpg.siege.core.utils.particleEffects;

import net.siegerpg.siege.core.Core;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class Helix implements Runnable{

    public void createHelix(final Location location, final Particle particle) {
        new BukkitRunnable() {
            final Location loc = location;
            double t;
            final double r = 2;

            public void run() {
	            this.t = this.t + Math.PI / 16;
                final double x = this.r * Math.cos(this.t);
                final double y = 0.5* this.t;
                final double z = this.r * Math.sin(this.t);
	            this.loc.add(x, y, z);
                location.getWorld().spawnParticle(particle.builder().count(2).offset(0,0,0).particle(), this.loc, 5);
	            this.loc.subtract(x, y, z);
                if (this.t > Math.PI * 8) {
                    cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 1);
    }
    public void createHelix(final Location location, final Particle particle, final Double radius, final Double offset, final Double time) {
        new BukkitRunnable() {
            final Location loc = location;
            double t;
            final double r = radius;

            public void run() {
	            this.t = this.t + Math.PI / 32;
                final double x = this.r * Math.cos(this.t);
                final double y = 0.5* this.t;
                final double z = this.r * Math.sin(this.t);
	            this.loc.add(x, y, z);
                location.getWorld().spawnParticle(particle.builder().count(2).offset(offset,offset,offset).particle(), this.loc, 5);
	            this.loc.subtract(x, y, z);
                if (this.t > Math.PI * time) {
                    cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 1);
    }

    @Override
    public void run() {

    }
}
