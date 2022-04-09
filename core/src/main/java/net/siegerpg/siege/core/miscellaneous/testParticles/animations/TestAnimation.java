package net.siegerpg.siege.core.miscellaneous.testParticles.animations;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import net.siegerpg.siege.core.miscellaneous.testParticles.particles.*;
import org.bukkit.*;
import org.bukkit.util.*;

public class TestAnimation implements interfaceAnimation {

	@Override
	public void createAnimation(Location loc1, Location loc2, Particle p, Class< ? > data) {
		interfaceParticle part = new DotParticle();
		for(int i = 0; i < 10; i++) {
			part.createParticle(loc1.add(new Vector(0, i, 0)), null, p, data);
		}
	}

}
