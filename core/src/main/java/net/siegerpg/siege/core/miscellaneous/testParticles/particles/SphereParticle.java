package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.*;

import javax.annotation.Nullable;

public class SphereParticle implements interfaceParticle {
	double increase = Math.PI / 9;
	int count = 2;

	/**
	 * @param loc1 center location
	 * @param loc2 next location
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createParticle(@NotNull Location loc1, @NotNull Location loc2, @NotNull Particle p, @Nullable Class< ? > data) {

		for(int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {

				double angle = j * increase;
				double angle2 = i * increase;

				double size = loc1.distance(loc2);

				Vector v = new Vector(Math.cos(angle) * size * Math.sin(angle2), size * Math.cos(angle2), Math.sin(angle) * size);

				loc1
						.getWorld()
						.spawnParticle(p, loc1.add(v), count / 2, data);
			}
		}
	}
}
