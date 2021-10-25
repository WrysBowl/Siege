package net.siegerpg.siege.core.utils.particleEffects;

import net.siegerpg.siege.core.Core;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class Waves {

    public void createWaves(final Location loc) {
        new BukkitRunnable(){
            double t = Math.PI/4;
            public void run(){
	            this.t = this.t + 0.1*Math.PI;
                for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
                    double x = this.t *Math.cos(theta);
                    double y = 2*Math.exp(-0.1* this.t) * Math.sin(this.t) + 1.5;
                    double z = this.t *Math.sin(theta);
                    loc.add(x,y,z);
                    loc.subtract(x,y,z);
                    theta = theta + Math.PI/64;
                    x = this.t *Math.cos(theta);
                    y = 2*Math.exp(-0.1* this.t) * Math.sin(this.t) + 1.5;
                    z = this.t *Math.sin(theta);
                    loc.add(x,y,z);
                    loc.getWorld().spawnParticle(Particle.SPELL_WITCH.builder().count(1).offset(0,0,0).particle(), loc, 5);
                    loc.subtract(x,y,z);
                }
                if (this.t > 8){
                    cancel();
                }
            }

        }.runTaskTimer(Core.plugin(), 0, 1);
    }
}
