package net.siegerpg.siege.core.miscellaneous.testParticles;

import org.bukkit.*;

public interface interfaceAnimation {

	//https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html :)

	/**
	 * @param loc center location
	 * @param p   Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 */
	abstract void createAnimation(Location loc, Particle p, Class<?> data);
}