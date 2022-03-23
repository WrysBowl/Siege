package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

public class DotParticle implements interfaceParticle {

	int count = 5;


	/**
	 * @param loc1 center location
	 * @param loc2 Always null
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createParticle(@NotNull Location loc1, Location loc2, Particle p, Class< ? > data) {
		// loc 2 is always null.
		loc1.getWorld().spawnParticle(p, loc1, count, data);

	}

}




































