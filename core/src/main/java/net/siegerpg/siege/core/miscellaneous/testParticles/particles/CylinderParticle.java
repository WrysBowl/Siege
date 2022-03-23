package net.siegerpg.siege.core.miscellaneous.testParticles.particles;

import net.siegerpg.siege.core.miscellaneous.testParticles.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.jetbrains.annotations.*;

import javax.annotation.*;
import javax.annotation.Nullable;

public class CylinderParticle implements interfaceParticle {

	double increase = Math.PI / 36;
	int count = 2;

	/**
	 * @param loc1 center location
	 * @param loc2 next location
	 * @param p    Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	@Override
	public void createParticle(@NotNull Location loc1, @NotNull Location loc2, @NotNull Particle p, @Nullable Class< ? > data) {


		for(int j = 0; j < 72; j++){

			double angle = j * increase;

			double size = loc1.distance(loc2);

			Vector v = new Vector(Math.cos(angle) * size, 0, Math.sin(angle) * size);

			loc1.getWorld().spawnParticle(p, loc1.add(v), count, data);
		}
	}

}
