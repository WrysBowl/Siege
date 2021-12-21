package net.siegerpg.siege.core.customEvents;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.events.Gold_Storm;
import net.siegerpg.siege.core.customEvents.events.Haste_Buff;
import net.siegerpg.siege.core.customEvents.events.Speed_Buff;
import net.siegerpg.siege.core.customEvents.events.Thunder_Storm;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class CustomEventListener implements Listener {
	public static HashMap<String, CustomEvent> events = new HashMap<>() {
		{
			put("GOLD_STORM", new Gold_Storm());
			put("THUNDER_STORM", new Thunder_Storm());
			put("HASTE_BUFF", new Haste_Buff());
			put("SPEED_BUFF", new Speed_Buff());

		}
	}; //fills up on start-up
	public static CustomEvent currentlyActive = null;
	private static final long eventWaitTimer = 1800 * 20L; //wait timer for events
	private static boolean eventDelayed = false;

	public CustomEventListener() {
		new BukkitRunnable() {
			@Override
			public void run() {
				triggers();
			}
		}.runTaskTimer(Core.plugin(), 20, 1800 * 20L);
	}

	public void triggers() {
		if (currentlyActive != null) return; //if an event is not active then allow code to trigger a new one
		if (eventDelayed) return;
		//allow to be shown 4 ticks later

		for (CustomEvent event : events.values()) { //trigger all events
			if (!event.triggerable()) continue;

			event.action();
			startTimer(event);

			//delay next event
			eventDelayed = true;
			new BukkitRunnable() {
				@Override
				public void run() {
					eventDelayed = false;
				}
			}.runTaskLater(Core.plugin(), eventWaitTimer);

			return;
		}
	}
	private void startTimer(CustomEvent event) {
		new BukkitRunnable() {
			@Override
			public void run() {
				currentlyActive = null;
				event.clearAction();
			}
		}.runTaskLater(Core.plugin(), event.duration * 20L); //checks for event every 10 seconds
	}
}
