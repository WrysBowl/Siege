package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.listeners.BlockBreakListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitTask;

public class More_Wheat extends CustomEvent {

	BukkitTask currentTask;

	public More_Wheat() {
		this.duration = 600;
	}

	public More_Wheat(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(15.0);
	}

	@Override
	public void action() {

		BlockBreakListener.addedLuck.put(Material.WHEAT, 100);

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#ECDA6B>2x Drops from wheat!"));
		Bukkit.broadcast(Utils.parse("<gray>Duration (<aqua>"+Utils.secondsToHHMMSS(this.duration)+"<gray>)"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

	@Override
	public void clearAction() {

		BlockBreakListener.addedLuck.remove(Material.WHEAT);

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#ECDA6B>The wheat frenzy has passed."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
