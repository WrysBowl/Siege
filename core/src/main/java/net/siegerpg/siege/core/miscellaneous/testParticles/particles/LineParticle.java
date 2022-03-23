package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;

public class LineParticle implements interfaceParticle {

	int count = 2;

	/**
	 * @param loc1 first location
	 * @param loc2 next location
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createParticle(Location loc1, Location loc2, Particle p, Class< ? > data) {
		int num = (int) (loc1.distance(loc2) * 10);
		for(int i = 0; i < num; i++) {
			loc1.getWorld().spawnParticle(p, loc1.multiply((double)i / num).add(loc2.multiply(1 - (double)i/num)), count, data);
		}
	}

}
