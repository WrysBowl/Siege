package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.customEvents.CustomEventListener;
import net.siegerpg.siege.core.miscellaneous.GoldEXPSpawning;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Gold_Storm extends CustomEvent {

	BukkitTask currentTask;

	public Gold_Storm() {
		this.duration = 900;
	}

	public Gold_Storm(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(25.0);
	}

	@Override
	public void action() {

		World world = Bukkit.getWorld("Hilly_Woods");
		if (world == null) return;

		final int r = 242;
		final int g = 204;
		final int b = 96;
		Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(r, g, b), 8);

		this.currentTask = new BukkitRunnable() {
			@Override
			public void run() {
				for (Player player : world.getPlayers()) { //trigger all events
					final Location location = player.getLocation().add(0,4,0);
					location.getWorld().spawnParticle(Particle.REDSTONE, location, 20, 0.75, 0.25, 0.75, dust);
					GoldEXPSpawning.spawnGold((int)Math.ceil(player.getLevel()/5.0), location);
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 20L); //checks for event every 10 seconds

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>The gold storm has begun!"));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>Gold will rain for 15 minutes"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

	@Override
	public void clearAction() {

		this.currentTask.cancel();
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#F2CC60>The gold storm has passed."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
