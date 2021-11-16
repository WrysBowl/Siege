package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Helix;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Necromancer extends Dungeon {

	public Necromancer() {

		super("Necromancer", 10,
		      new NecromancerKey(0),
		      new Location(null, -265, 82, 285), "Hilly_Woods",
		      100
		     );
	}

	@Override
	public void spawning() {

		Location loc = new Location(Core
				                            .plugin()
				                            .getServer()
				                            .getWorld("Hilly_Woods"), -265, 82, 285);
		new Helix().createHelix(loc, Particle.SMOKE_LARGE);

		Bukkit
				.getServer()
				.getScheduler()
				.runTaskLater(Core.plugin(), () -> {
					new Waves().createWaves(loc);
					loc
							.getWorld()
							.playSound(loc, Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
				}, 80);
	}

}