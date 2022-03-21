package net.siegerpg.siege.core.miscellaneous.testParticles;

import org.bukkit.*;

public interface interfaceParticle {
	//https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html :)

	/**
	 *
	 * @param loc center location
	 * @param p   Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 * @param amount multiplier of particles
	 */
	default void rotatedParticle(Location loc, Particle p, Class<?> data, int sizeX, int sizeY, int sizeZ, int rotationX, int rotationY, int rotationZ, int amount){

	}

	/**
	 *
	 * @param loc center location
	 * @param p   Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 * @param size size of particle
	 * @param amount multiplier of particles
	 */
	default void createParticle(Location loc, Particle p, Class<?> data, int size, int amount){

	}

	/**
	 *
	 * @param loc center location
	 * @param p   Particle type (class Particle)
	 * @param data Data, see spigot doc.
	 * @param amount multiplier of particles
	 */
	default void createDotParticle(Location loc, Particle p, Class<?> data, int amount){

	}



}
