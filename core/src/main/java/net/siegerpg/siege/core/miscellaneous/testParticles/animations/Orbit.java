package net.siegerpg.siege.core.miscellaneous.testParticles.animations;

import net.siegerpg.siege.core.*;
import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;

public class Orbit implements interfaceAnimation {

	double increase = Math.PI / 36;
	int count = 2;

	/**
	 * @param loc1 center location
	 * @param loc2 radius
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createAnimation(Location loc1, Location loc2, Particle p, Class< ? > data) {

		new BukkitRunnable() {
			int j;
			final double size = loc1.distance(loc2);
			@Override
			public void run() {
				if(j > 144){
					this.cancel();
				}
				double angle = j * increase;
				Vector v = new Vector(Math.cos(angle) * size, 0, Math.sin(angle) * size);

				loc1.getWorld().spawnParticle(p, loc1.add(v), count, data);
				j++;
			}
		}.runTaskTimer(Core.plugin(), 1L, 1L);

	}

}
