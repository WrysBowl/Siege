package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.customEvents.CustomEventListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;

public class Thunder_Storm extends CustomEvent {

	public Thunder_Storm() {
		this.duration = 900;
	}

	public Thunder_Storm(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable(Event e) {
		return Utils.randTest(15.0);
	}

	@Override
	public void action(Event e) {

		World world = Bukkit.getWorld("Hilly_Woods");
		if (world == null) return;
		world.setStorm(true);

	}

	@Override
	public void clearAction(Event e) {

		World world = Bukkit.getWorld("Hilly_Woods");
		if (world == null) {
			Bukkit.getLogger().info(Utils.tacc("&cThunder storm event has failed to clear."));
			return;
		}
		world.setStorm(false);

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#639DD5>The thunder storm has passed."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
