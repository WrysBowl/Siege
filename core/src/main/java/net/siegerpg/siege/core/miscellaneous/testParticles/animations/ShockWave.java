package net.siegerpg.siege.core.miscellaneous.testParticles.animations;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import net.siegerpg.siege.core.miscellaneous.testParticles.particles.*;
import org.bukkit.*;

public class ShockWave implements interfaceAnimation {

	/**
	 * @param loc1 center location
	 * @param loc2 size location
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createAnimation(Location loc1, Location loc2, Particle p, Class< ? > data) {
		interfaceParticle particle = new CylinderParticle();
		int num = (int) (loc1.distance(loc2) * 10);
		for(int i = 0; i < loc2.distance(loc1); i++ ){
			particle.createParticle(loc1, loc1.multiply((double)i / num).add(loc2.multiply(1 - (double)i/num)), p, data);
		}
	}

}
