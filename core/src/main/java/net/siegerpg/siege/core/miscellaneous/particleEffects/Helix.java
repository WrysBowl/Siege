package net.siegerpg.siege.core.miscellaneous.particleEffects;

import net.siegerpg.siege.core.Core;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class Helix implements Runnable {

	public void createHelix (Location location, Particle particle) {
		new BukkitRunnable() {
			Location loc = location;
			double t = 0;
			double r = 2;

			public void run () {
				t = t + Math.PI / 16;
				double x = r * Math.cos(t);
				double y = 0.5 * t;
				double z = r * Math.sin(t);
				loc.add(x, y, z);
				location.getWorld().spawnParticle(particle.builder().count(2).offset(0, 0, 0).particle(), loc, 5);
				loc.subtract(x, y, z);
				if (t > Math.PI * 8) {
					this.cancel();
				}
			}
		}.runTaskTimer(Core.plugin(), 0, 1);
	}

	public void createHelix (Location location, Particle particle, Double radius, Double offset, Double time) {
		new BukkitRunnable() {
			Location loc = location;
			double t = 0;
			double r = radius;

			public void run () {
				t = t + Math.PI / 32;
				double x = r * Math.cos(t);
				double y = 0.5 * t;
				double z = r * Math.sin(t);
				loc.add(x, y, z);
				location.getWorld().spawnParticle(particle.builder().count(2).offset(offset, offset, offset).particle(), loc, 5);
				loc.subtract(x, y, z);
				if (t > Math.PI * time) {
					this.cancel();
				}
			}
		}.runTaskTimer(Core.plugin(), 0, 1);
	}

	@Override
	public void run () {

	}
}
