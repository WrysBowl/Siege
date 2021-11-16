package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BroodmotherKey;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Helix;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Broodmother extends Dungeon {

	public Broodmother () {
		super("Broodmother", 10,
				new BroodmotherKey(0),
				new Location(null, 7, 89, -416), "Hilly_Woods",
				100
		);
	}

	@Override
	public void spawning () {
		Location loc = new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), 27, 89, -416);
		new Helix().createHelix(loc, Particle.SUSPENDED_DEPTH);

		Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
			new Waves().createWaves(loc);
			loc.getWorld().playSound(loc, Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
		}, 80);
	}
}