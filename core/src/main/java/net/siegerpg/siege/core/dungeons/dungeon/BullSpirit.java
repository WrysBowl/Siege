package net.siegerpg.siege.core.dungeons.dungeon;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BullSpiritKey;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Helix;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class BullSpirit extends Dungeon {

	public BullSpirit () {
		super("BullSpirit", 8,
				new BullSpiritKey(0),
				new Location(null, 272, 70, 20), "Hilly_Woods",
				100
		);
	}

	@Override
	public void spawning () {
		Location loc = new Location(Core.plugin().getServer().getWorld("Hilly_Woods"), 272, 70, 20);
		new Helix().createHelix(loc, Particle.CRIT);

		Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
			new Waves().createWaves(loc);
			loc.getWorld().playSound(loc, Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
		}, 80);
	}
}