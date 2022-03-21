package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;

public class DotParticle implements interfaceParticle {

	@Override
	public void createDotParticle(Location loc, Particle p, Class<?> data, int amount){
		loc.getWorld().spawnParticle(p, loc, amount, data);
	}
}




































