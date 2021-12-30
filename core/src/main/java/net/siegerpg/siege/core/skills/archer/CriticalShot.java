package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class CriticalShot extends Skill {

	@Override
	public Duration getCooldownDuration(int level) {

		return null;
	}

	@Override
	public int getManaCost(int level) {

		return 50;
	}

	@Override
	public int getGoldCost(int level) {

		return 100;
	}

	@Override
	public void trigger(@NotNull Player player, int level) {

	}

}
