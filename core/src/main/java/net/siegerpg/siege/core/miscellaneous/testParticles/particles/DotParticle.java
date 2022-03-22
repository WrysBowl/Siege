package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;

public class DotParticle implements interfaceParticle {

	int count = 5;

	@Override
	public void createParticle(Location loc, Particle p, Class< ? > data) {

		loc.getWorld().spawnParticle(p, loc, count);

	}

}




































