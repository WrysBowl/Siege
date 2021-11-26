package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.LichKey;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Helix;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Lich extends Dungeon {

	public Lich() {

		super("Lich", 6,
		      new LichKey(0),
		      new Location(null, 372, 87, 132), "Hilly_Woods",
		      100
		     );
	}

	@Override
	public void spawning() {

		Location loc = new Location(Core
				                            .plugin()
				                            .getServer()
				                            .getWorld("Hilly_Woods"), 372, 87, 132);
		new Helix().createHelix(loc, Particle.SOUL);

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